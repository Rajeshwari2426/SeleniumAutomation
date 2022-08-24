package com.CQA.SeleniumAutomation;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LaunchBrowserTest {
	public static WebDriver driver;

	@Test
	public void launchBrowser() throws InterruptedException {
		Scanner sc = new Scanner(System.in); // System.in is a standard input stream
		System.out.print("Select a browser:1.Chrome 2.Egde 3.firefox");
		String str = sc.nextLine(); // reads string
		System.out.print("You have entered: " + str);

		switch (str) {
		case "1":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\rajar\\eclipse-workspace\\SeleniumAutomation\\SeleniumAutomation\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "2":
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\rajar\\eclipse-workspace\\SeleniumAutomation\\SeleniumAutomation\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();

			break;
		case "3":
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\rajar\\eclipse-workspace\\SeleniumAutomation\\SeleniumAutomation\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
			
		}
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		String title = driver.getTitle();
		System.out.println("tITLE:" + title);
		Thread.sleep(2000);
		String currentUrl = driver.getCurrentUrl();
		System.out.println("URL:" + currentUrl);
		Thread.sleep(2000);
		String pageSource = driver.getPageSource();
		System.out.println("Source code:" + pageSource);
		Thread.sleep(2000);
		driver.close();
	}

}
