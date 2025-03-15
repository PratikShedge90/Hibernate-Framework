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
        	configuration = new Configuration();  // This will search for 'hibernate.properties'
        	configuration.addResource("Student.hbm.xml");   // This Method Adds the Mapping File 
        	
        	sf = configuration.buildSessionFactory();
        	session = sf.openSession();
        	
        	txn = session.beginTransaction();
        	
        	Student student = new Student();
        	student.setRno(101);
        	student.setName("Aniket");
        	student.setPer(90.0);
        	
        	session.save(student);
        	
        	txn.commit();
    
        	System.out.println("Object is Save Succesfully !!");
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
