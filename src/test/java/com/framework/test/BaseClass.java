package com.framework.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseClass {

	static WebDriver driver = null;
	@BeforeMethod(alwaysRun = true)
	@Parameters("Browser")
	public void launchBrowser(String browser) {
		
		switch(browser) {
		case "chrome":
		driver = new ChromeDriver();
		System.out.println("Launched " + browser + " browser");
		break;
		
		case "firefox":
			driver = new FirefoxDriver();
			System.out.println("Launched " + browser + " browser");
			break;
			
		case "edge":
			driver = new EdgeDriver();
			System.out.println("Launched " + browser + " browser");
			break;
		
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		

	}
	
	@BeforeMethod(alwaysRun = true, dependsOnMethods = {"launchBrowser"})
	public void launchApplication() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
	}
	
	
	
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider(name ="login")
	public String [][] testData(){
		String [][] loginCred = {{"Admin","admin123"}, {"invaliduser","invalidpass"}};
		return loginCred;
	}
}
