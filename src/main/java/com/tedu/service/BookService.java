package com.tedu.service;

import java.util.List;

import com.tedu.entity.Book;
import com.tedu.entity.Result;

public interface BookService {

	Result<List<Book>> createBook(int userId,String bookname,String note, String imagepath);

	Result<List<Book>> loadBook(int userId);

	Result<List<Book>> deleteBook(int bookId);

	Result<List<Book>> updateBook(int bookId, String imagepath, String bookname, String note);
	
}
