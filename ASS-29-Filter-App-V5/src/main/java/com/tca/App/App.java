package com.tca.App;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Filter;
import org.hibernate.Query;
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

			// Filter 1
/*			Filter filter = session.enableFilter("cityfilter");
			filter.setParameter("tca", "POONA");
*/ 			
			// Filter 2
/*			Filter filter = session.enableFilter("perfilter");
			filter.setParameter("marks", 70.0);
*/
			// Filter 3
			
			Filter filter = session.enableFilter("city_per_filter");
			filter.setParameter("student_city", "POONA");
			filter.setParameter("marks", 70.0);
			
			Query query = session.createQuery("FROM Student");
			
			List<Student> L = query.list();
			
			for (Student s : L) 
			{
				System.out.println("Roll Number : " + s.getRno());
				System.out.println("Name        : " + s.getName());
				System.out.println("Percentage  : " + s.getPer());
				System.out.println("City        : " + s.getCity());
				
				System.out.println("-----------------------------");
			}	

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
