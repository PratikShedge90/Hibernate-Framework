package com.tca.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="EXECUTIVE")
public class Executive extends Employee 
{
	@Column(name="erole")
	private String erole;

	public String getErole() {
		return erole;
	}

	public void setErole(String erole) {
		this.erole = erole;
	}
}
