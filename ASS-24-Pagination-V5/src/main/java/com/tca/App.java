package com.tca;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tca.entities.Student;

public class App 
{
	public static void main(String[] args) 
	{
		Configuration configuration = null;
		SessionFactory sf = null;
		Session session = null;

		try 
		{
			Scanner sc = new Scanner(System.in);
			
			configuration = new Configuration();
			configuration.configure();
			configuration.addAnnotatedClass(Student.class);

			sf = configuration.buildSessionFactory();
			session = sf.openSession();
			

		    //-----------------PAGINATION---------------------
			
			Query query = session.createQuery("from Student ");
			query.setMaxResults(3);
			
			for(int i=0; i<=9; i+=3)
			{
				query.setFirstResult(i);	// 0 , 3, 6, 9
				List<Student> list = query.list();
				
				for(Student s : list)
				{
					System.out.println(s.getRno() + " " + s.getName() + " " + s.getCity() + " " + s.getPer());
				}
				System.out.println("===============================================");
				
				System.out.println("Enter Any Key To See Next Records !");
				sc.next();
			}

			
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
