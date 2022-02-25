package com.Orangehrm.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//1
	public WebDriver driver;
	
	//2
	public LoginPage(WebDriver driver) {
		this.driver = driver; //Assigning the driver passed from Test Case to local Webdriver driver.
		PageFactory.initElements(driver, this);
	}
	
	//3 --> Locator for Username field
	@FindBy(id="txtUsername")
	WebElement txtUsername;
	
	//4 --> Locator for password field.
	@FindBy(name = "txtPassword")
	WebElement txtPassword;
	
	//5 --> Locator for Login button
	@FindBy(xpath="//input[@type='submit']")
	WebElement btnLogin;
	
	//6. Method to enter username
	public void setUsername(String un) {
		txtUsername.clear();
		txtUsername.sendKeys(un);
	}
	
	//7. Method to enter password
	public void setPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	
	//8. Method to click on Login button
	public void clickLoginButton() {
		btnLogin.click();
	}


}
