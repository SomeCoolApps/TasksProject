package com.data.module.model;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoTest {

	@Test
	public void testSaveUser() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		UserDao userDao = (UserDao) ctx.getBean("userDao");
		User user = new User(0, "testUser");

		Number id = userDao.saveUser(user);

		User user2 = userDao.findUser(id.intValue());

		List<User> all = userDao.getAll(0);

		for (User user1 : all) {
			System.out.println(user1.getName());

		}

		assert (user2 != null);
		System.out.println("found user " + user2.getName());

		userDao.deleteUser(user2);
		System.out.println("User deleted " + user2.getName());

		User user3 = userDao.findUser(id.intValue());
		assert (user3 == null);

		((ConfigurableApplicationContext) ctx).close();
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
