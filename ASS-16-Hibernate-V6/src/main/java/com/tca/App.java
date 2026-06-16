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

			Student ob = new Student();
			ob.setRno(101);
			ob.setName("Dj Sunnya");
			ob.setPer(90.0);

		//  session.save(ob)  --> This method is deprecated after version 6 of hibernate 
			session.persist(ob);
			
			int trno = (int) session.getIdentifier(ob);
			System.out.println("Saved --> " + trno);

			
			
			
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
