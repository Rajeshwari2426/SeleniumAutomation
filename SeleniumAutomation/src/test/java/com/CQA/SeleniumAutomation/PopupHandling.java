package com.CQA.SeleniumAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PopupHandling {
	
	public static WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rajar\\eclipse-workspace\\SeleniumAutomation\\SeleniumAutomation\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://demoqa.com/alerts");
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
	}
	@Test
	public void alertPopupTest() throws InterruptedException {
		
		driver.findElement(By.id("alertButton")).click();
		Alert alert=driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();		
	}
	@Test
	public void confirmationPopupTest() throws InterruptedException {
		
		driver.findElement(By.id("confirmButton")).click();
		Alert alert=driver.switchTo().alert();
		Thread.sleep(2000);
		alert.dismiss();		
	}
	@Test
	public void promptPopupTest() throws InterruptedException {
		
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id("promtButton")).click();
		Thread.sleep(2000);
		Alert alert=driver.switchTo().alert();
		alert.sendKeys("raji");
		Thread.sleep(2000);
		alert.dismiss();
		
	}
	@Test
	public void hiddenDivisionPopup() throws InterruptedException {
		driver.navigate().to("https://www.cleartrip.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='flex flex-middle flex-between t-all fs-2 focus:bc-secondary-500 bg-transparent bc-neutral-100 c-pointer pr-2 pl-3 pt-2 pb-2 ba br-4 h-8 c-neutral-900']//*[name()='svg']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@aria-label='Sat Sep 10 2022']")).click();
	}
	
	
	
}
