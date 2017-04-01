package com.tedu.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

public class User implements Serializable{
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
	
	private int totalIn;
	private int totalOut;
	private int totalLeft;
	
	
	private Set<Book> books;
	
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
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", nickname=" + nickname
				+ ", truename=" + truename + ", sex=" + sex + ", birthday=" + birthday + ", email=" + email+", familyId=" + familyId
				+ ", mobilephone=" + mobilephone + "]";
	}
	public int getFamilyId() {
		return familyId;
	}
	public void setFamilyId(int familyId) {
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

	
		
}
