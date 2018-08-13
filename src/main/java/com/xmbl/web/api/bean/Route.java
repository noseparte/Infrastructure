package com.xmbl.web.api.bean;

public class Route {

	public final static String PATH = "/api";
	
	public class User{
		public final static String PATH = "/user";
		
		public final static String USER_LIST = "/user_list";				//用户列表
		public final static String ADD_USER = "/add_user";					//添加用户
	}
	
	/**
	 * 邮件系统
	 */
	public class Email{
		public final static String PATH = "/email";
		
		public final static String SEND = "/send";							//发送邮件
	}

	/**
	 * GameServers
	 */
	public class Server{
		public final static String PATH = "/server";

		public final static String SERVER_LIST = "/ServerLst";						//获取服务器列表
	}

	/**
	 * 短信系统
	 */
	public class SMS{
		public final static String PATH = "/sms";
		
		public final static String SEND = "/send";							//发送邮件
	}
	
	/**
	 * 支付系统
	 */
	public class Payment{
		public final static String PATH = "/pay";
		
		public final static String ALI_PAY = "/ali_pay";					//支付宝下单
		public final static String ALI_PAY_NOTIFY = "/ali_pay_notify";		//异步通知
		public final static String TRANSFER = "/transfer";					//用户提现申请
		public final static String ALI_TRANSFER = "/ali_transfer";			//支付宝用户提现申请
		public final static String WX_TRANSFER = "/wx_transfer";			//微信用户提现申请
		
		public final static String WX_PAY = "/wx_pay";						//微信下单
		public final static String WX_PAY_NOTIFY = "/wx_pay_notify";		//微信异步通知
		
	}
	
	
	
	
	
	
}
