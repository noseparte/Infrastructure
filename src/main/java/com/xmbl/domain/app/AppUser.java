package com.xmbl.domain.app;

import com.xmbl.base.pojo.GeneralBean;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

/**
 * Copyright © 2018 noseparte © BeiJing BoLuo Network Technology Co. Ltd.
 *
 * @Author Noseparte
 * @Compile 2018-08-07 -- 17;21
 * @Version 1.0
 * @Description
 */
@Data
public class AppUser extends GeneralBean {

    // 用户id(原先老账号accountid)
    private String accountid;
    // 游戏玩家id
    private String playerid;
    // 游戏玩家姓名
    private String playername;
    // 创建人id
    private String createid;
    // 创建时间
    private Date createtime;
    // 修改人id
    private String updateid;
    // 修改时间
    private Date updatetime;
    // 用户账号 （登录账号）
    private String userkey;
    // 用户密码
    private String password;
    // 注册类型（Y:游客,P:手机号，E:邮箱）
    private String type;
    // 手机号码
    private String mobile;
    // 手机号码是否激活
    private boolean mobile_activate = Boolean.FALSE;
    // 电子邮箱
    private String email;
    // 电子邮箱是否激活
    private boolean email_activate = Boolean.FALSE;
    // 游客账号
    private String youke;
    // 游客账号是否可用
    private boolean youke_activate;
    // 账号状态（1--启用;2--禁用）
    private Integer status;
    // 服务器id
    private String serverid;
    // 登录次数
    private Integer logincnt = 0;
    @DBRef
    @Field("appUser")
    private List<AppUserAuth> appUserAuth;



}
