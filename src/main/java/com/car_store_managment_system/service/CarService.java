package com.car_store_managment_system.service;

import java.util.List;

import com.car_store_managment_system.dao.CarDao;
import com.car_store_managment_system.dto.Car;

public class CarService {

	CarDao dao = new CarDao(); 
	
	public void connectPersonWithCar( int perosnId , List<Car> list) 
	{
		dao.connectPersonWithCar(perosnId, list);
	}
	public void insertCar( List<Car> list) {
		dao.insertCar(list);
	}
}

