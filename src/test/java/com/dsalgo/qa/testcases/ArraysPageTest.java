package com.dsalgo.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dsalgo.qa.base.BaseClass;
import com.dsalgo.qa.pages.ApplicationsOfArrayPage;
import com.dsalgo.qa.pages.ArrayPage;
import com.dsalgo.qa.pages.ArraysInPythonPage;
import com.dsalgo.qa.pages.ArraysUsingListPage;
import com.dsalgo.qa.pages.BasicOperationsListPage;
import com.dsalgo.qa.pages.Graph2Page;
import com.dsalgo.qa.pages.GraphPage;
import com.dsalgo.qa.pages.GraphRepresentationsPage;
import com.dsalgo.qa.pages.HomePage;
import com.dsalgo.qa.pages.MainPage;
import com.dsalgo.qa.pages.RegisterPage;
import com.dsalgo.qa.pages.SignInPage;
import com.dsalgo.qa.pages.TryEditorPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class ArraysPageTest extends BaseClass{
	
	MainPage mainPage;
	HomePage homePage;
	TryEditorPage tryEditPage;
	SignInPage signInPage;
	ArrayPage arrayPage;
	ArraysInPythonPage arraysInPythonPage;
	ArraysUsingListPage arraysUsingListPage;
	BasicOperationsListPage basicOperationsListPage;
	ApplicationsOfArrayPage applicationsOfArrayPage;
	
	
	public ArraysPageTest() {
		//call the super class constructor to get the properties
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		//Initialize the browser
		initialization();
		
		signInPage = new SignInPage();
		mainPage = new MainPage();
		homePage = new HomePage();
		tryEditPage = new TryEditorPage();
		arrayPage = new ArrayPage();
		arraysInPythonPage = new ArraysInPythonPage();
		arraysUsingListPage = new ArraysUsingListPage();
		tryEditPage = new TryEditorPage();
		basicOperationsListPage = new BasicOperationsListPage();
		applicationsOfArrayPage = new ApplicationsOfArrayPage();
	}

	@Test
	@Severity(SeverityLevel.NORMAL)
	@Description("Arrays Page Test Scenarios")
	@Story("Story Name: Scenarios related to Arrays Page")
	public void ArraysTestScenarios() throws InterruptedException {
		homePage = mainPage.clickGetStarted();
		signInPage = homePage.goToLoginPage();
		String username = prop.getProperty("username");
		String userpwd = prop.getProperty("password");
		homePage = signInPage.SuccessfulLogin(username,userpwd);
		arrayPage = homePage.goToArrayPage();
		String heading = arrayPage.getHeading();
		Assert.assertEquals(heading, "Array");
		arraysInPythonPage = arrayPage.goToArraysInPythonPage();
		tryEditPage = arraysInPythonPage.goToTryEditorPage();
		String text="Hello";
		String getMsg = tryEditPage.runCode("print(\"" + text + "\")");
		System.out.println(getMsg);
		Assert.assertTrue(getMsg.contains(text));
		driver.navigate().back();
		arraysUsingListPage = arraysInPythonPage.goToArraysUsingListPage();
		tryEditPage =arraysUsingListPage.goToTryEditorPage();
		driver.navigate().back();
		basicOperationsListPage = arraysUsingListPage.goToBasicOperationsListPage();
		tryEditPage= basicOperationsListPage.goToTryEditorPage();
		driver.navigate().back();
		applicationsOfArrayPage = basicOperationsListPage.goToApplicationsOfArrayPagePage();
		tryEditPage= applicationsOfArrayPage.goToTryEditorPage();
		driver.navigate().back();
		applicationsOfArrayPage.SignOut();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
