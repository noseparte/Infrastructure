package com.xmbl.dao.gm;

import java.util.List;

import com.xmbl.base.dao.GeneralDao;
import com.xmbl.domain.gm.GameServers;

public interface IGameServersDao extends GeneralDao<GameServers> {

	List<GameServers> getServerListByTypeAndOperatorStatus(String type, Integer operatorStatus);
	
}
