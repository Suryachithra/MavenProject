package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_Frames {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// 1.Launch Chrome Browser
		driver = new ChromeDriver();

		// 2.Maximize the browser window
		driver.manage().window().maximize();

		// 3.Launch the application
		driver.get("https://demoqa.com/");
		
		// 4.Locate elements
		WebElement alertWindowsFrames = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", alertWindowsFrames);
		
		WebElement frames = driver.findElement(By.xpath("//span[text()='Frames']"));
		js.executeScript("arguments[0].click()", frames);
        
		// 5.Print frame element text
		switchToFrame("frame1");
		
		switchToFrame("frame2");
		
		// 6.Print main window element text
		switchToMainWindow();
		WebElement text = driver.findElement(By.xpath("//div[contains(text(),'Sample Iframe page There are 2 Iframes')]"));
		text.getText();

		// 7.Close browser window
		driver.quit();

	}
	
	//switch to frame and get text 
	public static void switchToFrame(String frameName) {
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='"+frameName+"']"));
		driver.switchTo().frame(frame);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//iframe[@id='"+frameName+"']")));
		
		WebElement textInsideframe = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		textInsideframe.getText();
	}
	
	//switch back to the main window 
    public static void switchToMainWindow() {
        String mainWindowHandle = driver.getWindowHandle();
        driver.switchTo().window(mainWindowHandle);
    }

}
