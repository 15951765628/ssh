package com.tedu.service;

import java.util.Date;
import java.util.List;

import com.tedu.entity.Bill;
import com.tedu.entity.Result;

public interface BillService {

	Result<List<Bill>> loadBills(int bookId);

	Result<List<Bill>> loadBill(int billId);

	Result<List<Bill>> createBill(int bookId, String type, int num, String note, int payAccount, int receiveAccount);

	Result<List<Bill>> updateBill(int billId, String type, int num,String note, int payAccount, int receiveAccount);

	Result<List<Bill>> deleteBill(int billId);

	Result<List<Bill>> deleteBills(int bookId);

	Result<List<Bill>> loadBillByTime(int bookId, Date starttime,Date endtime);

	Result<List<List<String>>> loadMoney(int bookId, Date dayStart, Date weekStart, Date monthStart, Date yearStart);

	Result<List<Bill>> deleteBill2(int billId);
	
}
