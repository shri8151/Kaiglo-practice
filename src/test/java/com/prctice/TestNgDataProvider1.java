package com.prctice;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.kaiglo.geneicUtilityPackage.ExcelUtility;

public class TestNgDataProvider1  {
	
	@Test(dataProvider = "getData")
	public void test1(String username, String password) {
		System.out.println(username+"------>"+password);
		}
	
    @DataProvider
    public String[][] getData(){
    	 ExcelUtility excelUtiity = new ExcelUtility();
    	excelUtiity.openExelFile();
    	String[][] arr = excelUtiity.getDataFromExcel("Sheet2");
    	excelUtiity.closeExelFile();
    	return arr;
    	
    }
    
    @Parameters("url")
    @Test
	public void test(String url) {
		System.out.println("this");
		Reporter.log("url is--->"+url,true);
		}
}
