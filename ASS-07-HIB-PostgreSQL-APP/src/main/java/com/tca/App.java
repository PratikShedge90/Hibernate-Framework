package com.tca;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.beans.Student;

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
        	
        	sf = configuration.buildSessionFactory();
        	session = sf.openSession();
        	txn = session.beginTransaction();
        	
        	Student ob = new Student();   // int:0, name:null, per:0.0
        	ob.setRno(107);
        	ob.setName("Aniket");
        	ob.setPer(81.0);
        	ob.setAge(23);
        	ob.setAadhar(8720932);
        	
        	session.save(ob);   // Hibernate is database independent 
        	                    // bcz save() method can save record in any type of database.
        	                    // It prepare INSERT sql with the help of Dialect class.
        	txn.commit();
        	
        	System.out.println("Data is Saved SuccesFully");
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
