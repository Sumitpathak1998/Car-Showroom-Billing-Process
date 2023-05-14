package com.car_store_managment_system.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // for creating a table automatic in database 
@NoArgsConstructor
@AllArgsConstructor
@Data // for automatic create a getter and setter 
public class Car {

	@Id // make a column as Primary Key 
	private int carId ; 
	private String carName ;
	private String carColor ; 
	private double price ; 
	private int modelNo ; 
	@ManyToOne
	@JoinColumn( name = "personId")
	private Person person; 
}
