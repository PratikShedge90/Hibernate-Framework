package com.tca.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student 
{
	@EmbeddedId
	StudentCompositeKey id;
	
	@Column(name="city")
	private String city;
	
	public StudentCompositeKey getId() {
		return id;
	}

	public void setId(StudentCompositeKey id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
