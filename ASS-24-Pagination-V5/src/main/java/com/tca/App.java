package com.tca;

import java.awt.datatransfer.Transferable;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Student;

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
			configuration.addAnnotatedClass(Student.class);

			sf = configuration.buildSessionFactory();
			session = sf.openSession();
			txn = session.beginTransaction();
			

		    //----------------- Native SQL ---------------------
			
			/** Entity SQL Query  */
/*			
			SQLQuery sqlQuery = session.createSQLQuery("select * from student");
			sqlQuery.addEntity(Student.class);
			
			List<Student> list = sqlQuery.list();
			
			for(Student s : list)
			{
				System.out.println("Rno  :" + s.getRno());
				System.out.println("Name :" + s.getName());
				System.out.println("City :" + s.getCity());
				System.out.println("Per  :" + s.getPer());
			}
*/			
			/** Entity SQL Query with Positional Parameter */
/*			
			SQLQuery sqlQuery = session.createSQLQuery("select * from student where sper>= ?0");
			sqlQuery.setParameter(0,70.0);
			sqlQuery.addEntity(Student.class);
			
			List<Student> list = sqlQuery.list();
			
			for(Student s : list)
			{
				System.out.println("Rno  :" + s.getRno());
				System.out.println("Name :" + s.getName());
				System.out.println("City :" + s.getCity());
				System.out.println("Per  :" + s.getPer());
			}
*/			
			/** Entity SQL Query with Named Parameter */
/*			
			SQLQuery sqlQuery = session.createSQLQuery("select * from student where sper>= :abc");
			sqlQuery.setParameter("abc",70);
			sqlQuery.addEntity(Student.class);
			
			List<Student> L = sqlQuery.list();
			
			for(Student s : L)
			{
				System.out.println("Roll No. :" + s.getRno() + "\tName :" + s.getName() + "\tCity : " + s.getCity() + "\tPer : " + s.getPer());
				System.out.println("---------------------------------------------------------");
			}
*/			
			
			/** Scalar SQL Query -> If you are Interested in Particular Columns  */
/*			
			SQLQuery sqlQuery = session.createSQLQuery("select srno,sname,sper,scity from student");
			sqlQuery.addEntity(Student.class);
			
			List<Student> L = sqlQuery.list();
			
			for(Student s : L)
			{
				System.out.println("Roll No. :" + s.getRno() + "\tName :" + s.getName() + "\tCity : " + s.getCity() + "\tPer : " + s.getPer());
				System.out.println("---------------------------------------------------------");
			}
*/
			//----------INSERT----------------------
/*			
			 SQLQuery sqlQuery = session.createSQLQuery("insert into student values(?0,?1,?2,?3) ");
			 sqlQuery.addEntity(Student.class);
			 
			 sqlQuery.setParameter(0, 121);
			 sqlQuery.setParameter(1, "Pratik");
			 sqlQuery.setParameter(2, 90);
			 sqlQuery.setParameter(3, "DELHI");
			 
			 int rowcnt = sqlQuery.executeUpdate();
			 
			 System.out.println("Records Updated : " + rowcnt);
*/			
			
			
			 
			//----------UPDATE----------------------
/*			 
			 SQLQuery sqlQuery = session.createSQLQuery("update student set scity= ?0 where srno=?1 ");
			 sqlQuery.addEntity(Student.class);
			 
			 sqlQuery.setParameter(0, "Dubai");
			 sqlQuery.setParameter(1, 121);
			 
			 int rowcnt = sqlQuery.executeUpdate();
			 
			 System.out.println("Records Updated : " + rowcnt);
*/
			
			//----------DELETE----------------------
/*	 
			 SQLQuery sqlQuery = session.createSQLQuery("delete from student where scity=?0 ");
			 sqlQuery.addEntity(Student.class);
			 
			 sqlQuery.setParameter(0, "Dubai");
			 
			 int rowcnt = sqlQuery.executeUpdate();
			 
			 System.out.println("Records Updated : " + rowcnt);
*/
			
			//--------DROP TABLE ----------------------
/*	
			SQLQuery sqlQuery = session.createSQLQuery("drop table student");
			sqlQuery.addEntity(Student.class);
			
			int rowcnt = sqlQuery.executeUpdate();			
*/			
			
			
			txn.commit();

			
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
