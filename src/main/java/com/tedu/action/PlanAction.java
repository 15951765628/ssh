package com.tedu.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.tedu.entity.Plan;
import com.tedu.entity.Result;
import com.tedu.service.PlanService;

@Controller
@Scope("prototype")
public class PlanAction {
	
	@Resource
	private PlanService planService;
	
	public String loadPlan()
	{
		u=planService.loadplan(planId);
		return "success";
	}
	
	public String loadPlans()
	{
		u=planService.loadplans(userId);
		return "success";
	}
	
	public String updatePlan()
	{
		u=planService.updateplan(planId,money,totalmoney,note,startdate,enddate,name);
		return "success";
	}
	
	public String createPlan()
	{ 
		u=planService.createplan(userId,money,totalmoney,note,startdate,createdate,enddate,name);
		return "success";
	}
	
	public String deletePlan()
	{
		u=planService.deleteplan(planId);
		return "success";
	}
	
	
	
	private  int planId;
	private  int money;
	private  int totalmoney;
	private  String name;
	private  String note;
	private  int userId;
	private  Date startdate;
	private  Date createdate;
	private  Date enddate;
	
	private Result<List<Plan>> u;
	
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getTotalmoney() {
		return totalmoney;
	}
	public void setTotalmoney(int totalmoney) {
		this.totalmoney = totalmoney;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Result<List<Plan>> getU() {
		return u;
	}

	public void setU(Result<List<Plan>> u) {
		this.u = u;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	
}
