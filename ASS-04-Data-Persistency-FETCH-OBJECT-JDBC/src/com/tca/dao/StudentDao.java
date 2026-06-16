package com.tca.dao;

import java.util.List;

import com.tca.entities.Student;

public interface StudentDao 
{
	// Interface has only Abstract Methods
	public abstract String save(Student ob);
	
	public abstract List<Student> getAllStudent(); 

}
