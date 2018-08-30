package cn.vgbhfive.vid.vid_graphql;

import cn.vgbhfive.vid.vid_intf.intf.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * @time:
 * @author: Vgbh
 */
public class Query {

    @Autowired
    private IdService idService;

    @Bean
    public Long getId () {
        return idService.genId();
    }

}
