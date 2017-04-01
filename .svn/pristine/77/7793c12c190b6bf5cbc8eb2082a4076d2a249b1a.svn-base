package com.tedu.service;

import java.util.Date;
import java.util.List;

import com.tedu.entity.Product;
import com.tedu.entity.Result;

public interface ProductService {

	Result<List<Product>> loadProduct(int productId);

	Result<List<Product>> loadProducts(int userId);

	Result<List<Product>> updateProduct(int productId, String name, int price, int totalMoney, String note, float rate,
			Date startdate, Date enddate, int payaccountId,int num);

	Result<List<Product>> createProduct(String name, int price, int totalMoney, String note, float rate, Date startdate,
			Date enddate, int userId, int payaccountId,int type,int num);

	Result<List<Product>> deleteProduct(int productId);

}
