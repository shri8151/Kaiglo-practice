package com.prctice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsetDataIntoTable {

	public static void main(String[] args) throws SQLException {

//create the object for driver implementation class and register driver to jdbc
			Driver dbdriver=new Driver();
			DriverManager.registerDriver(dbdriver);
			
			
//Establish a connection with database
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet44", "root", "root");
				
			
		//create a statement
					Statement statement = con.createStatement();
			
			
			//execute the qurry
			   int result = statement.executeUpdate("insert into sdet44 values(105,'ganesh',70000.00,'shr@eew',12345679)");
			
			
  if(result==1)
  {
	  System.out.println("data updated successfully");
  }	
statement.close();
con.close();
	}
	
	}
