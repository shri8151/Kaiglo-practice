package com.kaiglo.geneicUtilityPackage;

import com.aventstack.extentreports.ExtentTest;

public class ThreadSafe {
	
	
	private static ThreadLocal<WebdriverUtility>webdriverUtility=new ThreadLocal<WebdriverUtility>();
	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
    /**
     * 
     * @return
     */
	public static ExtentTest getExtentTest() {
		return extentTest.get();
	}
    /**
     * 
     * @param sextentTest
     */
	public static void setExtentTest( ExtentTest sextentTest ) {
		extentTest.set(sextentTest);
	}

	
	/**
	 * 
	 * @return
	 */
	public static WebdriverUtility getWebdriverUtility() {
		return webdriverUtility.get();
	}
     /**
      * 
      * @param swebdriverUtility
      */
	public static void setWebdriverUtility(WebdriverUtility swebdriverUtility) {
		webdriverUtility.set(swebdriverUtility);
	}
	
}
