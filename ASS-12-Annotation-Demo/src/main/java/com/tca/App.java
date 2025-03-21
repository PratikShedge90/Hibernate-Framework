package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Student;

public class App {
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
        	ob.setRno(777);
        	ob.setName("DJ MSD Django");
        	ob.setPer(44.55);
        	
        	session.save(ob);
        	
        	txn.commit();
        		
        	System.out.println(" SuccesFully !!!");
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
