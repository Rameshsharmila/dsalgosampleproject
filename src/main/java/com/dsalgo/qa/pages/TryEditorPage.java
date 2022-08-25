package com.dsalgo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgo.qa.base.BaseClass;

public class TryEditorPage extends BaseClass{

	@FindBy (xpath="//form[@id=\"answer_form\"]/div/div/div/textarea")
	WebElement textEditor;
	
	@FindBy (xpath="//button[@type=\"button\"]")
	WebElement runBtn;
	
	@FindBy (xpath="//pre[@id=\"output\"]")
	WebElement outputMsg;
	
	public TryEditorPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String runCode(String code) throws InterruptedException {
		Thread.sleep(100);
		textEditor.sendKeys(code);
		runBtn.click();
		String msg = outputMsg.getText();
		
		return msg;
	}
	
	
	public void verifyAlert(String code) throws InterruptedException {
		Thread.sleep(100);
		textEditor.sendKeys(code);
		runBtn.click();
		String alerttext = driver.switchTo().alert().getText();
		System.out.println(alerttext);
		driver.switchTo().alert().accept();
	}
}
