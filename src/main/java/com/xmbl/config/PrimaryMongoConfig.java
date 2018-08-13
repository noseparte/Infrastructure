package com.xmbl.config;

import com.mongodb.MongoClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * Copyright © 2018 noseparte © BeiJing BoLuo Network Technology Co. Ltd.
 *
 * @Author Noseparte
 * @Compile 2018-08-12 -- 17:12
 * @Version 1.0
 * @Description     platform_server
 */
@Configuration
@ConfigurationProperties(prefix = "spring.data.mongodb.primary")
public class PrimaryMongoConfig extends AbstractMongoConfig{

    /**
     * 本地mongodb不需要密码，用这个
     */
    public MongoDbFactory mongoDbFactory(){
        return new SimpleMongoDbFactory(new MongoClient(host, port), database);
    }

    @Primary
    @Bean(name="mongoTemplate")
    public MongoTemplate getMongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }


}
