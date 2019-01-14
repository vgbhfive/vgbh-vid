package cn.vgbhfive.vid.vid_service.populator.impl;

import cn.vgbhfive.vid.vid_intf.bean.Id;
import cn.vgbhfive.vid.vid_service.entity.IdMeta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @time:
 * @author: Vgbh
 */
@Component
@Qualifier("sync")
public class SyncIdPopulator extends BasePopulator {

    private static final Logger log = LoggerFactory.getLogger(SyncIdPopulator.class);

    public SyncIdPopulator () {
        super();
    }

    public synchronized void populateId(Id id, IdMeta idMeta) {
        super.populateId(id, idMeta);
        //log.info("SyncIdPopulator 由父类生成时间戳和序列号 ");
    }
}
