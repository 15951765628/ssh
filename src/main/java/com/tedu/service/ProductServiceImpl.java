package com.tedu.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tedu.dao.BillDao;
import com.tedu.dao.ProductDao;
import com.tedu.entity.Product;
import com.tedu.entity.Result;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService{

	
	@Resource
	private ProductDao productDao;
	@Resource
	private BillDao billDao;

	public Result<List<Product>> loadProduct(int productId) {
		// TODO Auto-generated method stub
		return productDao.loadProduct(productId);
	}

	public Result<List<Product>> loadProducts(int userId) {
		// TODO Auto-generated method stub
		return productDao.loadProducts(userId);
	}

	public Result<List<Product>> updateProduct(int productId, String name, int price, int totalMoney, String note,
			float rate, Date startdate, Date enddate, int payaccountId,int num) {
		// TODO Auto-generated method stub
		return productDao.updateProduct(productId,name,price,totalMoney,note,rate,startdate,enddate,payaccountId,num);
	}

	public Result<List<Product>> createProduct(String name, int price, int totalMoney, String note, float rate,
			Date startdate, Date enddate, int userId, int payaccountId,int type,int num) {
		// TODO Auto-generated method stub
		Result<List<Product>> result=productDao.createProduct(name,price,totalMoney,note,rate,startdate,enddate,userId,payaccountId,type,num);
		if(result.getStatus()==0){
			if(totalMoney==0){
				billDao.createBill(0, "理财产品", price, "", payaccountId, 0);
			}else{
				billDao.createBill(0, "理财产品", totalMoney, "", payaccountId, 0);
			}
			
		}
		
		return result;
	}

	public Result<List<Product>> deleteProduct(int productId) {
		// TODO Auto-generated method stub
		Result<List<Product>> result=productDao.deleteProduct(productId);
		return result;
	}
	


}
