package com.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String mobile=readconfig.getmobile();
	public String otp1=readconfig.getotp1();
	public String otp2=readconfig.getotp2();
	public String otp3=readconfig.getotp3();
	public String otp4=readconfig.getotp4();
	public String otp5=readconfig.getotp5();
	public String otp6=readconfig.getotp6();
	
	
	public static WebDriver driver;
	public static Logger logger;
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
	//System.setProperty("webdriver.chrome.driver", readconfig.getchromepath());
		//driver=new ChromeDriver();
		
		logger=Logger.getLogger("Quiklyz");
		PropertyConfigurator.configure("log4j.properties");
		if(br.equals("chrome")) 
		{
		System.setProperty("webdriver.chrome.driver", readconfig.getchromepath());
		 driver=new ChromeDriver();
	     }
	    else if(br.equals("firefox"))
	    {
		System.setProperty("webdriver.gecko.driver", readconfig.getgeckopath());
		driver=new FirefoxDriver();
	    }
		driver.get(baseURL);
	}
public void loadtimes() throws IOException {
	JavascriptExecutor js = (JavascriptExecutor) driver;
    if (js.executeScript("return window.performance.navigation.type").equals(1L)) {
    	captureScreen(driver,"PLPPage");
    	logger.info("Page is loaded twice");
    } else {
    	captureScreen(driver,"PLPPage");
    	logger.info("Page is loaded once ");
    }
}


	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+ "/ScreenShots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("SCreenshot taken");
		
	}
}
