package com.dsalgo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgo.qa.base.BaseClass;

import io.qameta.allure.Step;

public class Graph2Page extends BaseClass{
	
	@FindBy (xpath="//a[text()=\"Graph Representations\"]")
	WebElement GraphRepLink;
	
	
	@FindBy (xpath="//a[@href=\"/tryEditor\"]")
	WebElement TryHereBtn;
	
	
	
	public Graph2Page() {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Verify the Page Title for Graph Page")
	public boolean validatePageTitle() {
		return driver.getTitle().contains("Graph");
				
	}
	
	public GraphRepresentationsPage goToGraphRepPage() {
		GraphRepLink.click();
		return new GraphRepresentationsPage();
	}
	
	public TryEditorPage goToTryEditorPage() {
		TryHereBtn.click();
		
		return new TryEditorPage();
	}

}
