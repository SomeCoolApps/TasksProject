package com.coolapps.tasks;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class UserDao {

	// TODO @Autowired
	SessionFactory sessionFactory;// = HibernateUtils.getSessionFactory();

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveorUpdateUser(User e) {

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.saveOrUpdate(e);

		session.getTransaction().commit();

	}

	public void deleteUser(User e) {
		Session currentSession = sessionFactory.openSession();
		currentSession.beginTransaction();

		currentSession.delete(e);
	}

	public List<User> findUser(String name) {

		Session currentSession = sessionFactory.openSession();

		List<User> list = currentSession.createCriteria(User.class).add(Restrictions.eq("name", name)).list();
		return list;

	}

}
