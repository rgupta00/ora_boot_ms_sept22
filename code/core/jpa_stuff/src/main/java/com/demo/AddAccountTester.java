package com.demo;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
public class AddAccountTester {

	public static void main(String[] args) {
	
		//JPA
		//SessionFactory === EntityManagerFactory				PU(persitance Unit)
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("bankapp_ora");
		
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction tx= em.getTransaction();
		
		try {
			tx.begin();
			Account account=new Account("guru", 3000);
			em.persist(account);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		
		em.close();
		
		emf.close();
		
	}
}














