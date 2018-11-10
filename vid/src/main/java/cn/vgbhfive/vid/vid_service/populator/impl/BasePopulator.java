package cn.vgbhfive.vid.vid_service.populator.impl;

import cn.vgbhfive.vid.vid_intf.bean.Id;
import cn.vgbhfive.vid.vid_service.entity.IdMeta;
import cn.vgbhfive.vid.vid_service.entity.IdType;
import cn.vgbhfive.vid.vid_service.populator.IdPopulator;
import cn.vgbhfive.vid.vid_service.populator.ResetPopulator;
import cn.vgbhfive.vid.vid_service.util.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @time:
 * @author: Vgbh
 */
public abstract class BasePopulator implements IdPopulator, ResetPopulator {

    private static final Logger logger = LoggerFactory.getLogger(BasePopulator.class);

    protected long sequence = 0;
    protected long lastTimeStamp = -1;

    public BasePopulator () {
        super();
    }

    @Override
    public void populateId (Id id, IdMeta idMeta) {
        long timeStamp = TimeUtils.genTime(IdType.parse(id.getType()));//当前时间戳
        TimeUtils.validateTimestamp(lastTimeStamp, timeStamp);//判断是否准确

        if (timeStamp == lastTimeStamp) {//同一时刻下的并发获取Id
            sequence++;
            sequence &= idMeta.getSeqBitsMask();
            if (sequence == 0) {
                timeStamp = TimeUtils.tillNextTimeUnit(lastTimeStamp, IdType.parse(id.getType()));
            }
        } else {
            lastTimeStamp = timeStamp;
            sequence = 0;
        }

        id.setSeq(sequence);
        id.setTime(timeStamp);
        //logger.info(" BasePopulator 父类生成时间戳和序列号 ");
    }

    @Override
    public void reset () {
        this.sequence = 0;
        this.lastTimeStamp = -1;
    }

}
