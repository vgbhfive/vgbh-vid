package cn.vgbhfive.vid.vid_service.provider.impl;

import cn.vgbhfive.vid.vid_service.provider.MachineIdProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @time:
 * @author: Vgbh
 */
@Component
@Qualifier("ip")
public class IpConfiguranleMachineIdProvider{ //implements MachineIdProvider {
    //@Override
    public long getMachineId() {
        return 0;
    }
}
