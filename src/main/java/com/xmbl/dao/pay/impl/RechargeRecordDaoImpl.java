package com.xmbl.dao.pay.impl;

import java.util.Date;

import com.xmbl.base.dao.GeneralPaymentDaoImpl;
import com.xmbl.dao.pay.RechargeRecordDao;
import com.xmbl.domain.pay.RechargeRecord;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.xmbl.constant.CommonConstant;

@Repository
public class RechargeRecordDaoImpl extends GeneralPaymentDaoImpl<RechargeRecord> implements RechargeRecordDao {

	@Override
	protected Class<RechargeRecord> getEntityClass() {
		return RechargeRecord.class;
	}

	@Override
	public void updateBill(String ordeNo, String remark) {
		Query query = new Query();
		if(StringUtils.isNotBlank(ordeNo) && !StringUtils.trim(ordeNo).equals("")) {
			query.addCriteria(Criteria.where("orderNo").is(ordeNo));
		}
		Update update = new Update();
		update.set("orderState", CommonConstant.Normal);
		update.set("orderAccountingTime", new Date());
		update.set("remark", remark);
		this.getMongoTemplate().updateFirst(query, update, RechargeRecord.class, "rechargeRecord");
	}

}
