package com.dsalgo.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgo.qa.base.BaseClass;

public class ArraysUsingListPage extends BaseClass {

	@FindBy(xpath="//a[@href='arrays-using-list']")
	WebElement arraysUsingListLink;
	
	@FindBy(xpath="//a[@href='/array/basic-operations-in-lists/']")
	WebElement basicOpListLink;
	
	@FindBy (xpath="//a[@href=\"/tryEditor\"]")
	WebElement TryHereBtn;
	
	public ArraysUsingListPage() {
		PageFactory.initElements(driver, this);
	}
	
	public TryEditorPage goToTryEditorPage() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);" , TryHereBtn);
		TryHereBtn.click();
		
		return new TryEditorPage();
	}
	
	public BasicOperationsListPage goToBasicOperationsListPage() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,0)");
		basicOpListLink.click();
		
		return new BasicOperationsListPage();
	}
}
