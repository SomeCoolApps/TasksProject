package com.data.module.model;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTester {
	
	  
	public static void main(String[] args) {
		
		  
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");  
	     
	    SessionFactory sf=(SessionFactory)ctx.getBean("sessionFactory");
	    
	    
	    UserDao dao = new UserDao();
	    dao.setSessionFactory(sf);
	    User e = new User(11,"test");
	   
	    
		dao.saveorUpdateUser(e );
		List<User> t = dao.findUser("test");
		for(User f:t){
			System.out.println(f.getName());
		}
		
		dao.deleteUser(e);
		
	      
	
}  
	  
	  
}
