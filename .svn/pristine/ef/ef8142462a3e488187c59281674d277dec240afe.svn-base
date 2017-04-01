package com.tedu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tedu.dao.AccountDao;
import com.tedu.dao.BillDao;
import com.tedu.entity.Account;
import com.tedu.entity.Result;
import com.tedu.entity.Bill;


@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService{

	@Resource
	private AccountDao accountDao;
	
	@Resource 
	private BillDao billDao;
	
	public Result<List<Account>> loadAccounts(int userId) {
		// TODO Auto-generated method stub
		return accountDao.loadAccounts(userId);
	}

	public Result<List<Account>> loadAccount(int accountId) {
		// TODO Auto-generated method stub
		Result<List<Account>> result=accountDao.loadAccount(accountId);

		return result;
	}

	public Result<List<Account>> createAccount(int userId, String accountname, String type, String note, int money) {
		// TODO Auto-generated method stub
		return accountDao.createAccount(userId,accountname,type,note,money);
	}

	public Result<List<Account>> updateAccount(int accountId, String accountname, String type, String note, int money) {
		// TODO Auto-generated method stub
		return accountDao.updateAccount(accountId,accountname,type,note,money);
	}

	public Result<List<Account>> deleteAccount(int accountId,int receiveAccount) {
		// TODO Auto-generated method stub
		
		Result<List<Account>> re=accountDao.loadAccount(accountId);
		
		billDao.createBill(0,"转账",re.getData().get(0).getMoney(),"",re.getData().get(0).getAccountId(),receiveAccount);
		return accountDao.deleteAccount(accountId);
	}

	public Result<List<Account>> loadTotalMoney(int userId) {
		// TODO Auto-generated method stub
		return accountDao.loadTotalMoney(userId);
	}

	public Result<List<Account>> loadAccountMoney(int accountId) {
		// TODO Auto-generated method stub
		return accountDao.loadAccountMoney(accountId);
	}
	
}
