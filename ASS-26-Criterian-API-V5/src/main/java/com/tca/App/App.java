package com.tca.App;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

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
			

		    //----------------- Criterion API's ---------------------
			
			// select * from student
/*			
			Criteria criteria = session.createCriteria(Student.class);
			List<Student> list = criteria.list();
			
			for (Student s : list) 
			{
				System.out.println("Roll Number : " + s.getRno());
				System.out.println("Name        : " + s.getName());
				System.out.println("Percentage  : " + s.getPer());
				System.out.println("City        : " + s.getCity());
			}
*/
			// SELECT * FROM student ORDER BY per DESC
/*			
			Criteria criteria = session.createCriteria(Student.class);
			Order order = Order.desc("per");
			
			criteria.addOrder(order);
			
			List<Student> list = criteria.list();
			
			for (Student s : list) 
			{
				System.out.println("Roll Number : " + s.getRno());
				System.out.println("Name        : " + s.getName());
				System.out.println("Percentage  : " + s.getPer());
				System.out.println("City        : " + s.getCity());
				
				System.out.println("-----------------------------------");
			}
*/
			
			// SELECT * FROM student WHERE per >=70 AND per<=90 ORDER BY per DESC
/*			
			Criteria criteria = session.createCriteria(Student.class);
			
			Criterion c1 = Restrictions.ge("per", 70.0);
			Criterion c2 = Restrictions.le("per", 90.0);
		
			criteria.add(c1);
			criteria.add(c2);
			
			Order order = Order.desc("per");
			criteria.addOrder(order);
			
			List<Student> list = criteria.list();
			
			for (Student s : list) 
			{
				System.out.println("Roll Number : " + s.getRno());
				System.out.println("Name        : " + s.getName());
				System.out.println("Percentage  : " + s.getPer());
				System.out.println("City        : " + s.getCity());
				
				System.out.println("-----------------------------------");
			}
			
*/
			/**	Scalar Query */
			// SELECT name, per FROM student WHERE per >=70 AND per<=90 ORDER BY per DESC
/*		
			Criteria criteria = session.createCriteria(Student.class);
			
			Criterion c1 = Restrictions.ge("per", 70.0);
			Criterion c2 = Restrictions.le("per", 90.0);
		
			criteria.add(c1);
			criteria.add(c2);
			
			Order order = Order.desc("per");
			criteria.addOrder(order);
			
			ProjectionList pl = Projections.projectionList();
			pl.add(Projections.property("name"));
			pl.add(Projections.property("per"));
			
			criteria.setProjection(pl);
			
			List<Object[]> list = criteria.list();
			
			for(Object[] ob : list)
			{
				for(Object data : ob)
				{
					System.out.print(data.toString() + " ");
				}
				System.out.println();
			}
*/	
			// select count(*) FROM student
/*			
			Criteria criteria = session.createCriteria(Student.class);
			criteria.setProjection(Projections.rowCount());
			Long cnt = (Long)criteria.uniqueResult();
			
			System.out.println("No Of Records : " + cnt );
*/
			// select max(per) FROM student
/*			
			Criteria criteria = session.createCriteria(Student.class);
			criteria.setProjection(Projections.max("per"));
			
			Double maxper = (Double) criteria.uniqueResult();
			
			System.out.println("Maximum Per : " + maxper);
*/
			
			// LIKE, %,_
					    // SELECT * from student WHERE city LIKE 'P%'; 
/*			
			Criteria criteria = session.createCriteria(Student.class);
			
			criteria.add(Restrictions.like("city", "P%"));
			
			List<Student> list = criteria.list();
			
			for (Student s : list) 
			{
				System.out.println("Roll Number : " + s.getRno());
				System.out.println("Name        : " + s.getName());
				System.out.println("Percentage  : " + s.getPer());
				System.out.println("City        : " + s.getCity());
				
				System.out.println("-----------------------------------");
			}
			
*/
			
			//----------GROUP BY --------------------------
			// select city, count(*) from student group by scity;
/*			
			Criteria criteria = session.createCriteria(Student.class);
			
			ProjectionList pl = Projections.projectionList();
			pl.add(Projections.groupProperty("city"));
			pl.add(Projections.rowCount());
			
			criteria.setProjection(pl);
			
			
			List<Object[]> list = criteria.list();
			
			for(Object[] ob : list)
			{
				for(Object data : ob)
				{
					System.out.print(data.toString() + " ");
				}
				System.out.println();
			}
*/
			//----------GROUP BY HAVING --------------------------
			
			//select city, count(*) from student group by scity having count(*) > 1;

/*
			Criteria criteria = session.createCriteria(Student.class);
			
			ProjectionList pl = Projections.projectionList();
			pl.add(Projections.groupProperty("city"));
			pl.add(Projections.rowCount());
			
			criteria.setProjection(pl);
			
													//			 0    1      0     1
			List<Object[]> list = criteria.list();  // L --> [ [Pune, 2], [Mumbai, 2] ]
			
			for(Object[] ob : list)
			{
				Long cnt = (Long) ob[1];
				if(cnt > 1)
				{
					System.out.println("City : " + ob[0] + " " + "No of Students " +cnt );
				}
				
			}
*/
			
			// UPDATE --> UPDATE student SET per=99 WHERE rno=101;
/*			
			Criteria criteria = session.createCriteria(Student.class);
			criteria.add(Restrictions.eq("rno", 101));
			
			List<Student> list = criteria.list();
			
			for (Student s : list) 
			{
				s.setPer(99.87);
			}
*/			
			
			// DELETE --> DELETE FROM student WHERE rno=101;
			
			Criteria criteria = session.createCriteria(Student.class);
			criteria.add(Restrictions.eq("city", "MUMBAI"));
			
			List<Student> list = criteria.list();
			
			for (Student s : list) 
			{
				session.delete(s);
			}
			
			System.out.println("No of Records deleted : " + list.size());
			
			
			
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
