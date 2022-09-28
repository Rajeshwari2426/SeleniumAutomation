package com.CQA.SeleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class Independent_Dependent_Xpath_Test {
	public static WebDriver driver;
	@Test
	public void independent_Dependent_Xpath_Seleniumsite_javaDownload() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rajar\\eclipse-workspace\\SeleniumAutomation\\SeleniumAutomation\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://www.seleniumhq.org/download/");
		 Thread.sleep(3000);
		// XPath using independent and dependent concept
		 driver.findElement(By.xpath("p[.='Java']/..//a[.='4.4.0 (August 9, 2022)']")).click();
		 Thread.sleep(5000);
		 driver.close();
	}


}
