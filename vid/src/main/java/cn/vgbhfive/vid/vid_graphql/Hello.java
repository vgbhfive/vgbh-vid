package cn.vgbhfive.vid.vid_graphql;

//import com.coxautodev.graphql.tools.GraphQLResolver;
//import graphql.GraphQL;
//import graphql.schema.GraphQLObjectType;
//import graphql.schema.GraphQLSchema;
import org.springframework.context.annotation.Bean;
//import org.springframework.data.repository.CrudRepository;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;

//import java.util.Optional;

//import static graphql.Scalars.GraphQLInt;
//import static graphql.Scalars.GraphQLString;
//import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
//import static graphql.schema.GraphQLObjectType.newObject;

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
        //User user = new User();
        //user.setId(12);
        //user.setName("ssss");

        //定义GraphQL类型
        //GraphQLObjectType userType = newObject().name("User").field(newFieldDefinition().type(GraphQLInt).name("id").build()).field(newFieldDefinition().type(GraphQLString).name("name").build()).build();

        //定义暴露给客户端查询的query api
        //GraphQLObjectType queryType = newObject().name("userQuery").field(newFieldDefinition().type(userType).name("user").staticValue(user).build()).build();

        //创建Schema
        //GraphQLSchema schema = GraphQLSchema.newSchema().query(queryType).build();

        //测试输出
        //GraphQL graphQL = GraphQL
        //Map<String, Object> result = graphQL.execute("{user{id,name}}").getData();
        //System.out.println(result);




    }

//    @Entity
//    static class User {
//        @Id
//        @GeneratedValue
//        private Integer id;
//        private String name;
//
//        public User() {
//        }
//
//        public User(String name) {
//            this.name = name;
//        }
//
//        public Integer getId() {
//            return id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setId(Integer id) {
//            this.id = id;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        @Override
//        public int hashCode() {
//            return id.hashCode();
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            if (this == obj) {
//                return true;
//            }
//            if (obj == null || getClass() != obj.getClass()) {
//                return false;
//            }
//            User user = (User) obj;
//            return id.equals(user.id);
//        }
//
//        @Override
//        public String toString() {
//            return "User{" +
//                    "id='" + id + '\'' +
//                    ", name='" + name + '\'' +
//                    '}';
//        }
//
//    }
//
//    interface UserRepository extends CrudRepository<User, Integer> {
//
//    }
//
//    class UserResolve implements GraphQLResolver<User> {
//        private UserRepository userRepository;
//
//        public UserResolve(UserRepository userRepository) {
//            this.userRepository = userRepository;
//        }
//
//        public Optional<User> getUser(User user) {
//            return userRepository.findById(user.getId());
//        }
//    }


}
