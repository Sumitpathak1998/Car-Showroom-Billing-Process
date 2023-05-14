package com.car_store_managment_system.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // for making a table in database 
@NoArgsConstructor
@AllArgsConstructor
@Data // for generate getter and setter
public class Address {

	@Id 
	private int addressId ; 
	private String city ;
	private String street ; 
	private String flatNumber; 
	private String townName ; 
	@OneToOne( mappedBy =  "address")
	private Pan pan ; 
}
