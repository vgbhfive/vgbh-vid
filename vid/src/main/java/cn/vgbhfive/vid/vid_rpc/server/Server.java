package cn.vgbhfive.vid.vid_rpc.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @time: 2018/11/7
 * @author: Vgbh
 */
@Component
public class Server {

    public void server() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"provider.xml"});
        context.start();

        System.in.read();
    }

}
