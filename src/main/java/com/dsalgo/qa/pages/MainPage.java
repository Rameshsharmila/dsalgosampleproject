package com.dsalgo.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgo.qa.base.BaseClass;

import io.qameta.allure.Step;

public class MainPage extends BaseClass{
	
	@FindBy (xpath="//button[@class='btn']")
	WebElement getStarted;
	
	@FindBy(xpath="//div[@class='content']/h1")
	WebElement heading;
	
	public MainPage() {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Verify the Page Text for Main Page")
	public boolean validatePageText() {
		return heading.getText().contains("Preparing for the Interviews");
	}

	@Step("Get the Main Page title")
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	@Step("Click on get started to go to home page")
	public HomePage clickGetStarted() {
		getStarted.click();
		return new HomePage();
	}
}
