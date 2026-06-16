package com.tca.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.tca.entities.Student;

public class StudentDaoImpl implements StudentDao {

	public String save(Student ob) 
	{
		Connection con = null;
		PreparedStatement ps = null;

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");		// Class has the intance of instantiating user defined class 
			
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

}
