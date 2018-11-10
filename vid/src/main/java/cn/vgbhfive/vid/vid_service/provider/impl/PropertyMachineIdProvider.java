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
@Qualifier("property")
public class PropertyMachineIdProvider implements MachineIdProvider {

    private static final Logger logger = LoggerFactory.getLogger(PropertyMachineIdProvider.class);

    private long machineId;

    //从配置文件中获取机器ID
    public PropertyMachineIdProvider() {
        //logger.info(" PropertyMachineIdProvider construct! ");
    }

    @Override
    public long getMachineId() {

        return 0;
    }

    public void setMachineId(long machineId) {
        this.machineId = machineId;
    }
}
