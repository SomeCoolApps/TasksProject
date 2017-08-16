package com.coolapps.tasks.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coolapps.tasks.model.Task;
import com.coolapps.tasks.model.TaskDao;
import com.coolapps.tasks.model.User;
import com.coolapps.tasks.model.UserActivites;
import com.coolapps.tasks.model.UserDao;
import com.coolapps.tasks.model.UserTask;

@RestController
public class UserController {

	@RequestMapping(method = RequestMethod.POST, value = "/user/{name}")
	public User message(@PathVariable String name,@RequestBody User user2) {// REST Endpoint.
		
		List<UserActivites> activities = user2.getUserActivites();
		
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		SessionFactory sf = (SessionFactory) ctx.getBean("sessionFactory");

		UserDao dao = new UserDao();
		dao.setSessionFactory(sf);
		User e = new User();
		
		e.setName(name);

		dao.saveorUpdateUser(e);
		
		List<User> t = dao.findUser(name);
		int id =0;
		for (User f : t) {
			System.out.println(f.getName());
			id = f.getId();
		}

		// dao.deleteUser(e);

		User user = new User();
		user.setId(id);
		user.setName(name);
		List<UserActivites> userActivites = new ArrayList<UserActivites>();
		UserActivites activity = new UserActivites();
		activity.setActivity("create schedule");
		activity.setActivityDate(new Date());
		userActivites.add(activity );
		user.setUserActivites(userActivites );
		List<UserTask> userTasks = new ArrayList<UserTask>();
		UserTask task = new UserTask();
		Task task1 = new Task();
		task1.setDescription("task description");
		//task1.setStatus(");
		task.setTask(task1 );
		
		userTasks.add(task );
		user.setUserTasks(userTasks );
		return user;
	}
	
	
	
	
	@RequestMapping("/task/{name}/{summary}, method = RequestMethod.POST")
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
