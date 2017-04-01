package com.tedu.action;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tedu.entity.Family;
import com.tedu.entity.Result;
import com.tedu.entity.U_family;
import com.tedu.entity.User;
import com.tedu.service.FamilyService;
import com.tedu.service.UserService;;

@Controller
@Scope("prototype")
public class FamilyAction {

	
	public String checkFamily(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session= request.getSession();
		//if(session.getAttribute("userId")!=null){
		if(userId!=0){
			//u=familyService.checkFamily(Integer.parseInt(session.getAttribute("userId")+""));
			u=familyService.checkFamily(userId);
		}
		return "success";
	}
	
	public String searchFamily(){
		
		u=familyService.searchFamily(familyId);
		return "success";
	}
	
	
	public String createFamily(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session= request.getSession();
		//if(session.getAttribute("userId")!=null){
		if(userId!=0)
		{
			//userId=Integer.parseInt(session.getAttribute("userId")+"");
			u=familyService.createFamily(userId,name,declaration,address);
		}
		
		familyService.addFamilyId(userId,u.getData().get(0).getFamilyId());
		
		return "success";
	}
	
	public String createApply(){
		
		familyService.createApply(userId,username,familyId,familyname,fcreaterId);
		
		return "success";
	}
	
	public String loadApply(){
		
		u2=familyService.loadApply(userId);
		
		return "success";
	}

	public String updateApply(){
	
		u2=familyService.updateApply(u_familyId,userId,familyId,fcreaterId,isRefuse);
	
	return "success";
} 
	
	
	
	
	
	private Result<List<Family>> u;
	
	private int familyId ;
	private int userId;
	private String name ;
	private Date createdate;
	private String icon;
	private String declaration ;
	private String address ;
	private int createrId ;
	private Set<User> users;
	
	private Result<List<U_family>> u2;
	
	private int u_familyId;
	private int fcreaterId;
	private int isRead;
	private int isRefuse;
	
	private String username;
	private String familyname;
	
	
	@Resource
	private FamilyService familyService;
	
	@Resource
	private UserService userService;
	
	
	
	
	public Result<List<Family>> getU() {
		return u;
	}
	public void setU(Result<List<Family>> u) {
		this.u = u;
	}
	public int getFamilyId() {
		return familyId;
	}
	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getDeclaration() {
		return declaration;
	}
	public void setDeclaration(String declaration) {
		this.declaration = declaration;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCreaterId() {
		return createrId;
	}
	public void setCreaterId(int createrId) {
		this.createrId = createrId;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getU_familyId() {
		return u_familyId;
	}

	public void setU_familyId(int u_familyId) {
		this.u_familyId = u_familyId;
	}

	public int getFcreaterId() {
		return fcreaterId;
	}

	public void setFcreaterId(int fcreaterId) {
		this.fcreaterId = fcreaterId;
	}

	public int getIsRead() {
		return isRead;
	}

	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}

	public int getIsRefuse() {
		return isRefuse;
	}

	public void setIsRefuse(int isRefuse) {
		this.isRefuse = isRefuse;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Result<List<U_family>> getU2() {
		return u2;
	}

	public void setU2(Result<List<U_family>> u2) {
		this.u2 = u2;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFamilyname() {
		return familyname;
	}

	public void setFamilyname(String familyname) {
		this.familyname = familyname;
	}
	
}
