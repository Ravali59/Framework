package com.ors.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ors.pages.Loginpage;
import com.ors.utilities.BaseClass;

public class LoginTest extends BaseClass {
	@Test()

	public void loginApp() {
		

		test = report.createTest("login to orangehrm");

		Loginpage  loginpage=PageFactory.initElements(driver, Loginpage .class);
		test.info("succfull login");
		loginpage.LoginToOrangehrm(excel.getStringData("login", 0, 0),excel.getStringData("login", 0, 1));
	    test.pass("passed succefully");
		
				
	}



	}

	
	


