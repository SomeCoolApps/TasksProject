package com.coolapps.tasks.controllers;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coolapps.tasks.model.Task;
import com.coolapps.tasks.model.TaskDao;
import com.coolapps.tasks.model.User;
import com.coolapps.tasks.model.UserDao;

@RestController
public class UserController {

	@RequestMapping("/user/{player}")
	public User message(@PathVariable String player) {// REST Endpoint.

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		SessionFactory sf = (SessionFactory) ctx.getBean("sessionFactory");

		UserDao dao = new UserDao();
		dao.setSessionFactory(sf);
		User e = new User();
		
		e.setName(player);

		dao.saveorUpdateUser(e);
		List<User> t = dao.findUser(player);
		int id =0;
		for (User f : t) {
			System.out.println(f.getName());
			id = f.getId();
		}

		// dao.deleteUser(e);

		User user = new User();
		user.setId(id);
		user.setName(player);
		return user;
	}
	
	@RequestMapping("/task/{name}/{summary}")
	public Task createTask(@PathVariable String name , @PathVariable String summary){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
		TaskDao dao = new TaskDao();
		dao.setSessionFactory(sessionFactory);
		Task task = new Task();
		task.setName(name);
		task.setDescription(summary);

		dao.saveorUpdateTask(task);
		return task;
		
	}

}
