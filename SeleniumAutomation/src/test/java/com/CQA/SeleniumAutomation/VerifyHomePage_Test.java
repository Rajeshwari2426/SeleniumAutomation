package com.CQA.SeleniumAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyHomePage_Test {
	public static WebDriver driver;

	@BeforeTest
	public void launchBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rajar\\eclipse-workspace\\SeleniumAutomation\\SeleniumAutomation\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");

		driver.findElement(By.name("email")).sendKeys("8790142483");
		driver.findElement(By.id("pass")).sendKeys("xyyz123");
		
//		driver.findElement(By.xpath("//button[.='Log In']")).click();
//		Thread.sleep(3000);
		WebElement loginResult = new WebDriverWait(driver, Duration.ofSeconds(10))
		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Log In']")));
		// Print the first result
		System.out.println(loginResult.getText());
		loginResult.click();

	}

	@Test
	public void verifyHomePageUsingTitle() throws InterruptedException {

		String expectedTitle = "(2) Facebook";
		String actualTitle = driver.getTitle();
		// If actual title contains "Enter Time" text then home page is displayed.
		if (actualTitle.contains(expectedTitle)) {
			System.out.println("Home page is displayed");
		} else {
			System.out.println("Home page is NOT displayed");
		}
		driver.close();
	}

	@Test
	public void verifyHomePageUsingUrl() throws InterruptedException {

		String expectedUrl = "https://www.facebook.com/";
		String actualUrl = driver.getCurrentUrl();
		if (actualUrl.contains(expectedUrl)) {
			System.out.println("Home page is displayed");
		} else {
			System.out.println("Home page is NOT displayed");
		}
		driver.close();
	}

	@Test
	public void verifyHomePageUsingElement() throws InterruptedException {
		WebElement homeBtn = driver.findElement(By.xpath("//span[@class='om3e55n1']"));
		if (homeBtn.isDisplayed()) {
			System.out.println("Home page is displayed");
		} else {
			System.out.println("Home page is NOT displayed");
		}
		driver.close();

	}
	
	

}
