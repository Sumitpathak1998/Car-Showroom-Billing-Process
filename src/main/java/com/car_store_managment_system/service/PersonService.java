package com.car_store_managment_system.service;

import java.util.List;

import com.car_store_managment_system.dao.PersonDao;
import com.car_store_managment_system.dto.Car;
import com.car_store_managment_system.dto.Person;

public class PersonService {

	PersonDao dao = new PersonDao();

	public void savePerson(Person person ) {
		dao.savePerson(person);
	}

	public void savePerson(Person person, String panNumber) {
		dao.savePerson(person, panNumber);
	}
	
	public Person getById( int personId) {
		return dao.getById(personId); 
	}
	
	public void deletePerson( int personId) {
		dao.deletePerson(personId);
	}
	
	public void updatePerson( int personId , String email , String dob , String flatNo){
		dao.updatePerson(personId, email, dob, flatNo);
	}
	
	public List<Person> displayPerson(){
		return dao.displayPerson(); 
	}
}
