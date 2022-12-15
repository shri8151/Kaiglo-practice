package com.kaiglo.geneicUtilityPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * This class contains reusable methods for fetching data from external property file.
 * @author Srikanth
 *
 */
public class FileUtility {
private FileInputStream fis;

Properties p;

/**
 * This method is for opening the property file.
 * @param propertyFiLePath
 * @throws IOException
 */
public void openPropertyFile(String propertyFiLePath)  {
	try {
		fis=new FileInputStream(propertyFiLePath);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	 p=new Properties();
	try {
		p.load(fis);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
	
/**
	 * this method is use for get the value from property file.
	 * @param propertyFiLePath
	 * @param key
	 * @return
 * @throws IOException 
	 */
	
public String getDataFromPropertyFile(String key) 
{
			String value = p.getProperty(key).trim();
			
	        return value;
	}
/*
 * This method will close property file.
 */
public void closePropertyFile() {
	try {
		fis.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
}