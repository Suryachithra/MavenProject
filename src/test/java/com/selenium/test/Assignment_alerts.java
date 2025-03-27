package com.selenium.test;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_alerts {
	
		static WebDriver driver;
	public static void main(String[] args) {
		
		// 1.Launch Chrome Browser
		driver = new ChromeDriver();
					       
		// 2.Maximize the browser window
		driver.manage().window().maximize();
					       
		// 3.Launch the application
		driver.get("https://demoqa.com/");
		
		// 4.Locate Alert buttons
		WebElement alertWindowsFrames = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", alertWindowsFrames);
		
		WebElement alerts = driver.findElement(By.xpath("//span[text()='Alerts']"));
		alerts.click();
		
		// 5.Launch Information alert
		alertHandle("alert");
					       
		// 6.Print Alert message
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		
		// 7.Click on OK button
		alert.accept();
					       
		// 8.Launch confirmation alert
		alertHandle("confirm");
		
		// 9.Print Alert message
		System.out.println(alert.getText());	 
		
		// 10.Click on Cancel button
		alert.dismiss();
		
		// 11.Launch prompt alert with dialog box alert
		js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.id("promtButton")));
		alertHandle("promt");
		
		// 12.Print message
		System.out.println(alert.getText());
			
		// 13.Enter Text in Alert
		alert.sendKeys("suryachithra");
					       
		// 14.Click on OK button
		alert.accept();

	}
	
		public static void alertHandle(String alertName) {
			WebElement alertsButton = driver.findElement(By.xpath("//button[@id='"+alertName+"Button']"));
			alertsButton.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.alertIsPresent());
		}

}
