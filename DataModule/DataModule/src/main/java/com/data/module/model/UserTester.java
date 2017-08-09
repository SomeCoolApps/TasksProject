package com.data.module.model;

import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  

public class UserTester {
	
	  
	public static void main(String[] args) {  
	    ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");  
	      
	    UserDao dao=(UserDao)ctx.getBean("edao");  
	    // int status=dao.saveUser(new User(102,"Amit",35000));  
	    // System.out.println(status);  
	          
	    /*int status=dao.updateUser(new User(102,"Sonoo",15000)); 
	    System.out.println(status); 
	    */  
	          
	    /*User e=new User(); 
	    e.setId(102); 
	    int status=dao.deleteUser(e); 
	    System.out.println(status);*/  
	      
	}  
	  
	  
}
