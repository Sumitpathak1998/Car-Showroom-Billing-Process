package com.car_store_managment_system.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.car_store_managment_system.dto.Car;
import com.car_store_managment_system.dto.CarBooking;
import com.car_store_managment_system.dto.Person;

public class CarBookingDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sumit");
	
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	EntityTransaction entityTransaction = entityManager.getTransaction(); 
	
	public void bookCar( CarBooking carBooking , int personId , int carId) {
		
		Person person = entityManager.find( Person.class, personId);
		
		Car car = entityManager.find( Car.class, carId);
		
		entityTransaction.begin();
		
		if( person != null && car != null ) {
			
			car.setPerson(person);
			
			entityManager.merge(car);
			
			carBooking.setCar(car);
			carBooking.setPerson(person);
			
			entityManager.persist(carBooking);
			entityTransaction.commit();
			
			System.out.println("Data Persisted & Car and Person connected");
		}
	}
	public CarBooking getById( int carBookingId) {
		
		CarBooking carbook = entityManager.find( CarBooking.class, carBookingId); 
		
		if( carbook != null ) {
			return carbook ;
		}else {
			return null ; 
		}
	}
	public List<Double> billDetails( int carBookId ) {
		
		CarBooking cb = entityManager.find( CarBooking.class, carBookId);

		double showRoomPrice = cb.getCar().getPrice(); 
		double registrationCharge = showRoomPrice*0.05;
		double roadTax = 5000 ; 
		double insurace = 3500 ; 
		double CGST = showRoomPrice*0.18 ;
		double SGST = showRoomPrice*0.18 ; 
		double total = showRoomPrice+registrationCharge+roadTax+insurace+CGST+SGST ;
		
		List<Double> list = new ArrayList<Double>(); 
		
		list.add(showRoomPrice); 
		list.add(registrationCharge);
		list.add(roadTax);
		list.add(insurace);
		list.add(CGST);
		list.add(SGST);
		list.add(total); 
		
		return list ;
	}
	
}
