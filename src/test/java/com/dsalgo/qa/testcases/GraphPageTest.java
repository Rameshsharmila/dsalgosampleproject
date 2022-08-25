package com.dsalgo.qa.testcases;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dsalgo.qa.base.BaseClass;
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


public class GraphPageTest extends BaseClass{
	
	RegisterPage registerPage;
	MainPage mainPage;
	HomePage homePage;
	GraphPage graphPage;
	Graph2Page graph2Page;
	GraphRepresentationsPage graphRepPage;
	TryEditorPage tryEditPage;
	SignInPage signInPage;
	
	public GraphPageTest() {
		//call the super class constructor to get the properties
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		//Initialize the browser
		initialization();
		registerPage = new RegisterPage();
		signInPage = new SignInPage();
		mainPage = new MainPage();
		homePage = new HomePage();
		graphPage = new GraphPage();
		graph2Page = new Graph2Page();
		graphRepPage = new GraphRepresentationsPage();
		tryEditPage = new TryEditorPage();
	}
	
	@Test
	@Severity(SeverityLevel.NORMAL)
	@Description("Graph Page Test Scenarios")
	@Story("Story Name: Scenarios related to Graph Page")
	public void GraphTestScenarios() throws InterruptedException {
		homePage = mainPage.clickGetStarted();
		signInPage = homePage.goToLoginPage();
		String username = prop.getProperty("username");
		String userpwd = prop.getProperty("password");
		homePage = signInPage.SuccessfulLogin(username,userpwd);
		graphPage = homePage.goToGraphPageviaBtn();
		String gtitle = graphPage.verifyPageTitle();
		Assert.assertEquals(gtitle, "Graph");
		String gheading = graphPage.getHeading();
		Assert.assertEquals(gheading, "Graph");
		String gurl = graphPage.getCurrentURL();
		Assert.assertEquals(gurl,"https://dsportalapp.herokuapp.com/graph/");
		graph2Page = graphPage.goToGraphPage();
		tryEditPage = graph2Page.goToTryEditorPage();
		
		String text="Hello";
		String getMsg = tryEditPage.runCode("print(\"" + text + "\")");
		System.out.println(getMsg);
		Assert.assertTrue(getMsg.contains(text));
	}
	
	@Test
	@Severity(SeverityLevel.NORMAL)
	@Description("Graph Representations Page Test Scenarios")
	@Story("Story Name: Scenarios related to Graph Representations Page")
	public void GraphRepresentationTestScenarios() throws InterruptedException {
		homePage = mainPage.clickGetStarted();
		signInPage = homePage.goToLoginPage();
		String username = prop.getProperty("username");
		String userpwd = prop.getProperty("password");
		homePage = signInPage.SuccessfulLogin(username,userpwd);
		graphPage = homePage.goToGraphPageviaBtn();
		graphRepPage = graphPage.goToGraphRepPage();
		
		//Verify the url,heading and title of Graph Representations Page
		String grURL = graphRepPage.getCurrentURL();
		String grheading = graphRepPage.getHeading();
		String grtitle = graphRepPage.verifyPageTitle();		
		Assert.assertEquals(grURL, "https://dsportalapp.herokuapp.com/graph/graph-representations/");
		Assert.assertEquals(grheading, "Graph Representations");
		Assert.assertEquals(grtitle, "Graph Representations");
		
		//Verify the functionality of tryEditor Page
		tryEditPage = graphRepPage.goToTryEditorPage();
		String text="Hello";
		String getMsg = tryEditPage.runCode("print(\"" + text + "\")");
		System.out.println(getMsg);
		Assert.assertTrue(getMsg.contains(text));
				
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
