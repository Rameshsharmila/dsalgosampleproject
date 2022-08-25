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
import com.dsalgo.qa.pages.TryEditorPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class TryEditorPageTest extends BaseClass{
	
	TryEditorPage tryEditorPage;
	
	public TryEditorPageTest() {
		//call the super class constructor to get the properties
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		//Initialize the browser
		initialization();
		tryEditorPage = new TryEditorPage();
	}
	
	@Test
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify the Python code in Try Editor Page")
	@Story("Verify the Python code in Try Editor Page")
	public void runCodeAndVerify() throws InterruptedException {
		String text="Hello";
		String getMsg = tryEditorPage.runCode("print(\"" + text + "\")");
		System.out.println(getMsg);
		Assert.assertTrue(getMsg.contains(text));
	}
	
	@Test
	public void runCodeandVerifyAlert() throws InterruptedException {
		tryEditorPage.verifyAlert("Hello");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
