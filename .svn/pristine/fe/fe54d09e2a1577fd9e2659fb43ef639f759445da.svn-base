package com.tedu.service;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tedu.dao.FamilyDao;
import com.tedu.dao.UserDao;
import com.tedu.entity.Family;
import com.tedu.entity.Result;
import com.tedu.entity.U_family;

@Service("familyService")
@Transactional
public class FamilyServiceImpl implements FamilyService{

	@Resource
	private FamilyDao familyDao;
	
	@Resource 
	private UserDao userDao;
	
	//检查用户是否拥有家庭
	public Result<List<Family>> checkFamily(int userId) {
		// TODO Auto-generated method stub
		Result<List<Family>> result = userDao.checkFamily(userId);
		if(result.getStatus()==0)
		{
			result=familyDao.loadFamilyMembers(result.getData().get(0).getFamilyId());
		}
		
		return result;
	}

	public Result<List<Family>> createFamily(int userId, String name, String declaration, String address) {
				
		Family family= new Family();
		family.setCreatedate(com.tedu.tools.time.getDate());
		family.setName(name);
		family.setAddress(address);
		family.setCreaterId(userId);
		family.setDeclaration(declaration);
		//family.setIcon(icon);
		
		return familyDao.createFamily(family);
	}
	
	public void addFamilyId(int userId,int familyId) {
		// TODO Auto-generated method stub
		userDao.addFamilyId(userId,familyId);
		
	}

	public void createApply(int userId,String username, int familyId,String familyname,int fcreaterId) {
		// TODO Auto-generated method stub
		familyDao.createApply(userId,username,familyId,familyname,fcreaterId);
	}

	public Result<List<U_family>> loadApply(int userId) {
		// TODO Auto-generated method stub
		return familyDao.loadApply(userId);
	}

	public Result<List<U_family>> updateApply(int u_familyId, int userId, int familyId, int fcreaterId, int isRefuse) {
		// TODO Auto-generated method stub
		return familyDao.updateApply(u_familyId,userId,familyId,fcreaterId,isRefuse);
	}

	public Result<List<Family>> searchFamily(int familyId) {
		// TODO Auto-generated method stub
		return familyDao.searchFamily(familyId);
	}
	
	
}
