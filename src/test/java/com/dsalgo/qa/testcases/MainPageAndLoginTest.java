package com.dsalgo.qa.testcases;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dsalgo.qa.base.BaseClass;
import com.dsalgo.qa.pages.HomePage;
import com.dsalgo.qa.pages.MainPage;
import com.dsalgo.qa.pages.RegisterPage;
import com.dsalgo.qa.pages.SignInPage;
import com.dsalgo.qa.util.excelDataProvider;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;

public class MainPageAndLoginTest extends BaseClass{

	MainPage mainPage;
	SignInPage signInPage;
	HomePage homePage;
	
	public MainPageAndLoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		//Initialize the browser
		initialization();	
		mainPage = new MainPage();
		homePage = new HomePage();
		signInPage = new SignInPage();
		
	}
	
	@DataProvider (name="UserDetails")
	public String[][] getDataFromExcel() throws IOException {
		
		String path = System.getProperty("user.dir") + "/src/main/java/com/dsalgo/qa/util/UserDetails.xlsx";
		
		int rowNum = excelDataProvider.getRowCount(path, "Sheet1");
		int colNum = excelDataProvider.getCellCount(path, "Sheet1", 1);
		
		String usrdata[][] = new String[rowNum][colNum];
		
		for(int i=1; i<=rowNum; i++) {
			for(int j=0; j<colNum-1; j++) {
				usrdata[i-1][j] = excelDataProvider.getCellData(path, "Sheet1", i, j);
			}
		}

		return usrdata;
	}
	
	@Test(dataProvider="UserDetails")
	@Severity(SeverityLevel.MINOR)
	@Description("Test Case to verify the user is not allowed to login")
	@Story("Story Name: To check the unsuccessful login scenario")
	public void verifyLogin(String uname, String pwd) {
		homePage = mainPage.clickGetStarted();
		signInPage = homePage.goToLoginPage();
		String unsuccerrormsg= signInPage.UnsuccessfulLogin(uname, pwd);
		System.out.println("Invalid username or password  ");		
	
	}
	
	
	
	@Test
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case to verify the user is logged in successfully")
	@Story("Story Name: To check the successful login scenario")
	public void successfulLogin() {
		String title = mainPage.getPageTitle();
		Assert.assertEquals(title,"Numpy Ninja5");
		Assert.assertTrue(mainPage.validatePageText());
		homePage = mainPage.clickGetStarted();
		signInPage = homePage.goToLoginPage();
		String username = prop.getProperty("username");
		String userpwd = prop.getProperty("password");
		homePage = signInPage.SuccessfulLogin(username,userpwd);
		String loggedinmsg = homePage.messageOnTopScreen();
		Assert.assertEquals(loggedinmsg,"You are logged in");
		homePage.SignOut();
		String loggedoutmsg = homePage.messageOnTopScreen();
		Assert.assertEquals(loggedoutmsg,"Logged out successfully");

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
