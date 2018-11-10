package cn.vgbhfive.vid.restful;

import cn.vgbhfive.vid.vid_rest.VIDController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @time:
 * @author: Vgbh
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RestFulTest implements Runnable{

    private ConcurrentHashMap<Long, Integer> map = new ConcurrentHashMap<Long, Integer>();

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
        for (int i = 0; i < 50; ++i) {
            new Thread(new RestFulTest()).start();
        }
        System.out.print("\n\n\n\nsssss\n\n\n\n");
        long ll = 11;
        map.put(ll, 12);
        for(Map.Entry<Long, Integer> entry: map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }

    @Override
    public void run() {
        try {
            long id1 = vidController.getId();
            System.out.println(id1);
            map.put(id1, 1 + map.get(id1));
            Thread.sleep(100);

            long id2 = vidController.getId();
            System.out.println(id2);
            map.put(id2, 1 + map.get(id2));
            Thread.sleep(100);

            long id3 = vidController.getId();
            System.out.println(id3);
            map.put(id3, 1 + map.get(id3));
            Thread.sleep(100);

            long id4 = vidController.getId();
            System.out.println(id4);
            map.put(id4, 1 + map.get(id4));
            Thread.sleep(100);

            long id5 = vidController.getId();
            System.out.println(id5);
            map.put(id5, 1 + map.get(id5));
            //Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
        在经过多线程的测试中，发现了以下问题：
        1、多线程的请求中vidController会出现空指针的问题。
        2、多线程请求的过程中，线程请求还未结束，项目便已经停止了运行。
        3、多线程多任务的情况下们会出现大面积的请求错误现象。
        4、多线程多任务的请求下，map无法记录产生的ID，无法记录是否产生错误的ID。
         */
    }
}
