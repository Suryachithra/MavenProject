package com.framework.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AppTestClass extends BaseClass{
	
	@Test(priority=1, groups = {"Regression"})
	public void pageLogo() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//img[@alt='company-branding']"), 0));
		WebElement logo = driver.findElement(By.xpath("//img[@alt='company-branding']"));
		Boolean logoIsDisplayed = logo.isDisplayed();
		System.out.println(logoIsDisplayed);
	}

	@Test(dataProvider = "login",priority=2, groups = {"Regression","Sanity"})
	public void login(String user, String pass) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//button[@type='submit']"), 0));
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		username.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
	}
	@Test(priority=3, groups = {"Regression","Sanity","Smoke"}, dependsOnMethods= {"login"})
	public void forgotPassword() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//p[contains(@class,'login-forgot-header')]"), 0));
		WebElement forgotPassword = driver.findElement(By.xpath("//p[contains(@class,'login-forgot-header')]"));
		if(forgotPassword.isEnabled()) {
			forgotPassword.click();
		}
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
	}
	
	

}
