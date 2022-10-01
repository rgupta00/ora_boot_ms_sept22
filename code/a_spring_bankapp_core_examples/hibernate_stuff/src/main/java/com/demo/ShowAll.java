package com.demo;
import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.demo.factory.HibernateSessionFactory;

public class ShowAll {

	public static void main(String[] args) {
		// hibernate session factory
		SessionFactory factory = HibernateSessionFactory.getSessionFactory();

		// 2. session object : Session
		Session session = factory.openSession(); // Session session=factory.getCurrentSession()

											//HQL
//		List<Account> accounts=session.createQuery("select a from Account a", Account.class).getResultList();
//		accounts.forEach(a-> System.out.println(a));
		
		List<String> accountsHolderNames=session.createQuery("select a.name from Account a", String.class).getResultList();
		accountsHolderNames.forEach(a-> System.out.println(a));
		
		session.close();
		factory.close();
	}
}
