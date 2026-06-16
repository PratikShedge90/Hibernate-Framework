package com.tca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddStudent {

	public static void main(String[] args)
	{
		Connection con = null;
		PreparedStatement ps = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		try
		{
			// 1. Load Driver & Register the Driver 
			Class.forName("com.mysql.cj.jdbc.Driver");
			   
			// 2. Form the Connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hfb02", "root", "root@123" );
			
			System.out.println("Enter the RollNumber : ");
			int rno = Integer.parseInt(br.readLine());
			
			System.out.println("Enter the Name : ");
			String name = br.readLine();
			
			System.out.println("Enter the Percentage : ");
			float per = Float.parseFloat(br.readLine());
			
			// 3. prepare SQL Statement
			ps = con.prepareStatement("INSERT INTO student VALUES(?,?,?)");

			ps.setInt(1, rno);
			ps.setString(2, name);
			ps.setFloat(3, per);
			
			// 4. Fire the SQL Statement
			int sval = ps.executeUpdate();
			
			if(sval >= 1) {
				System.out.println("Record is Saved SuccessFully!!");
			}else {
				System.out.println("Not Saved !!");
			}
			
			System.out.println("Done !!!!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally   // 5. closing the connection
		{
			try
			{
				System.out.println("Connection is closing Either Flow go inside try or catch block !!");
			  con.close();
		    }
			catch(Exception e) 
			{
		    	e.printStackTrace();
		    }
		}
	

	}

}
