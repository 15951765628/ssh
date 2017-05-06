package com.tedu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tedu.dao.BillDao;
import com.tedu.dao.DataDao;
import com.tedu.entity.Bill;
import com.tedu.entity.Data;
import com.tedu.entity.Result;


@Service("dataService")
@Transactional
public class DataServiceImpl implements DataService{

	@Resource
	private DataDao dataDao;

	public Result<List<Data>> addData(String content, String imgpath) {
		// TODO Auto-generated method stub
		return dataDao.addData(content,imgpath);
	}

	public Result<List<Data>> loadDatas() {
		// TODO Auto-generated method stub
		return dataDao.loadDatas();
	}

	public Result<List<Data>> loadData(int dataId) {
		// TODO Auto-generated method stub
		return dataDao.loadData(dataId);
	}

	public Result<List<Data>> delData(int dataId) {
		// TODO Auto-generated method stub
		return dataDao.delData(dataId);
	}

	public Result<List<Data>> updateData(int dataId, String content, String imgpath) {
		// TODO Auto-generated method stub
		return dataDao.updateData(dataId,content,imgpath);
	}

	public Result<List<Data>> loadDataByUser(int dataId) {
		// TODO Auto-generated method stub
		return dataDao.loadDataByUser(dataId);
	}

	public Result<List<Data>> search(String content) {
		// TODO Auto-generated method stub
		return dataDao.search(content);
	}
	
		
	
}
