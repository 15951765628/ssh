package com.tedu.dao;

import java.util.List;

import com.tedu.entity.Result;
import com.tedu.entity.Skin;

public interface SkinDao {

	Result<List<Skin>> createSkin(String skinTheme, String skinImg);

	Result<List<Skin>> loadSkins();

	Result<List<Skin>> editSkin(int skinId, String skinTheme, String skinImg);

	Result<List<Skin>> deleteSkin(int skinId);




}
