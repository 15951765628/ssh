package com.tedu.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.tedu.entity.Account;
import com.tedu.entity.Bill;
import com.tedu.entity.Family;
import com.tedu.entity.Result;
import com.tedu.entity.User;

import com.tedu.entity.U_family;

@Repository("familyDao")//扫描
public class FamilyDaoImpl implements FamilyDao{

	@Resource//注入
	private HibernateTemplate template;

	public void save(Family family) {
		template.save(family);
	}

	public void update(Family family) {
		template.update(family);
	}

	public void delete(int familyId) {
		Family family = new Family();
		family.setFamilyId(familyId);
		template.delete(family);
	}

	public Family findById(int familyId) {
		Family family = template.load(Family.class, familyId);
		return family;
	}
	
	
	public Result<List<Family>> checkFamily(int familyId) {
		// TODO Auto-generated method stub
		Result<List<Family>> rs= new Result<List<Family>>();
		List<Family> list= new ArrayList<Family>();
		
		try {
			//System.out.println(this.findById(familyId)!=null);
			
			Family family=this.findById(familyId);
			list.add(family);
			if(family.getFamilyId()!=0)
			{
				rs.setStatus(0);//该用户拥有家庭
				rs.setData(list);
			}else{
				rs.setMsg("请加入家庭！");
				rs.setStatus(2);//该用户没有家庭
			}
	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			rs.setStatus(1);
			rs.setMsg("访问失败，请重试！");
			
		}
		
		return rs;
	}

	public Result<List<Family>> createFamily(Family family) {
		// TODO Auto-generated method stub
		Result<List<Family>> rs= new Result<List<Family>>();
		List<Family> list = new ArrayList<Family>();
		try {
			//System.out.println(this.findById(familyId)!=null);
			this.save(family);
			list.add(family);
			rs.setData(list);
			rs.setMsg("创建成功");
			rs.setStatus(0);//创建成功


	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			rs.setStatus(1);
			rs.setMsg("访问失败，请重试！");
			
		}
		
		return rs;

	}

	public Result<List<Family>> loadFamilyMembers(int familyId) {
		// TODO Auto-generated method stub
				Result<List<Family>> rs= new Result<List<Family>>();
				List<Family> list = new ArrayList<Family>();
				try {
					//System.out.println(this.findById(familyId)!=null);
				
					list.add(this.findById(familyId));
					rs.setData(list);
					rs.setMsg("加载家庭信息成功！");
					rs.setStatus(0);//创建成功


			
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					rs.setStatus(1);
					rs.setMsg("访问失败，请重试！");
					
				}
				
				return rs;
	}

