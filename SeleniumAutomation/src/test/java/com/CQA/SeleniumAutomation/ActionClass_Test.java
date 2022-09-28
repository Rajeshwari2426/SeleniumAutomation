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

public class ActionClass_Test {

	public static WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rajar\\eclipse-workspace\\SeleniumAutomation\\SeleniumAutomation\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test

	public void ContextClickUsingActionsClass() throws AWTException, InterruptedException {

		driver.get("https://demo.actitime.com/login.do");		
		WebElement link = driver.findElement(By.linkText("actiTIME Inc."));
		Actions actions = new Actions(driver);
		actions.contextClick(link).perform();
		Thread.sleep(3000);	
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_W);
		r.keyRelease(KeyEvent.VK_W);
			driver.quit();
	}

	@Test
	public void gmail_contextClickDemo_mailArchive() throws InterruptedException {

		driver.get(
				"https://accounts.google.com/signin/v2/challenge/pwd?service=mail&passive=1209600&osid=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin&cid=1&navigationDirection=forward&TL=AKqFyY_toPfcu-rkPQSXDiKxaSX-fE6UTlnXq1jrl3-sWNUtfqDLa1uMmBy4pjov");
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("rajibr2426@gmail.com");
		
		driver.findElement(By.xpath("//span[.='Next']")).click();
		Thread.sleep(3000);		
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Raji@123");		
		driver.findElement(By.xpath("//span[.='Next']")).click();
		Thread.sleep(10000);		
		String xp = "(//b[contains(.,'')])[2]";		
		WebElement mail = driver.findElement(By.xpath(xp));
			System.out.println(mail.getText());		
		Actions actions = new Actions(driver);		
		actions.contextClick(mail).perform();
		Thread.sleep(6000);		
		driver.findElement(By.xpath("(//div[@class='J-N-JX aDE aDD'])[1]")).click();
	}

	@Test
	public void moveToElement() {
		driver.get("https://www.facebook.com");		
		WebElement menu = driver.findElement(By.id("email"));		
		Actions actions = new Actions(driver);
		actions.moveToElement(menu).perform();
		driver.findElement(By.id("pass")).click();
		driver.close();
	}

	@Test
	public void MouseHover() {
		driver.get("https://demo.actitime.com/login.do");
		Actions action = new Actions(driver);
		WebElement username = driver.findElement(By.id("username"));
		action.moveToElement(username).perform();
		WebElement login = driver.findElement(By.id("loginButton"));
		action.moveToElement(login).click().perform();
		// composite multiple actions can be achieved using the below statement
		// action.moveToElement(username).moveToElement(login).click().build().perform();
		driver.close();
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
		WebElement element1 = driver.findElement(By.xpath("//div[@id='draggable']"));		
		WebElement element2 = driver.findElement(By.xpath("//p[text()='Drop here']"));		
		Actions actions = new Actions(driver);	
		actions.dragAndDropBy(element1, element2.getLocation().getX() + 10, element2.getSize().getHeight() + 10)
				.perform();
		driver.close();
	}

}
