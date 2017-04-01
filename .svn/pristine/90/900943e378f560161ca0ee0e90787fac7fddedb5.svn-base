package com.tedu.dao;

import java.util.List;

import com.tedu.entity.Account;
import com.tedu.entity.Result;

public interface AccountDao {
	
	Account findById(int accountId);
	
	void update(Account account);

	Result<List<Account>> loadAccounts(int userId);

	Result<List<Account>> loadAccount(int accountId);

	Result<List<Account>> createAccount(int userId, String accountname, String type, String note, int money);

	Result<List<Account>> updateAccount(int accountId, String accountname, String type, String note, int money);

	Result<List<Account>> deleteAccount(int accountId);

	Result<List<Account>> loadTotalMoney(int userId);

	Result<List<Account>> loadAccountMoney(int accountId);

}
