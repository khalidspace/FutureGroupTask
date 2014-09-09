package com.futuregrouptask.views;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

@ManagedBean(name = "hibernateService")
@ApplicationScoped
public class HibernateService implements Serializable {

	private final static SessionFactory sessionFactory;

	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure();
			/*
			 * ServiceRegistry serviceRegistry = new
			 * ServiceRegistryBuilder().applySettings(
			 * configuration.getProperties()).buildServiceRegistry();
			 */
			sessionFactory = configuration.buildSessionFactory();
		} catch (Throwable ex) {
			// Log the exception.
			System.err.println("Initial SessionFactory creation failed." + ex);
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
