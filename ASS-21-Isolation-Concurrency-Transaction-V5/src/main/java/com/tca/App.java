package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.tca.entities.Account;

public class App 
{
	public static void main(String[] args) 
	{
		Configuration configuration = null;
		SessionFactory sf = null;
		Session session1 = null;
		Transaction txn1 = null;
		
		Session session2 = null;
		Transaction txn2 = null;
		
		try 
		{
			configuration = new Configuration();
			configuration.configure();
			configuration.addAnnotatedClass(Account.class);

			sf = configuration.buildSessionFactory();
			
			session1 = sf.openSession();		
			session2 = sf.openSession();
			
			txn1 = session1.beginTransaction();
			txn2 = session2.beginTransaction();
			
			Account a1 = session1.get(Account.class, 101);
			a1.setBalance(a1.getBalance() + 15 );
			
			
			Account a2 = session2.get(Account.class, 101);
			a2.setBalance(a2.getBalance() - 25 );
			
			session1.update(a1);
			session2.update(a2);
			
			txn1.commit();
			txn2.commit();    // Important Note is that which transaction is getting First Committed and After committing the Second txn commit will overwrite the first txn.
			
			System.out.println("Mission Accomplished SuccesFully !!!");		
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
			txn1.rollback();
			txn2.rollback();
		} 
		finally 
		{
			session1.close();
			session2.close();
			sf.close();
		}
	}
}
