package com.dsalgo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgo.qa.base.BaseClass;

public class SignInPage extends BaseClass{
	
	@FindBy (name="username")
	WebElement UserName;
	
	@FindBy (name="password")
	WebElement password;
	
	@FindBy (xpath="//input[@type=\"submit\"]")
	WebElement LoginBtn;
	
	@FindBy (xpath="//input[@type=\"submit\"]")
	WebElement ErrorMsg;
	//Invalid Username and Password
	
	
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}

	public String UnsuccessfulLogin(String usrname, String inpwd) {
		UserName.sendKeys(usrname);
		password.sendKeys(inpwd);
		LoginBtn.click();
		
		return ErrorMsg.getText();
		
	}
	
	public HomePage SuccessfulLogin(String usrname, String pwd) {
		UserName.sendKeys(usrname);
		password.sendKeys(pwd);
		LoginBtn.click();
		return new HomePage();
	}
	

}
