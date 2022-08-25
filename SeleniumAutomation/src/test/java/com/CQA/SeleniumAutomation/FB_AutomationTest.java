package com.CQA.SeleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FB_AutomationTest {
	public static WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rajar\\eclipse-workspace\\SeleniumAutomation\\SeleniumAutomation\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
	}

	@Test
	public void loginTest() throws InterruptedException {
		driver.findElement(By.name("email")).sendKeys("8790142483");
		driver.findElement(By.id("pass")).sendKeys("xyz");
		Thread.sleep(2000);
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
		driver.close();

	}

	@Test
	public void signupPageTest() throws InterruptedException {
		driver.findElement(By.linkText("Create New Account")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("firstname")).sendKeys("Raji");
		driver.findElement(By.name("firstname")).clear();
		// driver.findElement(By.name("lastname")).sendKeys("gandi");
		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("gandi");
		driver.findElement(By.name("reg_email__")).sendKeys("Rajibr2426@gmail.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("Rajibr2426@gmail.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("Raji@gmail.com");
		driver.findElement(By.name("birthday_day")).sendKeys("26");
		Thread.sleep(2000);
		driver.findElement(By.name("birthday_month")).sendKeys("Feb");
		driver.findElement(By.id("year")).sendKeys("1997");
		driver.findElements(By.name("sex")).get(0).click();
		driver.findElement(By.name("websubmit")).click();
		String text = driver.findElement(By.name("websubmit")).getAttribute("name");
		System.out.println("text on button is:" + text);
		Thread.sleep(7000);
		driver.close();

	}

	@Test
	public void signupWithXpathTest() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Raji");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("Rajibr2426@gmail.com");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("gandi");
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("Rajibr2426@gmail.com");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Raji@gmail.com");
		driver.findElement(By.xpath("//select[@name='birthday_day']")).sendKeys("26");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@name='birthday_month']")).sendKeys("Feb");
		driver.findElement(By.xpath("//select[@id='year']")).sendKeys("1997");
		driver.findElements(By.xpath("//input[@name='sex']")).get(0).click();		
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		Thread.sleep(7000);
		driver.close();

	}
	@Test
	public void loginTestXpath() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("8790142483");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("xyz123456");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@name='login']")).click();
		Thread.sleep(6000);
		String exp = "The password that you've entered is incorrect. Forgotten password?";
	      //identify actual error message
	      WebElement m = driver.findElement(By.className("_9ay7"));
	      String act = m.getText();
	      System.out.println("Error message is: "+ act);
	      //verify error message with Assertion
	     // Assert.assertEquals(exp, act);
	      if (exp==act)
	    	  System.out.println("error codeis matching");
	      else
	    	  System.out.println("error code is not matching");  
	     
		driver.close();
	}
	@Test
	public void signupWithXpathfunctionsTest() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[contains(@name,'firstname')]")).sendKeys("Raji");
		driver.findElement(By.xpath("//input[contains(@name,'lastname')]")).sendKeys("gandi");
		driver.findElement(By.xpath("//input[contains(@name,'reg_email__')]")).sendKeys("Rajibr2426@gmail.com");
		driver.findElement(By.xpath("//input[starts-with(@id,'u_')][starts-with(@name,'reg_email_confirmation__')]")).sendKeys("Rajibr2426@gmail.com");
		driver.findElement(By.xpath("//input[contains(@name,'reg_passwd__')]")).sendKeys("Raji@gmail.com");
		driver.findElement(By.xpath("//select[@name='birthday_day']")).sendKeys("26");
		driver.findElement(By.xpath("//option[contains(text(),'Feb')]")).click();
		Thread.sleep(3000);
		driver.close();}

}
