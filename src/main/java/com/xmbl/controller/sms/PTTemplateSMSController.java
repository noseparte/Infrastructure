package com.xmbl.controller.sms;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSONObject;
import com.xmbl.base.BaseController;
import com.xmbl.service.sms.SendSmsService;
import com.xmbl.web.api.bean.ResponseResult;
import com.xmbl.web.api.bean.Route;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * Copyright © 2018 noseparte © BeiJing BoLuo Network Technology Co. Ltd.
 * @Author Noseparte
 * @Compile 2018年8月2日 -- 下午4:52:07
 * @Version 1.0
 * @Description		短信服务	
 */
@Slf4j
@RestController
@RequestMapping(value = Route.PATH + Route.SMS.PATH)
@Api(value = "短信服务",description = "短信服务")
public class PTTemplateSMSController extends BaseController{
	
	@Autowired
	private SendSmsService sendSmsService;

	/**
	 * 发送短信
	 *
	 * @param jsonData
	 * @return
	 */
	@ApiOperation(value = "发送短信")
	@ApiImplicitParam(name = "短信内容",value = "jsonData",required = true,dataType = "String")
	@RequestMapping(value = Route.SMS.SEND, method = RequestMethod.POST)
	public ResponseResult sendSms(@RequestParam(value="jsonData", required=false) String jsonData) {
		log.info("调用短信发送模块开始");
		try {
			Assert.isTrue(StringUtils.isNotBlank(jsonData), "jsonData不能为空");
			JSONObject jsonDataObj = (JSONObject) JSONObject.parse(jsonData);
			String appId = (String) jsonDataObj.get("appId");
			Assert.isTrue(StringUtils.isNotBlank(appId), "appId不能为空");
			String mobiles = (String) jsonDataObj.get("mobiles");
			String[] mobileArr = mobiles.split(",");
			Assert.isTrue(mobileArr.length >=1, "手机号码传参有误");
			if (mobileArr.length == 1) {
				log.info("单发短信功能");
			} else {
				log.info("群发短信功能");
			}
			Assert.isTrue(StringUtils.isNotBlank(mobiles), "手机号码列表不能为空");
			String templateId = (String) jsonDataObj.get("templateId");
			Assert.isTrue(StringUtils.isNoneBlank(templateId), "模板id不能为空");
			String params = (String) jsonDataObj.get("params");
			Assert.isTrue(StringUtils.isNotBlank(params) , "模板参数不能为空");
			log.info("调用短信发送模块参数验证成功!");
			ResponseResult responseResult = sendSmsService.sendSms(jsonData);
			Assert.isTrue("ok".equals(responseResult.getMsg()), responseResult.getMsg());
			log.info("调用短信发送模块结束！");
			return successJson("发送短信成功");
		} catch (Exception e) {
			log.error("调用短信发送模块出错啦！错误信息为:",e.getMessage());
			return errorJson(e.getMessage());
		}
	}
}
