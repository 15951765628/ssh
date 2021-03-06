package com.tedu.dao;

import java.util.Date;
import java.util.List;

import com.tedu.entity.Family;
import com.tedu.entity.Result;
import com.tedu.entity.User;

public interface UserDao {
	public void save(User user);
	public void update(User user);
	public void delete(int userId);
	public User findById(int userId);
	public Result<List<User>> userList();
	/**
	 * 按用户名作条件查询
	 * @param name
	 * @return 有结果返回User对象;没结果返回null
	 */
	public User findByName(String name);
	public Result<List<User>> userLogin(String username, String password);
	public Result<List<User>> userRegister(String username, String password, String email);
	public Result<List<Family>> checkFamily(int userId);
	public Object addFamilyId(int userId, int familyId);
	public Result<List<User>> loadUser(int userId);
	public Result<List<User>> updateUser(int userId, String email, String password, String truename, String birthday,
			String sex, String mobilephone, String nickname, String usericon, String skin);
	public Result<List<User>> loadUserTotal(int userId,Date startdate,Date endDate );
	public Result<List<User>> changePassword(int userId, String password);
	public Result<List<User>> loadUsers();
	public Result<List<User>> addCollection(int userId, int dataId);
	public Result<List<User>> delCollection(int userId, int dataId);
	public Result<List<User>> search(String truename);
}
