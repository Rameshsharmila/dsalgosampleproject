package com.dsalgo.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgo.qa.base.BaseClass;

public class ApplicationsOfArrayPage extends BaseClass{
	
	@FindBy (xpath="//a[@href=\"/tryEditor\"]")
	WebElement TryHereBtn;
	
	@FindBy (xpath="//a[@href=\"/logout\"]")
	WebElement SignOutLink;
	
	public ApplicationsOfArrayPage() {
		PageFactory.initElements(driver, this);
	}

	public TryEditorPage goToTryEditorPage() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);" , TryHereBtn);
		TryHereBtn.click();
		
		return new TryEditorPage();
	}
	
	public void SignOut() {
		SignOutLink.click();
	}
	
}
