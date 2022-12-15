package com.prctice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import com.mysql.cj.jdbc.Driver;

public class validateDatabase {

	public static void main(String[] args) throws SQLException {

		int emp_Id=109;
		String name="mahesh";
		float salary= 20000;
		
		
		Driver dbdriver=new Driver();
		DriverManager.registerDriver(dbdriver);
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet44", "root", "root");
		try {
	      Statement statement = connection.createStatement();
	      
	     ResultSet results = statement.executeQuery("select * from sdet44");
	     
	     HashSet<String>eid=new HashSet<String>();
	     HashSet<String>names=new HashSet<String>();
	     HashSet<String>salaryList=new HashSet<String>();
	     
	      while(results.next())
	     {
	    	 
				eid.add(results.getString("Emp_Id"));
				names.add(results.getString("name"));
				 salaryList.add(results.getString("salary"));
			
	       }
	     
	    	 
	    	     if(eid.contains(emp_Id) && name.contains(name) && salaryList.contains(salary))
	    	     {
	    		 
	    		 System.out.println("duplicate value avaiable");
	    	     }
	    	     else 
	    	     {
	    		 
	    	    	 int result = statement.executeUpdate("insert into sdet44 values(emp_Id,name,salary,'shr@eew',12345679)");
	    	    	 if(result==1)
	    	    	 {
	    			 System.out.println("data updated successfully");
	    	    	 }
	    	     }
	    	 }	
	    	     
	    	catch (Exception e) 
	    	{
	    		
	    		e.printStackTrace();
			}
	    	
	    finally
	    {
			

	    	connection.close();
		}
		
	
	     }
	}

