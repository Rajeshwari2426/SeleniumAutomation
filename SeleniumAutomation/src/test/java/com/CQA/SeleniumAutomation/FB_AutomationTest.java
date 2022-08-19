package com.CQA.SeleniumAutomation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FB_AutomationTest {
	@Test
	public void fbAutomationTest() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rajar\\eclipse-workspace\\SeleniumAutomation\\SeleniumAutomation\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.findElement(By.name("email")).sendKeys("Raji@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Raji");
		Thread.sleep(2000);
		driver.findElement(By.name("login")).click();
		
	}
	@Test
	public void signupPageTest()
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rajar\\eclipse-workspace\\SeleniumAutomation\\SeleniumAutomation\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.findElement(By.linkText("Create New Account")).click();
		driver.findElement(By.name("firstname")).sendKeys("Raji");
//		driver.findElement(By.name("lastname")).sendKeys("gandi");
//		driver.findElement(By.name("reg_email__")).sendKeys("Raji@gmail.com");
//		driver.findElement(By.name("reg_passwd__")).sendKeys("Raji@gmail.com");
//		
	}
	
}
