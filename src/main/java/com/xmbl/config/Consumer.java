package com.xmbl.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xmbl.util.email.EmailUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * Copyright © 2018 noseparte © BeiJing BoLuo Network Technology Co. Ltd.
 *
 * @Author Noseparte
 * @Compile 2018-05-29 -- 19:10
 * @Version 1.0
 * @Description
 */
@Slf4j
@Component
    public class Consumer {

        @JmsListener(destination = "emailQueue")
        public void receiveEmailQueue(final TextMessage text, Session session)
                throws JMSException {
            try {
                log.info("邮件队列收到的报文为: message,{}", text.getText());
                text.acknowledge();// 使用手动签收模式，需要手动的调用，如果不在catch中调用session.recover()消息只会在重启服务后重发
                JSONObject jsonObj = JSON.parseObject(text.getText());
                boolean isSucc = EmailUtils.sendMailForSystem(jsonObj);
                Assert.isTrue(isSucc, "发送邮件失败");
            } catch (Exception e) {
                log.error("errorMsg:{ ============================ 发送邮件失败,错误信息为：,errorMsg,{}", e.getMessage());
                session.recover();// 此不可省略 重发信息使用
            }
        }


        @JmsListener(destination = "smsQueue")
    public void receiveSMSQueue(final TextMessage text, Session session)
            throws JMSException {
        try {
            log.info("短信队列收到的报文为: message,{}", text.getText());
            text.acknowledge();// 使用手动签收模式，需要手动的调用，如果不在catch中调用session.recover()消息只会在重启服务后重发
            JSONObject jsonObj = JSON.parseObject(text.getText());
            boolean isSucc = EmailUtils.sendMailForSystem(jsonObj);
            Assert.isTrue(isSucc, "发送短信失败");
        } catch (Exception e) {
            log.error("errorMsg:{ ============================ 发送短信失败,错误信息为：,errorMsg,{}", e.getMessage());
            session.recover();// 此不可省略 重发信息使用
        }
    }

    @JmsListener(destination = "emailTopic",containerFactory = "myJmsContainerFactory")
    public void receiveEmailTopic(final TextMessage text, Session session)
            throws JMSException {
        try {
            log.info("邮件主题收到的报文为: message,{}", text.getText());
            text.acknowledge();// 使用手动签收模式，需要手动的调用，如果不在catch中调用session.recover()消息只会在重启服务后重发
            JSONObject jsonObj = JSON.parseObject(text.getText());
            boolean isSucc = EmailUtils.sendMailForSystem(jsonObj);
            Assert.isTrue(isSucc, "发送邮件失败");
        } catch (Exception e) {
            log.error("errorMsg:{ ============================ 发送邮件失败,错误信息为：,errorMsg,{}", e.getMessage());
            session.recover();// 此不可省略 重发信息使用
        }
    }

    @Bean
    JmsListenerContainerFactory<?> myJmsContainerFactory(ConnectionFactory connectionFactory){
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }


}
