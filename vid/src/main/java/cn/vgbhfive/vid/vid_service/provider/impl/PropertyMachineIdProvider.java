package cn.vgbhfive.vid.vid_service.provider.impl;

import cn.vgbhfive.vid.vid_service.provider.MachineIdProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @time:
 * @author: Vgbh
 */
@Component
@Qualifier("property")
public class PropertyMachineIdProvider implements MachineIdProvider {

    private long machineId;

    @Override
    public long getMachineId() {
        return 0;
    }

    public void setMachineId(long machineId) {
        this.machineId = machineId;
    }
}
