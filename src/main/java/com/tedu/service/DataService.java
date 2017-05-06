package com.tedu.service;

import java.util.Date;
import java.util.List;

import com.tedu.entity.Bill;
import com.tedu.entity.Data;
import com.tedu.entity.Result;

public interface DataService {

	Result<List<Data>> addData(String content, String imgpath);

	Result<List<Data>> loadDatas();

	Result<List<Data>> loadData(int dataId);

	Result<List<Data>> delData(int dataId);

	Result<List<Data>> updateData(int dataId, String content, String imgpath);

	Result<List<Data>> loadDataByUser(int dataId);

	Result<List<Data>> search(String content);


	
}
