package com.tedu.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.tedu.entity.Note;
import com.tedu.entity.Plan;
import com.tedu.entity.Result;

@Repository("planDao")//扫描
public class PlanDaoImpl implements PlanDao{

	
	@Resource//注入
	private HibernateTemplate template;
	
	public void save(Plan plan){
		template.save(plan);
		
	}
	
	public void update(Plan plan){
		template.update(plan);
	}
	
	public void delete(int planId){
		Plan plan=new Plan();
		plan.setPlanId(planId);
		template.delete(plan);
	}
	
	public Plan findById(int planId){
		Plan plan=template.load(Plan.class, planId);
		return plan;
	}
	
	
	
	public Result<List<Plan>> loadplan(int planId) {
		// TODO Auto-generated method stub
		Result<List<Plan>> result=new Result<List<Plan>>();
		List<Plan> list=new ArrayList<Plan>();
		try {
			Plan plan=findById(planId);
			list.add(plan);
			
			result.setData(list);
			result.setStatus(0);
		} catch (Exception e) {
			// TODO: handle exception
			result.setStatus(1);
		}
		
		return result;
	}

	public Result<List<Plan>> loadplans(int userId) {
		// TODO Auto-generated method stub
		Result<List<Plan>> result=new Result<List<Plan>>();
		List<Plan> list=new ArrayList<Plan>();
		try {
			String sql="from Plan where userId = ?";
			list=template.find(sql,userId);
			
			result.setData(list);
			result.setStatus(0);
		} catch (Exception e) {
			// TODO: handle exception
			result.setStatus(1);
		}
		
		return result;
	}

	public Result<List<Plan>> updateplan(int planId, int money, int totalmoney, String note, Date startdate,Date enddate,String name) {
		// TODO Auto-generated method stub
		Result<List<Plan>> result=new Result<List<Plan>>();
		List<Plan> list=new ArrayList<Plan>();
		try {
			Plan plan=findById(planId);
			//plan.setEnddate(enddate);
			//plan.setStartdate(startdate);
			plan.setTotalmoney(totalmoney);
			plan.setName(name);
			plan.setMoney(money);
			plan.setNote(note);
			
			update(plan);
			
			
			
			result.setStatus(0);
		} catch (Exception e) {
			// TODO: handle exception
			result.setStatus(1);
			e.printStackTrace();
		}
		
		return result;
	}

	public Result<List<Plan>> createplan(int userId, int money, int totalmoney, String note, Date startdate,
			Date createdate, Date enddate,String name) {
		// TODO Auto-generated method stub
		Result<List<Plan>> result=new Result<List<Plan>>();
		List<Plan> list=new ArrayList<Plan>();
		try {
			Plan plan=new Plan();
			plan.setCreatedate(com.tedu.tools.time.getDate());
			plan.setEnddate(enddate);
			plan.setStartdate(startdate);
			plan.setTotalmoney(totalmoney);
			plan.setUserId(userId);
			plan.setMoney(money);
			plan.setName(name);
			if(note!=null){
				plan.setNote(note);
			}
			
			save(plan);
			
			result.setStatus(0);
		} catch (Exception e) {
			// TODO: handle exception
			result.setStatus(1);
		}
		
		return result;
	}

	public Result<List<Plan>> deleteplan(int planId) {
		// TODO Auto-generated method stub
		Result<List<Plan>> result=new Result<List<Plan>>();
		List<Plan> list=new ArrayList<Plan>();
		try {
			delete(planId);
			result.setStatus(0);
		} catch (Exception e) {
			// TODO: handle exception
			result.setStatus(1);
		}
		
		return result;
	}

}
