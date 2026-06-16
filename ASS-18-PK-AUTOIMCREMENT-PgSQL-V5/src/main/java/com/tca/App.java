package com.tca;

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

			Student ob = new Student();  // ob-[rno=null, name=AAA, per=60]
		
			ob.setName("AAA");
			ob.setPer(80.0);
			int trno = (int)session.save(ob);
			
			System.out.println("Saved SuccessFully --> " + trno);			
			
			txn.commit();
			System.out.println(" Data is Saved SuccesFully !!!");
			
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
