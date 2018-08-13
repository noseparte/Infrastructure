package com.xmbl.service.app;

import com.xmbl.dao.app.UserDao;
import com.xmbl.dao.app.impl.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class AppUserService extends UserDaoImpl {

	@Autowired
	private UserDao userDao;
	
	public boolean verifyPassword(String AccountId, String passWord) {
		Boolean flag = userDao.verifyPassword(AccountId,passWord);
		if(flag) {
			return true;
		}
		return false;
	}

}
