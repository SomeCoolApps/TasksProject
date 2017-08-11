package com.coolapps.tasks.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class TaskDao {

	// TODO @Autowired
	SessionFactory sessionFactory;// = HibernateUtils.getSessionFactory();

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveorUpdateTask(Task e) {

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.saveOrUpdate(e);

		session.getTransaction().commit();

	}

	public void deleteTask(Task e) {
		Session currentSession = sessionFactory.openSession();
		currentSession.beginTransaction();

		currentSession.delete(e);
	}

	public List<User> findTask(String name) {

		Session currentSession = sessionFactory.openSession();

		List<User> list = currentSession.createCriteria(Task.class).add(Restrictions.eq("name", name)).list();
		return list;

	}

}
