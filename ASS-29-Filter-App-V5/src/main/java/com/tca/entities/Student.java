package com.tca.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

@Entity
@Table(name="student")
//@FilterDef(name="cityfilter", parameters=@ParamDef(name="tca", type="string"))
//@Filter(name="cityfilter", condition="scity = :tca")

//@FilterDef(name="perfilter", parameters=@ParamDef(name="marks", type="double"))
//@Filter(name="perfilter", condition="sper >= :marks")

//@FilterDef(name="city_per_filter", parameters= {@ParamDef(name="student_city", type="string"),
//		                                        @ParamDef(name="marks", type="double")})
//@Filter(name="city_per_filter", condition="scity = :student_city and sper >= :marks")

@FilterDefs({ @FilterDef(name="cityfilter", parameters=@ParamDef(name="tca", type="string")),
			  @FilterDef(name="perfilter", parameters=@ParamDef(name="marks", type="double")),
			  @FilterDef(name="city_per_filter", parameters= { @ParamDef(name="student_city", type="string"),
					  										   @ParamDef(name="marks", type="double")
					  										  })
			})

@Filters({ @Filter(name="cityfilter", condition="scity = :tca"),
		   @Filter(name="perfilter", condition="sper >= :marks"),
		   @Filter(name="city_per_filter", condition="scity = :student_city and sper >= :marks")
		})
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
