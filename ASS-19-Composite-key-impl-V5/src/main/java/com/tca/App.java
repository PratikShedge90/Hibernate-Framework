package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Student;
import com.tca.entities.StudentCompositeKey;

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
			
			/*			

			//------How to Insert a Record for Composite key--------------------------
			
			StudentCompositeKey key = new StudentCompositeKey();
			key.setFname("Pratik");
			key.setLname("Shedge");
			
			Student student = new Student();
			student.setId(key);
			student.setCity("Raigad");

			session.save(student);
			
			// --------------------------------------------------------------------------------

			*/	
			
			//------How we fecth a specific Record for Composite Key --------------------------

			StudentCompositeKey key = new StudentCompositeKey();
			key.setFname("Pratik");
			key.setLname("Shedge");
			
			Student student = session.load(Student.class, key);
			System.out.println(student);
		
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
