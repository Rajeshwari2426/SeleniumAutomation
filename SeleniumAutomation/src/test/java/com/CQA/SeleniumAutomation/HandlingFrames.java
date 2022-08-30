package com.CQA.SeleniumAutomation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlingFrames {
	public static WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rajar\\eclipse-workspace\\SeleniumAutomation\\SeleniumAutomation\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	@Test
	public void Frame_Demo(){		
		driver.get("file:///C:/Users/rajar/Documents/page2.html");
		//using index of the frame - [ int value] [ index of frames starts with zero]
		driver.switchTo().frame(0);
		driver.findElement(By.id("t1")).sendKeys("a");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("t2")).sendKeys("a");
		//using id attribute of the frame -string
		driver.switchTo().frame("f1");
		driver.findElement(By.id("t1")).sendKeys("b");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("t2")).sendKeys("b");
		//using name attribute of the frame -string
		driver.switchTo().frame("n1");
		driver.findElement(By.id("t1")).sendKeys("c");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("t2")).sendKeys("c");
		//using address of the frame -webelement
		WebElement f = driver.findElement(By.className("c1"));
		driver.switchTo().frame(f);
		driver.findElement(By.id("t1")).sendKeys("d");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("t2")).sendKeys("d");
		driver.close();
		}
	@Test
	
	public void ContextClickusingActionsClass() throws AWTException, InterruptedException {
		
		driver.get("https://demo.actitime.com/login.do");
		//find the ActiTIME Inc. link
		WebElement link = driver.findElement(By.linkText("actiTIME Inc."));
		//right click (context click) on actitime link
		Actions actions = new Actions(driver);
		actions.contextClick(link).perform();
		Thread.sleep(3000);
		//press 'w' from the keyboard for opening in a new window
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_W);
		r.keyRelease(KeyEvent.VK_W);
		//quit() method closes all the browsers opened by Selenium
		driver.quit();
		}
	@Test
	public void gmail_contextClickDemo_mailArchive ()throws InterruptedException {
		
		driver.get("https://www.gmail.com");
		//enter email id
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("rajibr2426@gmail.com");
		//click on Next button
		driver.findElement(By.xpath("//span[.='Next']")).click();
		Thread.sleep(3000);
		//enter password id
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Raji@123");
		//click on Next button
		driver.findElement(By.xpath("//span[.='Next']")).click();
		Thread.sleep(10000);
		//Write xpath expression for the mail item based on a subject
		String xp = "(//b[contains(.,'')])[2]";
		//get the address of the mail item which you want to archive
		WebElement mail = driver.findElement(By.xpath(xp));
		//print the subject of the mail
		System.out.println(mail.getText());
		//Creating an object of Actions class 
		Actions actions = new Actions(driver);
		//using Actions class object and contextClick() method, right click on the mail item
		actions.contextClick(mail).perform();
		Thread.sleep(6000);
		//click on Archive to archive the mail 
		driver.findElement(By.xpath("(//div[@class='J-N-JX aDE aDD'])[1]")).click();
		}
	@Test
	public void moveToElement() {
		driver.get("https://www.facebook.com");
		//find the menu "About Company"
		
		WebElement menu = driver.findElement(By.id("email"));
		//mouse hover on "About Company" menu
		Actions actions = new Actions(driver);
		actions.moveToElement(menu).perform();		
	   driver.findElement(By.id("pass")).click();
	   driver.close();
		}
	@Test
	public void MouseHover(){		
		driver.get("https://demo.actitime.com/login.do");
		Actions action = new Actions(driver);
		//movetoElement - used for mouse hover
		//Mouse hover on “AREAS OF EXPERTISE” menu
		WebElement username = driver.findElement(By.id("username"));
		action.moveToElement(username).perform();
		//Click on “AREAS OF EXPERTISE” menu
		WebElement login = driver.findElement(By.id("loginButton"));
		action.moveToElement(login).click().perform();
		//composite multiple actions can be achieved using the below statement
		//action.moveToElement(AreaOfExpertise).moveToElement(cloudApp).click().build().perform();
driver.close();
		}
	@Test
	public void Menu() throws InterruptedException {		
		driver.get("https://www.google.com/");
		WebElement foundation = driver.findElement(By.className("gb_Ue"));
		Actions actions = new Actions(driver);
		//mouse hover on Foundation tab
		actions.moveToElement(foundation).perform();
		Thread.sleep(3000);
//		WebElement enrollment = driver.findElement(By.xpath("(//span[text()='ENROLLMENT'])[1]"));
//		//mouse hover on Enrollment 
//		actions.moveToElement(enrollment).perform();
//		Thread.sleep(3000);
//		WebElement corporateEnrol = driver.findElement(By.xpath("//span[text()='CORPORATE ENROLLMENT']"));
//		//mouse hover on Corporate Enrollment
//		actions.moveToElement(corporateEnrol).perform();
//		Thread.sleep(3000);
//		//click on Corporate Enrollment
//		driver.findElement(By.xpath("//span[text()='ONLINE ENROLLMENT']")).click();
		//driver.close();
		}
	@Test
	public void DragAndDropExample() {
		
		driver.get("https://jqueryui.com/droppable/");
		WebElement f = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(f);			
		WebElement element1 = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement element2 = driver.findElement(By.xpath("//p[text()='Drop here']"));
		Actions actions = new Actions(driver);
		// drag block 1 element and drop it on block 2 element
		actions.dragAndDrop(element1, element2).perform();
		driver.close();
	}
	@Test
	public void DragAndDropbyOffset_Example() throws InterruptedException {
		
		driver.get("https://jqueryui.com/droppable/");
		WebElement f = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(f);	
		//write xpath for Block 1
		WebElement element1 = driver.findElement(By.xpath("//div[@id='draggable']"));
		//write xpath for Block 3
		WebElement element2 = driver.findElement(By.xpath("//p[text()='Drop here']"));
		//Create an object of Actions class and pass driver object as an argument
		Actions actions = new Actions(driver);
		//call the dragAndDropBy() method of Actions class
		actions.dragAndDropBy(element1, element2.getLocation().getX()+10,element2.getSize().getHeight()+10).perform();
		driver.close();
		}
	
	

}
