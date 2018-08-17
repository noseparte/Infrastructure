package com.xmbl.controller.email;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xmbl.base.BaseController;
import com.xmbl.util.email.EmailUtils;
import com.xmbl.web.api.bean.ResponseResult;
import com.xmbl.web.api.bean.Route;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright © 2018 noseparte © BeiJing BoLuo Network Technology Co. Ltd.
 *
 * @Author Noseparte
 * @Compile 2018-08-10 -- 18:41
 * @Version 1.0
 * @Description
 */
@Slf4j
@RestController
@RequestMapping(value = Route.PATH + Route.Email.PATH)
@Api(value = "邮件服务",description = "邮件服务")
public class PTEmailController extends BaseController {


    /**
     * 发送邮件
     *
     * @param jsonData
     * @return ResponseResult
     */
    @ApiOperation(value = "发送邮件")
    @ApiImplicitParam(name = "jsonData", value = "邮件内容", required = true, dataType = "String")
    @RequestMapping(value = Route.Email.SEND,method = RequestMethod.POST)
    public ResponseResult send(@RequestParam(value="jsonData") String jsonData) {
        try {
            log.info("发送邮件controller 开始");
            JSONObject jsonObj = JSON.parseObject(jsonData);
            Assert.isTrue(jsonObj != null, "jsonObj 不能为空");
            boolean isSucc = EmailUtils.sendMailForSystem(jsonObj);;
            Assert.isTrue(isSucc, "发送邮件失败");
            log.info("发送邮件controller 结束");
            return successJson(isSucc);
        } catch (Exception e) {
            log.error("发送邮件controller报错了，错误信息为:",e.getMessage());
            return errorJson(e.getMessage());
        }
    }

}
