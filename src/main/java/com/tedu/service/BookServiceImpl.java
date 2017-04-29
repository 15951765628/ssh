package com.tedu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tedu.dao.BookDao;
import com.tedu.entity.Book;
import com.tedu.entity.Result;

@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService{

	
	@Resource
	private BookDao bookDao;
	
	public Result<List<Book>> createBook(int userId,String bookname,String note,String imagepath) {
		// TODO Auto-generated method stub
		return bookDao.createBook(userId,bookname,note,imagepath);
	}

	public Result<List<Book>> loadBook(int userId) {
		// TODO Auto-generated method stub
		return bookDao.loadBook(userId);
	}

	public Result<List<Book>> deleteBook(int bookId) {
		// TODO Auto-generated method stub
		return bookDao.deleteBook(bookId);
	}

	public Result<List<Book>> updateBook(int bookId, String imagepath, String bookname, String note) {
		// TODO Auto-generated method stub
		return bookDao.updateBook(bookId,imagepath,bookname,note);
	}
	
}
