package cn.vgbhfive.vid.vid_rest;

import cn.vgbhfive.vid.vid_intf.intf.IdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
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

    private static final Logger logger = LoggerFactory.getLogger(VIDController.class);

    @Autowired
    private IdService idService;

    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public long getId() {
        Long id = idService.genId();
        logger.info("Client request for a ID,successful！！！ --- ID：" + id);
        return id;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String hello() {
        logger.info("Client test successful！ --- Hello World.");
        return "Hello World";
    }


}

