package cn.vgbhfive.vid.vid_service.util;

import cn.vgbhfive.vid.vid_service.entity.IdType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @time:
 * @author: Vgbh
 */
public class TimeUtils {

    protected static final Logger log = LoggerFactory.getLogger(TimeUtils.class);

    public static final long EPOCH = 1420041600000L;

    //根据IdType判断并获取当前系统时间
    public static long genTime(final IdType idType) {
        if (idType == IdType.MAX_PEAK) {
            return (System.currentTimeMillis() - TimeUtils.EPOCH) / 1000;
        } else if (idType == IdType.MIN_GRANULARITY) {
            return System.currentTimeMillis() - TimeUtils.EPOCH;
        }
        return (System.currentTimeMillis() - TimeUtils.EPOCH) / 1000;
    }

    //判断时间是否准确
    public static void validateTimestamp(long lastTimeStamp, long timestamp) {
        if (timestamp < lastTimeStamp) {
            if (log.isErrorEnabled())
                log.error(String
                        .format("Clock moved backwards.  Refusing to generate id for %d second/milisecond.",
                                lastTimeStamp - timestamp));

            throw new IllegalStateException(
                    String.format(
                            "Clock moved backwards.  Refusing to generate id for %d second/milisecond.",
                            lastTimeStamp - timestamp));
        }

    }

    public static long tillNextTimeUnit(long lastTimeStamp, IdType idType) {
        long timeStamp = 0;

        if (log.isInfoEnabled()) {
            log.error(String.format("Clock moved backwards.  Refusing to generate id for %d second/milisecond.",
                    lastTimeStamp));
            timeStamp = TimeUtils.genTime(idType);
            while (timeStamp <= lastTimeStamp) {
                timeStamp = TimeUtils.genTime(idType);
            }
        }

        if (log.isInfoEnabled()) {
            log.error(String.format("Clock moved backwards.  Refusing to generate id for %d second/milisecond.",
                    timeStamp));
        }
        return timeStamp;
    }
}
