package com.CQA.SeleniumAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElements_Test {
	public static WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rajar\\eclipse-workspace\\SeleniumAutomation\\SeleniumAutomation\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	@Test
	public void findElements_Example () {
		
		driver.get("https://demo.actitime.com/login.do");
		//findElements() method returns list of web element
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		//get the total number of link elements
		int totalLinks = allLinks.size();
		System.out.println("total number of links present on the web page is : "+totalLinks);
		int visibleLinkCount = 0;
		int hiddenLinkCount = 0;
		//using foreach loop, iterate through all the links
		for (WebElement link : allLinks) {
		//if the link is displayed, then print the text of the link
		if (link.isDisplayed()) {
		visibleLinkCount++;
		System.out.println(visibleLinkCount+" --> "+link.getText());
		}else{
		hiddenLinkCount++;
		}
		}
		System.out.println("Total number of visible links :" + visibleLinkCount);
		System.out.println("Total number of hidden links :" + hiddenLinkCount);
		driver.close();
		}
	@Test
	public void totalCheckboxes() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		
		driver.findElement(By.name("pwd")).sendKeys("manager");
	driver.findElement(By.xpath("//a[@id='loginButton']")).click();
	driver.findElement(By.id("container_tasks")).click();
	
	List<WebElement> allcheckboxes = driver.findElements(By.xpath("//div[contains(@class,'checkbox')]"));
	//List<WebElement> allcheckboxes = driver.findElements(By.xpath("//div[contains(@class,'img')]"));
	//get the total number of link elements
	int totalCheckboxes = allcheckboxes.size();
	System.out.println("total number of checboxes present on the web page is : "+totalCheckboxes);
	 //((WebElement) allcheckboxes).click();
	driver.findElement(By.xpath("//div[contains(@class,'checkbox')]")).click();
	WebElement lastCheckbox=driver.findElement(By.xpath("//div[text()='Spaceship testing']"));
	lastCheckbox.click();
	
	}
	}
	



