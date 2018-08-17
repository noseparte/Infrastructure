package com.xmbl;

import com.xmbl.config.Producer;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.jms.Destination;

@SpringBootApplication
@ComponentScan(basePackages = {"com.xmbl"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//开启异步任务
@EnableAsync
public class InfrastructureApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfrastructureApplication.class, args);
    }

}
