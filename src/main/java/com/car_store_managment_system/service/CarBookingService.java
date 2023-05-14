package com.car_store_managment_system.service;

import java.util.List;

import com.car_store_managment_system.dao.CarBookingDao;
import com.car_store_managment_system.dto.CarBooking;

public class CarBookingService {

	CarBookingDao dao = new CarBookingDao(); 
	
	public void bookCar( CarBooking carBooking , int personId , int carId)
	{
		dao.bookCar(carBooking,personId,carId);
	}
	public CarBooking getById( int carBookingId) 
	{
		 return dao.getById(carBookingId); 
	}
	public List<Double> billDetails( int carBookId ){
		return dao.billDetails(carBookId); 
	}
}
