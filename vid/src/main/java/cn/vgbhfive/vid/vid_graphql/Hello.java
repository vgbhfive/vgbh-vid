package cn.vgbhfive.vid.vid_graphql;

import graphql.GraphQL;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import org.springframework.context.annotation.Bean;

import java.util.Map;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

/**
 * @time:
 * @author: Vgbh
 */
public class Hello {

    @Bean
    public String hello () {
        return "Hell World!";
    }

    public static void main (String[] args) {
        //服务端示例数据
        User user = new User();
        user.setId("12");
        user.setName("ssss");

        //定义GraphQL类型
        GraphQLObjectType userType = newObject()
                .name("User")
                .field(newFieldDefinition().type(GraphQLString).name("id").build())
                .field(newFieldDefinition().type(GraphQLString).name("name").build())
                .build();

        //定义暴露给客户端查询的query api
        GraphQLObjectType queryType = newObject()
                .name("userQuery")
                .field(newFieldDefinition().type(userType).name("user").staticValue(user).build())
                .build();

        //创建Schema
        GraphQLSchema schema = GraphQLSchema.newSchema()
                .query(queryType)
                .build();

        //测试输出
        GraphQL graphQL = GraphQL.newGraphQL(schema).build();
        Map<String, Object> result = graphQL.execute("{user{id,name}}").getData();
        System.out.println(result);
    }

    static class User {
        private String id;
        private String name;

        public User() {
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }


}
