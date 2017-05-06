package com.tedu.entity;

import java.io.Serializable;
import java.util.Date;

public class Skin implements Serializable {

	private int skinId;
	private String skinTheme;
	private String skinImg;
	public int getSkinId() {
		return skinId;
	}
	public void setSkinId(int skinId) {
		this.skinId = skinId;
	}
	public String getSkinTheme() {
		return skinTheme;
	}
	public void setSkinTheme(String skinTheme) {
		this.skinTheme = skinTheme;
	}
	public String getSkinImg() {
		return skinImg;
	}
	public void setSkinImg(String skinImg) {
		this.skinImg = skinImg;
	}
	


}
