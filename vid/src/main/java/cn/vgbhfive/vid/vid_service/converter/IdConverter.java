package cn.vgbhfive.vid.vid_service.converter;

import cn.vgbhfive.vid.vid_intf.bean.Id;
import cn.vgbhfive.vid.vid_service.entity.IdMeta;
import org.springframework.stereotype.Component;

/**
 * @time:
 * @author: Vgbh
 *
 * 将Id类型的实例转换为long类型的实例
 */
@Component
public interface IdConverter {

    long convert(Id id);

    long doConvert(Id id, IdMeta idMeta);

    Id convert(long id);

    Id doConvert (long id, IdMeta idMeta);
}
