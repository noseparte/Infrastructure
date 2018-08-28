package com.xmbl.controller.jms;

import com.xmbl.base.BaseController;
import com.xmbl.config.Producer;
import com.xmbl.web.api.bean.Response;
import com.xmbl.web.api.bean.Route;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

/**
 * Copyright © 2018 noseparte © BeiJing BoLuo Network Technology Co. Ltd.
 *
 * @Author Noseparte
 * @Compile 2018-08-14 -- 16:34
 * @Version 1.0
 * @Description ActiveMQ 消息队列管理中心i
 */
@Slf4j
@RestController
@RequestMapping(value = Route.PATH + Route.Jms.PATH)
@Api(value = "消息队列", description = "ActiveMQ 消息队列")
public class PTJmsController extends BaseController {

    @Autowired
    private Producer producer;

    /**
     * 添加邮件任务到消息队列
     *
     * @param jsonData
     * @return
     */
    @ApiOperation(value = "添加邮件任务到消息队列")
    @ApiImplicitParam(name = "消息内容", value = "jsonData", required = true, dataType = "String")
    @RequestMapping(value = Route.Jms.SEND_EMAIL_MESSAGE, method = RequestMethod.POST)
    public Response sendEmailQueue(@RequestParam(value = "jsonData", required = true) String jsonData) {
        long startTime = System.currentTimeMillis();
        log.info("infoMsg: ================================= 添加邮件任务到消息队列开始,startTime,{}", startTime);
        Response reponse = this.getReponse();
        try {
            Destination emailDestination = new ActiveMQQueue("emailQueue");
            producer.sendMessage(emailDestination, jsonData);

            long endTime = System.currentTimeMillis();
            log.info("infoMsg: ================================= 添加邮件任务到消息队列结束,endTime,{}", endTime);
            long spendTIme = endTime - startTime;
            log.info("infoMsg: ================================= 共计消耗时间,spendTIme,{}", spendTIme);
            return reponse.success();
        } catch (Exception e) {
            log.error("errorMsg:{ ============================== 添加邮件任务到消息队列失败,errorMessage,{}", e.getMessage());
            return reponse.failure(e.getMessage());
        }
    }


    /**
     * 添加邮件任务到订阅队列
     *
     * @param jsonData
     * @return
     */
    @ApiOperation(value = "添加邮件任务到订阅队列")
    @ApiImplicitParam(name = "消息内容", value = "jsonData", required = true, dataType = "String")
    @RequestMapping(value = Route.Jms.SUBSCRIBE_EMAIL_MESSAGE, method = RequestMethod.POST)
    public Response sendEmailTopic(@RequestParam(value = "jsonData", required = true) String jsonData) {
        long startTime = System.currentTimeMillis();
        log.info("infoMsg: ================================= 添加邮件任务到订阅队列开始,startTime,{}", startTime);
        Response reponse = this.getReponse();
        try {
            Destination emailDestination = new ActiveMQTopic("emailTopic");
            producer.sendMessage(emailDestination, jsonData);

            long endTime = System.currentTimeMillis();
            log.info("infoMsg: ================================= 添加邮件任务到订阅队列结束,endTime,{}", endTime);
            long spendTIme = endTime - startTime;
            log.info("infoMsg: ================================= 共计消耗时间,spendTIme,{}", spendTIme);
            return reponse.success();
        } catch (Exception e) {
            log.error("errorMsg:{ ============================== 添加邮件任务到订阅队列失败,errorMessage,{}", e.getMessage());
            return reponse.failure(e.getMessage());
        }
    }


}
