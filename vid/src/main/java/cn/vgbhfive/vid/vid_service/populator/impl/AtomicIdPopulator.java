package cn.vgbhfive.vid.vid_service.populator.impl;

import cn.vgbhfive.vid.vid_intf.bean.Id;
import cn.vgbhfive.vid.vid_service.entity.IdMeta;
import cn.vgbhfive.vid.vid_service.entity.IdType;
import cn.vgbhfive.vid.vid_service.populator.IdPopulator;
import cn.vgbhfive.vid.vid_service.populator.ResetPopulator;
import cn.vgbhfive.vid.vid_service.util.TimeUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @time:
 * @author: Vgbh
 */
@Component
@Qualifier("atomic")
public class AtomicIdPopulator implements IdPopulator, ResetPopulator {

    class Variant {
        private long sequence = 0;
        private long lastTimeStamp = -1;
    }

    private AtomicReference<Variant> variant = new AtomicReference<>(new Variant());

    public AtomicIdPopulator() {
        super();
    }

    @Override
    public void populateId(Id id, IdMeta idMeta) {
        Variant varOld, varNew;
        long timestamp, sequence;

        while (true) {
            varOld = variant.get();

            timestamp = TimeUtils.genTime(IdType.parse(id.getType()));
            TimeUtils.validateTimestamp(varOld.lastTimeStamp, timestamp);

            sequence = varOld.sequence;

            if (timestamp == varOld.lastTimeStamp) {
                sequence++;
                sequence &= idMeta.getSeqBitsMask();
                if (sequence == 0) {
                    timestamp = TimeUtils.tillNextTimeUtil(varOld.lastTimeStamp, IdType.parse(id.getType()));
                }
            } else {
                sequence = 0;
            }

            varNew = new Variant();
            varNew.sequence = sequence;
            varNew.lastTimeStamp = timestamp;

            if (variant.compareAndSet(varOld, varNew)) {
                id.setSeq(sequence);
                id.setTime(timestamp);

                break;
            }

        }


    }

    @Override
    public void reset() {
        variant = new AtomicReference<Variant>(new Variant());
    }
}
