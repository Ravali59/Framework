package com.ors.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class Loginpage {
	WebDriver driver;
	public Loginpage  (WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}
	
@FindBy(name="txtUsername")WebElement username;
@FindBy(id="txtPassword")WebElement password;
@FindBy(id="btnLogin")WebElement login_butn;


public void LoginToOrangehrm(String Uname,String Pass )

{
	 username.sendKeys(Uname);
	 password.sendKeys(Pass );
	 login_butn.click();
	
	 
}
}
