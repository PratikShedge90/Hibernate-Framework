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
   //     Transaction txn = null;
        
        try
        {
        	configuration = new Configuration();
        	configuration.configure();
        	
        	sf = configuration.buildSessionFactory();
        	session = sf.openSession();
    
            //reflection     	
        	Student s = (Student)session.get(Student.class, 101);  // get() method is Generic it can give object of Student, Teacher etc.
        	
        	System.out.println(s);
        	
         	Student s2 = (Student)session.get(Student.class, 101);
        		
        	System.out.println(" SuccesFully !!!");
        }
        catch(Exception e)
        {
        	e.printStackTrace();
      //  	txn.rollback();
        }
        finally
        {
        	session.close();
        	sf.close();
        }

    }
}
