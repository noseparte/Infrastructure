# Infrastructure
A distributed project built by SpringBoot+Dubbo+Zookeeper+MongoDB

SpringBoot 整合MongoDB多数据源

一、前情提要

1.环境：SpringBoot+Dubbo+Zookeeper+MongoDB

<!-- Spring Boot 启动父依赖 -->
<parent>    
	<groupId>org.springframework.boot</groupId>    
	<artifactId>spring-boot-starter-parent</artifactId>    
	<version>1.5.1.RELEASE</version>
</parent>
<dependencies>    
	<dependency>        
		<groupId>io.dubbo.springboot</groupId>        
		<artifactId>spring-boot-starter-dubbo</artifactId>        
		<version>${dubbo-spring-boot}</version>    
	</dependency>    
	<dependency>
		<groupId>org.springframework.boot</groupId>        
		<artifactId>spring-boot-starter-data-mongodb</artifactId>    
	</dependency>
</dependencies>

2.业务场景有多个数据源,因故需配置多数据源来满足业务需求
	* 平台服务器 platform_server
	* 支付服务器 payment_server
	* 登录服务器 login

二、准备工作

1.什么是SpringBoot                  http://www.ityouknow.com/springboot/2016/01/06/spring-boot-quick-start.html
2.SpringBoot 整合Dubbo/Zookeeper      https://www.cnblogs.com/Alandre/p/6490142.html
3.MongoDB Windows下的安装与部署       https://blog.csdn.net/Noseparte/article/details/78416846

三、开始搭建

	* AbstractMongoConfig 通用配置类获取MongoDbFactory
	* PrimaryMongoConfig    platform_server的MongoDbFactory
	* SecondaryMongoConfig    payment_server的mongoDbFactory
	* ThirdMongoConfig    login的mongoDbFactory
	* GeneralPaymentDaoImpl    在GeneralPaymentDaoImpl中的注入

四、源码地址     源码地址： https://github.com/noseparte/Infrastructure

