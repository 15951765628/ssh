package com.tedu.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tedu.entity.Bill;
import com.tedu.entity.Book;
import com.tedu.entity.Result;
import com.tedu.service.BillService;


@Controller
@Scope("prototype")
public class BillAction {

	@Resource
	private BillService billService;
	
	//加载账本下账单
	public String loadBills(){
		u=billService.loadBills(bookId);
		return "success";
	}
	
	//加载金钱
	public String loadMoney(){
		u2=billService.loadMoney(bookId,dayStart,weekStart,monthStart,yearStart);
		return "success";
	}
	
	
	//加载账本下账单
	public String loadBillByTime(){
		u=billService.loadBillByTime(bookId,starttime,endtime);
		return "success";
	}
	
	//加载指定账单
	public String loadBill(){
		u=billService.loadBill(billId);
		return "success";
	}
	
	//新增账单
	public String createBill(){
		u=billService.createBill(bookId,type,num,note,payAccount,receiveAccount);
		return "success";
	}
	
	//修改账单
	public String updateBill(){
		u=billService.updateBill(billId,type,num,note,payAccount,receiveAccount);
		return "success";
	}
	
	//删除账单
	public String deleteBill(){
		u=billService.deleteBill(billId);
		return "success";
	}
	
	//删除账本下账单/**
	/**
	 * 
	 * 暂时有点问题
	 * 
	 * @return
	 */
	public String deleteBills(){
		u=billService.deleteBills(bookId);
		return "success";
	}
	
	

	
	
	private int billId;
	private Date createdate;
	private String type;
	private String note;
	private int payAccount;
	private int receiveAccount;
	private int bookId;
	private int num;
	private Date starttime;
	private Date endtime;
	
	private int accountId;

	private Date dayStart;
	private Date weekStart;
	private Date monthStart;
	private Date yearStart;
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}





	private Result<List<Bill>> u;
	private Result<List<List<String>>> u2;
	

	public Result<List<Bill>> getU() {
		return u;
	}

	public void setU(Result<List<Bill>> u) {
		this.u = u;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getPayAccount() {
		return payAccount;
	}
	public void setPayAccount(int payAccount) {
		this.payAccount = payAccount;
	}
	public int getReceiveAccount() {
		return receiveAccount;
	}
	public void setReceiveAccount(int receiveAccount) {
		this.receiveAccount = receiveAccount;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Date getDayStart() {
		return dayStart;
	}

	public void setDayStart(Date dayStart) {
		this.dayStart = dayStart;
	}

	public Date getWeekStart() {
		return weekStart;
	}

	public void setWeekStart(Date weekStart) {
		this.weekStart = weekStart;
	}

	public Date getMonthStart() {
		return monthStart;
	}

	public void setMonthStart(Date monthStart) {
		this.monthStart = monthStart;
	}

	public Date getYearStart() {
		return yearStart;
	}

	public void setYearStart(Date yearStart) {
		this.yearStart = yearStart;
	}

	public Result<List<List<String>>> getU2() {
		return u2;
	}

	public void setU2(Result<List<List<String>>> u2) {
		this.u2 = u2;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}


	
}
