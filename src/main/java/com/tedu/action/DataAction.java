package com.tedu.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tedu.entity.Bill;
import com.tedu.entity.Book;
import com.tedu.entity.Data;
import com.tedu.entity.Result;
import com.tedu.service.BillService;
import com.tedu.service.DataService;


@Controller
@Scope("prototype")
public class DataAction {

	@Resource
	private DataService dataService;
	
	
	public String loadDatas(){
		u=dataService.loadDatas();
		return "success";
	}
	
	public String loadData(){
		u=dataService.loadData(dataId);
		return "success";
	}
	
	public String delData(){
		u=dataService.delData(dataId);
		return "success";
	}
	
	public String updateData(){
		u=dataService.updateData(dataId,content,imgpath);
		return "success";
	}
	
	public String addData(){
		u=dataService.addData(content,imgpath);
		return "success";
	}
	
	public String loadDataByUser(){
		//吧userId传进来
		u=dataService.loadDataByUser(dataId);
		return "success";
	}
	
	
	
	





	private Result<List<Data>> u;
	


	private int dataId;
	private String content;
	private String imgpath;
	public int getDataId() {
		return dataId;
	}
	public void setDataId(int dataId) {
		this.dataId = dataId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public Result<List<Data>> getU() {
		return u;
	}
	public void setU(Result<List<Data>> u) {
		this.u = u;
	}


	

	
}
