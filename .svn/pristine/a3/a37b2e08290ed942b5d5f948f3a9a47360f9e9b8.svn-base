package com.tedu.action;


import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tedu.entity.Book;
import com.tedu.entity.Result;
import com.tedu.entity.User;
import com.tedu.service.UserService;

@Controller
@Scope("prototype")
public class UserAction {
  
	
	
	
	//登录验证
	public String userLogin(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session= request.getSession();
 		u=userService.userLogin(username,password);
 		if(u.getStatus()==0){
 			session.setAttribute("userId", u.getData().get(0).getUserId());
 		}
		return "success";
	}
	
	//查询所有用户
	public String userList(){
		
		u=userService.userList();
		return "success";
	}
	
	//注册
	public String userRegister(){
		
		u=userService.userRegister(username,password,email);
		return "success";
	}

	
	public String loadUser(){
		u=userService.loadUser(userId);
		return "success";
	}
	
	public String updateUser(){
		u=userService.updateUser(userId,email,password,truename,birthday,sex,mobilephone,nickname,usericon);
		return "success";
	}
	
	public String changePassword(){
		u=userService.changePassword(userId,password);
		return "success";
	}
	
	public String loadUserTotal(){
		u=userService.loadUserTotal(userId,startDate,endDate);
		return "success";
	}
	
	public String loadUsersTotalByFamily(){
		u=userService.loadUsersTotalByFamily(familyId,startDate,endDate);
		return "success";
	}
	
	
	private Result<List<User>> u;
	//接收
	private int userId;
	private String username;
	private String password;
	private String nickname;
	private String truename;
	private String sex;
	private String birthday;
	private String email;
	private String mobilephone;
	private String usericon;
	private int familyId;
	private Set<Book> books;
	private int totalIn;
	private int totalOut;
	private int totalLeft;
	
	private Date startDate;
	private Date endDate;
	
	
	@Resource
	private UserService userService;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Result<List<User>> getU() {
		return u;
	}

	public void setU(Result<List<User>> u) {
		this.u = u;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public int getFamilyId() {
		return familyId;
	}

	public void setFamilyId(int  familyId) {
		this.familyId = familyId;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public String getUsericon() {
		return usericon;
	}

	public void setUsericon(String usericon) {
		this.usericon = usericon;
	}

	public int getTotalIn() {
		return totalIn;
	}

	public void setTotalIn(int totalIn) {
		this.totalIn = totalIn;
	}

	public int getTotalOut() {
		return totalOut;
	}

	public void setTotalOut(int totalOut) {
		this.totalOut = totalOut;
	}

	public int getTotalLeft() {
		return totalLeft;
	}

	public void setTotalLeft(int totalLeft) {
		this.totalLeft = totalLeft;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


}