package com.tca.App;

import java.util.List;
import java.util.Scanner;

import javax.persistence.NamedQuery;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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

			//-------Named Query-----------------------
			// Code : @NamedQuery(name= "GET_ALL_INFO", query= "FROM Student")
/*			
			Query query = session.getNamedQuery("GET_ALL_INFO");
			List<Student> L = query.getResultList();
			
			for (Student s : L) 
			{
				System.out.println("Roll Number : " + s.getRno());
				System.out.println("Name        : " + s.getName());
				System.out.println("Percentage  : " + s.getPer());
				System.out.println("City        : " + s.getCity());
				
				System.out.println("-----------------------------");
			}
			
*/			
			// Code : @NamedQuery(name="GET_CITYWISE", query="FROM Student where city= :abc")
/*			
			Query query = session.getNamedQuery("GET_CITYWISE");
			query.setParameter("abc", "PUNE");
			
			List<Student> L = query.getResultList();
			
			for (Student s : L) 
			{
				System.out.println("Roll Number : " + s.getRno());
				System.out.println("Name        : " + s.getName());
				System.out.println("Percentage  : " + s.getPer());
				System.out.println("City        : " + s.getCity());
				
				System.out.println("-----------------------------");
			}
*/
			
// Code : @NamedQuery(name="MODIFY_STUDENT_CITY", query="UPDATE Student SET city= :new_city WHERE city= :old_city")

/*
			Query query = session.getNamedQuery("MODIFY_STUDENT_CITY");
			query.setParameter("new_city", "POONA");
			query.setParameter("old_city", "PUNE");
			
			int cnt = query.executeUpdate();
			
			System.out.println("Number of Records Updated : " + cnt);
			
*/
// Code : @NamedQuery(name="REMOVE_STUDENT", query="DELETE FROM Student WHERE rno= :rollnumber")
			
			Query query = session.getNamedQuery("REMOVE_STUDENT");
			query.setParameter("rollnumber", 121);
			
			int cnt = query.executeUpdate();
			System.out.println("Number of Records Updated : " + cnt);
			

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
