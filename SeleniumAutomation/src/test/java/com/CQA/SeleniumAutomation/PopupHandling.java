package com.CQA.SeleniumAutomation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PopupHandling {

	public static WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rajar\\eclipse-workspace\\SeleniumAutomation\\SeleniumAutomation\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		// driver.navigate().to("https://demoqa.com/alerts");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void alertPopupTest() throws InterruptedException {

		driver.findElement(By.id("alertButton")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
	}

	@Test
	public void confirmationPopupTest() throws InterruptedException {

		driver.findElement(By.id("confirmButton")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.dismiss();
	}

	@Test
	public void promptPopupTest() throws InterruptedException {

		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id("promtButton")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("raji");
		Thread.sleep(2000);
		alert.dismiss();

	}

	@Test
	public void hiddenDivisionPopup() throws InterruptedException {
		driver.navigate().to("https://www.cleartrip.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//button[@class='flex flex-middle flex-between t-all fs-2 focus:bc-secondary-500 bg-transparent bc-neutral-100 c-pointer pr-2 pl-3 pt-2 pb-2 ba br-4 h-8 c-neutral-900']//*[name()='svg']"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@aria-label='Sat Sep 10 2022']")).click();
	}

	@Test
	public void hiddenDivisionPopup_CalendarPopup_cleartrip_selectTodaysDate() throws InterruptedException {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		option.addArguments("--disable-geolocation");
		option.addArguments("--ignore-certificate-errors");
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.cleartrip.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//button[@class='flex flex-middle flex-between t-all fs-2 focus:bc-secondary-500 bg-transparent bc-neutral-100 c-pointer pr-2 pl-3 pt-2 pb-2 ba br-4 h-8 c-neutral-900']//*[name()='svg']"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@aria-label='Sat Sep 10 2022']")).click();
	}

	@Test
	public void fileUploadPopup_Demo() throws InterruptedException, AWTException {

		driver.get("http://nervgh.github.io/pages/angular-file-upload/examples/simple");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='file'][@multiple='']"))
				.sendKeys("C:\\Users\\rajar\\Downloads\\RajaRajeshwariGandiResume.pdf");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='button'][@ng-click='item.upload()']")).click();
//		Thread.sleep(2000);
//		driver.close();
	}

	@Test
	public void fileUploadPopupUsingAutoit() throws InterruptedException, IOException {

		driver.get("https://www.freepdfconvert.com/pdf-to-word");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Choose PDF file")).click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\rajar\\Documents\\CQA1.exe");

	}

	@Test
	public void fileDownloadInChromeBrowser() throws InterruptedException {

		// Create Hashmap object and assign the profile settings
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", "C:\\Users\\rajar\\Downloads\\RAJESHWARI");
		// Assign this chromePrefs object with ChromeOptions object
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		// Create optionsability object and assign the option object
		// Desiredoptionsabilities options = Desiredoptionsabilities.chrome();
		options.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(options);
		driver.get("http://www.seleniumhq.org/download/");
		Thread.sleep(3000);
		driver.findElement(By.linkText("4.4.0 (August 9, 2022)")).click();
	}

	@Test
	public void closeParentWindow() {
		driver.get("http://www.naukri.com");
		driver.manage().window().maximize();
		String parentId = driver.getWindowHandle();
		System.out.println(parentId);
		Set<String> allWindowHandles = driver.getWindowHandles();
		// using size(), get the count of total number of browser windows
		int count = allWindowHandles.size();
		System.out.println("Number of browser windows opened on the system is : " + count);
		for (String windowHandle : allWindowHandles) {
			// switch to each browser window
			driver.switchTo().window(windowHandle);
			String title = driver.getTitle();
			// print the window handle id of each browser window
			System.out.println("Window handle id of page -->" + title + " --> is : " + windowHandle);
			// close all the browsers one by one
			driver.close();

			/*
			 * Instead of using driver.close(), we can use driver.quit() to close all the
			 * browsers at once
			 */
			// driver.quit();
		}

	}

	@Test
	public void closeMainBrowserOnly() throws InterruptedException {

		driver.get("https://www.naukri.com/");
		// get the window handle id of the parent browser window
		String parentWindowhandleID = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		int count = allWindowHandles.size();
		System.out.println("Number of browser windows opened on the system is : " + count);
		for (String windowHandle : allWindowHandles) {
			// switch to each browser window
			driver.switchTo().window(windowHandle);
			String title = driver.getTitle();
			/*
			 * compare the window id with the Parent browser window id, if both are equal,
			 * then only close the main browser window.
			 */
			if (windowHandle.equals(parentWindowhandleID)) {

				System.out.println("Main Browser window with title -->" + title + " --> is closed");
				Thread.sleep(2000);
				driver.close();
			}
		}
	}

	@Test
	public void closeALLChildbrowsersONLY() throws InterruptedException {

		driver.get("https://www.naukri.com/");
		// get the window handle id of the parent browser window
		String parentWindowhandleID = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		int count = allWindowHandles.size();
		System.out.println("Number of browser windows opened on the system is : " + count);
		for (String windowHandle : allWindowHandles) {
			// switch to each browser window
			driver.switchTo().window(windowHandle);
			String title = driver.getTitle();
			/*
			 * compare the window id of all the browsers with the Parent browser window id,
			 * if it is not equal, then only close the browser windows.
			 */
			if (!windowHandle.equals(parentWindowhandleID)) {

				System.out.println("Child Browser window with title -->" + title + " --> is closed");
				Thread.sleep(2000);
				driver.close();
			}
		}
	}

	@Test
	public void closeAnySpecifiedBrowser() throws InterruptedException {

		driver.get("https://www.naukri.com/");
		// Set the expected title of the browser window which you want to close
		String expected_title = "Tech Mahindra";
		Set<String> allWindowHandles = driver.getWindowHandles();
		int count = allWindowHandles.size();
		System.out.println("Number of browser windows opened on the system is : " + count);
		for (String windowHandle : allWindowHandles) {
			// switch to each browser window
			driver.switchTo().window(windowHandle);
			String actual_title = driver.getTitle();
			// Checks whether the actual title contains the specified expected title
			if (actual_title.contains(expected_title)) {

				System.out.println("Specified Browser window with title -->" + actual_title + " --> is closed");
				Thread.sleep(2000);
				driver.close();
			}
		}
	}

	@Test
	public void handleTabs_using_getWindowHandles() throws InterruptedException {

		// enter actitime login url
		driver.get("https://demo.actitime.com/login.do");
		// get the window handle id of the parent browser window
		String parentwindowHandle = driver.getWindowHandle();
		// enter username
		driver.findElement(By.id("username")).sendKeys("admin");
		// enter password
		driver.findElement(By.name("pwd")).sendKeys("manager");
		// click on actiTIME INC link
		driver.findElement(By.xpath("//a[text()='actiTIME Inc.']")).click();
		// get the number of windows currently opened on the system
		Set<String> allwhs = driver.getWindowHandles();
		// switch to all the browser windows
		for (String wh : allwhs) {
			driver.switchTo().window(wh);
		}
		// get the title of the tab
		String childtitle = driver.getTitle();
		System.out.println("Title of the child tab is :" + childtitle);
		Thread.sleep(2000);
		// close the child tab
		driver.close();
		// switch back to the main browser window
		driver.switchTo().window(parentwindowHandle);
		// close the main browser window
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		Thread.sleep(2000);
		// closing the parent window
		driver.close();
	}
	@Test
	
	public void windowPopup_Example() throws InterruptedException, AWTException, IOException {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.get("https://demo.actitime.com/login.do");
		Thread.sleep(3000);		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_P);
		r.keyRelease(KeyEvent.VK_P);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Runtime run = Runtime.getRuntime();
		run.exec("C:\\\\Users\\\\rajar\\\\Documents\\\\CQA1.exe");
		Thread.sleep(5000);
		driver.close();
		}


}
