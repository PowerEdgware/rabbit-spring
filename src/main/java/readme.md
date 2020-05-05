### spring 集成整合 rabbitmq 20200502  

> core lib spring-amqp/spring-rabbit  
> Spring AMQP版本：2.2.6.RELEASE  
>note : spring-amqp is the base abstraction, 
and spring-rabbit is the RabbitMQ implementation.

#### 官网快速入门
1.[spring-amqp官网地址](https://docs.spring.io/spring-amqp/docs/2.2.6.RELEASE/reference/html/#quick-tour)  
2.[spring-amqp github例子](https://github.com/spring-projects/spring-amqp-samples)  
3.[spring-amqp rabbitmq官方整合的例子](https://www.rabbitmq.com/getstarted.html)每一个tutorial的 最下方Spring-AMQP链接,都是基于springboot实现。


** 依赖包和版本**  
1.spring-amqp版本：2.2.6.RELEASE

```
<dependency>
  <groupId>org.springframework.amqp</groupId>
  <artifactId>spring-rabbit</artifactId>
  <version>2.2.6.RELEASE</version>
</dependency>
```

2.`spring framework`最低版本：5.2.0.  
3.`amqp-client`最低版本：5.7.0  

#### 几种整合方式  

** Very, Very Quick**  

`com.study.quickiest` 包

** Xml based configuration**  

> 地址：https://docs.spring.io/spring-amqp/docs/2.2.6.RELEASE/reference/html/#_with_xml_configuration

`com.study.xml` 包

** Java Configuration**  

`com.study.javaconfig`

** springboot 方式**  

`com.study.springboot`

> note: 上述几种整合都是很简单的demo如果要深入点的例子还得去看spring-amqp官网和rabbitmq官网提供的
>spring-amqp的例子。


### 使用Spring AMQP  

