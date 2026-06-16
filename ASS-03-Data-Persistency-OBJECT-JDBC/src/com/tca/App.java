package com.tca;

import com.tca.dao.StudentDao;
import com.tca.dao.StudentDaoImpl;
import com.tca.entities.Student;

public class App {

	public static void main(String[] args) {

		Student ob = new Student();
		ob.setRno(112);
		ob.setName("VVV");
		ob.setPer(50.33);
		
		StudentDao dao = new StudentDaoImpl();
		
		String status = dao.save(ob);
		
		if(status.equals("Success"))
		{
			System.out.println("Record is Saved Successfully");
		}
		else if(status.equals("Failed"))
		{
			System.out.println("Record is not saved Please check again !");
		}

		
	}

}
