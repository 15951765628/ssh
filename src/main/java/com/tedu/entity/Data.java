package com.tedu.entity;

import java.io.Serializable;
import java.util.Date;

public class Data implements Serializable {

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

}
