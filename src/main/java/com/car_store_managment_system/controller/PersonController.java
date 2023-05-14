package com.car_store_managment_system.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.internal.build.AllowSysOut;

import com.car_store_managment_system.dto.Address;
import com.car_store_managment_system.dto.Car;
import com.car_store_managment_system.dto.Pan;
import com.car_store_managment_system.dto.Person;
import com.car_store_managment_system.service.PersonService;

public class PersonController {

	public static void main(String[] args) {

		PersonService service = new PersonService();

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1.For Insert \n2.For Insert Person with existing Pan and Address \n3.Connect Person with the Car \n4.GetById \n5.Delete \n6.For Update \n7.For Display \n8.Sing Out");
			int select = sc.nextInt();
			switch (select) {
			case 1: {
				Person person = new Person();
				System.out.println("Enter the Person id");
				int personId = sc.nextInt();
				System.out.println("Enter the name of Person");
				String name = sc.next();
				name += sc.nextLine();
				System.out.println("Enter the Phone number");
				long phone = sc.nextLong();
				System.out.println("Enter the email of the Person");
				String email = sc.next();

				person.setPersonId(personId);
				person.setName(name);
				person.setPhone(phone);
				person.setEmail(email);

				Pan pan = new Pan();

				System.out.println("Enter the Pan Id");
				int panId = sc.nextInt();
				System.out.println("Enter the Pan Number");
				String number = sc.next();
				System.out.println("Enter the Data of Birth");
				String dob = sc.next();
				System.out.println("Enter the gender");
				String gender = sc.next();

				pan.setPanId(panId);
				pan.setPanNumber(number);
				pan.setDate(dob);
				pan.setGender(gender);

				Address address = new Address();

				System.out.println("Enter the address Id");
				int addressId = sc.nextInt();
				System.out.println("Enter the City name");
				String city = sc.next();
				city += sc.nextLine();
				System.out.println("Enter the Street Name");
				String street = sc.next();
				street += sc.nextLine();
				System.out.println("Enter the Flat Number");
				String flat = sc.next();
				System.out.println("Enter the town name");
				String town = sc.next();
				town += sc.nextLine();

				address.setAddressId(addressId);
				address.setCity(city);
				address.setFlatNumber(flat);
				address.setStreet(street);
				address.setTownName(town);

				pan.setAddress(address);
				
				person.setPan(pan);
				person.setAddress(address);

				service.savePerson(person);

			}break;
			case 2: {
				Person person = new Person();

				System.out.println("Enter the Person id");
				int personId = sc.nextInt();
				System.out.println("Enter the name of Person");
				String name = sc.next();
				name += sc.nextLine();
				System.out.println("Enter the Phone number");
				long phone = sc.nextLong();
				System.out.println("Enter the email of the Person");
				String email = sc.next();

				person.setPersonId(personId);
				person.setName(name);
				person.setPhone(phone);
				person.setEmail(email);

				System.out.println("Enter the Pan Number");
				String panNumber = sc.next();

				service.savePerson(person, panNumber);
			}break; 
			case 4: {
				System.out.println("Enter the Person Id");
				int id = sc.nextInt();
				Person person = service.getById(id);

				System.out.println("--------Person Id --------");
				System.out.println("Person Id : " + person.getPersonId());
				System.out.println("Person Name : " + person.getName());
				System.out.println("Person Phone : " + person.getPhone());
				System.out.println("Person Email : " + person.getEmail());

				System.out.println("------PAN Details -------");
				System.out.println("PAN Id : " + person.getPan().getPanId());
				System.out.println("PAN Number : " + person.getPan().getPanNumber());
				System.out.println("Date Of Birth : " + person.getPan().getDate());
				System.out.println("Person Gender : " + person.getPan().getGender());

				System.out.println("-------Address Details ---------");
				System.out.println("Address Id : " + person.getAddress().getAddressId());
				System.out.println("City Name : " + person.getAddress().getCity());
				System.out.println("Street Name : " + person.getAddress().getStreet());
				System.out.println("Flat Number : " + person.getAddress().getFlatNumber());
				System.out.println("Town Name : " + person.getAddress().getTownName());
			}break;
			case 5: {
				System.out.println("Enter the Person Id for delete the data");
				int id = sc.nextInt();

				service.deletePerson(id);
			}break;
			case 6:{
				System.out.println("Enter the Person Id");
				int personId = sc.nextInt(); 
				System.out.println("Enter the Email");
				String email = sc.next(); 
				System.out.println("Enter the Person  Updated Date Of Birth");
				String dob = sc.next(); 
				System.out.println("Enter the Updated Flat Number");
				String flat = sc.next(); 
				
				service.updatePerson(personId, email, dob, flat);
			}break ; 
			case 7:{
				List<Person> list = service.displayPerson(); 
				
				for ( Person person : list) {
					
					System.out.println("--------Person Id --------");
					System.out.println("Person Id : " + person.getPersonId());
					System.out.println("Person Name : " + person.getName());
					System.out.println("Person Phone : " + person.getPhone());
					System.out.println("Person Email : " + person.getEmail());

					System.out.println("------PAN Details -------");
					System.out.println("PAN Id : " + person.getPan().getPanId());
					System.out.println("PAN Number : " + person.getPan().getPanNumber());
					System.out.println("Date Of Birth : " + person.getPan().getDate());
					System.out.println("Person Gender : " + person.getPan().getGender());

					System.out.println("-------Address Details ---------");
					System.out.println("Address Id : " + person.getAddress().getAddressId());
					System.out.println("City Name : " + person.getAddress().getCity());
					System.out.println("Street Name : " + person.getAddress().getStreet());
					System.out.println("Flat Number : " + person.getAddress().getFlatNumber());
					System.out.println("Town Name : " + person.getAddress().getTownName());
				}
			}break ; 
			case 8:{
				System.out.println("Sing Out");
				System.exit(0);
			}break; 
			}
		}
	}
}