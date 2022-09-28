package com.CQA.SeleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class XPathAxes_Test {
	public static WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rajar\\eclipse-workspace\\SeleniumAutomation\\SeleniumAutomation\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
	}
	@Test
	public void xpathUsingAxes() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body//select/child::option[5]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(" descendant::option[26]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("descendant::option[27]/parent::select")).click();
		Thread.sleep(5000);
		
		driver.close();
		
	}

}
