package com.Orangehrm.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Orangehrm.pageObjects.DashboardPage;
import com.Orangehrm.pageObjects.LoginPage;
import com.Orangehrm.testBase.BaseClass;

public class TC003_VerifyMyLeaveLinkDisplayed extends BaseClass {
	
	@Test
	public void checkMyLeaveLinkDisplayedTest() throws IOException {
		LoginPage lp = new LoginPage(driver);
		DashboardPage dp = new DashboardPage(driver);
		
		//Login Steps
		lp.setUsername(prop.getProperty("username"));
		logger.info("Username entered is - " + prop.getProperty("username"));
		lp.setPassword(prop.getProperty("password"));
		logger.info("Password entered is - " + prop.getProperty("password"));
		lp.clickLoginButton();
		logger.info("User Logged in successfully");
		
		//Check if My Leave link is displayed
		boolean linkStatus = dp.myLeaveLinkDisplayed();
		Assert.assertTrue(linkStatus, "My Leave link is not displayed on Dashboard Page");
		logger.info("My Leave link is displayed on Dashboard Page");
		
		capturescreen(driver, "checkMyLeaveLinkDisplayedTest");
		
	}

}
