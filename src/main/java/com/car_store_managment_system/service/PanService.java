package com.car_store_managment_system.service;

import com.car_store_managment_system.dao.PanDao;
import com.car_store_managment_system.dto.Pan;

public class PanService {

	PanDao dao = new PanDao(); 
	
	public void savePanAddress(Pan pan) {
		dao.savePanAddress(pan);
	}
	
}

