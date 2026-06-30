package com.tca.App;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Employee;
import com.tca.entities.Executive;

public class App 
{
	public static void main(String[] args) 
	{
		Configuration configuration = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction txn = null;

		try 
		{
			Scanner sc = new Scanner(System.in);
			
			configuration = new Configuration();
			configuration.configure();
			configuration.addAnnotatedClass(Executive.class);
			configuration.addAnnotatedClass(Employee.class);

			sf = configuration.buildSessionFactory();
			session = sf.openSession();
			txn = session.beginTransaction();

			//-----------------Inheritance Mapping Table Per class--------------------
/*			
 			// Inserting Data
 
			Employee emp = new Employee();
			emp.setEid(111);
			emp.setName("Pratik");
			session.save(emp);
			
			Executive exe = new Executive();
			exe.setEid(222);
			exe.setName("Saurav");
			exe.setErole("Senior SDE");
			
			session.save(exe);
			
*/
			
			// Fetching Data
/*			
			Employee emp = session.get(Employee.class, 111);
			System.out.println("EMPLOYEE INFORMATION ");
			System.out.println("EMPLOYEE ID   : " + emp.getEid());
			System.out.println("EMPLOYEE NAME : " + emp.getName());
			
			Employee emp = session.get(Employee.class, 222);
			System.out.println("EMPLOYEE INFORMATION ");
			System.out.println("EMPLOYEE ID   : " + emp.getEid());
			System.out.println("EMPLOYEE NAME : " + emp.getName());
	
*/	
		
			/** Parent ref can hold Child class reference */
/*				
			Employee emp = session.get(Executive.class, 222);
			System.out.println("EMPLOYEE INFORMATION ");
			System.out.println("EMPLOYEE ID   : " + emp.getEid());
			System.out.println("EMPLOYEE NAME : " + emp.getName());
*/

/*
			Executive exe = session.get(Executive.class, 222);
			System.out.println("EXECUTIVE INFORMATION ");
			System.out.println("EXECUTIVE ID   : " + exe.getEid());
			System.out.println("EXECUTIVE NAME : " + exe.getName());
			System.out.println("EXECUTUVE ROLE : " + exe.getErole());
*/
			
// Not Works bcz query is formed --> select * from emp1 where eid = 111 and  DISCRIMINATOR='EXECUTIVE';
// So, No data is Fetched to form emp object, it means emp is NULL
// So, If we try to access emp.getEid() we get NullPointerException
			
			Executive exe = session.get(Executive.class, 111);
			System.out.println("EXECUTIVE INFORMATION ");
			System.out.println("EXECUTIVE ID   : " + exe.getEid());
			System.out.println("EXECUTIVE NAME : " + exe.getName());
			System.out.println("EXECUTUVE ROLE : " + exe.getErole());
			
			txn.commit();

			System.out.println("Done .......!");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			session.close();
			sf.close();
		}

	}
}
