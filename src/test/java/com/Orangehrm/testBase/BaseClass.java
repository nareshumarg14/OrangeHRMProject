package com.Orangehrm.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	//1. Defining global Webdriver
	public WebDriver driver;
	public Properties prop;
	
	//Log4j step
	public Logger logger = LogManager.getLogger(this.getClass());
	
	//2. Launch Browser, Open Application
	@BeforeClass
	@Parameters("browser")
	public void setup(String browserName) throws IOException {
		//Code to connect to properties file
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\resources\\config.properties");
		prop.load(fis);
		
		//Opening browser based on parameter passed from testNg.xml
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("*****Chrome Browser is launched successfully*****");
		} else if(browserName.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger.info("*****Edge Browser is launched successfully*****");
		} else if(browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info("*****Firefox Browser is launched successfully*****");
		} else {
			System.out.println("Please pass the browser names as chrome / edge / firefox");
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		logger.info("Orange HRM application is opened and the url is -" + prop.getProperty("url"));
	}
	
	//3. To close the application
	@AfterClass
	public void tearDown() {
		driver.quit();
		logger.info("*****Orange HRM application is closed*****");
	}
	
	/***
	 * @author Naresh
	 * @Description This method is for capturing screenshots of the application
	 * @param driver
	 * @param testname
	 * @throws IOException
	 * @Date 23rd Feb 2022
	 */
	public void capturescreen(WebDriver driver, String testname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "\\screenshots\\" + testname+".png");
		FileUtils.copyFile(source, target);
		logger.info("*****Screenshot captured successfully*****");
	}
}
