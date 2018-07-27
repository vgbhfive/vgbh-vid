package cn.vgbhfive.vid.vid_service.converter.impl;

import cn.vgbhfive.vid.vid_intf.bean.Id;
import cn.vgbhfive.vid.vid_service.converter.IdConverter;
import cn.vgbhfive.vid.vid_service.entity.IdMeta;
import cn.vgbhfive.vid.vid_service.entity.IdMetaFactory;
import cn.vgbhfive.vid.vid_service.entity.IdType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @time:
 * @author: Vgbh
 *
 * ID类型与Longleixing之间相互转化
 */
@Component
public class IdConverterImpl implements IdConverter {

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

        System.out.println("   " + id.getMachine() + "     " + id.getSeq() + "    " + id.getTime() + "    "
                + id.getGenMethod()+ "     " + id.getType() + "    " + id.getVersion());

        System.out.println(idMeta.getSeqBitsStartPos() + "------" + idMeta.getTimeBitsStartPos() + "-----" +
                idMeta.getGenMethodBitsStartPos() + "----" + idMeta.getTypeBitsStartPos() + "----" + idMeta.getVersionBitsStartPos());

        ret |= id.getMachine();
        ret |= id.getSeq() << idMeta.getSeqBitsStartPos();
        ret |= id.getTime() << idMeta.getTimeBitsStartPos();
        ret |= id.getGenMethod() << idMeta.getGenMethodBitsStartPos();
        ret |= id.getType() << idMeta.getTypeBitsStartPos();
        ret |= id.getVersion() << idMeta.getVersionBitsStartPos();

        return ret;
    }

    @Override
    public Id convert(long id) {
        return doConvert(id, idMeta);
    }

    @Override
    public Id doConvert(long id, IdMeta idMeta) {
        Id ret = new Id();

        ret.setMachine(id & idMeta.getMachineBitsMask());
        ret.setSeq((id >>> idMeta.getSeqBitsStartPos()) & idMeta.getSeqBitsMask());
        ret.setTime((id >>> idMeta.getTimeBitsStartPos()) & idMeta.getTimeBitsMask()) ;
        ret.setGenMethod((id >>> idMeta.getGenMethodBitsStartPos()) & idMeta.getGenMethodBitsMask());
        ret.setType((id >>> idMeta.getTypeBitsStartPos()) & idMeta.getTypeBitsMask());
        ret.setVersion((id >>> idMeta.getVersionBitsStartPos()) & idMeta.getVersionBitsMask());

        return ret;
    }

    public IdMeta getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(IdMeta idMeta) {
        this.idMeta = idMeta;
    }
}
