package cn.vgbhfive.vid.vid_rest;

import cn.vgbhfive.vid.vid_intf.bean.Id;
import cn.vgbhfive.vid.vid_intf.intf.IdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 对外提供REST访问接口
 *
 * @time:
 * @author: Vgbh
 */
@RestController("/vid")
@ComponentScan("cn.vgbhfive.vid")
public class VIDController {

    private static final Logger log = LoggerFactory.getLogger(VIDController.class);

    @Autowired
    private IdService idService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String hello() {
        //log.info("Client test successful！ --- Hello World.");
        return "Hello World";
    }

    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public long getId() {
        Long id = idService.genId();
        //log.info("Client request for a ID,successful！ --- ID：" + id);
        return id;
    }

    @RequestMapping(value = "/expid", method = RequestMethod.GET)
    public Id expId(@RequestParam("id") long id) {
        Id result = idService.expId(id);
        //log.info("Client exp Id successful！--- Result: " + result.toString());
        return result;
    }


}

