package com.tedu.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tedu.dao.PlanDao;
import com.tedu.entity.Note;
import com.tedu.entity.Plan;
import com.tedu.entity.Result;

@Service("planService")
@Transactional
public class PlanServiceImpl implements PlanService{

	
	@Resource
	private PlanDao planDao;

	public Result<List<Plan>> loadplan(int planId) {
		// TODO Auto-generated method stub
		return planDao.loadplan(planId);
	}

	public Result<List<Plan>> loadplans(int userId) {
		// TODO Auto-generated method stub
		return planDao.loadplans(userId);
	}

	public Result<List<Plan>> updateplan(int planId, int money, int totalmoney, String note, Date startdate,
			Date enddate ,String name) {
		// TODO Auto-generated method stub
		return planDao.updateplan(planId,money,totalmoney,note,startdate,enddate,name);
	}

	public Result<List<Plan>> createplan(int userId, int money, int totalmoney, String note, Date startdate,
			Date createdate, Date enddate,String name) {
		// TODO Auto-generated method stub
		return planDao.createplan(userId,money,totalmoney,note,startdate,createdate,enddate,name);
	}

	public Result<List<Plan>> deleteplan(int planId) {
		// TODO Auto-generated method stub
		return planDao.deleteplan(planId);
	}
	


}
