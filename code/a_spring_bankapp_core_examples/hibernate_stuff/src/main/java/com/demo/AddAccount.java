package com.demo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.demo.factory.HibernateSessionFactory;

public class AddAccount {

	public static void main(String[] args) {
		// hibernate session factory
		SessionFactory factory = HibernateSessionFactory.getSessionFactory();

		// 2. session object : Session
		Session session = factory.openSession(); // Session session=factory.getCurrentSession()

		// 3. start the tx
		Transaction tx = session.getTransaction();

		// Create the account object and save with hib
		try {
			tx.begin();
			Account account = new Account("umesh", 1000);
			session.save(account);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
		}

		session.close();

		factory.close();
	}
}
