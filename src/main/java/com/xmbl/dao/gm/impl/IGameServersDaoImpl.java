package com.xmbl.dao.gm.impl;

import java.util.Collections;
import java.util.List;

import com.xmbl.base.dao.GeneralDaoImpl;
import com.xmbl.dao.gm.IGameServersDao;
import com.xmbl.domain.gm.GameServers;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public class IGameServersDaoImpl extends GeneralDaoImpl<GameServers> implements IGameServersDao {

	@Override
	protected Class<GameServers> getEntityClass() {
		return GameServers.class;
	}

	@Override
	public List<GameServers> getServerListByTypeAndOperatorStatus(String type, Integer operatorStatus) {
		try {
			Query query = new Query();
			 Criteria criteria = new Criteria();
			 criteria = criteria.and("type").is(type);
			 criteria = criteria.and("operatorStatus").is(operatorStatus);
			 query.addCriteria(criteria);
			 List<GameServers> gameServerLst = getMongoTemplate().find(query, GameServers.class, "gameservers");
			 return gameServerLst;
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

}
