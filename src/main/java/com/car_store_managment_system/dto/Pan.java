package com.car_store_managment_system.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // for automatic create a table
@NoArgsConstructor
@AllArgsConstructor
@Data // for generate getter and setter 
public class Pan {

	@Id
	private String panNumber ; 
	private int panId ; 
	private String date ; 
	private String gender ; 
	@OneToOne (cascade =  CascadeType.ALL) // Cascade is use for automatic persist the dependent object
	@JoinColumn ( name = "addressId")  // JoinColumn is use for give our own choice foregin key name  
	private Address address; 
} 
