package com.tedu.dao;


import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;


import com.tedu.entity.Result;
import com.tedu.entity.Skin;


@Repository("skinDao")//扫描
public class SkinDaoImpl implements SkinDao{

	
	@Resource//注入
	private HibernateTemplate template;

	
	public void save(Skin Data){
		template.save(Data);
		
	}
	
	public void update(Skin Data){
		template.update(Data);
	}
	
	public void delete(int DataId){
		Skin Data=new Skin();
		Data.setSkinId(DataId);
		template.delete(Data);
	}
	
	public Skin findById(int DataId){
		Skin Data=template.load(Skin.class, DataId);
		return Data;
	}

	public Result<List<Skin>> createSkin(String skinTheme, String skinImg) {
		// TODO Auto-generated method stub
		Result<List<Skin>> result=new Result<List<Skin>>();
		try {
			Skin s=new Skin();
			s.setSkinImg(skinImg);
			s.setSkinTheme(skinTheme);
			save(s);
			
			
			result.setStatus(0);
		} catch (Exception e) {
			// TODO: handle exception
			result.setStatus(1);
		}
		
		
		return result;
	}

	public Result<List<Skin>> loadSkins() {
		// TODO Auto-generated method stub
				Result<List<Skin>> result=new Result<List<Skin>>();
				List<Skin> list=new ArrayList<Skin>();
				
				try {
					String sql="from Skin";
					list=template.find(sql);
					
					result.setData(list);
					result.setStatus(0);
				} catch (Exception e) {
					// TODO: handle exception
					result.setStatus(1);
				}
				
				
				return result;
	}

	public Result<List<Skin>> editSkin(int skinId, String skinTheme, String skinImg) {
		// TODO Auto-generated method stub
				Result<List<Skin>> result=new Result<List<Skin>>();
				try {
					Skin s=findById(skinId);
					s.setSkinTheme(skinTheme);
					update(s);
										
					result.setStatus(0);
				} catch (Exception e) {
					// TODO: handle exception
					result.setStatus(1);
				}
				
				
				return result;
	}

	public Result<List<Skin>> deleteSkin(int skinId) {
		// TODO Auto-generated method stub
				Result<List<Skin>> result=new Result<List<Skin>>();
				try {
					
					delete(skinId);
					
					result.setStatus(0);
				} catch (Exception e) {
					// TODO: handle exception
					result.setStatus(1);
				}
				
				
				return result;
	}

	

	



	
}
