package com.xmbl.util.email;

import com.xmbl.util.PropertyUtil;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author: sunbenbao
 * @Email: 1402614629@qq.com
 * @类名:  MailConstant 
 * @创建时间:  2018年1月4日 下午8:26:40
 * @修改时间:  2018年1月4日 下午8:26:40
 * @类说明:
 */
public class MailConstant {

	@Value("${mail.sender.default}")
	public static String MAIL_SENDER_DEFAULT;

	@Value("${mail.username.default}")
	public static String MAIL_USERNAME_DEFAULT;

	@Value("${mail.password.default}")
	public static String MAIL_PASSWORD_DEFAULT;

}
