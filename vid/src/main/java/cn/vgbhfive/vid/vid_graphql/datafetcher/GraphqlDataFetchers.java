package cn.vgbhfive.vid.vid_graphql.datafetcher;

import cn.vgbhfive.vid.vid_intf.intf.IdService;
import graphql.schema.DataFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 数据获取
 *
 * @time: 2019/1/14
 * @author: Vgbh
 */
@Component
public class GraphqlDataFetchers {

    private static final Logger log = LoggerFactory.getLogger(GraphqlDataFetchers.class);

    @Autowired
    private IdService idService;

    public DataFetcher getHelloDataFetcher() {
        log.info("Hello World!");
        return environment -> "World";
    }

    public DataFetcher getVidDataFetcher() {
        long id = idService.genId();
        log.info("Client request for a ID,successful！！！ --- ID：" + id);
        return environment -> id;
    }

}
