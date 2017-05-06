package com.tedu.service;

import java.util.Date;
import java.util.List;

import com.tedu.entity.Bill;
import com.tedu.entity.Data;
import com.tedu.entity.Result;
import com.tedu.entity.Skin;

public interface SkinService {

	Result<List<Skin>> createSkin(String skinTheme, String skinImg);

	Result<List<Skin>> loadSkins();

	Result<List<Skin>> editSkin(int skinId, String skinTheme, String skinImg);

	Result<List<Skin>> deleteSkin(int skinId);
	


	
}
