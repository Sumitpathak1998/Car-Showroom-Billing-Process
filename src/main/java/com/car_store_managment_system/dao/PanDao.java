package com.car_store_managment_system.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.car_store_managment_system.dto.Pan;

public class PanDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sumit"); 
	
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	EntityTransaction entityTransaction = entityManager.getTransaction(); 
	
	public void savePanAddress(Pan pan) {
		
		entityTransaction.begin();
		entityManager.persist(pan);
		entityTransaction.commit();
		
		System.out.println("-----Data Persited -------");
	}
}
