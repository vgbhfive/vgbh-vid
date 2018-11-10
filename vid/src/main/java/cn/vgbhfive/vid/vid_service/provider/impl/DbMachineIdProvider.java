package cn.vgbhfive.vid.vid_service.provider.impl;

import cn.vgbhfive.vid.vid_service.provider.MachineIdProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @time:
 * @author: Vgbh
 */
@Component
@Qualifier("db")
public class DbMachineIdProvider implements MachineIdProvider {

    /*
        这是从数据库中获取相应的MachineId
     */

    private static final Logger log = LoggerFactory.getLogger(DbMachineIdProvider.class);

    private long machineId;

    //预留JDBC模板，在大规模存取情况下择优选择
    //private JdbcTemplate jdbcTemplate;

    public DbMachineIdProvider () {
        //log.info(" DbMachineIdProvider constructed! ");
    }

    //方法主体
    public void init() {

    }

    @Override
    public long getMachineId() {
        return machineId;
    }

    public void setMachineId (long machineId) {
        this.machineId = machineId;
    }
}
