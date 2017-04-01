package com.tedu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tedu.dao.BillDao;
import com.tedu.entity.Bill;
import com.tedu.entity.Result;


@Service("billService")
@Transactional
public class BillServiceImpl implements BillService{

	@Resource
	private BillDao billDao;
	
	
	public Result<List<Bill>> loadBills(int bookId) {
		// TODO Auto-generated method stub
		return billDao.loadBills(bookId);
	}

	public Result<List<Bill>> loadBill(int billId) {
		// TODO Auto-generated method stub
		return billDao.loadBill(billId);
	}

	public Result<List<Bill>> createBill(int bookId,String type,int num, String note, int payAccount, int receiveAccount) {
		// TODO Auto-generated method stub
		return billDao.createBill(bookId,type,num,note,payAccount,receiveAccount);
	}

	public Result<List<Bill>> updateBill(int billId, String type,int num,  String note, int payAccount, int receiveAccount) {
		// TODO Auto-generated method stub
		return billDao.updateBill(billId,type,num,note,payAccount,receiveAccount);
	}

	public Result<List<Bill>> deleteBill(int billId) {
		// TODO Auto-generated method stub
		return billDao.deleteBill(billId);
	}

	public Result<List<Bill>> deleteBills(int bookId) {
		// TODO Auto-generated method stub
		return billDao.deleteBills(bookId);
	}

	public Result<List<Bill>> loadBillByTime(int bookId, Date starttime,Date endtime) {
		// TODO Auto-generated method stub
		return billDao.loadBillByTime(bookId,starttime,endtime);
	}

	public Result<List<List<String>>> loadMoney(int bookId, Date dayStart, Date weekStart, Date monthStart, Date yearStart) {
		// TODO Auto-generated method stub
		Result<List<List<String>>> result=new Result<List<List<String>>>();
		List<List<String>> list=new ArrayList<List<String>>();
		list.add(billDao.loadMoneyByTime(bookId,dayStart,dayStart));
		list.add(billDao.loadMoneyByTime(bookId,weekStart,dayStart));
		list.add(billDao.loadMoneyByTime(bookId,monthStart,dayStart));
		list.add(billDao.loadMoneyByTime(bookId,yearStart,dayStart));
		
		result.setData(list);
		
		return result;
	}
	
}
