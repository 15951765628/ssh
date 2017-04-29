package com.tedu.action;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tedu.entity.Bill;
import com.tedu.entity.Book;
import com.tedu.entity.Family;
import com.tedu.entity.Result;
import com.tedu.service.BillService;
import com.tedu.service.BookService;


@Controller
@Scope("prototype")
public class BookAction {

	@Resource
	private BookService bookService;
	
	@Resource
	private BillService billService;
	
	//创建账本
	public String createBook(){
		
		u=bookService.createBook(userId,bookname,note,imagepath);
		
		return "success";
	}
	
	//查询账本
	public String loadBook(){
		u=bookService.loadBook(userId);
		
		return "success";
	}
	
	//删除账本
	public String deleteBook(){
		u=bookService.deleteBook(bookId);
		if(u.getStatus()==0){
			//删除相关账单
			billService.deleteBills(bookId);
		}
		return "success";
	}
	
	//修改账本
	public String updateBook(){
		u=bookService.updateBook(bookId,imagepath,bookname,note);
		return "success";
	}
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private int bookId;
	private String imagepath;
	private String bookname;
	private String note;
	private int userId;
	private Set<Bill> bills;
	private Result<List<Book>> u;
	

	public Result<List<Book>> getU() {
		return u;
	}

	public void setU(Result<List<Book>> u) {
		this.u = u;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
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

	public Set<Bill> getBills() {
		return bills;
	}

	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}
	
	
}
