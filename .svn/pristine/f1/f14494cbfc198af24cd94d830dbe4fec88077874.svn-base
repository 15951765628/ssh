package com.tedu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tedu.dao.FamilyDao;
import com.tedu.dao.UserDao;
import com.tedu.entity.Family;
import com.tedu.entity.Result;
import com.tedu.entity.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;
	
	@Resource
	private FamilyDao familyDao;
	
	//用户登录
	public Result<List<User>> userLogin(String username, String password) {
		
		return userDao.userLogin(username,password);
	}

	//用户列表
	public Result<List<User>> userList() {
		return userDao.userList();
	}

	//用户注册
	public Result<List<User>> userRegister(String username, String password,String email) {
		// TODO Auto-generated method stub
		
		return userDao.userRegister(username,password);
	}

	public Result<List<User>> loadUser(int userId) {
		// TODO Auto-generated method stub
		return userDao.loadUser(userId);
	}

	public Result<List<Family>> checkFamily(int userId) {
		// TODO Auto-generated method stub
		return userDao.checkFamily(userId);
	}


	public Result<List<User>> updateUser(int userId, String email, String password, String truename, String birthday,
			String sex, String mobilephone, String nickname,String usericon) {
		// TODO Auto-generated method stub
		return userDao.updateUser(userId,email,password,truename,birthday,sex,mobilephone,nickname,usericon);
	}

	public Result<List<User>> loadUserTotal(int userId,Date startdate ,Date enddate) {
		// TODO Auto-generated method stub
		return userDao.loadUserTotal(userId,startdate,enddate);
	}

	public Result<List<User>> loadUsersTotalByFamily(int familyId, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		Result<List<User>> result=new Result<List<User>>();
		List<User> list=new ArrayList<User>();
		Family family=familyDao.findById(familyId);
		for(User user:family.getUsers()){			
			list.add(loadUserTotal(user.getUserId(),startDate,endDate).getData().get(0));			
		}
		
		result.setData(list);
		
		return result;
	}

	public Result<List<User>> changePassword(int userId, String password) {
		// TODO Auto-generated method stub
		return userDao.changePassword(userId,password);
	}

	



}
