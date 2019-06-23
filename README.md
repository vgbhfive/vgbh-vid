# vgbh-vid
Distribute sender
分布式ID分发器

### TODO 
1. 添加多种生成方法，满足各类需求。(进行中)
2. 进行相应的压测，确定Vid承受极限。
	1. 对RESTFul接口进行了多线程多任务的测试，发现了许多的问题，后续还会进行改进。
		1. 多线程测试问题已经解决，响应时间有了很明显的改善。(完成)
	2. 添加全局info输出按钮，防止测试无谓的输出影响。
		1. 修改了大部分的输出样式，采用日志输出，统一输出，统一解决。(完成)
3. 优化架构，满足多种需求，比如Netty等。
	1. 添加Netty架构，进一步提高QPS。(进行中)
4. 添加解析Vid接口，使用ID可以得到详细的ID信息。
	1. 接口已添加，方法未实现。
		1. 解析ID接口已实现，测试已通过。(完成)
5. GraphQL API接口添加完成，还未测试，并且暂时不能运行，还在进一步的修改中。
	1. 目前Error已被改正，可以正常运行。(进行中)
6. (Demo)构造伪造ID，对外提供接口，传入对应的参数，返回伪造的ID。
	1. 添加接口，还未实现。(进行中)
7. 将十进制转换为十六进制，进而减小存储空间。(进行中)
8. 为应对流量高峰，即加入流量控制组件和服务降级组件。(进行中)
9. 为应对不同用户的需求，将该分发器进行简易、中等、复杂的版本进行划分。(进行中)

### GraphQL
1. 添加了GraphQL的测试用例，为下一步的GraphQL开发做基础。
2. 添加GraphQL包，确保在可运行的前提下添加无误。
3. 更新API接口，满足多种条件下的请求和访问。

### RPC
1. 添加了RPC的服务接口，独立启动VidApplication没有任何错误。
2. 在启用RPC服务时，请先启动本机的Zookeeper服务，注意修改对应的参数。
3. RPC的Test测试还有Error，正在修理当中。

### 依赖
```
 	<dependencies>
        <!--Start-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <!--GraphQL-->
        <dependency>
            <groupId>com.graphql-java</groupId>
            <artifactId>graphql-spring-boot-starter</artifactId>
            <version>3.0</version>
        </dependency>

        <!--Dubbo-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>dubbo</artifactId>
            <version>2.5.3</version>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework</groupId>
                    <artifactId>spring</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

        <!--Zookeeper-->
        <dependency>
            <groupId>org.apache.zookeeper</groupId>
            <artifactId>zookeeper</artifactId>
            <version>3.4.5</version>
            <type>pom</type>
        </dependency>
        <dependency>
            <groupId>com.101tec</groupId>
            <artifactId>zkclient</artifactId>
            <version>0.2</version>
        </dependency>
        <dependency>
            <groupId>com.google.guava</groupId>
            <artifactId>guava</artifactId>
            <version>21.0</version>
        </dependency>

    </dependencies>
```

### 展示
#### REST 测试
[localhost:8080/vid/id](localhost:8080/vid/id)
![1](/img/1.jpg)

#### RPC 测试


### 后续
如果你觉得不错，可以点一个Star，谢谢。
若有其他的问题，欢迎提Issue。