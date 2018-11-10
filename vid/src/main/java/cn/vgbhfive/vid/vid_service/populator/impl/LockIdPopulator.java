package cn.vgbhfive.vid.vid_service.populator.impl;

import cn.vgbhfive.vid.vid_intf.bean.Id;
import cn.vgbhfive.vid.vid_service.entity.IdMeta;
import cn.vgbhfive.vid.vid_service.populator.IdPopulator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @time:
 * @author: Vgbh
 */
@Component
@Qualifier("lock")
public class LockIdPopulator extends BasePopulator {

    private static final Logger logger = LoggerFactory.getLogger(LockIdPopulator.class);

    private Lock lock = new ReentrantLock();

    public LockIdPopulator () {
        super();
    }

    public void populateId(Id id, IdMeta idMeta) {
        lock.lock();
        try {
            super.populateId(id, idMeta);
        } finally {
            lock.unlock();
        }

        //logger.info("LockIdPopulator 由父类生成时间戳和序列号 ");
    }

}
