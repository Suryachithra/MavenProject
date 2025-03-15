package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SeleniumLocators {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://parabank.parasoft.com/parabank/index.htm");

		String title = driver.getTitle();
		Assert.assertEquals(title, "ParaBank | Welcome | Online Banking");

		// Locate logo using 'Xpath' locator
		driver.findElement(By.xpath("//img[@title='ParaBank']"));

		// Locate text using 'Xpath' locator
		driver.findElement(By.xpath("//p[contains(text(),'Experience')]"));

		// Locate Administration using 'className' locator
		driver.findElement(By.className("admin"));

		// Locate Solutions using 'className' locator
		driver.findElement(By.className("Solutions"));

		// Locate About Us link using 'cssSelector' locator
		driver.findElement(By.cssSelector("ul[class='leftmenu'] > li:nth-child(2) > a[href='about.htm']"));

		// Locate Services link using 'cssSelector' locator
		driver.findElement(By.cssSelector("ul[class='leftmenu'] > li:nth-child(3) > a[href='services.htm']"));

		// Locate Products link using 'cssSelector' locator
		driver.findElement(By.cssSelector(
				"ul[class='leftmenu'] > li:nth-child(4) > a[href='http://www.parasoft.com/jsp/products.jsp']"));

		// Locate Locations link using 'cssSelector' locator
		driver.findElement(By.cssSelector(
				"ul[class='leftmenu'] > li:nth-child(5) > a[href='http://www.parasoft.com/jsp/pr/contacts.jsp']"));

		// Locate Admin Page link using 'linkTest' locator
		driver.findElement(By.linkText("Admin Page"));
		
		// Locate text using 'Xpath' locator
		driver.findElement(By.xpath("//ul[@class='services')"));

		// Locate username field using 'name' locator
		driver.findElement(By.name("username"));

		// Locate password field using 'name' locator
		driver.findElement(By.name("password"));

		// Locate Login Button using 'Xpath' locator
		driver.findElement(By.xpath("//input[@value='Log In']"));

		// Locate 'Forgot login info?' link using 'Partial linkText' locator
		driver.findElement(By.partialLinkText("Forgot login"));

		// Locate 'Register' link using 'linkText' locator
		driver.findElement(By.linkText("Register"));

		// Locate 'home' link using 'cssSelector' locator
		// parent: li[class='home']
		// target: a[href='index.htm']
		driver.findElement(By.cssSelector("li[class='home'] > a[href='index.htm']"));

		// Locate 'about' link using 'cssSelector' locator
		driver.findElement(By.cssSelector("li[class='aboutus'] > a[href='about.htm']"));

		// Locate 'contact' link using 'cssSelector' locator
		driver.findElement(By.cssSelector("li[class='contact'] > a[href='contact.htm']"));

		// Locate 'ATM Services' using 'className' locator
		driver.findElement(By.className("captionone"));

		// Locate 'Withdraw Funds' link using 'linkText' locator
		driver.findElement(By.linkText("Withdraw Funds"));

		// Locate 'Transfer Funds' link using 'cssSelector' locator
		driver.findElement(
				By.cssSelector("ul[class='services']  > li:nth-child(3) > a[href='services/ParaBank?wsdl']"));

		// Locate 'Check Balances' link using 'linkText' locator
		driver.findElement(By.linkText("Check Balances"));

		// Locate 'Make Deposits' link using 'linkText' locator
		driver.findElement(By.linkText("Make Deposits"));

		// Locate 'Online Services' using 'className' locator
		driver.findElement(By.className("captiontwo"));

		// Locate 'Bill Pay' link using 'linkText' locator
		driver.findElement(By.linkText("Bill Pay"));

		// Locate 'Check Balances' link using 'linkText' locator
		driver.findElement(By.linkText("Account History"));

		// Locate 'Transfer Funds' link using 'cssSelector' locator
		driver.findElement(
				By.cssSelector("ul[class='servicestwo']  > li:nth-child(4) > a[href='services/bank?_wadl&_type=xml']"));

		// Locate 'READ MORE' using 'cssSelector' locator
		driver.findElement(By.cssSelector("p[class='more'] > a[href='services.htm']"));

		// Locate 'Latest News' using 'className' locator
		driver.findElement(By.className("captionthree"));

		// Locate 'ParaBank Is Now Re-Opened' link using 'linkText' locator
		driver.findElement(By.linkText("ParaBank Is Now Re-Opened"));

		// Locate 'New! Online Bill Pay' link using 'linkText' locator
		driver.findElement(By.linkText("New! Online Bill Pay"));

		// Locate 'New! Online Account Transfers' link using 'linkText' locator
		driver.findElement(By.linkText("New! Online Account Transfers"));

		// Locate 'READ MORE' using 'cssSelector' locator
		driver.findElement(By.cssSelector("p[class='more'] > a[href='news.htm']"));

		// Locate 'Home' link using 'cssSelector' locator
		driver.findElement(
				By.cssSelector("div[id ='footerPanel'] > ul:nth-child(1) > li:nth-child(1)>a[href='index.htm']"));

		// Locate 'About Us' link using 'cssSelector' locator
		driver.findElement(
				By.cssSelector("div[id ='footerPanel'] > ul:nth-child(1) > li:nth-child(2)>a[href='about.htm']"));

		// Locate 'Services' link using 'cssSelector' locator
		driver.findElement(
				By.cssSelector("div[id ='footerPanel'] > ul:nth-child(1) > li:nth-child(3)>a[href='services.htm']"));
		
		// Locate 'Products' link using 'cssSelector' locator
				driver.findElement(
						By.cssSelector("div[id ='footerPanel'] > ul:nth-child(1) > li:nth-child(4)>a[href='http://www.parasoft.com/jsp/products.jsp']"));

		// Locate 'Location' link using 'cssSelector' locator
		driver.findElement(
				By.cssSelector("div[id ='footerPanel'] > ul:nth-child(1) > li:nth-child(5)>a[href='http://www.parasoft.com/jsp/pr/contacts.jsp']"));

		// Locate 'Forum' link using 'linkText' locator
		driver.findElement(By.linkText("Forum"));

		// Locate 'Site Map' link using 'linkText' locator
		driver.findElement(By.linkText("Site Map"));

		// Locate 'Contact Us' link using 'linkText' locator
		driver.findElement(By.linkText("Contact Us"));

		driver.close();

	}

}
