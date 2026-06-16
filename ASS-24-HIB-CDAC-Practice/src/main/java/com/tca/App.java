package com.tca;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Student;
import com.tca.entities.Teacher;

public class App 
{
    public static void main(String[] args) 
    {
    	Configuration configuration = null;
    	SessionFactory  sf = null;
    	Session session = null;
    	Transaction txn = null;
    	
    	Configuration configuration2 = null;
    	SessionFactory sf2 = null;
    	Session session2 = null;
    	Transaction txn2 = null;
     	
    	try
    	{
    		configuration = new Configuration();             // configuration --> Data
    		configuration.configure("mysqlconfig.cfg.xml");    // It Loads and Parse XML Files (like Giving or taking Information about Database Properties, hibernate Properties & Mapping File )

    		sf = configuration.buildSessionFactory();        // cmd + shift + 1

    		session = sf.openSession();
    		txn = session.beginTransaction();
    		
    		configuration2 = new Configuration();
    		configuration2.configure("pgconfig.cfg.xml");
    		
    		sf2 = configuration2.buildSessionFactory();
    		
    		session2 = sf2.openSession();
    		txn2 = session2.beginTransaction();

    		Student ob = new Student();
    		ob.setRno(111);
    		ob.setName("Saurav");
    		ob.setPer(66);

    		session.save(ob);
    		session2.persist(ob);
    		
    		Teacher teacher = new Teacher();
    		teacher.setTno(101);
    		teacher.setName("Sachin");
    		teacher.setSalary(320000.0);
    		
    		session.persist(teacher);
    		session2.persist(teacher);
    		
    		txn.commit();
    		txn2.commit();
    		
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
