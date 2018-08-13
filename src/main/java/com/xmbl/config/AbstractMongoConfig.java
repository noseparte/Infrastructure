package com.xmbl.config;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import lombok.Data;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;


/**
 * Copyright © 2018 noseparte © BeiJing BoLuo Network Technology Co. Ltd.
 *
 * @Author Noseparte
 * @Compile 2018-08-12 -- 17:09
 * @Version 1.0
 * @Description
 */
@Data
public class AbstractMongoConfig {

    protected String host;
    protected int port;
    protected String username;
    protected String password;
    protected String database;

    public MongoDbFactory mongoDbFactory(){
        ServerAddress serverAddress = new ServerAddress(host, port);
        return new SimpleMongoDbFactory(new MongoClient(serverAddress),database);
    }



}
