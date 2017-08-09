package com.data.module.model;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoTest {

	@Test
	public void testSaveUser() {
		
		  
		
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

	@Test
	public void testUpdateUser() {
		// fail("Not yet implemented");
	}

	@Test
	public void testDeleteUser() {
		// fail("Not yet implemented");
	}

}
