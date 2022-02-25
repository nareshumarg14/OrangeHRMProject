package com.Orangehrm.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Orangehrm.pageObjects.DashboardPage;
import com.Orangehrm.pageObjects.LoginPage;
import com.Orangehrm.testBase.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class TC001_VerifyUserLoggedIn extends BaseClass {
	@Test
	public void loginTest() throws IOException {
		LoginPage lp = new LoginPage(driver);
		DashboardPage dp = new DashboardPage(driver);
		
		lp.setUsername(prop.getProperty("username"));
		logger.info("Username entered is - " + prop.getProperty("username"));
		lp.setPassword(prop.getProperty("password"));
		logger.info("Password entered is - " + prop.getProperty("password"));
		
		//Calling method to capture screenshot
		capturescreen(driver, "loginTest - Before Clicking on Login button");
		
		lp.clickLoginButton();
		logger.info("Clicked on Login button");
		boolean linkStatus = dp.dashboardLinkDisplayed();
		Assert.assertEquals(linkStatus, true, "User Login failed");
		logger.info("User logged in successfully");
		
		//Calling method to capture screenshot
		capturescreen(driver, "loginTest - After User Login");
	}
	
	

}
