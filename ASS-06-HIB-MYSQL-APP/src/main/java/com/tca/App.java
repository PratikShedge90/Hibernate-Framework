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
    	SessionFactory  sf = null;
    	Session session = null;
    	Transaction txn = null;
    	
    	try
    	{
    		configuration = new Configuration();             // configuration --> Data
    		configuration.configure("hibernate.cfg.xml");    // It Loads and Parse XML Files (like Giving or taking Information about Database Properties, hibernate Properties & Mapping File )

    		sf = configuration.buildSessionFactory();        // cmd + shift + 1

    		session = sf.openSession();
    		txn = session.beginTransaction();

    		Student ob = new Student();
    		ob.setRno(222);
    		ob.setName("AAA");
    		ob.setPer(60);

    		session.save(ob);
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
