package com.CQA.SeleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
	public void logininTest() throws InterruptedException {
		driver.findElement(By.name("email")).sendKeys("8790142483");
																			          driver.findElement(By.id("pass")).sendKeys("jollysmile");
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
		//driver.findElement(By.name("lastname")).sendKeys("gandi");
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
		String text=driver.findElement(By.name("websubmit")).getAttribute("name");
		System.out.println("text on button is:"+text);
		Thread.sleep(3000);
		driver.close();

	}

}
