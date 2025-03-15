package com.tca;

import javax.naming.directory.InvalidAttributesException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Student;

public class App {
	
	
	public static Student addData(Integer rno, String name, Double per, String email) throws InvalidAttributesException
	{
		if(per<0 || per > 100)
		{
			throw new InvalidAttributesException("Percentage Should be between 0 and 100");
			
		}
		
		Student ob = new Student();
		ob.setRno(rno);
		ob.setName(name);
		ob.setEmail(email);
		ob.setPer(per);
		
		return ob;
	}
	
	
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
        	
            Student ob = addData(101,"Saurav",90.0,"A@gmail.com");
        	
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
