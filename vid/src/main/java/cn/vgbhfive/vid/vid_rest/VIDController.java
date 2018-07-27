package cn.vgbhfive.vid.vid_rest;

import cn.vgbhfive.vid.vid_intf.intf.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @time:
 * @author: Vgbh
 *
 * 对外提供REST访问接口
 */
@RestController("/vid")
@ComponentScan("cn.vgbhfive.vid")
public class VIDController {

    @Autowired
    private IdService idService;

    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public long getId() {
        return idService.genId();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String hello() {
        return "Hello World";
    }


}

