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
			ob.setRno(103);
			ob.setName("BBB");
			ob.setPer(77.0);

			session.save(ob);
			
//			Student s = session.get(Student.class, 101);
//			System.out.println(s.getName());
//			System.out.println(s.getPer());
//			System.out.println(s.getRno());
			
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
