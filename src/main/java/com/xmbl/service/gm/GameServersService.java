package com.xmbl.service.gm;

import java.util.List;

import com.alibaba.dubbo.config.annotation.Service;
import com.xmbl.dao.gm.IGameServersDao;
import com.xmbl.dao.gm.impl.IGameServersDaoImpl;
import com.xmbl.domain.gm.GameServers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Service
@Repository
public class GameServersService extends IGameServersDaoImpl {

	@Autowired
	private IGameServersDao gameServerDao;
	
	public List<GameServers> getServerListByTypeAndOperatorStatus(String type, Integer operatorStatus) {
		List<GameServers> gameServerLst = gameServerDao.getServerListByTypeAndOperatorStatus(type,operatorStatus);
		return gameServerLst;
	}

}