package com.tedu.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.ResultTransformer;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.tedu.entity.Account;
import com.tedu.entity.Bill;
import com.tedu.entity.Data;
import com.tedu.entity.Result;

@Repository("dataDao")//扫描
public class DataDaoImpl implements DataDao{

	
	@Resource//注入
	private HibernateTemplate template;

	
	public void save(Data Data){
		template.save(Data);
		
	}
	
	public void update(Data Data){
		template.update(Data);
	}
	
	public void delete(int DataId){
		Data Data=new Data();
		Data.setDataId(DataId);
		template.delete(Data);
	}
	
	public Data findById(int DataId){
		Data Data=template.load(Data.class, DataId);
		return Data;
	}

	public Result<List<Data>> addData(String content, String imgpath) {
		// TODO Auto-generated method stub
		Result<List<Data>> result =new Result<List<Data>>();
		List<Data> list=new ArrayList<Data>();
		try {
			Data d=new Data();
				d.setContent(content);
				d.setImgpath(imgpath);
				save(d);
			result.setStatus(0);
			
		} catch (Exception e) {
			// TODO: handle exception
			result.setStatus(1);
		}
		
		return result;
	}

	public Result<List<Data>> loadDatas() {
		// TODO Auto-generated method stub
		Result<List<Data>> result =new Result<List<Data>>();
		List<Data> list=new ArrayList<Data>();
		try {
			String sql="from Data";
			list=template.find(sql);
			result.setData(list);
			result.setStatus(0);
			
		} catch (Exception e) {
			// TODO: handle exception
			result.setStatus(1);
		}
		
		return result;
	}

	public Result<List<Data>> delData(int dataId) {
		// TODO Auto-generated method stub
		Result<List<Data>> result =new Result<List<Data>>();
		List<Data> list=new ArrayList<Data>();
		try {
			
			delete(dataId);
			
			result.setStatus(0);
			
		} catch (Exception e) {
			// TODO: handle exception
			result.setStatus(1);
		}
		
		return result;
	}

	public Result<List<Data>> updateData(int dataId, String content, String imgpath) {
		// TODO Auto-generated method stub
		Result<List<Data>> result =new Result<List<Data>>();
		List<Data> list=new ArrayList<Data>();
		try {
			
			Data d=findById(dataId);
			if(content!=null) d.setContent(content);
			if(imgpath!=null) d.setImgpath(imgpath);
			update(d);
			result.setStatus(0);
			
		} catch (Exception e) {
			// TODO: handle exception
			result.setStatus(1);
		}
		
		return result;
	}

	public Result<List<Data>> loadData(int dataId) {
		// TODO Auto-generated method stub
		Result<List<Data>> result =new Result<List<Data>>();
		List<Data> list=new ArrayList<Data>();
		try {
			Data d=findById(dataId);
			list.add(d);
			result.setData(list);
			result.setStatus(0);
			
		} catch (Exception e) {
			// TODO: handle exception
			result.setStatus(1);
		}
		
		return result;
	}



	
}
