package com.ors.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	
	public  WebDriver driver;
	public  LoginDataProvider  excel ;
	public  ConfigDataProvider config;
	public ExtentReports report ;
	public ExtentTest test;
	
	
	
	
	@BeforeSuite
	public void setUpSuite()
	{
		Reporter.log("setting the credentials  test is beeing starded",true);
			excel = new LoginDataProvider();
			 config = new ConfigDataProvider();
			 
			 
			 ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Results/orsreport+"+WebLibraries.getCurrentDateFormat()+".html"));
			 Reporter.log("html report generated",true);
			 report  = new ExtentReports();
			 report.attachReporter(extent);
			 Reporter.log("setting are done test is  starded",true);
				 
		 
	}
	
	@BeforeClass
	
		public void SetUp() {
		Reporter.log("browser is opening",true);
			driver=BrowserFactory.StartApplication(driver,config.getBrowser(), config.getStageUrl());
			Reporter.log("browser opened",true);
		}
	@AfterClass
	public void TearDown() {
		BrowserFactory.quitdriver(driver);
	}
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		Reporter.log("test passed screenshots are being taken",true);
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			WebLibraries.getScreenShot(driver);
			test.pass("test passed ", MediaEntityBuilder.createScreenCaptureFromPath(WebLibraries.getScreenShot(driver)).build());
			Reporter.log("screenshot are taken",true);
			
		}
		report.flush();
		
	}
	
}
