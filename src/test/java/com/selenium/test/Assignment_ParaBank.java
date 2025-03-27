package com.selenium.test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment_ParaBank {

	static WebDriver driver = null;
	
	public static void main(String[] args) {

		// 1. Launch browser window(Chrome) 
		driver = new ChromeDriver();
		
		// 2. Maximize the browser window 
		driver.manage().window().maximize();
		
		// 3. Delete all the cookies  
		driver.manage().deleteAllCookies();
		
		// 4. Enter URL and Launch the application (https://parabank.parasoft.com/parabank/index.htm) 
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
		// 5. Verify application title (ParaBank | Welcome | Online Banking)
		String actualTitle = driver.getTitle();
		String expectedTitle = "ParaBank | Welcome | Online Banking";
		Assert.assertEquals(actualTitle, expectedTitle);
		
		// 6. Verify application logo
		WebElement logo = driver.findElement(By.xpath("//img[@title='ParaBank']"));
		Assert.assertTrue(logo.isDisplayed());
		
		// 7. Verify application caption (Experience the difference)
		WebElement caption = driver.findElement(By.xpath("//p[@class='caption']"));
		String actualCaption = caption.getText();
		String expCaption = "Experience the difference";
		Assert.assertEquals(actualCaption, expCaption);
		
		// 8. Enter Invalid credentials in Username and Password textboxes
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.clear();
		username.sendKeys("invaliduser");
		
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.clear();
		password.sendKeys("invalidpassword");
		
		// 9. Verify button label (LOG IN) and Click on Login Button
		WebElement login = driver.findElement(By.xpath("//input[@value='Log In']"));
		
		//Verify label
		String actualLabel = login.getAttribute("value").toUpperCase();
		String expLabel = "LOG IN";
		Assert.assertEquals(actualLabel, expLabel);
		
		//click login button
		login.click();
		
		// 10. Verify error message is coming
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//p[@class='error']"), 0));
		
		WebElement errorMessage = driver.findElement(By.xpath("//p[@class='error']"));
		Assert.assertTrue(errorMessage.isDisplayed());
		
		// 11. Click on Admin page link
		WebElement adminPage = driver.findElement(By.xpath("//a[text()='Admin Page']"));
		adminPage.click();
		
		// 12. Wait for admin page
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//h1[@class='title' and contains(text(),'Administration')]"), 0));
		
		// 13. Select Data access mode as ' SOAP'
		radioButtonSelection("soap");
		
		// 14. Scroll-down till Loan provider
		// 15. Select Loan provider as 'Web Service'
		selectLoanProvider("Web Service");
		
		// 16. Click on Submit button
		WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
		submitButton.click();
		
		// 17. wait for Successful submission message
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//b[text()='Settings saved successfully.']"), 0));
		
		// 18. Click on Services Link
		WebElement servicesLink = driver.findElement(By.xpath("//ul[@class='leftmenu']//a[text()='Services']"));
		servicesLink.click();
		
		// 19. Wait for Services page
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//span[text()='Bookstore services:']"), 0));
		
		// 20. Scroll-down till Bookstore services
		WebElement bokstoreServices = driver.findElement(By.xpath("//span[text()='Bookstore services:']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", bokstoreServices);	
		
		// 21. Get total rows, columns in the bookstore service table
		// 22. Get Column headers of book store services table
		// 23. Get all the data from book store service table
		// 24. Close browser window
	}
	
	public static void radioButtonSelection(String option) {
		WebElement dataAccessMode = driver.findElement(By.xpath("//input[@value='"+option+"']"));
		dataAccessMode.click();
	}
	
	public static void selectLoanProvider(String option) {
		WebElement loanProvider = driver.findElement(By.xpath("//select[@id='loanProvider']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", loanProvider);		
		Select s = new Select(loanProvider);
		s.selectByVisibleText(option);
	}

}
