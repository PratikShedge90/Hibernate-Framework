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
    	SessionFactory  sf = null;
    	Session session = null;
    	Transaction txn = null;
    	
    	try
    	{
    		configuration = new Configuration();             // configuration --> Data
    		configuration.configure("hibernate.cfg.xml");    // It Loads and Parse XML Files (like Giving or taking Information about Database Properties, hibernate Properties & Mapping File )
    		
    		configuration.addAnnotatedClass(Student.class);
    		
    		sf = configuration.buildSessionFactory();        // cmd + shift + 1

    		session = sf.openSession();
    		txn = session.beginTransaction();
    		
    		StudentCompositeKey key = new StudentCompositeKey();
    		key.setFname("Sachin");
    		key.setLname("Tendulkar");
    		
    		Student s = new Student();
    		s.setId(key);
    		s.setCity("Mumbai");
    		  		
    		session.persist(s);
    		
//    		System.out.println("Record is Save for Roll Number : " + trno);

    		txn.commit();
    		System.out.println("Data is Saved Successfully!");
    	}
    	catch(Exception e)
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
