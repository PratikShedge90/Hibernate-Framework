package com.tca.entities;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="student")
//@NamedQuery(name= "GET_ALL_INFO", query= "FROM Student")
//@NamedQuery(name="GET_CITYWISE", query="FROM Student where city= :abc")
//@NamedQuery(name="MODIFY_STUDENT_CITY", query="UPDATE Student SET city= :new_city WHERE city= :old_city")
@NamedQuery(name="REMOVE_STUDENT", query="DELETE FROM Student WHERE rno= :rollnumber")
public class Student 
{
	@Id
	@Column(name="srno")
	private Integer rno;
	
	@Column(name="sname")
	private String name;
	
	@Column(name="sper")
	private Double per;
	
	@Column(name="scity")
	private String city;

	
	public Integer getRno() {
		return rno;
	}

	public void setRno(Integer rno) {
		this.rno = rno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPer() {
		return per;
	}

	public void setPer(Double per) {
		this.per = per;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
