package com.tedu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.tedu.entity.Book;
import com.tedu.entity.Result;

@Repository("bookDao")//扫描
public class BookDaoImpl implements BookDao{

	
	@Resource//注入
	private HibernateTemplate template;
	
	public void save(Book book) {
		template.save(book);
	}

	public void update(Book book) {
		template.update(book);
	}

	public void delete(int bookId) {
		Book book = new Book();
		book.setBookId(bookId);
		template.delete(book);
	}

	public Book findById(int bookId) {
		Book book = template.load(Book.class, bookId);
		return book;
	}

	public Result<List<Book>> createBook(int userId, String bookname, String note) {
		// TODO Auto-generated method stub
		Result<List<Book>> result=new Result<List<Book>>();
		List<Book> list=new ArrayList<Book>();
		try {
			Book book=new Book();
			book.setBookname(bookname);
			book.setNote(note);
			book.setUserId(userId);
			save(book);
			
			//list.add(book);
			
			//result.setData(list);
			result.setStatus(0);
			result.setMsg("创建成功!");
		} catch (Exception e) {
			// TODO: handle exception
			result.setMsg("创建失败!");
			result.setStatus(1);
		} 
		
		
		return result;
	}

	public Result<List<Book>> loadBook(int userId) {
		// TODO Auto-generated method stub
				Result<List<Book>> result=new Result<List<Book>>();
				List<Book> list=new ArrayList<Book>();
				try {
					 String hql = "from Book where userId = ?";
					list=template.find(hql,userId);

					result.setData(list);
					result.setStatus(0);
					result.setMsg("创建成功!");
				} catch (Exception e) {
					// TODO: handle exception
					result.setMsg("创建失败!");
					result.setStatus(1);
				} 
				
				
				return result;
	}

	public Result<List<Book>> deleteBook(int bookId) {
		// TODO Auto-generated method stub
		Result<List<Book>> result=new Result<List<Book>>();
		List<Book> list=new ArrayList<Book>();
		try {
			delete(bookId);
			
			result.setStatus(0);
		} catch (Exception e) {
			// TODO: handle exception
			result.setStatus(1);
		} 
		
		
		return result;
	}

	public Result<List<Book>> updateBook(int bookId, String imagepath, String bookname, String note) {
		// TODO Auto-generated method stub
				Result<List<Book>> result=new Result<List<Book>>();
				List<Book> list=new ArrayList<Book>();
				try {
					Book book=findById(bookId);
					if(bookname!=null){
						book.setBookname(bookname);
					}
					if(imagepath!=null){
						book.setImagepath(imagepath);
					}
					if(note!=null){
						book.setNote(note);
					}
					
					update(book);
					result.setStatus(0);
					result.setMsg("创建成功!");
				} catch (Exception e) {
					// TODO: handle exception
					result.setMsg("创建失败!");
					result.setStatus(1);
				} 
				
				
				return result;
	}
}
