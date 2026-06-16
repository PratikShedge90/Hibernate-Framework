package com.tca;

import java.util.List;

import org.hibernate.query.Query;
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
			configuration = new Configuration();
			configuration.configure();
			configuration.addAnnotatedClass(Student.class);

			sf = configuration.buildSessionFactory();
			session = sf.openSession();
			txn = session.beginTransaction();

		    //-----------------------------------------------
/*
			// SELECT * FROM student; (SQL) is equivalent to "from Student" in (HQL)
			
			Query query = session.createQuery("from Student");
			
			List<Student> L = query.list();
			
			for(Student s : L)
			{
				System.out.println(s.getRno() + s.getName() + s.getPer() + s.getCity());
				
			}
*/
			//-----------------------------------------------
			
			// This Approach is Used When your requirement is to Fetch the Specified Columns from DB table

/*
			Query query = session.createQuery("select rno,name,city from Student");  // rno name & city are Field name of Entity class 			
			
			List<Object[]> L = query.list();
			
			for(Object[] ob : L)
			{
				for(Object data : ob)
				{
					System.out.print(data.toString());
				}
			}
*/
			
/*
			// ORDER BY
			
	        Query query = session.createQuery("from Student ORDER BY per DESC");
			
			List<Student> L = query.list();
			
			for(Student s : L)
			{
				System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer() + " " + s.getCity());
				
			}		
*/
			
/*			
			// WHERE clause 
			
			   Query query = session.createQuery("from Student WHERE per >= 70");
				
				List<Student> L = query.list();
				
				for(Student s : L)
				{
					System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer() + " " + s.getCity());
					
				}	
*/
			
			
			
	        Query query = session.createQuery("select count(*), max(per), min(per), avg(per), sum(per) from Student");
			
         	List<Object[]> L = query.list();
			
			for(Object[] ob : L)
			{
				for(Object data : ob)
				{
					System.out.print(data.toString() + " ");
				}
			}	
	
		    //-----------------------------------------------

			txn.commit();

			System.out.println(" SuccesFully !!!");
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			txn.rollback();
		} 
		finally 
		{
			session.close();
			sf.close();
		}

	}
}
