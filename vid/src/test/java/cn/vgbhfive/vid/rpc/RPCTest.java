package cn.vgbhfive.vid.rpc;

import cn.vgbhfive.vid.vid_rpc.server.impl.RPCService;
import com.alibaba.dubbo.common.utils.NetUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @time: 2018/11/7
 * @author: Vgbh
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RPCTest {

    @Test
    public void rpcTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"consumer.xml"});
        RPCService service = (RPCService) context.getBean("IdService");
        long id = service.genId();
        System.out.print("\n\n\n--------------" + id + "--------\n\n\n");
    }

    @Test
    public void ipTest() {
        System.out.print(NetUtils.getLocalAddress());
        //LocalAddress:192.19.45.157
    }
}

