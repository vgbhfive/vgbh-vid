package cn.vgbhfive.vid.vid_graphql.datafetcher;

import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

/**
 * 数据获取
 *
 * @time: 2019/1/14
 * @author: Vgbh
 */
@Component
public class GraphqlDataFetchers {

    public DataFetcher getHelloDataFetcher() {
        return environment -> "World";
    }

    public DataFetcher getVidDataFetcher() {
        return environment -> environment.getArgument("vid");
    }

}
