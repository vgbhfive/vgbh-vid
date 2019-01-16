package cn.vgbhfive.vid.vid_service.service;

import cn.vgbhfive.vid.vid_intf.bean.Id;
import cn.vgbhfive.vid.vid_intf.intf.IdService;
import cn.vgbhfive.vid.vid_service.converter.IdConverter;
import cn.vgbhfive.vid.vid_service.converter.impl.IdConverterImpl;
import cn.vgbhfive.vid.vid_service.entity.IdMeta;
import cn.vgbhfive.vid.vid_service.entity.IdMetaFactory;
import cn.vgbhfive.vid.vid_service.entity.IdType;
import cn.vgbhfive.vid.vid_service.provider.MachineIdProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 主逻辑被封装在抽象父类中AbstractIdServiceImpl中
 *
 * @time:
 * @author: Vgbh
 */
@Component
public abstract class AbstractIdServiceImpl implements IdService {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    //以下四个属性分别表示集器ID、生成方式、类型和版本，对于任意一个发号器实例，这些属性一旦固定下来是不会改变的。
    protected long machineId = -1;
    protected long genMethod = 0;
    protected long type = 0;
    protected long version = 0;

    protected IdType idType;
    protected IdMeta idMeta;

    @Autowired
    private IdConverter idConverter;

    @Autowired
    @Qualifier("property")
    private MachineIdProvider machineIdProvider;

    public AbstractIdServiceImpl(IdType type) {
        idType = type;
    }

    public AbstractIdServiceImpl(String type) {
        idType = IdType.parse(type);
    }

    public AbstractIdServiceImpl() {
        idType = IdType.MAX_PEAK;
    }

    public void init() {
        this.machineId = machineIdProvider.getMachineId();
        //log.info("+++++++++++++++++++++++++++" + this.machineId + "++++++++++++++++++++++");

        if (machineId < 0) {
            log.error("The machine ID is not configured properly so that Vesta Service refuses to start.");
            throw new IllegalStateException(
                    "The machine ID is not configured properly so that Vesta Service refuses to start.");
        }
        if(this.idMeta == null){
            setIdMeta(IdMetaFactory.getIdMeta(idType));
            setType(idType.value());
        } else {
            if(this.idMeta.getTimeBits() == 30){
                setType(0);
            } else if(this.idMeta.getTimeBits() == 40){
                setType(1);
            } else {
                throw new RuntimeException("Init Error. The time bits in IdMeta should be set to 30 or 40!");
            }
        }
        setIdConverter(new IdConverterImpl(this.idMeta));
    }

    //模板回调函数，调用IdPopulator
    protected abstract void populateId(Id id) ;

    @Override
    public long genId() {
        init();
        Id id = new Id();
        id.setGenMethod(genMethod);
        id.setMachine(machineId);
        id.setType(type);
        id.setVersion(version);

        populateId(id);

        long ret = idConverter.convert(id);

        if (log.isTraceEnabled()) {
            log.trace(String.format("-----------ID：%s => %d----------"), id, ret);
        }
        //System.out.println(ret);
        return ret;
    }

    @Override
    public Id expId(long id) {
        return idConverter.convert(id);
    }

    @Override
    public long makeId(long time, long seq) {
        return 0;
    }

    @Override
    public long makeId(long time, long seq, long machine) {
        return 0;
    }

    @Override
    public long makeId(long genMethod, long time, long seq, long machine) {
        return 0;
    }

    @Override
    public long makeId(long type, long genMethod, long time, long seq, long machine) {
        return 0;
    }

    @Override
    public long makeId(long varsion, long type, long genMethod, long time, long seq, long machine) {
        return 0;
    }

    @Override
    public Date transTime(long time) {
        return null;
    }

    //getter、setter
    public void setMachineId(long machineId) {
        this.machineId = machineId;
    }

    public void setGenMethod(long genMethod) {
        this.genMethod = genMethod;
    }

    public void setType(long type) {
        this.type = type;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public void setIdMeta(IdMeta idMeta) {
        this.idMeta = idMeta;
    }

    public void setIdConverter(IdConverter idConverter) {
        this.idConverter = idConverter;
    }

    public void setMachineIdProvider(MachineIdProvider machineIdProvider) {
        this.machineIdProvider = machineIdProvider;
    }

}
