package com.tedu.service;

import java.util.Date;
import java.util.List;

import com.tedu.entity.Family;
import com.tedu.entity.Result;
import com.tedu.entity.User;

public interface UserService {
	public Result<List<User>> userList();
	public Result<List<User>> loadUser(int userId);
	public Result<List<User>> userLogin(String username, String password);
	public Result<List<User>> userRegister(String username, String password, String email);
	public Result<List<User>> updateUser(int userId, String email, String password, String truename, String birthday,String sex, String mobilephone, String nickname, String usericon);
	public Result<List<User>> loadUserTotal(int userId,Date startdate,Date endDate);
	public Result<List<User>> loadUsersTotalByFamily(int familyId, Date startDate, Date endDate);
	public Result<List<User>> changePassword(int userId, String password);
	
}
