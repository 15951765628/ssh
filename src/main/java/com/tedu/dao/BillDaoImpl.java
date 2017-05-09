package com.tedu.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.tedu.entity.Account;
import com.tedu.entity.Bill;
import com.tedu.entity.Result;

@Repository("billDao")//扫描
public class BillDaoImpl implements BillDao{

	
	@Resource//注入
	private HibernateTemplate template;
	
	@Resource
	private AccountDao accountDao;
	
	public void save(Bill bill){
		template.save(bill);
		
	}
	
	public void update(Bill bill){
		template.update(bill);
	}
	
	public void delete(int billId){
		Bill bill=new Bill();
		bill.setBillId(billId);
		template.delete(bill);
	}
	
	public Bill findById(int billId){
		Bill bill=template.load(Bill.class, billId);
		return bill;
	}

	public Result<List<Bill>> loadBills(int bookId) {
		// TODO Auto-generated method stub
		Result<List<Bill>> result=new Result<List<Bill>>();
		List<Bill> list=new ArrayList<Bill>();
		
		try {
			String sql="from Bill where bookId=?";
			list=template.find(sql, bookId);
			result.setData(list);
			result.setStatus(0);
		} catch (Exception e) {
			// TODO: handle exception
			result.setStatus(1);
			
		}
		
		return result;
	}

	public Result<List<Bill>> loadBill(int billId) {
		// TODO Auto-generated method stub
				Result<List<Bill>> result=new Result<List<Bill>>();
				List<Bill> list=new ArrayList<Bill>();
				
				try {
					Bill bill=findById(billId);
					list.add(bill);
					
					result.setData(list);
					result.setStatus(0);
				} catch (Exception e) {
					// TODO: handle exception
					result.setStatus(1);
					
				}
				
				return result;
	}

	public Result<List<Bill>> createBill(int bookId, String type, int num, String note, int payAccount,int receiveAccount) {
		// TODO Auto-generated method stub
				Result<List<Bill>> result=new Result<List<Bill>>();
				List<Bill> list=new ArrayList<Bill>();
				
				try {
					Bill bill=new Bill();
					bill.setBookId(bookId);
					
					if(note!=null){
						bill.setNote(note);
					}
					if(num!=0){
						bill.setNum(num);
					}
					if(payAccount!=0){
						bill.setPayAccount(payAccount);
					}
					if(receiveAccount!=0){
						bill.setReceiveAccount(receiveAccount);
					}
					bill.setType(type);
					bill.setCreatedate(com.tedu.tools.time.getDate());
					
					save(bill);
					
					changeAccount(payAccount,num,receiveAccount);
					
					result.setStatus(0);
					
				} catch (Exception e) {
					// TODO: handle exception
					result.setStatus(1);
					
				}
				
				return result;
	}

	public Result<List<Bill>> updateBill(int billId, String type, int num, String note, int payAccount,int receiveAccount) {
		// TODO Auto-generated method stub
				Result<List<Bill>> result=new Result<List<Bill>>();
				List<Bill> list=new ArrayList<Bill>();
				
				try {
					Bill bill=findById(billId);
					
					changeAccount(bill.getReceiveAccount(), bill.getNum(), bill.getPayAccount());
					
					if(note!=null){
						bill.setNote(note);
					}
					if(num!=0){
						bill.setNum(num);
					}
					if(payAccount!=0){
						bill.setPayAccount(payAccount);
					}
					if(receiveAccount!=0){
						bill.setReceiveAccount(receiveAccount);
					}
					if(type!=null){
						bill.setType(type);
					}
					
					changeAccount(payAccount,num,receiveAccount);
					
					update(bill);
					
					result.setStatus(0);
				} catch (Exception e) {
					// TODO: handle exception
					result.setStatus(1);
					
				}
				
				return result;
	}

	public Result<List<Bill>> deleteBill(int billId) {
		// TODO Auto-generated method stub
				Result<List<Bill>> result=new Result<List<Bill>>();
				List<Bill> list=new ArrayList<Bill>();
				
				try {
					Bill bill=findById(billId);
					
					changeAccount(bill.getReceiveAccount(), bill.getNum(), bill.getPayAccount());
					
					template.delete(bill);
					result.setStatus(0);
				} catch (Exception e) {
					// TODO: handle exception
					result.setStatus(1);
					
				}
				
				return result;
	}
	
	public Result<List<Bill>> deleteBill2(int billId) {
		// TODO Auto-generated method stub
				Result<List<Bill>> result=new Result<List<Bill>>();
				List<Bill> list=new ArrayList<Bill>();
				
				try {
					delete(billId);
					result.setStatus(0);
				} catch (Exception e) {
					// TODO: handle exception
					result.setStatus(1);
					
				}
				
				return result;
	}

	public Result<List<Bill>> deleteBills(int bookId) {
		// TODO Auto-generated method stub
				Result<List<Bill>> result=new Result<List<Bill>>();
				List<Bill> list=new ArrayList<Bill>();
				String sql="delete from bill where bookId = ?";
				
				try {
					//int  row=template.getSessionFactory().getCurrentSession().createSQLQuery(sql).setInteger(0, bookId).executeUpdate();
					
				} catch (Exception e) {
					// TODO: handle exception
					result.setStatus(1);
					
				}
				return result;
	}

	public Result<List<Bill>> loadBillByTime(int bookId, Date starttime,Date endtime) {
		// TODO Auto-generated method stub
		Result<List<Bill>> result=new Result<List<Bill>>();
		List<Bill> list=new ArrayList<Bill>();
		
		try {
			
			
			String sql="from Bill where bookId = ? and createdate between ?  and  ? ";
			list=template.find(sql, bookId,starttime,endtime);
			result.setData(list);
			result.setStatus(0);
		} catch (Exception e) {
			// TODO: handle exception
			result.setStatus(1);
			
		}
		
		return result;
	}

	public List<String> loadMoneyByTime(int bookId, Date dayStart, Date dayStart2) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		int inmoney=0;
		int outmoney=0;
		try {
			String sql="from  Bill where bookId = ? and createdate between ? and ?";
			List<Bill> bills=template.find(sql,bookId,dayStart,dayStart2);
			for(Bill bill:bills){
				if(bill.getPayAccount()!=0){
					outmoney+=bill.getNum();
				}else{
					inmoney+=bill.getNum();
				}
			}
			
			list.add(inmoney+"");
			list.add(outmoney+"");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	
	public void changeAccount(int payAccount,int num,int receiveAccount)
	{
		Account pay=new Account();
		Account receive=new Account();
		if(payAccount!=0){
			pay=accountDao.findById(payAccount);
		}
		if(receiveAccount!=0){
			receive=accountDao.findById(receiveAccount);
		}
		
		if(pay.getAccountId()!=0){
			pay.setMoney(pay.getMoney()-num);
		}
		if(receive.getAccountId()!=0){
			receive.setMoney(receive.getMoney()+num);
		}
		if(pay.getAccountId()!=0){
			accountDao.update(pay);
		}
		if(receive.getAccountId()!=0){
			accountDao.update(receive);
		}
		
		
				
	}

	
}
