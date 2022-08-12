package com.CQA.SeleniumAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LaunchBrowserTest {
	@Test
	public void launchBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\rajar\\eclipse-workspace\\SeleniumAutomation\\SeleniumAutomation\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		
			Thread.sleep(2000);
		
		String title=driver.getTitle();
		System.out.println("tITLE:"+title);
		Thread.sleep(2000);
		String currentUrl=driver.getCurrentUrl();
		System.out.println("URL:"+currentUrl);
		Thread.sleep(2000);
		String pageSource=driver.getPageSource();
		System.out.println("Source code:"+pageSource);
		Thread.sleep(2000);
		driver.close();
	}
	

}
