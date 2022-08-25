package com.dsalgo.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgo.qa.base.BaseClass;

public class RegisterPage extends BaseClass {
	
	@FindBy (name="username")
	WebElement UserName;
	
	@FindBy (name="password1")
	WebElement Password;
	
	@FindBy (name="password2")
	WebElement PasswordConf;
	
	@FindBy (xpath = "//input[@type=\"submit\"]")
	WebElement RegisterBtn;
	
	@FindBy (xpath = "//div[@role=\"alert\"]")
	WebElement ErrorMsg;
	//password_mismatch:The two password fields didn’t match.
	
	
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage completeRegistration(String usrname, String pwd) {
		UserName.sendKeys(usrname);
		Password.sendKeys(pwd);
		PasswordConf.sendKeys(pwd);
		RegisterBtn.click();
		
		return new HomePage();
	}
	
	public String verifyErrorMessage(String usrname, String pwd) {
		UserName.sendKeys(usrname);
		Password.sendKeys(pwd);
		PasswordConf.sendKeys("something");
		RegisterBtn.click();
		
		return ErrorMsg.getText();
	}
}
