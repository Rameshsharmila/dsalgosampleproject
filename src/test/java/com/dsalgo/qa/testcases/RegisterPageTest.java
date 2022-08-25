package com.dsalgo.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dsalgo.qa.base.BaseClass;
import com.dsalgo.qa.pages.HomePage;
import com.dsalgo.qa.pages.MainPage;
import com.dsalgo.qa.pages.RegisterPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class RegisterPageTest extends BaseClass{
	RegisterPage registerPage;
	MainPage mainPage;
	HomePage homePage;
	
	
	public static String randomname = "UsrTest"+ org.apache.commons.lang.RandomStringUtils.randomAlphabetic(4);
	
	public RegisterPageTest() {
		//call the super class constructor to get the properties
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		//Initialize the browser
		initialization();
		registerPage = new RegisterPage();
		mainPage = new MainPage();
		homePage = new HomePage();
	}
	
	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Description("Register a New User")
	@Story("Story Name: New User Registration")
	public void registerUserTest() {
		System.out.println(randomname);
		homePage = mainPage.clickGetStarted();
		registerPage = homePage.goToRegisterPage();
		homePage = registerPage.completeRegistration(randomname, "qatestnumpy");
		String msg = homePage.messageOnTopScreen();
		System.out.println("message is.." +msg);
		Assert.assertTrue(msg.contains(randomname), msg);
	
	}
	
	@Test
	@Severity(SeverityLevel.NORMAL)
	@Description("Register User with invalid data")
	@Story("Story Name: New User Registration-Negative")
	public void registerUserNegativeTest() {
		homePage = mainPage.clickGetStarted();
		registerPage = homePage.goToRegisterPage();
		String ErrorMessage = registerPage.verifyErrorMessage("qatest12345", "qatestnumpy");
		System.out.println(ErrorMessage);
		Assert.assertEquals("password_mismatch:The two password fields didn’t match.", ErrorMessage);
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
