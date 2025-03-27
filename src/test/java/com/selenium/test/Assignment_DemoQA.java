package com.selenium.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_DemoQA {

	static WebDriver driver = null;

	public static void main(String[] args) {

		// 1. Launch browser window(Chrome)
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--window-size=1920,1080");

		driver = new ChromeDriver();

		// 2. Maximize the browser window
		driver.manage().window().maximize();

		// 3. Delete all the cookies
		driver.manage().deleteAllCookies();

		// 4. Enter URL and Launch the application
		// (https://demoqa.com/automation-practice-form)
		driver.get("https://demoqa.com/automation-practice-form");

		// 5. Wait for Page-load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//h1[text()='Practice Form']"), 0));

		// 6. Enter First name and Last name
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
		

		// 8. Select Gender (Female)
		selectGender("Female");

		// 9. Enter mobile number
		WebElement mobNumber = driver.findElement(By.xpath("//input[@id='userNumber']"));
		mobNumber.isDisplayed();
		mobNumber.isEnabled();
		mobNumber.clear();
		mobNumber.sendKeys("1234567890");

		// 10.Select DOB (1-Feb-1991)
		selectDOB("1", "February", "1991");

		// 11.Search and Select Computer Science
		selectSubject("Computer Science");

		// 12.Select Hobbies as Sports and Reading
		String [] hobbies = {"Sports", "Reading"};
		selectHobbies(hobbies);

		// 13.Upload photo
		// 14. Wait till window open to upload the file		
		// 15. Upload file
		// 16. Wait till file upload
		String filePath = System.getProperty("user.dir")+"\\Files\\img13.jpg";
		uploadPhoto(filePath);
		
		// 17.Submit Details
		WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", submitButton);	

		// 18. Close browser window
		driver.quit();
	}

	public static void selectGender(String option) {
		WebElement gender = driver.findElement(By.xpath("//label[text()='"+option+"']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", gender);
		gender.click();
	}

	public static void selectDOB(String date, String month, String year) {
		// open calendar
		WebElement dobField = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
		dobField.click();

		// Wait for calendar
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions
				.numberOfElementsToBeMoreThan(By.xpath("//select[@class='react-datepicker__month-select']"), 0));

		// Select month
		WebElement monthDropdown = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		Select selectMonth = new Select(monthDropdown);
		selectMonth.selectByVisibleText(month);

		// Select year
		WebElement yearDropdown = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		Select selectYear = new Select(yearDropdown);
		selectYear.selectByVisibleText(year);

		// Select the date
		WebElement dateText = driver
				.findElement(By.xpath("//div[text()='" + date + "' and contains(@aria-label,'" + month + "')]"));
		dateText.click();
	}

	public static void selectSubject(String subjectName) {
		WebElement subjects = driver.findElement(By.xpath("//div[contains(@class,'subjects-auto-complete__value')]"));

		// scroll down to element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", subjects);

		// Enter input values
		Actions actions = new Actions(driver);
		actions.sendKeys(subjects, subjectName).perform();

		// Wait until the suggestion is getting displayed
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[text()='" + subjectName + "' and contains(@class,'option')]"), 0));

		// Select the option
		WebElement suggestion = driver.findElement(By.xpath("//div[text()='"+subjectName+"' and contains(@class,'option')]"));
		suggestion.click();
	}
	
	public static void selectHobbies(String[] hobbies) {
		for(String hobby : hobbies) {
			WebElement element = driver.findElement(By.xpath("//label[text()='"+hobby+"']"));
			if(!element.isSelected()) {
				element.click();
			}
		}
	}
	
	public static void uploadPhoto(String filePath) {
		WebElement uploadPhoto = driver.findElement(By.xpath("//input[@id='uploadPicture']"));
		uploadPhoto.sendKeys(filePath);
	}
	
	
}
