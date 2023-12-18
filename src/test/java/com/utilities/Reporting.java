package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//Listener class used to generate report
public class Reporting extends TestListenerAdapter {

	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	 public void onStart(ITestContext testContext) {
		 String timeStamp=new SimpleDateFormat("yyyy.MM.dd.ss").format(new Date());
		 String repName="Test-Report-" +timeStamp+".html";
		
		 htmlReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);//specify location
        
			try {
				htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

			// TODO Auto-generated catch block
		
		 
		 extent=new ExtentReports();
		 
		 extent.attachReporter(htmlReporter);
		 extent.setSystemInfo("Host name","localhost");
		 extent.setSystemInfo("Environment","UAT");
		 extent.setSystemInfo("user", "OnlineCustomer");
		 
		 
		 htmlReporter.config().setDocumentTitle("QUIKLYZ Test Project");//tile of report
		 htmlReporter.config().setReportName("Automation Test Reporter");//name of the report
		
		htmlReporter.config().setTheme(Theme.DARK);
		 
	 }
	 
	 public void onTestSuccess(ITestResult tr) {
		 logger=extent.createTest(tr.getName());//create new entry in the report
		 logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));//send the passed information
	 }
	 
	 public void onTestFailure(ITestResult tr) {
		 logger=extent.createTest(tr.getName());//create new entry in the report
		 logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));//send the passed information 
		 
		 String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		 File f=new File(screenshotPath);
		 if(f.exists()) {
			 logger.fail("Screenshot is below:" +logger.addScreenCaptureFromPath(screenshotPath));
			 
		 }
	 } 
		 public void onTestSkipped(ITestResult tr) {
			 
			 logger=extent.createTest(tr.getTestName());//create new entry in the report
			 logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));//send the passed information 
		 }
		 public void onFinish(ITestContext testContext) {
			 extent.flush();
	 }
	 
}

