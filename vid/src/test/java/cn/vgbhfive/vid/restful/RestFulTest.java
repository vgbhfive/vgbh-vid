package cn.vgbhfive.vid.restful;

import cn.vgbhfive.vid.vid_rest.VIDController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @time:
 * @author: Vgbh
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RestFulTest {

    @Autowired
    private VIDController vidController;

    //普通样例测试
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

    }

}
