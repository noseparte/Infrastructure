package com.xmbl.dao.pay.impl;

import com.xmbl.base.dao.GeneralPaymentDaoImpl;
import com.xmbl.dao.pay.ThirdPayDao;
import com.xmbl.domain.pay.ThirdPayBean;
import org.springframework.stereotype.Repository;


@Repository
public class ThirdPayDaoImpl extends GeneralPaymentDaoImpl<ThirdPayBean> implements ThirdPayDao {

	@Override
	protected Class<ThirdPayBean> getEntityClass() {
		return ThirdPayBean.class;
	}

}
