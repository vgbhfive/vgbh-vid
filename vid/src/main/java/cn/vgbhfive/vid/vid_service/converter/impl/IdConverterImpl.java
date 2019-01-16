package cn.vgbhfive.vid.vid_service.converter.impl;

import cn.vgbhfive.vid.vid_intf.bean.Id;
import cn.vgbhfive.vid.vid_service.converter.IdConverter;
import cn.vgbhfive.vid.vid_service.entity.IdMeta;
import cn.vgbhfive.vid.vid_service.entity.IdMetaFactory;
import cn.vgbhfive.vid.vid_service.entity.IdType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @time:
 * @author: Vgbh
 *
 * ID类型与Longleixing之间相互转化
 */
@Component
public class IdConverterImpl implements IdConverter {

    private static final Logger log = LoggerFactory.getLogger(IdConverterImpl.class);

    private IdMeta idMeta;

    public IdConverterImpl() {}

    public IdConverterImpl (IdType idType) {
        this(IdMetaFactory.getIdMeta(idType));
    }

    public IdConverterImpl(IdMeta idMeta) {
        this.idMeta = idMeta;
    }

    @Override
    public long convert(Id id) {
        return doConvert(id, idMeta);
    }

    @Override
    public long doConvert(Id id, IdMeta idMeta) {
        long ret = 0;
        //查看Id的信息
        //log.info("\n   " + id.getMachine() + "     " + id.getSeq() + "    " + id.getTime() + "    " +id.getGenMethod()+ "     " + id.getType() + "    " + id.getVersion() + "\n");
        //查看IdMeta的各项信息
        //log.info("\n" + idMeta.getSeqBitsStartPos() + "------" + idMeta.getTimeBitsStartPos() + "-----" +idMeta.getGenMethodBitsStartPos() + "----" + idMeta.getTypeBitsStartPos() + "----" +idMeta.getVersionBitsStartPos() + "\n");

        ret |= id.getMachine();
        ret |= id.getSeq() << idMeta.getSeqBitsStartPos();
        ret |= id.getTime() << idMeta.getTimeBitsStartPos();
        ret |= id.getGenMethod() << idMeta.getGenMethodBitsStartPos();
        ret |= id.getType() << idMeta.getTypeBitsStartPos();
        ret |= id.getVersion() << idMeta.getVersionBitsStartPos();
        //log.info(" ID ---> Long  return:" + ret );

        return ret;
    }

    @Override
    public Id convert(long id) {
        return doConvert(id, idMeta);
    }

    @Override
    public Id doConvert(long id, IdMeta idMeta) {
        Id ret = new Id();
        //查看IdMeta的各项信息
        log.info("\n" + idMeta.getSeqBitsStartPos() + "------" + idMeta.getTimeBitsStartPos() + "-----" +idMeta.getGenMethodBitsStartPos() + "----" + idMeta.getTypeBitsStartPos() + "----" +idMeta.getVersionBitsStartPos() + "\n");

        ret.setMachine(id & idMeta.getMachineBitsMask());
        ret.setSeq((id >>> idMeta.getSeqBitsStartPos()) & idMeta.getSeqBitsMask());
        ret.setTime((id >>> idMeta.getTimeBitsStartPos()) & idMeta.getTimeBitsMask()) ;
        ret.setGenMethod((id >>> idMeta.getGenMethodBitsStartPos()) & idMeta.getGenMethodBitsMask());
        ret.setType((id >>> idMeta.getTypeBitsStartPos()) & idMeta.getTypeBitsMask());
        ret.setVersion((id >>> idMeta.getVersionBitsStartPos()) & idMeta.getVersionBitsMask());

        log.info(" Long ---> ID  return:" + ret.toString());
        return ret;
    }

    public IdMeta getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(IdMeta idMeta) {
        this.idMeta = idMeta;
    }
}
