package com.tedu.service;

import java.util.List;

import com.tedu.entity.Account;
import com.tedu.entity.Book;
import com.tedu.entity.Result;

public interface AccountService {

	Result<List<Account>> loadAccounts(int userId);

	Result<List<Account>> loadAccount(int accountId);

	Result<List<Account>> createAccount(int userId, String accountname, String type, String note, int money);

	Result<List<Account>> updateAccount(int accountId, String accountname, String type, String note, int money);

	Result<List<Account>> deleteAccount(int accountId, int receiveAccount);

	Result<List<Account>> loadTotalMoney(int userId);

	Result<List<Account>> loadAccountMoney(int accountId);

	Result<List<Account>> deleteAccount1(int accountId);
	
}
