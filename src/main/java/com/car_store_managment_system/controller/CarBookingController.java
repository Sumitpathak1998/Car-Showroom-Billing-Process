package com.car_store_managment_system.controller;

import java.nio.file.spi.FileSystemProvider;
import java.util.List;
import java.util.Scanner;

import com.car_store_managment_system.dto.CarBooking;
import com.car_store_managment_system.service.CarBookingService;


public class CarBookingController {

	public static void main(String[] args) {
		
		CarBookingService service = new CarBookingService();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1.Book the Car \n2.See the Details \n3.Bill Details \n4.Sing Out");
			int select = sc.nextInt();
			switch(select) {
			case 1:{
				System.out.println("Enter the Car booking Id");
				int carbookId = sc.nextInt();
				System.out.println("Enter the Car Id");
				int carId = sc.nextInt();
				System.out.println("Enter the Person Id");
				int personId = sc.nextInt(); 
				
				CarBooking carBook = new CarBooking(); 
				
				carBook.setCarBookingId(carbookId);
				
				service.bookCar(carBook, personId, carId);
			}break ; 
			case 2:{
				System.out.println("Enter the Car Booking id");
				int id = sc.nextInt();
				CarBooking cb = service.getById(id); 
				
				if ( cb != null ) {
				
					System.out.println("-----Booking Details ------");
					System.out.println("Car Booking Id : "+cb.getCarBookingId());
					System.out.println("----Car Details --------");
					System.out.println("Car Id : "+cb.getCar().getCarId());
					System.out.println("Car Name : "+cb.getCar().getCarName());
					System.out.println("Car Color : "+cb.getCar().getCarColor());
					System.out.println("Car Model No : "+cb.getCar().getModelNo());
					System.out.println("Car Price : "+cb.getCar().getPrice());
					System.out.println("-----------Person Details ---------");
					System.out.println("Penson Id : "+cb.getPerson().getPersonId());
					System.out.println("Person Name : "+cb.getPerson().getName());
					System.out.println("Person Email : "+cb.getPerson().getEmail());
					System.out.println("Person Gender : "+cb.getPerson().getPan().getGender());
					System.out.println("Person Date of Birth : "+cb.getPerson().getPan().getDate());
					System.out.println("Contact Number : "+cb.getPerson().getPhone());
					System.out.println("------Person Address -----");
					System.out.println("Addrss Id : "+cb.getPerson().getAddress().getAddressId());
					System.out.println("Street Name : "+cb.getPerson().getAddress().getStreet());
					System.out.println("Flate Number : "+cb.getPerson().getAddress().getFlatNumber());
					System.out.println("City Name : "+cb.getPerson().getAddress().getCity());
					System.out.println("Town Name : "+cb.getPerson().getAddress().getTownName());
					System.out.println("-------PAN Details --------");
					System.out.println("Pan Id : "+cb.getPerson().getPan().getPanId());
					System.out.println("Pan Number : "+cb.getPerson().getPan().getPanNumber());
				}else {
					System.out.println("Please check the car booking id");
				}
			}break ; 
			case 3:{
				System.out.println("Enter the Car Booking Id");
				int id = sc.nextInt(); 
				
				List<Double> list = service.billDetails(id);
				
				CarBooking cb = service.getById(id); 
				
				System.out.println("------Bill Details -------");
				System.out.println();
				System.out.println("Car BookingId : "+cb.getCarBookingId());
				System.out.println("Owner Name : "+cb.getPerson().getName());
				System.out.println("Car Name : "+cb.getCar().getCarName());
				System.out.println("Showroom Price : "+list.get(0)+"Rs");
				System.out.println("Registration Charges : "+list.get(1)+"Rs");
				System.out.println("Road Tax : "+list.get(2)+"Rs");
				System.out.println("Insurance Amount : "+list.get(3)+"Rs");
				System.out.println("CGST 18% : "+list.get(4)+"Rs");
				System.out.println("SGST 18% : "+list.get(5)+"Rs");
				System.out.println("---------------------------");
				System.out.println("Total  Bill Amount : "+list.get(6)+"Rs");
			}break ; 
			case 4:{
				System.out.println("Singout to Portal");
				System.exit(0);
			} 
			}
		}
	}
}
