package com.dsalgo.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgo.qa.base.BaseClass;

public class GraphPage extends BaseClass {
	
	@FindBy(xpath="//a[@href=\"graph\"]")
	WebElement graphLink;
	
	@FindBy(xpath="//a[@href=\"graph-representations\"]")
	WebElement graphRepLink;
	
	public GraphPage() {
		PageFactory.initElements(driver, this);
	}
	
	public Graph2Page goToGraphPage() {
		graphLink.click();
		
		return new Graph2Page();
	}
	
	public GraphRepresentationsPage goToGraphRepPage() {
		graphRepLink.click();
		return new GraphRepresentationsPage();
	}
	
	public String verifyPageTitle() {
		
		return driver.getTitle();
	}
	
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	public String getHeading() {
		return driver.findElement(By.xpath("//h4[contains(text(),'Graph')]")).getText();
	}
}
