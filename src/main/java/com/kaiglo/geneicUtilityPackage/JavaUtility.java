package com.kaiglo.geneicUtilityPackage;


import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * This class contains java reusable methods.
 * @author Srikanth
 *
 */
public class JavaUtility {
/**
 * This method is used for convert to string to any data type.
 * @param s
 * @param stratergy
 * @return
 */
	public Object stringToAnyDataType(String s,String stratergy) {
		Object convertedData = null;
		if(stratergy.equals("int")) {
			 convertedData = Integer.parseInt(s);
		}
		else if(stratergy.equals("long")) {
			convertedData=Long.parseLong(s);
		}
		else if(stratergy.equals(s)) {
			convertedData=Float.parseFloat(s);
		}
			
		return convertedData;
	}
	
	/**
	 * This method can generate random members.
	 * @param limit
	 * @return
	 */
	public int getRandomNumber(int limit) {
		int randomNumber = new Random().nextInt(limit);
		return randomNumber; 
	}
	/*
	 * this method is used to get the MM(int) format of month.
	 */
	public int getMonthInMMFormat(String s) {
	return	DateTimeFormatter.ofPattern("MM").withLocale(Locale.ENGLISH).parse(s).get(ChronoField.MONTH_OF_YEAR);
		
	}
	/**
	 * This method is used to fetch the system date and time in dd_MM_YYYY_HH_mm_ss format.
	 * @return
	 */
	public String getDateTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_YYYY_HH_mm_ss");
		String d = sdf.format(date);
		return d;
		
	}
	
	
}
