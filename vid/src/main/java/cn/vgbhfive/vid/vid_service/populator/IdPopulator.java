package cn.vgbhfive.vid.vid_service.populator;

import cn.vgbhfive.vid.vid_intf.bean.Id;
import cn.vgbhfive.vid.vid_service.entity.IdMeta;
import org.springframework.stereotype.Service;

/**
 * @time:
 * @author: Vgbh
 *
 * 用于计算构成唯一ID的格式中的另外两个变量：序列号和时间
 */
@Service
public interface IdPopulator {

    void populateId (Id id, IdMeta idMeta) ;

}
