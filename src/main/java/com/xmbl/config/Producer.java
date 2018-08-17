package com.xmbl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * Copyright © 2018 noseparte © BeiJing BoLuo Network Technology Co. Ltd.
 *
 * @Author Noseparte
 * @Compile 2018-07-12 -- 14:47
 * @Version 1.0
 * @Description
 */
@Service
public class Producer {

    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * 发送消息，estination是发送到的队列，message是待发送的消息
     *
     * @param destination
     * @param message
     */
    public void sendMessage(Destination destination, final String message) {
//        System.out.println(jmsTemplate.getDeliveryMode());  //deliveryMode  ? 2:1 Persistent和nonpersistent的消息(是否持久)
        jmsTemplate.convertAndSend(destination, message);
    }

    /**
     * 发送消息，message是待发送的消息
     *
     * @param message
     */
    public void sendMessage(final String message) {
//        System.out.println(jmsTemplate.getDeliveryMode());
        jmsTemplate.convertAndSend("emailQueue", message);
    }


}
