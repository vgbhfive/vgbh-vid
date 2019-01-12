package cn.vgbhfive.vid.restful;

import cn.vgbhfive.vid.vid_rest.VIDController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @time: 2019/1/12
 * @author: Vgbh
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RestFulTest {

    private static final Logger log = LoggerFactory.getLogger(RestFulTest.class);

    @Autowired
    private VIDController vidController;

    //普通测试
    @Test
    public void VidTest () {
        System.out.println("1 Vid: " + vidController.getId());
        System.out.println("2 Vid: " + vidController.getId());
        System.out.println("3 Vid: " + vidController.getId());
        System.out.println("4 Vid: " + vidController.getId());
    }

    //多线程测试
    @Test
    public void VidThreadTest () {
        //执行调用
        Runnable runable = new Runnable() {
            @Override
            public void run() {
                //log.info("" + vidController.getId());
                System.out.println(vidController.getId() + "    " + System.currentTimeMillis());
            }
        };

        //线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                8, 10, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());

        //执行
        for (int i = 0; i < 100; i++) {
            executor.execute(runable);
        }

        /*
        未使用线程池前，在经过多线程的测试中，发现了以下问题：
        1、多线程的请求中vidController会出现空指针的问题。
        2、多线程请求的过程中，线程请求还未结束，项目便已经停止了运行。
        3、多线程多任务的情况下们会出现大面积的请求错误现象。
        4、多线程多任务的请求下，map无法记录产生的ID，无法记录是否产生错误的ID。
         */

        /*
        使用线程池，经过测试：
        1、请求100次，响应时间为16毫秒。
        2、没有出现空指针问题了。
        3、没有请求错误的出现。
         */
    }


}
