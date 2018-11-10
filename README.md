# vgbh-vid
Distribute sender


### TODO 
1、添加多种生成方法，满足各类需求。
2、进行相应的压测，确定Vid承受极限。
	2.1、对RESTFul接口进行了多线程多任务的测试，发现了许多的问题，后续还会进行改进。
	2.2、添加全局info输出按钮，防止测试无谓的输出影响。
3、优化架构，满足多种需求，比如Netty等。。

### GraphQL
1、添加了GraphQL的测试用例，为下一步的GraphQL开发做基础。
2、添加GraphQL包，确保在可运行的前提下添加无误。
3、更新API接口，满足多种条件下的请求和访问。

### RPC
1、添加了RPC的服务接口，独立启动VidApplication没有任何错误。
2、在启用RPC服务时，请先启动本机的Zookeeper服务。
3、RPC的Test测试还有Error，正在修理当中。