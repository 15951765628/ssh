package com.tedu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.tedu.entity.Account;
import com.tedu.entity.Bill;
import com.tedu.entity.Result;

@Repository("accountDao")//扫描
public class AccountDaoImpl implements AccountDao{

	@Resource//注入
	private HibernateTemplate template; 
	
	public void save(Account account){
		template.save(account);
	}
	
	public void update(Account account){
		template.update(account);
	}
	
	public void delete(int accountId){
		Account account=new Account();
		account.setAccountId(accountId);
		template.delete(account);
	}
	
	public Account findById(int accountId){
		return template.load(Account.class, accountId);
	}

	public Result<List<Account>> loadAccounts(int userId) {
		// TODO Auto-generated method stub
		Result<List<Account>> result=new Result<List<Account>>();
		List<Account> list=new ArrayList<Account>();
		try {
			String sql="from Account where userId=?";
			list=template.find(sql, userId);
			result.setData(list);
			result.setStatus(0);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			result.setStatus(1);
		}
		return result;
	}
	
	

	public Result<List<Account>> loadAccount(int accountId) {
		// TODO Auto-generated method stub
				Result<List<Account>> result=new Result<List<Account>>();
				List<Account> list=new ArrayList<Account>();
				try {
					String sql="from Bill where payAccount = ? or receiveAccount = ? ";
					List<Bill> bills=new ArrayList<Bill>();
					List<Bill> bills2=new ArrayList<Bill>();
					bills=template.find(sql,accountId,accountId);

					Account account=findById(accountId);				
					for(Bill bill:bills){
						Bill bill2=new Bill();
						bill2.setBillId(bill.getBillId());
						bill2.setBookId(bill.getBillId());
						bill2.setCreatedate(bill.getCreatedate());
						bill2.setNote(bill.getNote());
						if(bill.getReceiveAccount()!=accountId){
							bill2.setNum(-bill.getNum());
						}else{
							bill2.setNum(bill.getNum());
						}
						bill2.setPayAccount(bill.getPayAccount());
						bill2.setReceiveAccount(bill.getReceiveAccount());
						bill2.setType(bill.getType());
						
						bills2.add(bill2);
					}
					
					
					account.setBills(bills2);
					list.add(account);
					
					result.setData(list);
					result.setStatus(0);
					
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
					result.setStatus(1);
				}
				
				return result;
	}

	public Result<List<Account>> createAccount(int userId, String accountname, String type, String note, int money) {
		// TODO Auto-generated method stub
 				Result<List<Account>> result=new Result<List<Account>>();
				List<Account> list=new ArrayList<Account>();
				try {
					Account account=new Account();

					account.setAccountname(accountname);
					
					account.setMoney(money);
					
					if(note!=null){
						account.setNote(note);
					}

					account.setUserId(userId);
					account.setType(type);
					save(account);
					list.add(account);
					
					result.setData(list);
					result.setStatus(0);
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
					result.setStatus(1);
				}
				return result;
	}

	public Result<List<Account>> updateAccount(int accountId, String accountname, String type, String note, int money) {
		// TODO Auto-generated method stub
				Result<List<Account>> result=new Result<List<Account>>();
				List<Account> list=new ArrayList<Account>();
				try {
					Account account=findById(accountId);
					if(accountname!=null){
						account.setAccountname(accountname);
					}
					
					if(money!=0){
						account.setMoney(money);
					}
				
					if(note!=null){
						account.setNote(note);
					}
					if(type!=null){
						account.setType(type);
					}
					
					update(account);
					list.add(account);
					result.setData(list);
					result.setStatus(0);
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
					result.setStatus(1);
				}
				return result;
	}

	public Result<List<Account>> deleteAccount(int accountId) {
		// TODO Auto-generated method stub
				Result<List<Account>> result=new Result<List<Account>>();
				List<Account> list=new ArrayList<Account>();
				try {
					//template.getSessionFactory().getCurrentSession().createQuery("delete from account where accountId = "+accountId).executeUpdate();
					//int  row=template.getSessionFactory().getCurrentSession().createSQLQuery("delete from account where accountId = ?").setInteger(0, accountId).executeUpdate();
					//delete(accountId);
					
					result.setStatus(0);
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
					result.setStatus(1);
				}
				return result;
	}
	
	public Result<List<Account>> deleteAccount1(int accountId) {
		// TODO Auto-generated method stub
				Result<List<Account>> result=new Result<List<Account>>();
				List<Account> list=new ArrayList<Account>();
				try {
					delete(accountId);
					
					result.setStatus(0);
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
					result.setStatus(1);
				}
				return result;
	}

	public Result<List<Account>> loadTotalMoney(int userId) {
		// TODO Auto-generated method stub
		Result<List<Account>> result=new Result<List<Account>>();
		List<Account> list1=new ArrayList<Account>();
		List<Account> list2=new ArrayList<Account>();
		try {
			String sql="from Account where userId = ? ";
			list1=template.find(sql,userId);
			Account accIn=new Account();
			Account accOut=new Account();
			Account accTotalIn=new Account();
			for(Account account:list1){
				List<Bill> bills=new ArrayList<Bill>();
				String sql1="from Bill where payAccount = ? or receiveAccount = ? ";
				
				bills=template.find(sql1,account.getAccountId(),account.getAccountId());
				for(Bill bill:bills){
					if(bill.getBookId()!=0){
						if(bill.getPayAccount()==account.getAccountId()){
							accOut.setMoney(accOut.getMoney()+bill.getNum());
						}else if(bill.getReceiveAccount()==account.getAccountId()){
							accIn.setMoney(accIn.getMoney()+bill.getNum());
						}
					}
					
				}	
				
				accTotalIn.setMoney(accTotalIn.getMoney()+account.getMoney());
				
			}
			
			list2.add(accTotalIn);
			list2.add(accIn);
			list2.add(accOut);
			
			result.setData(list2);
			result.setStatus(0);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			result.setStatus(1);
		}
		return result;
	}

	public Result<List<Account>> loadAccountMoney(int accountId) {
		// TODO Auto-generated method stub
		Result<List<Account>> result=new Result<List<Account>>();
		List<Account> list=new ArrayList<Account>();
		try {
			
			Account account=findById(accountId);
			
			Account accIn=new Account();
			Account accOut=new Account();
			Account accTotalIn=new Account();
			List<Bill> bills=new ArrayList<Bill>();
			String sql="from Bill where payAccount = ? or receiveAccount = ? ";
			bills=template.find(sql,accountId,accountId);
			for(Bill bill:bills){
				if(bill.getPayAccount()==accountId){
					accOut.setMoney(accOut.getMoney()+bill.getNum());
				}else if(bill.getReceiveAccount()==accountId){
					accIn.setMoney(accIn.getMoney()+bill.getNum());
				}
			}
			accTotalIn.setMoney(account.getMoney());
			
			list.add(accTotalIn);
			list.add(accIn);
			list.add(accOut);
			
			result.setData(list);
			result.setStatus(0);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			result.setStatus(1);
		}
		return result;
	}
	
	
}
