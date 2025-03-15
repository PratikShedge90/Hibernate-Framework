package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.beans.Student;
import com.tca.beans.Teacher;

public class App {
    public static void main(String[] args)
    {
        Configuration configuration = null;
        SessionFactory sf = null;
        Session session = null;
        Transaction txn = null;
        
        Configuration configuration2 = null;
        SessionFactory sf2 = null;
        Session session2 = null;
        Transaction txn2 = null;
        
        try
        {
        	/** This is for MySQL Database Queries*/
        	
        	configuration = new Configuration();
        	configuration.configure("mysql.cfg.xml");
        	
        	sf = configuration.buildSessionFactory();
        	session = sf.openSession();
        	txn = session.beginTransaction();
        	
       //-------------------------------------------------------
        	/** This is for PostgreSQL Database Queries*/
        	
        	configuration2 = new Configuration();
        	configuration2.configure("pgsql.cfg.xml");
  
        	sf2 = configuration2.buildSessionFactory();
        	session2 = sf2.openSession();
        	txn2 = session2.beginTransaction();
        	
        	Student ob = new Student();
        	ob.setRno(102);
        	ob.setName("BBB");
        	ob.setPer(90.0);
        	
        	session.persist(ob);
        	session2.persist(ob);
       
       	/*
        	Integer trno = (Integer)session.save(ob);
        	
        	System.out.println("Record Saved For RollNumber :" + trno);
        */	
           Teacher teacher = new Teacher();
           teacher.setTname("Saurabh");
           teacher.setTrno(122);
           teacher.setTsalary(8000.0);
           
            session.persist(teacher);
        	session2.persist(teacher);
        	
        	txn.commit();
        	txn2.commit();
        	
        	System.out.println("Data is Saved SuccesFully !!!");
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	txn.rollback();
        	txn2.rollback();
        	
        }
        finally
        {
        	session.close();
        	sf.close();
        	
        	session2.close();
        	sf2.close();
        }
    }
}
