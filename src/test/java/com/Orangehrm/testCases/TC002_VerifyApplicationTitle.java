package com.Orangehrm.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Orangehrm.testBase.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_VerifyApplicationTitle extends BaseClass{	
	@Test
	public void checkApplicationTitleTest() throws IOException {
		String appTitle = driver.getTitle();
		Assert.assertEquals(appTitle, "OrangeHRM","Orange HRM application is not launched");
		logger.info("Orange HRM application is opened");
		
		capturescreen(driver, "checkApplicationTitleTest");
	}
	

}