	public void createApply(int userId,String username, int familyId,String familyname,int fcreaterId) {
		// TODO Auto-generated method stub
		try {
			U_family u=new U_family();
			u.setFamilyId(familyId);
			u.setFcreaterId(fcreaterId);
			u.setUserId(userId);
			u.setUsername(username);
			u.setFamilyname(familyname);
			template.save(u);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

	public Result<List<U_family>> loadApply(int userId) {
		// TODO Auto-generated method stub
		Result<List<U_family>> result =new Result<List<U_family>>();
		List<U_family> list=new ArrayList<U_family>();
		try {
			
			String sql="from U_family where fcreaterId = ? or userId =  ?";
			
			list=template.find(sql,userId,userId);
			if(list.size()>0){
				result.setData(list);
			}
			
			
			result.setStatus(0);
		} catch (Exception e) {
			// TODO: handle exception
			result.setStatus(1);
		}
		
		
		return result;
	}

	public Result<List<U_family>> updateApply(int u_familyId, int userId, int familyId, int fcreaterId, int isRefuse) {
		// TODO Auto-generated method stub
		Result<List<U_family>> result=new Result<List<U_family>>();
		
		try {
			if(u_familyId==0){
				String sql="from U_family where userId = ? or fcreaterId = ? ";
				List<U_family> list=template.find(sql,userId,userId);
				for(U_family uf:list){
					uf.setIsRead(1);
				}
			}else{
				U_family uf=template.load(U_family.class, u_familyId);
				uf.setIsRefuse(isRefuse);
				uf.setIsRead(0);
				template.save(uf);
				
				if(uf.getIsRefuse()==2){
					User user =template.load(User.class,userId);
					user.setFamilyId(uf.getFamilyId());
					template.save(user);
				}
			}
			result.setStatus(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setStatus(1);
		}
		
		
		return result;
	}

	public Result<List<Family>> searchFamily(int familyId) {
		// TODO Auto-generated method stub
		Result<List<Family>> result =new Result<List<Family>>();
		List<Family> list=new ArrayList<Family>();
		try {
			String sql="from Family where familyId = ?";
			
			list=template.find(sql,familyId);
			
			if(list.size()>0){
			
				result.setData(list);
			}
			
			
			result.setStatus(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setStatus(1);
			
		}
		return result;
	}

	public Result<List<Family>> loadFamilys() {
		// TODO Auto-generated method stub
		Result<List<Family>> result =new Result<List<Family>>();
		List<Family> list=new ArrayList<Family>();
		try {
			String sql="from Family where 1 = 1";
			
			list=template.find(sql);
			
			if(list.size()>0){
			
				result.setData(list);
			}
			
			
			result.setStatus(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setStatus(1);
			
		}
		return result;
	}

	public List<Integer> loadBudget(int familyId) {
		// TODO Auto-generated method stub
		/*List<User> users=new ArrayList<User>();
		List<Account> accounts=new ArrayList<Account>();
		List<Bill> bills=new ArrayList<Bill>();
		try {
			User user=findById(userId);
			String sqlAccounts=" from Account where userId = ? ";
			String sqlBills=" from Bill where (payAccount = ? or receiveAccount = ?) and createdate between ? and ?  and bookId not in (0) ";
			accounts=template.find(sqlAccounts,userId);
			for(Account account:accounts){
				bills=template.find(sqlBills,account.getAccountId(),account.getAccountId(),startdate,enddate);
				for(Bill bill:bills){
					if(bill.getPayAccount()==account.getAccountId()){
						user.setTotalOut(user.getTotalOut()+bill.getNum());
					}else if(bill.getReceiveAccount()==account.getAccountId()){
						user.setTotalIn(user.getTotalIn()+bill.getNum());
					}
				}			
				user.setTotalLeft(user.getTotalLeft()+account.getMoney());
			}
			users.add(user);
			result.setData(users);			
			result.setStatus(0);
		} catch (Exception e) {
			// TODO: handle exception
			result.setStatus(1);
		}*/
		List<Integer> result=new ArrayList<Integer>();
		List<User> users=new ArrayList<User>();
		List<Account> accounts=new ArrayList<Account>();
		List<Bill> bills=new ArrayList<Bill>();
		
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
		Calendar c1=Calendar.getInstance();
		Calendar c2=Calendar.getInstance();
		c1.setTime(new Date());		
		c2.setTime(new Date());	

		c1.set(c1.get(1), c1.get(2), c1.getMinimum(Calendar.DATE));
		c2.set(c2.get(1), c2.get(2), c2.getMaximum(Calendar.DATE));
		
		
		int totalIn=0;
		int totalOut=0;
		try {
			String sqlUsers="from User where familyId= ? ";
			users=template.find(sqlUsers,familyId);
			for(User user:users){
				String sqlAccounts=" from Account where userId = ? ";
				String sqlBills=" from Bill where (payAccount = ? or receiveAccount = ?) and createdate between"
						+ " '"+formatter.format(c1.getTime())+" 00:00:00' and '"+ formatter.format(c2.getTime()) +" 23:59:59' and bookId not in (0) ";
				accounts=template.find(sqlAccounts,user.getUserId());
				for(Account account:accounts){
					bills=template.find(sqlBills,account.getAccountId(),account.getAccountId());
					for(Bill bill:bills){
						if(bill.getPayAccount()==account.getAccountId()){
							totalOut+=bill.getNum();
						}else if(bill.getReceiveAccount()==account.getAccountId()){
							totalIn+=bill.getNum();
						}
					}			
				}
				
			}
		
			result.add(totalIn);
			result.add(totalOut);
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;
	}

	public Result<List<Family>> updateFamily(int familyId, int budgetin, int budgetout) {
		// TODO Auto-generated method stub
		Result<List<Family>> result =new Result<List<Family>>();
		
		try {
			Family family=findById(familyId);
			if(budgetin!=0) family.setBudgetin(budgetin);
			if(budgetout!=0) family.setBudgetout(budgetout);
			update(family);
			
			result.setStatus(0);
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(1);
			// TODO: handle exception
		}
		return result;
	}

}
