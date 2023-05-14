package com.car_store_managment_system.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;  

import com.car_store_managment_system.dto.Car;
import com.car_store_managment_system.dto.Person;

public class CarDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sumit"); 
	
	EntityManager entityManager = entityManagerFactory.createEntityManager(); 
	
	EntityTransaction entityTransaction = entityManager.getTransaction(); 
	
	public void connectPersonWithCar( int personId , List<Car> list)
	{		
		Person person = entityManager.find(Person.class , personId); 
		
		if ( person != null ) {
			
			for( Car car : list ) {
				
				car.setPerson(person);
				
				entityTransaction.begin();
				
				entityManager.persist(car);
				
				System.out.println("------Data Persisted-----");
			}
			entityTransaction.commit();
		}
	}
	
	public void insertCar( List<Car> list) {
		
		for ( Car car : list  ) {
			
			entityTransaction.begin();
			entityManager.persist(car);
			entityTransaction.commit();
			
			System.out.println("---- Car Data Persisted -------");
		}
	}
}
