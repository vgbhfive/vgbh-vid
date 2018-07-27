package cn.vgbhfive.vid.vid_service.service.impl;

import cn.vgbhfive.vid.vid_intf.bean.Id;
import cn.vgbhfive.vid.vid_service.entity.IdType;
import cn.vgbhfive.vid.vid_service.populator.IdPopulator;
import cn.vgbhfive.vid.vid_service.populator.impl.AtomicIdPopulator;
import cn.vgbhfive.vid.vid_service.populator.impl.LockIdPopulator;
import cn.vgbhfive.vid.vid_service.populator.impl.SyncIdPopulator;
import cn.vgbhfive.vid.vid_service.service.AbstractIdServiceImpl;
import cn.vgbhfive.vid.vid_service.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @time:
 * @author: Vgbh
 */
@Component
public class IdServiceImpl extends AbstractIdServiceImpl {

    private static final String SYNC_LOCK_IMPL_KEY = "vid.sync.lock.impl.key" ;

    private static final String ATOMIC_IMPL_KEY = "vid.atomic.impl.key" ;

    @Autowired
    private IdPopulator idPopulator ;

    public IdServiceImpl() {
        super();
        initPopulator();
    }

    public IdServiceImpl(String type) {
        super(type);
        initPopulator();
    }

    public IdServiceImpl(IdType type) {
        super(type);
        initPopulator();
    }

    private void initPopulator() {
        if(idPopulator != null){
            log.info("The " + idPopulator.getClass().getCanonicalName() + " is used.");
        } else if (CommonUtils.isPropKeyOn(SYNC_LOCK_IMPL_KEY)) {
            log.info("The SyncIdPopulator is used.");
            //idPopulator = new SyncIdPopulator();
        } else if (CommonUtils.isPropKeyOn(ATOMIC_IMPL_KEY)) {
            log.info("The AtomicIdPopulator is used.");
            idPopulator = new AtomicIdPopulator();
        } else {
            log.info("The default LockIdPopulator is used.");
            //idPopulator = new LockIdPopulator();
        }
    }

    @Override
    protected void populateId(Id id) {
        idPopulator.populateId(id, this.idMeta);
    }

    public void setIdPopulator(IdPopulator idPopulator) {
        this.idPopulator = idPopulator;
    }
}
