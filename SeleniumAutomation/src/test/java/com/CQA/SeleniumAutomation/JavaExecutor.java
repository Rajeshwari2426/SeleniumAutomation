package com.CQA.SeleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaExecutor {
	public static WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rajar\\eclipse-workspace\\SeleniumAutomation\\SeleniumAutomation\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void enterText_intoDisabledTextbox() throws InterruptedException {

		driver.get("file:///C:/Users/rajar/Documents/prgm.html");
		// Typecast the driver object to JavascriptExecutor interface type
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		// enter "admin" in first textbox using javascript
		js.executeScript("document.getElementById('t1').value='admin'");
		Thread.sleep(2000);
		// clear the value in second textbox using javascript
		js.executeScript("document.getElementById('t2').value=''");
		// enter "manager" in second textbox using javascript
		js.executeScript("document.getElementById('t2').value='manager'");
		// change the second text box to button type using Javascript
		js.executeScript("document.getElementById('t2').type='button'");
		driver.close();
	}

	@Test
	public void ScrollUpandDown() throws InterruptedException {

		driver.get("http://seleniumhq.org/download");
		// typecasting driver object to JavascriptExecutor interface type
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 1; i < 10; i++) {
			// scroll down on the webpage
			js.executeScript("window.scrollBy(0, 1000)");
			Thread.sleep(3000);
		}
		for (int i = 1; i < 10; i++) {
			// scroll up on the webpage
			js.executeScript("window.scrollBy(0, -1000)");
			Thread.sleep(3000);
		}
		driver.close();
	}

	@Test
	public void ScrollUpandDowntospecificElementonWebpage() throws InterruptedException {

		driver.get("http://seleniumhq.org/download");
		// click on the close icon of the yellow color background pop up
		driver.findElement(By.className("close")).click();
		Thread.sleep(3000);
		// find the Applitools element on the webpage
		WebElement ele = driver.findElement(By.xpath("//img[contains(@src,'applitools')]"));
		// get the X-coordinate and store in a variable
		int x = ele.getLocation().getX();
		// get the Y-coordinate and store in a variable
		int y = ele.getLocation().getY();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll to Applitools element’s x and y coordinate
		js.executeScript("window.scrollBy(" + x + ", " + y + ")");
		Thread.sleep(3000);
		driver.close();
	}

	@Test
	public void NavigatetoBottomofthePage() throws InterruptedException {

		driver.get("http://seleniumhq.org/download");
		driver.findElement(By.className("close")).click();
		// select an element which is present at the bottom of the page
		WebElement element = driver.findElement(By.className("text-white"));
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		System.out.println("X coordinate is :" + x + " and Y coordinate is :" + y);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
		Thread.sleep(5000);
		element.click();
		driver.close();
	}

}
