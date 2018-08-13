package com.xmbl.dao.pay;

import com.xmbl.base.dao.GeneralDao;
import com.xmbl.domain.pay.TransferRecord;

public interface TransferRecordDao extends GeneralDao<TransferRecord> {

	boolean generatedBills(TransferRecord record);
	
	boolean updateBill(String orderNo, String transferRemark);
}
