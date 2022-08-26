package com.CQA.SeleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class WebElementInterfaceMethods {
	public static WebDriver driver;

	@Test
	public void webElementInterfaceMethods() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rajar\\eclipse-workspace\\SeleniumAutomation\\SeleniumAutomation\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		WebElement unTB = driver.findElement(By.id("email"));
		int email_Ycordinate = unTB.getLocation().getY();// get location
		int email_Xcordinate = unTB.getLocation().getX();
		System.out.printf(" coordinate (%s , %s )\n", email_Xcordinate, email_Ycordinate);
		int email_Height = unTB.getSize().getHeight();// get size
		int email_width = unTB.getSize().getWidth();
		System.out.printf(" Height is :%s ,width is : %s \n", email_Height, email_width);
		// is enabled ()
		if (unTB.isEnabled()) {
			System.out.println("Email text box is enabled");
		} else {
			System.out.println("Email text box is disabled");
		}
		// get text()
		String text = unTB.getText();
		System.out.printf("Text is :%s \n", text);
		// get TagName()
		String tagName = unTB.getTagName();
		System.out.printf("\nTag Name :%s ", tagName);
		// get Attribute method
		String attribute = unTB.getAttribute("email");
		System.out.printf("\nText is :%s ", attribute);
		// get CSS Value method
		String cssValue = unTB.getCssValue("font");
		System.out.printf("\nfont style is :%s\n", cssValue);
		int x=unTB.getRect().getX();
		System.out.printf("%s",x);
		driver.close();
		

	}

}
