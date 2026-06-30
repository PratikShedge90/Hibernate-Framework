package com.tca.App;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.ContactNumber;
import com.tca.entities.Student;

public class App 
{
	public static void main(String[] args) 
	{
		Configuration configuration = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction txn = null;

		try 
		{
			Scanner sc = new Scanner(System.in);
			
			configuration = new Configuration();
			configuration.configure();
			configuration.addAnnotatedClass(Student.class);

			sf = configuration.buildSessionFactory();
			session = sf.openSession();
			txn = session.beginTransaction();

			//-----------------Component Mapping --------------------
/*
 * 			// Adding a Record 
  			
			ContactNumber contact= new ContactNumber();
			contact.setCountryCode(91);
			contact.setContact("7755903959");
			
			Student s = new Student();
			s.setRno(101);
			s.setName("Pratik");
			s.setPer(90.0);
			s.setCity("Raigad");
			s.setContact(contact);
			
			session.save(s);
*/
			// Fetching Data From Table
/*			
			Student student = session.get(Student.class, 101);
			
			System.out.println("Roll Number :"  + student.getRno());
			System.out.println("Name        :" + student.getName());
			System.out.println("Percentage  :" + student.getPer());
			System.out.println("City        :" + student.getCity());
			System.out.println("Contact     :" + student.getContact().getCountryCode() + "+" + student.getContact().getContact());
*/
			
			txn.commit();

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			session.close();
			sf.close();
		}

	}
}
