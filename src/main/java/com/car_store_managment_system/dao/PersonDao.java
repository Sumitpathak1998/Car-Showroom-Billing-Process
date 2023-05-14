package com.car_store_managment_system.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.car_store_managment_system.dto.Address;
import com.car_store_managment_system.dto.Car;
import com.car_store_managment_system.dto.Pan;
import com.car_store_managment_system.dto.Person;

public class PersonDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sumit"); 
	
	EntityManager entityManager = entityManagerFactory.createEntityManager(); 
	
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	/*
	 * Save Method 
	 * New added person , pan , address , car  
	 */
	public void savePerson( Person person ) {
		
		
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
		
		System.out.println("---Data Persist------");
	}
	
	/*
	 * Save Method 
	 * New added person and link this person with existing pan and address 
	 */
	public void savePerson( Person person , String panNumber ) {
		
		Pan pan = entityManager.find( Pan.class, panNumber); 
		
		if ( pan != null ) {

			/*
			 * This we need to do so that from the same Pan number multiple person not attached 
			 */
			String select = "select p from Person p";
			
			Query query = entityManager.createQuery(select);
			
			List<Person> list = query.getResultList();
			
			boolean result = true ; 
			for ( Person person1 : list) {
				
				if ( person1.getPan().getPanNumber().equals(panNumber)) {
					
					result = false ; 
					break ; 
				}
			}
			System.out.println(result);
			if ( result == true ) {
				
				person.setPan(pan);
				
				Address address = pan.getAddress(); 
				
				person.setAddress(address);
				
				entityTransaction.begin();
				entityManager.persist(person);
				entityTransaction.commit();
				
				System.out.println("----Data Persited-------");
			}else{
				System.out.println("Duplicate Pan not allowed");
			}
		}
		else {
			System.out.println("Please check the Pan Id");
		}
	}
	/*
	 * GetById Method
	 */
	public Person getById( int personId) {
		
		Person person = entityManager.find( Person.class, personId); 
		
		return person ; 
	}
	
	/*
	 * Delete the Person record 
	 */
	public void deletePerson( int personId) {
		
		Person person = entityManager.find( Person.class, personId);
		
		if ( person != null ) {
			
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
			
			System.out.println("-------Data Deleted--------");
		}else {
			System.out.println("Check the Person id");
		}
	}
	/*
	 * Update the data 
	 */
	public void updatePerson( int personId , String email , String dob , String flatNo) {
		
		Person person = entityManager.find( Person.class, personId);
		
		if ( person != null ) {
			
			person.setEmail(email);
			
			Pan pan = person.getPan(); 
			
			if ( pan != null ) {
				
				pan.setDate(dob);
			}
			
			Address address = person.getAddress(); 
			
			if ( address != null ) {
				
				address.setFlatNumber(flatNo);
			}
			
			entityTransaction.begin();
			entityManager.merge(person); 
			entityTransaction.commit();
			
			System.out.println("-----Data Updated------");
		}
		else {
			System.out.println("Please check the Person Id");
		}
	}
	/*
	 * Display all details 
	 */
	
	public List<Person> displayPerson(){
		
		String select = "select p from Person p";
		
		Query query = entityManager.createQuery(select); 
		
		List<Person> list = query.getResultList();
		
		return list; 
	}
}
