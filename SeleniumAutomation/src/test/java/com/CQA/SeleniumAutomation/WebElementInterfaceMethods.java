package com.CQA.SeleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElementInterfaceMethods {
	public static WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rajar\\eclipse-workspace\\SeleniumAutomation\\SeleniumAutomation\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
	}

	@Test
	public void webElementInterfaceMethods() throws InterruptedException {

		WebElement emailAdd = driver.findElement(By.id("email"));
		int email_Ycordinate = emailAdd.getRect().getY();// get location
		int email_Xcordinate = emailAdd.getRect().getX();
		System.out.printf("coordinates=(%s , %s )\n", email_Xcordinate, email_Ycordinate);
		int email_Height = emailAdd.getSize().getHeight();// get size
		int email_width = emailAdd.getSize().getWidth();
		System.out.printf(" Height is :%s ,width is : %s \n", email_Height, email_width);
		// is enabled ()
		if (emailAdd.isEnabled()) {
			System.out.println("Email text box is enabled");
		} else {
			System.out.println("Email text box is disabled");
		}
		// get text()
		String text = emailAdd.getText();
		System.out.printf("Text is :%s \n", text);
		// get TagName()
		String tagName = emailAdd.getTagName();
		System.out.println("\nTag Name : " + tagName);
		// get Attribute method
		String attribute = emailAdd.getAttribute("email");
		System.out.printf("\nText is :%s ", attribute);
		// get CSS Value method
		String cssValue = emailAdd.getCssValue("font");
		System.out.printf("\nfont style is :%s\n", cssValue);
		// get rect method
		int x = emailAdd.getRect().getX();
		int y = emailAdd.getRect().getY();
		int Height = emailAdd.getRect().getHeight();// get size
		int width = emailAdd.getRect().getWidth();
		System.out.printf("Height is :%s ,width is : %s \n", Height, width);
		System.out.println(+x + " , " + y);

		// submit method
		driver.findElement(By.name("login")).submit();
		Thread.sleep(5000);
		driver.close();

	}

	@Test
	public void VerifyFB_UNandPWDFieldsAreAligned_() {

		WebElement unTB = driver.findElement(By.id("email"));
		int un_x = unTB.getRect().getX();
		int un_y = unTB.getRect().getY();
		System.out.printf("coordinates=(%s , %s )\n", un_x, un_y);
		WebElement pwTB = driver.findElement(By.id("pass"));
		int pw_x = pwTB.getRect().getX();
		int pw_y = pwTB.getRect().getY();
		System.out.printf("coordinates=(%s , %s )\n", pw_x, pw_y);
		if (un_x == pw_x) {
			System.out.println("Email and password text box are aligned");
		} else {
			System.out.println("Email and password text box are NOT aligned");
		}
		driver.close();
	}

	@Test
	public void VerifyUNandPassword_HeightandWidth() {
		WebElement unTB = driver.findElement(By.id("email"));
		int email_height = unTB.getSize().getHeight();
		int email_width = unTB.getSize().getWidth();
		System.out.println(+email_height + " x " + email_width);
		WebElement pwdTB = driver.findElement(By.name("pass"));
		int password_height = pwdTB.getSize().getHeight();
		int password_width = pwdTB.getSize().getWidth();
		System.out.println(+password_height + " x " + password_width);
		if (email_height == password_height && email_width == password_width) {
			System.out.println("email and password fields are aligned");
		} else {
			System.out.println("email and password fields are NOT aligned");
		}
		driver.close();
	}

	@Test
	public void EnterTextIntoFocussedElementAndRemoveValuefromText() throws InterruptedException {
		driver.switchTo().activeElement().sendKeys("Raji");
		String value = driver.findElement(By.id("email")).getAttribute("value");
		System.out.println("Value present inside the text box is : " + value);
		driver.findElement(By.id("email")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("E nte re d Sa nj u");
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		// this line will actually delete the value if there is no space in the text
		// entered
		// if there is a space between two words in the email field, we have to use the
		// below lines of code
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("Again EnteredSanju");
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.id("email")).sendKeys(Keys.DELETE);
		Thread.sleep(2000);
		driver.close();
	}
	@Test
	public void PrintTooltip_Actitime_RememberCheckbox() throws InterruptedException {
		
		
		driver.get("https://demo.actitime.com/login.do");
//		driver.findElement(By.name("identifier")).sendKeys("rajarajeshwaribrgandi@gmail.com");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//span[text()='Next']")).click();
//		//find the Keep me Logged in Checkbox
//		WebElement Checkbox = driver.findElement(By.id("selectioni8"));
//		//get the tooltip text using getAttribute() method and store in a variable
//		String tooltipText = Checkbox.getAttribute("jsname");
//		System.out.println(tooltipText);
		Thread.sleep(2000);
		WebElement Checkbox = driver.findElement(By.id("keepLoggedInCheckBox"));		
		String tooltipText = Checkbox.getAttribute("title");
		Thread.sleep(2000);
		System.out.println(tooltipText);
		Thread.sleep(2000);
		driver.close();

	}
}
