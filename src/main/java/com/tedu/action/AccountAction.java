package com.tedu.action;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tedu.entity.Account;
import com.tedu.entity.Bill;
import com.tedu.entity.Result;
import com.tedu.service.AccountService;


@Controller
@Scope("prototype")
public class AccountAction {

	@Resource
	private AccountService accountService;
	
	//加载账本下账单
		public String loadAccounts(){
			u=accountService.loadAccounts(userId);
			return "success";
		}
		
		//加载指定账单
		public String loadAccount(){
			u=accountService.loadAccount(accountId);
			return "success";
		}
		
		//新增账单
		public String createAccount(){
			u=accountService.createAccount(userId,accountname,type,note,money);
			return "success";
		}
		
		//修改账单
		public String updateAccount(){
			u=accountService.updateAccount(accountId,accountname,type,note,money,imgpath);
			return "success";
		}
		
		//删除账单
		public String deleteAccount(){
			u=accountService.deleteAccount(accountId,receiveAccount);
			return "success";
		}
		
		//删除账单
		public String deleteAccount1(){
			u=accountService.deleteAccount1(accountId);
			return "success";
		}

	//查询账户总额和账户净收入，净支出
	public String loadTotalMoney(){
		u=accountService.loadTotalMoney(userId);
		return "success";
	}
	
	//查询账户总额和账户净收入，净支出
	public String loadAccountMoney(){
		u=accountService.loadAccountMoney(accountId);
		return "success";
	}
		
	

	
	private int accountId;
	private String accountname;
	private String type;
	private int money;
	private String note;
	private List<Bill> bills;
	private int userId;
	
	private int receiveAccount;
	
	
	
	
	private Result<List<Account>> u;
	
	public Result<List<Account>> getU() {
		return u;
	}

	public void setU(Result<List<Account>> u) {
		this.u = u;
	}

	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountname() {
		return accountname;
	}
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public int getReceiveAccount() {
		return receiveAccount;
	}

	public void setReceiveAccount(int receiveAccount) {
		this.receiveAccount = receiveAccount;
	}
}
