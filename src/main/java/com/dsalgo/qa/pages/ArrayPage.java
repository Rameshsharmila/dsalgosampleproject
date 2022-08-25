package com.dsalgo.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.dsalgo.qa.base.BaseClass;

public class ArrayPage extends BaseClass {

	@FindBy(xpath="//a[@href='arrays-in-python']")
	WebElement arraysInPythonLink;
	
	@FindBy(xpath="//a[@href='arrays-using-list']")
	WebElement arraysUsingListLink;
	
	public ArrayPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public ArraysInPythonPage goToArraysInPythonPage() {
		arraysInPythonLink.click();
		
		return new ArraysInPythonPage();
	}
	
	public String verifyPageTitle() {
		
		return driver.getTitle();
	}
	
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	public String getHeading() {
		return driver.findElement(By.xpath("//h4[contains(text(),'Array')]")).getText();
	}
}
