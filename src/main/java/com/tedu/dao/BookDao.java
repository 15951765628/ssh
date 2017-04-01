package com.tedu.dao;

import java.util.List;

import com.tedu.entity.Book;
import com.tedu.entity.Result;

public interface BookDao {

	Result<List<Book>> createBook(int userId, String bookname, String note);

	Result<List<Book>> loadBook(int userId);

	Result<List<Book>> deleteBook(int bookId);

	Result<List<Book>> updateBook(int bookId, String imagepath, String bookname, String note);

}
