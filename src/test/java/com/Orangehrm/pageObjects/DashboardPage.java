package com.Orangehrm.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	//1
	public WebDriver driver;
	
	//2
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//3. Create Locator for 
	@FindBy(id="menu_dashboard_index")
	WebElement dashboardLink;
	
	//Create Locator for My Leave link
	@FindBy(xpath="//span[contains(text(),'My Leave')]")
	WebElement myLeaveLink;
	
	//4. Create method for DashboardLink
	public boolean dashboardLinkDisplayed() {
		boolean status = dashboardLink.isDisplayed();
		return status;
	}
	
	//Create method for My Leave link
	public boolean myLeaveLinkDisplayed() {
		boolean status = myLeaveLink.isDisplayed();
		return status;
	}
}
