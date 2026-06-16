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
		Session session = null;
		Transaction txn = null;

		Integer senderAccNo = 101;
		Integer receiverAccNo = 102;
		Double amount = 10.0;

		try 
		{
			configuration = new Configuration();
			configuration.configure();
			configuration.addAnnotatedClass(Account.class);

			sf = configuration.buildSessionFactory();
			session = sf.openSession();

			//------Money Sender Object creation-----------
			
			Account sob = session.get(Account.class, senderAccNo);
			if (sob == null) 
			{
				System.out.println("Invalid Senders Account Number !! " + senderAccNo);
				return;
			}

			if (amount >= sob.getBalance()) 
			{
				System.out.println("Insufficient Balance in Sender's Account Number : " + senderAccNo);
			}

			sob.setBalance(sob.getBalance() - amount);
			
			
			//------Money Receiver Object creation-----------

			Account rob = session.get(Account.class, receiverAccNo);
			if (rob == null) 
			{
				System.out.println("Invalid Senders Account Number !! " + receiverAccNo);
				return;
			}
			rob.setBalance(rob.getBalance() + amount);

			txn = session.beginTransaction();
			session.update(sob);
			session.update(rob);

			txn.commit();

			System.out.println("Mission Accomplished SuccesFully !!!");
		} 
		catch (Exception e)
		{
			System.out.println("Money Transfer Failed !!");
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
