package com.xmbl.dao.pay;

import com.xmbl.base.dao.GeneralDao;
import com.xmbl.domain.pay.RechargeRecord;

public interface RechargeRecordDao extends GeneralDao<RechargeRecord> {

	 void updateBill(String ordeNo, String remark);
}
