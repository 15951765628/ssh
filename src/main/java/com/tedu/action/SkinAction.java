package com.tedu.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tedu.entity.Bill;
import com.tedu.entity.Book;
import com.tedu.entity.Result;
import com.tedu.entity.Skin;
import com.tedu.service.BillService;
import com.tedu.service.SkinService;



@Controller
@Scope("prototype")
public class SkinAction {

	@Resource
	private SkinService skinService;
	
	
	public String loadSkins(){
		u=skinService.loadSkins();
		return "success";
	}

	
	public String deleteSkin(){
		u=skinService.deleteSkin(skinId);
		return "success";
	}
	
	public String editSkin(){
		u=skinService.editSkin(skinId,skinTheme,skinImg);
		return "success";
	}
	
	public String createSkin(){
		u=skinService.createSkin(skinTheme,skinImg);
		return "success";
	}
	
	
	
	
	





	private Result<List<Skin>> u;
	


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
	public Result<List<Skin>> getU() {
		return u;
	}
	public void setU(Result<List<Skin>> u) {
		this.u = u;
	}


	

	
}
