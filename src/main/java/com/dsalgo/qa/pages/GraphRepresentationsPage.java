package com.dsalgo.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgo.qa.base.BaseClass;

public class GraphRepresentationsPage extends BaseClass {
	
	@FindBy (xpath="//a[@href=\"/tryEditor\"]")
	WebElement TryHereBtn;
	
	
	public GraphRepresentationsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validatePageTitle() {
		return driver.getTitle().contains("Graph Representations");
				
	}
	
	public String verifyPageTitle() {
		
		return driver.getTitle();
	}
	
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	public String getHeading() {
		return driver.findElement(By.xpath("//p[contains(text(),'Graph Representations')]")).getText();
	}
	
	public TryEditorPage goToTryEditorPage() {
		TryHereBtn.click();
		
		return new TryEditorPage();
	}

}
