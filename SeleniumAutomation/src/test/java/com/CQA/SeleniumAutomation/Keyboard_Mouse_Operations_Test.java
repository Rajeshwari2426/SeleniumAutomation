package com.CQA.SeleniumAutomation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Keyboard_Mouse_Operations_Test {
	@Test
	public void keyboardMouseOperationstest() throws InterruptedException, AWTException
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rajar\\eclipse-workspace\\SeleniumAutomation\\SeleniumAutomation\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");

		Thread.sleep(2000);
		Robot r = new Robot();
		r.mouseMove(300, 500);
		Thread.sleep(3000);
		//open menu
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_F);
		Thread.sleep(3000);
		r.keyRelease(KeyEvent.VK_F);
		r.keyRelease(KeyEvent.VK_ALT);
		Thread.sleep(3000);
		//minimize current window
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_SPACE);
		r.keyPress(KeyEvent.VK_N);
		Thread.sleep(2000);
		r.keyRelease(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_SPACE);
		r.keyRelease(KeyEvent.VK_ALT);
		//opens book marks
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_O);
		Thread.sleep(2000);
		r.keyRelease(KeyEvent.VK_O);
		r.keyRelease(KeyEvent.VK_SHIFT);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		//select file or opens file explorer
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_O);
		Thread.sleep(2000);
		r.keyRelease(KeyEvent.VK_O);
		r.keyRelease(KeyEvent.VK_CONTROL);
		driver.quit();
	}

}
