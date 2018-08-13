package com.xmbl.controller.gm;

import com.xmbl.base.BaseController;
import com.xmbl.domain.gm.GameServers;
import com.xmbl.service.gm.GameServersService;
import com.xmbl.web.api.bean.Response;
import com.xmbl.web.api.bean.Route;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Copyright © 2018 noseparte © BeiJing BoLuo Network Technology Co. Ltd.
 *
 * @Author Noseparte
 * @Compile 2018-08-13 -- 16:55
 * @Version 1.0
 * @Description
 */
@Slf4j
@RestController
@RequestMapping(value = Route.PATH + Route.Server.PATH)
public class PTGameServersController extends BaseController {

    @Autowired
    private GameServersService gameServersService;

    /**
     * 获取游戏服务器列表
     *
     * @return
     */
    @RequestMapping(value = Route.Server.SERVER_LIST,method = RequestMethod.POST)
    public Response getServerLst(){
        log.info("infoMsg:============================== 查询服务器列表开始。");
        Response reponse = this.getReponse();
        try{
            Query query = new Query();
            List<GameServers> gameServersLst = gameServersService.find(query);
            Assert.notNull(gameServersLst, "gameServersLst must cannot be null");
            log.info("infoMsg:============================== 查询服务器列表结束。存在节点为: isUsedCount,{}",gameServersLst.size());
            return reponse.success(gameServersLst);
        }catch (Exception e){
            log.error("errorMsg:============================== 查询服务器列表失败,错误信息为：msg,{}",e.getMessage());
            return reponse.failure(e.getMessage());
        }
    }




}
