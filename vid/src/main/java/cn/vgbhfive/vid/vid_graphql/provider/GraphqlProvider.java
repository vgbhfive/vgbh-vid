package cn.vgbhfive.vid.vid_graphql.provider;

import cn.vgbhfive.vid.vid_graphql.datafetcher.GraphqlDataFetchers;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

/**
 * GraphQL架构
 *
 * @time: 2019/1/14
 * @author: Vgbh
 */
@Component
public class GraphqlProvider {

    private GraphQL graphQL;

    @Autowired
    GraphqlDataFetchers graphqlDataFetcher;

    @PostConstruct
    public void init() throws IOException {
        URL url = Resources.getResource("graphql/schema.graphql");
        String sdl = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();

        return schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(TypeRuntimeWiring.newTypeWiring("Query")
                    .dataFetcher("hello", graphqlDataFetcher.getHelloDataFetcher())
                    .dataFetcher("vid", graphqlDataFetcher.getVidDataFetcher())
                    .build())
                .build();
    }

    @Bean
    public GraphQL graphQL() {
        return this.graphQL;
    }

}
