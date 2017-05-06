package com.tedu.service;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tedu.dao.SkinDao;
import com.tedu.entity.Result;
import com.tedu.entity.Skin;


@Service("skinService")
@Transactional
public class SkinServiceImpl implements SkinService{

	@Resource
	private SkinDao skinDao;

	public Result<List<Skin>> createSkin(String skinTheme, String skinImg) {
		// TODO Auto-generated method stub
		return skinDao.createSkin(skinTheme, skinImg);
	}

	public Result<List<Skin>> loadSkins() {
		// TODO Auto-generated method stub
		return skinDao.loadSkins();
	}

	public Result<List<Skin>> editSkin(int skinId, String skinTheme, String skinImg) {
		// TODO Auto-generated method stub
		return skinDao.editSkin(skinId, skinTheme, skinImg);
	}

	public Result<List<Skin>> deleteSkin(int skinId) {
		// TODO Auto-generated method stub
		return skinDao.deleteSkin(skinId);
	}

	

	
		
	
}
