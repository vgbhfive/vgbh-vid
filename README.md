# vgbh-vid
Distribute sender

### TODO 
1、添加多种生成方法，满足各类需求。
2、进行相应的压测，确定Vid承受极限。
	2.1、对RESTFul接口进行了多线程多任务的测试，发现了许多的问题，后续还会进行改进。
		2.1.1、多线程测试问题已经解决，响应时间有了很明显的改善。
	2.2、添加全局info输出按钮，防止测试无谓的输出影响。
		2.2.1、修改了大部分的输出样式，采用日志输出，统一输出，统一解决。
3、优化架构，满足多种需求，比如Netty等。
4、添加解析Vid接口，使用ID可以得到详细的ID信息。
	4.1、接口已添加，方法未实现。
		4.1.1、解析ID接口已实现，测试已通过。
5、GraphQL API接口添加完成，还未测试，并且暂时不能运行，还在进一步的修改中。
	5.1、目前Error已被改正，可以正常运行。

### GraphQL
1、添加了GraphQL的测试用例，为下一步的GraphQL开发做基础。
2、添加GraphQL包，确保在可运行的前提下添加无误。
3、更新API接口，满足多种条件下的请求和访问。

### RPC
1、添加了RPC的服务接口，独立启动VidApplication没有任何错误。
2、在启用RPC服务时，请先启动本机的Zookeeper服务。
3、RPC的Test测试还有Error，正在修理当中。