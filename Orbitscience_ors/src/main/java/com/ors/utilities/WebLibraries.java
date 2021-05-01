package com.ors.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.reporters.Files;

public class WebLibraries {
	
	public static String  getScreenShot(WebDriver driver )
	{	
		
		
		String screenshotpath = System.getProperty("user.dir")+"/ScreenShots/ors"+getCurrentDateFormat()+".png";
        TakesScreenshot sht = (TakesScreenshot) driver; 
        try {
		
		File screenshotfile = sht.getScreenshotAs(OutputType.FILE);
		File fis = new File (screenshotpath);
		
			FileUtils.copyFile(screenshotfile,fis);

			System.out.println("screeenshot taken");
			
		} 
        catch (IOException e) {
			

		System.out.println("screeenshot not taken");
		
		
	}
        return screenshotpath;
	}
	public static String getCurrentDateFormat()
	{
		DateFormat dateformat = new SimpleDateFormat("MM_dd_yyyy HH_mm_ss");
		Date date= new Date();
		/*String date1 = dateformat.format(date);
		System.out.println("current date and time is "+date1);*/
		return dateformat.format(date);
	}
}
	

	

