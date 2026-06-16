package com.tca.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tca.entities.Student;

public class StudentDaoImpl implements StudentDao {

	public String save(Student ob) 
	{
		Connection con = null;
		PreparedStatement ps = null;

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hfb02","root","root@123");
			
			ps = con.prepareStatement("INSERT INTO student VALUES(?,?,?)");

			ps.setInt(1, ob.getRno());
			ps.setString(2, ob.getName());
			ps.setDouble(3, ob.getPer());
			
			int sval = ps.executeUpdate();
			
			if(sval == 1) 
			{
				return "Success";
			}
			else 
			{
				return "Failed";
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return "Failed";
		} 
		finally 
		{
			try
			{
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

		}

	}

	@Override
	public List<Student> getAllStudent() 
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		
		List<Student> L = new ArrayList<>();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hfb02","root","root@123");
			
			ps = con.prepareStatement("select * from student");
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				int rno = rs.getInt("rno");
				String name = rs.getString("name");
				double per = rs.getDouble("per");
				
				Student student = new Student();
				student.setRno(rno);
				student.setName(name);
				student.setPer(per);
				
				L.add(student);
			}
			
			if(L.isEmpty()) 
			{
				return null;
			}
			else {
				return L;	
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			try
			{
				rs.close();
				ps.close();
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return null;
			}
		}
		
	}

}
