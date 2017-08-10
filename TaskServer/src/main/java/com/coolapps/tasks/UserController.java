package com.coolapps.tasks;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@RestController
public class UserController {
	
	  
	    @RequestMapping("/user/{player}")
	    public User message(@PathVariable String player) {//REST Endpoint.

			
			  
			
			ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");  
		     
		    SessionFactory sf=(SessionFactory)ctx.getBean("sessionFactory");
		    
		    
		    UserDao dao = new UserDao();
		    dao.setSessionFactory(sf);
		    User e = new User(11,player);
		   
		    
			dao.saveorUpdateUser(e );
			List<User> t = dao.findUser("test");
			for(User f:t){
				System.out.println(f.getName());
			}
			
			//dao.deleteUser(e);
			
		      
		

	        User user = new User(1,"Sunil");
	        return user;
	    }

}
