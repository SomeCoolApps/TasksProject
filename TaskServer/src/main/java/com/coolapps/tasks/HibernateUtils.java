package com.coolapps.tasks;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
@Resource
public class HibernateUtils {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
        	
        	
            // Create the SessionFactory from hibernate.cfg.xml
          //  return new Configuration().configure().buildSessionFactory();
            
            SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
            return factory;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
    	// Close caches and connection pools
    	getSessionFactory().close();
    }

}
