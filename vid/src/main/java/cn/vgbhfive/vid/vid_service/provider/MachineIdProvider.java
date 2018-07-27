package cn.vgbhfive.vid.vid_service.provider;

import org.springframework.stereotype.Service;

/**
 * @time:
 * @author: Vgbh
 *
 * 由于生成的ID是由机器的机器号所决定的，因此生成ID的方式是一个重要的因素。
 */
@Service
public interface MachineIdProvider {

    long getMachineId ();

}
