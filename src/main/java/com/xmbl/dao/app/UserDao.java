package com.xmbl.dao.app;

import com.xmbl.base.dao.GeneralDao;
import com.xmbl.domain.app.AppUser;

public interface UserDao extends GeneralDao<AppUser> {

	boolean verifyPassword(String AccountId, String passWord);
	
}
