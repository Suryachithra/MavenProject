package com.selenium.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_DemoQA {

	public static void main(String[] args) {
		
		// 1. Launch browser window(Chrome)      
		WebDriver driver = new ChromeDriver();
		
		// 2. Maximize the browser window
		driver.manage().window().maximize();
		
		// 3. Delete all the cookies
		driver.manage().deleteAllCookies();
		
		// 4. Enter URL and Launch the application (https://demoqa.com/automation-practice-form) 
		driver.get("https://demoqa.com/automation-practice-form");
		
		// 5. Wait for Page-load
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//img[@src='/images/Toolsqa.jpg']"), 0));
		
		//  6. Enter First name and Last name 
		WebElement firstname = driver.findElement(By.xpath("//input[@id='firstName']"));
		WebElement lastname = driver.findElement(By.xpath("//input[@id='lastName']"));
		firstname.isDisplayed();
		firstname.isEnabled();
		firstname.clear();
		lastname.isDisplayed();
		lastname.isEnabled();
		lastname.clear();
		firstname.sendKeys("suryachithra");
		lastname.sendKeys("test");
		
		// 7. Enter Email
		WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
		email.isDisplayed();
		email.isEnabled();
		email.clear();
		email.sendKeys("surya.test@gmail.com");
		
		//scroll down
		WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",submit);
		
		
		// 8. Select Gender (Female)
		WebElement gender = driver.findElement(By.xpath("//input[@value='Female']"));
		gender.click();
		
		// 9. Enter mobile number
		WebElement mobNumber = driver.findElement(By.xpath("//input[@id='userNumber']"));
		mobNumber.isDisplayed();
		mobNumber.isEnabled();
		mobNumber.clear();
		mobNumber.sendKeys("1234567890");
		
		// 10.Select DOB (1-Feb-1991)
		WebElement dob = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
		dob.click();
		WebElement month = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		Select monthOption = new Select(month);
		monthOption.selectByVisibleText("February");
		
		WebElement year = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		Select yearOption = new Select(year);
		yearOption.selectByVisibleText("1991");
		
		WebElement day = driver.findElement(By.xpath("//div[@aria-label='Choose Friday, February 1st, 1991']"));
		day.click();
	
		// 11.Search and Select Computer Science
		WebElement subject = driver.findElement(By.xpath("//div[contains(@class,'subjects-auto-complete__value-container subjects')]"));
		subject.isDisplayed();
		subject.isEnabled();
		subject.clear();
		subject.sendKeys("Computer Science");
		subject.sendKeys(Keys.ENTER);
		
		// 12.Select Hobbies as Sports and Reading 
		//WebElement sportsCheckbox = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-1']"));
		//WebElement readingCheckbox = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-2']"));
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(int i = 0; i<=checkboxes.size()-1;i++) {
			if(!checkboxes.get(i).isSelected()) {
				checkboxes.get(i).click();
				}
		}
		
		// 13.Upload photo
		WebElement uploadPhoto = driver.findElement(By.xpath("//input[@id='uploadPicture']"));
		uploadPhoto.click();
		
		
		// 16. Wait till file upload
		
		// 17.Submit Details
		WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
		submitButton.click();		
	
		// 18. Close browser window
		driver.close();
	}

}
