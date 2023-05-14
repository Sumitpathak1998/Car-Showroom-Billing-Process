package com.car_store_managment_system.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity // For Automatic generate the table 
@Data // for getter and setter method  
public class CarBooking {

	@Id
	private int carBookingId ; 
	@OneToOne
	private Car car;
	@OneToOne
	private Person person; 
}
