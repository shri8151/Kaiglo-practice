package com.prctice;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.kaiglo.geneicUtilityPackage.BaseClass;

@Listeners(com.kaiglo.geneicUtilityPackage.ListenerImplementationClass.class)
public class FaiureTest extends BaseClass
{
   
	@Test(retryAnalyzer = com.kaiglo.geneicUtilityPackage.RetryImplementationClass.class)
	public void abc() {
		System.out.println("Test start");
		
		
		System.out.println("Test end");
	}
	

}
