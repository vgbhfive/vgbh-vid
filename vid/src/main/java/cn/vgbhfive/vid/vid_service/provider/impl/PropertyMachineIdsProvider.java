package cn.vgbhfive.vid.vid_service.provider.impl;

import cn.vgbhfive.vid.vid_service.provider.MachineIdsProvider;

/**
 * @time:
 * @author: Vgbh
 */
public class PropertyMachineIdsProvider implements MachineIdsProvider {
    private long[] machineIds;
    private int currentIndex;

    @Override
    public long getNextMachineId () {
        return getMachineId();
    }

    public long getMachineId() {
        return machineIds[currentIndex++%machineIds.length];
    }

    public void setMachineIds (long[] machineIds) {
        this.machineIds = machineIds;
    }

}
