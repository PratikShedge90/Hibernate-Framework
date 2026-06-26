package com.tca;

import java.util.List;

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
			 //-----------------------------------------------
			
/*
			// ORDER BY
			
	        Query query = session.createQuery("from Student ORDER BY per DESC");
			
			List<Student> L = query.list();
			
			for(Student s : L)
			{
				System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer() + " " + s.getCity());
				
			}		
*/
			
			 //-----------------------------------------------	
/*			
			// WHERE clause 
			
			   Query query = session.createQuery("from Student WHERE per >= 70");
				
				List<Student> L = query.list();
				
				for(Student s : L)
				{
					System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer() + " " + s.getCity());
					
				}	
*/
			
/*		 //-----------------------------------------------
			
	        Query query2 = session.createQuery("select count(*), max(per), min(per), avg(per), sum(per) from Student");
			
         	List<Object[]> L = query.list();
			
			for(Object[] ob : L)
			{
				for(Object data : ob)
				{
					System.out.print(data.toString() + " ");
				}
			}	
		
*/	
			//-----------------------------------------------
/*		
			Query query = session.createQuery("select max(per) from Student");
			List<Object> L = query.list();
			
			System.out.println(L.get(0));
		   
			Query query2 = session.createQuery("select max(per) from Student");
			List<Long> L2 = query.list();
			
			System.out.println(L2.get(0));
*/
			
			//-----------------------------------------------
/*			
			Query query = session.createQuery("select city, count(*) from Student GROUP BY city HAVING count(*) >=2 ");
			List<Object[]> L = query.list();
			
			for(Object[] ob : L)
			{
				for(Object data : ob)
				{
					System.out.print(data + " ");
				}
				System.out.println();
			}
*/
			//-----------------------------------------------

/*
			Query query = session.createQuery("select per+2.5 from Student");
			List<Double> L = query.list();
			
			System.out.println(L);
*/			
			//----------------AND-------------------------------

/*
			Query query = session.createQuery("from Student WHERE per>=70 AND per<=80");
			List<Student> L = query.list();
			
			for(Student s : L)
			{
				System.out.println(s.getRno() +" | " + s.getName() +" | " + s.getCity() + " | " + s.getPer());
			}
*/
			//-----------------OR------------------------------
/*			
			Query query = session.createQuery("from Student WHERE city='PUNE' OR city='MUMBAI' ");
			List<Student> L = query.list();
			
			for(Student s : L)
			{
				System.out.println(s.getRno() +" | " + s.getName() +" | " + s.getCity() + " | " + s.getPer());
			}
			
*/			
			//-----------------BETWEEN------------------------------

/*
			Query query = session.createQuery("from Student WHERE per BETWEEN 70 AND 80");
			List<Student> L = query.list();
			
			for(Student s : L)
			{
				System.out.println(s.getRno() +" | " + s.getName() +" | " + s.getCity() + " | " + s.getPer());
			}
*/
			
			//-----------------Pattern Matching Query with HQL (LIKE,NOT LIKE, %)------------------
/*			
			Query query = session.createQuery("from Student where city LIKE 'P_%E' ");
			List<Student> L = query.list();
			
			for(Student s : L)
			{
				System.out.println(s.getRno() +" | " + s.getName() +" | " + s.getCity() + " | " + s.getPer());
			}
*/
			//-----------------NOT LIKE------------------------------
/*					
			Query query = session.createQuery("from Student where city NOT LIKE 'P_%E' ");
			List<Student> L = query.list();
			
			for(Student s : L)
			{
				System.out.println(s.getRno() +" | " + s.getName() +" | " + s.getCity() + " | " + s.getPer());
			}
*/
			//-----------------IS NOT NULL------------------------------
/*					
			Query query = session.createQuery("from Student where name IS NOT NULL ");
			List<Student> L = query.list();
			
			for(Student s : L)
			{
				System.out.println(s.getRno() +" | " + s.getName() +" | " + s.getCity() + " | " + s.getPer());
			}
*/
			
			//-----------------Sub-Query ------------------------------
/*			
			Query query = session.createQuery("from Student where per = (select max(per) from Student)");
			List<Student> L = query.list();
			
			for(Student s : L)
			{
				System.out.println(s.getRno() +" | " + s.getName() +" | " + s.getCity() + " | " + s.getPer());
			}
*/
			
		
			/** <-- HQL : Positional Parameters  --> */
/*				
			Query query = session.createQuery("from Student where per >= ?0 AND per <= ?1");
			query.setParameter(0, 70.0);
			query.setParameter(1, 80.0);
			
			List<Student> L = query.list();
			
			for(Student s : L)
			{
				System.out.println(s.getRno() +" | " + s.getName() +" | " + s.getCity() + " | " + s.getPer());
			}
*/		
			/** <-- HQL : Named Parameters  -->*/
/*
 			
			Query query = session.createQuery("from Student where per >= :abc AND per <= :xyz");
			query.setParameter("abc", 68.1);
			query.setParameter("xyz", 80.10);
			
			List<Student> L = query.list();
			
			for(Student s : L)
			{
				System.out.println(s.getRno() +" | " + s.getName() +" | " + s.getCity() + " | " + s.getPer());
			}			
*/	
			
			
			/** Update Query --> executeUpdate() */
			
			//-----------------Update ------------------------------
			
/*			
			Query query = session.createQuery("update Student set per = per+5 where city = 'Raigad' ");
			int cnt = query.executeUpdate();
			
			System.out.println("No of Records Updated : " + cnt);
			
			txn.commit();
			System.out.println(" Done SuccesFully !!!");
*/			
			
			//-----------------Delete------------------------------
			
			Query query = session.createQuery("delete from Student where city='Raigad' ");
			int cnt = query.executeUpdate();
			
			System.out.println("No of Records Updated : " + cnt);
			
			
			
			txn.commit();
			System.out.println(" Done SuccesFully !!!");
			
			
			
			
			
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
