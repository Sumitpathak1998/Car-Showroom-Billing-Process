package com.car_store_managment_system.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {

	@Id
	private int personId ; 
	private String name ; 
	private long phone ; 
	private String email ;
	/*
	 * Cascade is attribute of Hibernate with the help of that we can persist dependent object 
	 * 
	 */
	@OneToMany(mappedBy = "person")
	private List<Car> car; 
	@OneToOne (cascade =  CascadeType.ALL)
	@JoinColumn ( name = "panNumber")
	private Pan pan; 
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn( name = "addressId")
	private Address address ; 
}
