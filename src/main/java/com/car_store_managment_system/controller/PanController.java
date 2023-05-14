package com.car_store_managment_system.controller;

import java.util.Scanner;

import com.car_store_managment_system.dto.Address;
import com.car_store_managment_system.dto.Pan;
import com.car_store_managment_system.service.PanService;

public class PanController {

	public static void main(String[] args) {
		
		PanService service = new PanService(); 
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("1.For Insert");
			int select = sc.nextInt(); 
			switch(select) {
			case 1:{
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
				
				service.savePanAddress(pan);
			}break ; 
			}
		}
	}
}
