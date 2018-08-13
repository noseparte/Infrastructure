package com.xmbl.config;

import java.util.Date;

import com.xmbl.util.DateUtils;

import lombok.extern.java.Log;

/**
 * Copyright © 2018 noseparte © BeiJing BoLuo Network Technology Co. Ltd.
 * @Author Noseparte
 * @Compile 2018年7月18日 -- 上午10:53:31
 * @Version 1.0
 * @Description		alipay支付宝相关配置
 */
public class AlipayConfig {

	// 应用网关
	public final static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
	// 商户ID
	public final static String app_id = "";
	// 支付宝公钥
	public final static String ALIPAY_PUBLIC_KEY = "";
	// 应用私钥
	public final static String APP_PRIVATE_KEY = "";
	// AES密钥
	public final static String AES_KEY = "Os0oPwF0qUPVIi3H1iWQhg==";
	// 异步通知地址
//	public final static String notify_url = "http://39.107.92.242:8087/paymentServer/api/pay/ali_pay_notify";
	public final static String notify_url = "/paymentServer/api/pay/ali_pay_notify";
	// 签名类型			
	public final static String sign_type = "RSA2";
	// 编码格式
	public final static String charset = "UTF-8";
	// 仅支持JSON 
	public final static String format = "JSON";
	// 接口名称
	public final static String method = "alipay.trade.app.pay";
	// 调用的接口版本
	public final static String version = "1.0";
	// 支付场景 
	public final static String scene = "bar_code";
	// 调用的接口版本
	public final static String timestamp = DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	
	
}
