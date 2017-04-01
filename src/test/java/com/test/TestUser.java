package com.test;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.tedu.dao.UserDao;
import com.tedu.entity.Family;
import com.tedu.entity.User;

public class TestUser {
	
	/*private HibernateTemplate template;
	@Before
	public void init(){
		//实例化Spring容器
		String conf = "spring-hibernate.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		template = ac.getBean("template",HibernateTemplate.class);
	}
	
	@Test//测试UserDao
	public void test5(){
		String conf = "spring-hibernate.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		UserDao userDao = ac.getBean("userDao",UserDao.class);
		//List<User> list = userDao.findAll();
		///for(User user:list){
		//	System.out.println(user.getUsername());
		//}
	}
	
	@Test//测试Template
	public void test2(){
		User user = new User();
		user.setUsername("ssh");
		user.setPassword("123344");
		template.save(user);
	}
	
	@Test//测试HQL
	public void test3(){
		String hql = "from User";
		List<User> list = template.find(hql);
		for(User user:list){
			System.out.println(user.getUsername());
		}
	}
	
	@Test//测试带参数HQL
	public void test4(){
		String hql = "from User where username like ?";
		Object[] params = {"%o%"};
		List<User> list = template.find(hql, params);
		for(User user:list){
			System.out.println(user.getUsername());
		}
	}
	

				
				
				
				
				
//        String hql = "from Family where familyId = ?";
//		Object[] params = {1};
//		List<Family> familys = template.find(hql, params);
//		
//			System.out.println(familys.get(0));
//			Set<User_family> services = familys.get(0).getUser_familys();
//	        System.out.println(services.getClass().getName());
//	        for (User_family service : services) {
//	            System.out.println(service);
//       
//	        }*/
	}
	
