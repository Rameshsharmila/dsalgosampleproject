package com.dsalgo.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgo.qa.base.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy (xpath="//a[@href=\"/register\"]")
	WebElement RegisterLink;
	
	@FindBy (xpath="//a[@href=\"/login\"]")
	WebElement SignInLink;
	
	@FindBy (xpath="//a[@href=\"/logout\"]")
	WebElement SignOutLink;
	
	@FindBy (xpath="//h5[text()=\"Data Structures-Introduction\"]//parent::div/a")
	WebElement DataStructuresBtn;
	
	@FindBy (xpath="//h5[text()=\"Array\"]//parent::div/a")
	WebElement ArrayBtn;
	
	@FindBy (xpath="//h5[text()=\"Linked List\"]//parent::div/a")
	WebElement LinkedList;
	
	@FindBy (xpath="//h5[text()=\"Stack\"]//parent::div/a")
	WebElement StackBtn;
	
	@FindBy (xpath="//h5[text()=\"Queue\"]//parent::div/a")
	WebElement QueueBtn;
	
	@FindBy (xpath="//h5[text()=\"Tree\"]//parent::div/a")
	WebElement TreeBtn;
	
	
	@FindBy (xpath="//a[@class='dropdown-item'][@href='/tree']")
	WebElement TreeDd;
	
	@FindBy (xpath="//h5[text()=\"Graph\"]//parent::div/a")
	WebElement GraphBtn;
	
	@FindBy (xpath="//a[@class='dropdown-item'][@href='/graph']")
	WebElement GraphDd;
	
	@FindBy (xpath="//div[@role=\"alert\"]")
	WebElement MsgOnTop;
	//New Account Created. You are logged in as qatest12345
	//Logged out successfully
	//You are logged in

	
	@FindBy (xpath="//div[@class=\"navbar-nav\"]/ul/a[1]")
	WebElement usrNameOnTop;
	//qatest12345
	
	@FindBy (xpath="//div[@role=\"alert\"]")
	WebElement signOutLink;
	
	
	@FindBy (xpath="//a[@href='#'][@class='nav-link dropdown-toggle']")
	WebElement Ddmain;
	
	@FindBy (xpath="//a[@class='dropdown-item'][@href='/array']")
	WebElement ArrayDd;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public RegisterPage goToRegisterPage() {
		RegisterLink.click();
		return new RegisterPage();
	}
	
	public SignInPage goToLoginPage() {
		SignInLink.click();
		return new SignInPage();
	}
	
	public ArrayPage goToArrayPage() {
		Ddmain.click();
		ArrayDd.click();
		return new ArrayPage();
	}
	
	public void SignOut() {
		SignOutLink.click();
	}
	
	public TreePage goToTreePageviaBtn() {
		TreeBtn.click();
		
		return new TreePage();
		
	}
	
	public TreePage goToTreePageviaDropdown() {
		TreeDd.click();
		return new TreePage();
	}
	
	public GraphPage goToGraphPageviaBtn() {
		GraphBtn.click();
		
		return new GraphPage();
		
	}
	
	public GraphPage goToGraphPageviaDropdown() {
		GraphDd.click();
		
		return new GraphPage();
		
	}
	
	
	public String messageOnTopScreen() {
		return MsgOnTop.getText().toString();
	}
	
	public String NotLoggedIn() {
		return MsgOnTop.getText().toString();
	}

}
