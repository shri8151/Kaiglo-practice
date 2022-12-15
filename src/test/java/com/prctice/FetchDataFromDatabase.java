package com.prctice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchDataFromDatabase {

	public static void main(String[] args) throws SQLException {

	//create the object for driver implementation class and register driver to jdbc
	Driver dbdriver=new Driver();
	DriverManager.registerDriver(dbdriver);
		
	//get/establish database connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet44", "root", "root");
		
		//create statement
		
		Statement statement = connection.createStatement();
		
		
	//execute quarry
		ResultSet result = statement.executeQuery("select * from sdet44");
		
		 
		//utilization and fetch data from particular column
		while(result.next()){
			System.out.println(result.getString("name")+result.getString("salary"));
			
		}
	
	}

}
