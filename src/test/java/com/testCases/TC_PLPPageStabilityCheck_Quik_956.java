package com.testCases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.pageObject.LoginPage;
import com.pageObject.PLPPage;

import junit.framework.Assert;

public class TC_PLPPageStabilityCheck_Quik_956 extends BaseClass {

	@Test
	public void PLPStable() throws InterruptedException, IOException 
	{
		driver.manage().window().maximize();
		logger.info("open url");
		loadtimes();
		
		Thread.sleep(10000);
		PLPPage plp=new PLPPage(driver);
		plp.Clickcityselect();
		logger.info("city is cllickable");
		
		plp.clickbtnFIndCar();
		logger.info("Findcar is cllickable");
		
		loadtimes();
        
		System.out.println("test");
        //js.executeScript("window.scrollBy(0,-350)", "");
}
	
		
	
	
}

