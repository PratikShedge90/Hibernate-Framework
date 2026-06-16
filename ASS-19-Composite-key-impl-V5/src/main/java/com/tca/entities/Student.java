package com.tca.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

	@Override
	public String toString() {
		return "Student [id=" + id + ", city=" + city + "]";
	}
	
	

}
