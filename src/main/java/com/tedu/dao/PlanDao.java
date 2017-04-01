package com.tedu.dao;

import java.util.Date;
import java.util.List;

import com.tedu.entity.Plan;
import com.tedu.entity.Result;

public interface PlanDao {

	public Plan findById(int planId);
	
	
	Result<List<Plan>> loadplan(int planId);

	Result<List<Plan>> loadplans(int userId);

	Result<List<Plan>> updateplan(int planId, int money, int totalmoney, String note, Date startdate, Date enddate,String name);

	Result<List<Plan>> createplan(int userId, int money, int totalmoney, String note, Date startdate, Date createdate,
			Date enddate,String name);

	Result<List<Plan>> deleteplan(int planId);

}
