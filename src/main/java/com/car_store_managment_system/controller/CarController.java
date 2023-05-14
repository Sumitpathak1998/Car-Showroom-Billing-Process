package com.car_store_managment_system.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.car_store_managment_system.dto.Car;
import com.car_store_managment_system.service.CarService;

public class CarController {

	public static void main(String[] args) {
		
		CarService service = new CarService(); 
		
		Scanner sc = new Scanner(System.in); 
		
		while(true) {
			System.out.println("1.For Insert");
			int select = sc.nextInt(); 
			switch(select) {
			case 1:{
				List<Car> list = new ArrayList<Car>(); 
				
				char ch = 'a'; 
				do {
					Car car = new Car(); 
					
					System.out.println("Enter the Car Id");
					int carId = sc.nextInt();
					System.out.println("Enter the car name");
					String carName = sc.next(); 
					carName += sc.nextLine(); 
					System.out.println("Enter the Color of Car");
					String color = sc.next(); 
					System.out.println("Enter the Price of the Car");
					double price = sc.nextDouble(); 
					System.out.println("Enter the Car Model number");
					int modelNo = sc.nextInt(); 
					
					car.setCarId(carId);
					car.setCarName(carName);
					car.setCarColor(color);
					car.setPrice(price);
					car.setModelNo(modelNo);
					
					list.add(car); 
					
					System.out.println("If you want to add more Car on the same Person then press y");
					ch = sc.next().charAt(0); 
					
				}while(ch == 'y' || ch == 'Y'); 
				
				System.out.println("Enter the Person Id");
				int personId = sc.nextInt(); 
				
				service.connectPersonWithCar(personId, list);
				
			}break ; 
			case 2:{
				List<Car> list = new ArrayList<Car>(); 
				
				char ch = 'a'; 
				do {
					Car car = new Car(); 
					
					System.out.println("Enter the Car Id");
					int carId = sc.nextInt();
					System.out.println("Enter the car name");
					String carName = sc.next(); 
					carName += sc.nextLine(); 
					System.out.println("Enter the Color of Car");
					String color = sc.next(); 
					System.out.println("Enter the Price of the Car");
					double price = sc.nextDouble(); 
					System.out.println("Enter the Car Model number");
					int modelNo = sc.nextInt(); 
					
					car.setCarId(carId);
					car.setCarName(carName);
					car.setCarColor(color);
					car.setPrice(price);
					car.setModelNo(modelNo);
					
					list.add(car); 
					
					System.out.println("If you want to add more Car on the same Person then press y");
					ch = sc.next().charAt(0); 
					
				}while(ch == 'y' || ch == 'Y'); 
				
				service.insertCar(list);
			}break ; 
			}
		}
	}
}
