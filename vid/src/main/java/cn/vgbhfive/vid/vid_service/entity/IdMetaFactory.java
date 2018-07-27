package cn.vgbhfive.vid.vid_service.entity;

import org.springframework.stereotype.Component;

/**
 * @time:
 * @author: Vgbh
 */
@Component
public class IdMetaFactory {

    //最大峰值型
    private static final IdMeta MaxPeak = new IdMeta((byte) 10, (byte) 20, (byte) 30 ,(byte) 2,(byte) 1,(byte) 1);

    //最小粒度型
    private static final IdMeta MinGranularity = new IdMeta((byte) 10, (byte) 20, (byte) 30 ,(byte) 2,(byte) 1,(byte) 1);


    public static IdMeta getIdMeta (IdType idType) {
        if (IdType.MAX_PEAK.equals(idType)) {
            return MaxPeak;
        } else if (IdType.MIN_GRANULARITY.equals(idType)) {
            return MinGranularity;
        }

        return null;
    }

}
