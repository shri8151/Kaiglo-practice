package com.kaiglo.geneicUtilityPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;
/**
 * This class contains all reusable methods to perform actions on Database.
 * @author Srikanth
 *
 */


public class DataBaseUtility {
private Connection connection;
	/**
	 * This method i used to open and get connected to database.
	 * @param dbUrl
	 * @param dbUserName
	 * @param dbPassword
	 * @throws SQLException
	 */

        public void openDBConnection(String dbUrl, String dbUserName,String dbPassword)throws SQLException {
        	Driver dbdriver=new Driver();
        	DriverManager.registerDriver(dbdriver);
        	DriverManager.getConnection(dbUrl, dbUserName,dbPassword);
        	
         }
	/**
	 * This method is used for close the data base.
	 * @throws SQLException
	 */
        
        public void closeDB()throws SQLException {
        	connection.close();
        }
        
        /**
         * This method is used for fetch the data from the database.
         * @param query
         * @param columnName
         * @return
         * @throws SQLException
         */
        public List<String> getDataFromDataBase( String query, String columnName) throws SQLException {
        	
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(query);
        List<String> list = new ArrayList<String>();
        while(result.next()) {
        	list.add(result.getString(columnName));
        }
        return list;	
        }
     /**
      * This method used for verify the data is available in the database or not.   
      * @param query
      * @param columnName
      * @param expectedData
      * @return
      * @throws SQLException
      */
        public boolean verifyDataInDatabase(String query, String columnName, String expectedData) throws SQLException {
        	List<String> list=getDataFromDataBase(query,columnName);
        	boolean flag=false;
        	for(String actualData:list) {
        		
        		if(actualData.equalsIgnoreCase(expectedData)) {
        			flag=true;
        			break;	
        		}
        	}
        	if(list.contains(expectedData))
        	flag=true;
			return flag;
        }
        
}