package cn.vgbhfive.vid.vid_intf.intf;


import cn.vgbhfive.vid.vid_intf.bean.Id;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @time:
 * @author: Vgbh
 *
 * 对外唯一接口
 */
@Component
public interface IdService {

    //获取并产生唯一ID
    long genId () ;

    //产生唯一ID的反向操作，将ID信息以人为可见的方式进行表达
    Id expId (long id) ;

    //伪造某一时间的ID
    long makeId (long time, long seq) ;

    long makeId (long time, long seq, long machine) ;

    long makeId (long genMethod, long time, long seq, long machine) ;

    long makeId (long type, long genMethod, long time, long seq, long machine) ;

    long makeId (long varsion, long type, long genMethod, long time, long seq, long machine) ;

    //将整形时间翻译为格式化时间
    Date transTime (long time) ;

}
