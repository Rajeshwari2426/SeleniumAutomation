package com.CQA.SeleniumAutomation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ListBoxTest {
	public static WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rajar\\eclipse-workspace\\SeleniumAutomation\\SeleniumAutomation\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/rajar/Downloads/RAJESHWARI/ListBox.html");
	}

	@Test
	public void listBoxExample() throws InterruptedException {

		WebElement list = driver.findElement(By.id("mtr"));
		// Create an object of Select class and pass the address of list box as an
		// argument
		Select s = new Select(list);
		// getOptions() method returns a list of all the elements of the list box
		List<WebElement> options = s.getOptions();
		int size = options.size();
		System.out.println("Number of elements present inside the listbox is : " + size);
		// Print all the elements present in the list box
		for (WebElement webElement : options) {
			String text = webElement.getText();
			System.out.println(text);
		}
		// selectByIndex() selects an element based on the Index, here index starts with
		// 0
		s.selectByIndex(1);
		// selectByValue() method selects an element based on its value attribute.
		s.selectByValue("v");
		/*
		 * selectByVisibleText() method selects an element based on the actual text that
		 * is visible to the user. For instance, if there are multiple POORI present
		 * inside the listbox , it will select all the POORI elements.
		 */
		s.selectByVisibleText("POORI");
		System.out.println("************Print all selected options***********");
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		int size2 = allSelectedOptions.size();
		System.out.println("Number of items that is selected in the list box is : " + size2);
		System.out.println(" Selected items are printed below ");
		for (WebElement webElement : allSelectedOptions) {
			System.out.println(webElement.getText());
		}
		System.out.println("check whether it is a multiple select listbox or not");
		boolean multiple = s.isMultiple();
		System.out.println(multiple + " yes , it is multi select");
		if (multiple) {
			// Print the first selected option in the list box
			WebElement firstSelectedOption = s.getFirstSelectedOption();
			System.out.println(firstSelectedOption.getText() + "is the first selected item in the list box");
			// deselect the item present in 0th index.
			s.deselectByIndex(0);
			// Print the first selected option in the list box
			WebElement firstSelectedOption1 = s.getFirstSelectedOption();
			System.out.println(firstSelectedOption1.getText() + " is the first selected item");
			// deselect an item which has an attribute called value and its value is "v"
			s.deselectByValue("v");
			// Print the first selected option in the list box
			WebElement firstSelectedOption2 = s.getFirstSelectedOption();
			System.out.println(firstSelectedOption2.getText() + " is the first selected item");
			s.deselectByVisibleText("POORI");
		}
		Thread.sleep(2000);
		driver.close();
	}

	@Test
	public void printListValues_SortedOrder() throws InterruptedException {

		WebElement listElement = driver.findElement(By.id("mtr"));
		Select s = new Select(listElement);
		List<WebElement> allOptions = s.getOptions();
		int count = allOptions.size();
		System.out.println(count);
		System.out.println("-----print the values in the list ----");
		ArrayList<String> list = new ArrayList<String>();
		for (WebElement option : allOptions) {
			String text = option.getText();
			System.out.println(text);
			list.add(text);
		}
		Collections.sort(list);
		System.out.println("-----print the value in sorted order----");
		for (String value : list) {
			System.out.println(value);
		}
		Thread.sleep(2000);
		driver.close();
	}

	@Test
	public void printUniqueElementinthelistbox() throws InterruptedException {

		WebElement listElement = driver.findElement(By.id("mtr"));
		Select s = new Select(listElement);
		List<WebElement> allOptions = s.getOptions();
		int count = allOptions.size();
		System.out.println(count);
		System.out.println("-----print the values in the list ----");
		HashSet<String> allElements = new HashSet<String>();
		for (WebElement option : allOptions) {
			String text = option.getText();
			System.out.println(text);
			allElements.add(text);
		}
		System.out.println(allElements);
		Thread.sleep(2000);
		driver.close();
	}

	@Test
	public void printUniqueElement_Sorted() throws InterruptedException {

		WebElement listElement = driver.findElement(By.id("mtr"));
		Select s = new Select(listElement);
		List<WebElement> allOptions = s.getOptions();
		int count = allOptions.size();
		System.out.println(count);
		System.out.println("-----print the values in the list ----");
		TreeSet<String> allElements = new TreeSet<String>();
		for (WebElement option : allOptions) {
			String text = option.getText();
			System.out.println(text);
			allElements.add(text);
		}
		System.out.println(allElements);
		Thread.sleep(2000);
		driver.close();
	}

	@Test

	public void checklisthasDUPLICATEvalues_HashSet() {

		WebElement listbox = driver.findElement(By.id("mtr"));
		Select s = new Select(listbox);
		List<WebElement> allOptions = s.getOptions();
		int count1 = allOptions.size();
		System.out.println("Number of elements in the list is :" + count1);
		HashSet<String> allElementText = new HashSet<String>();
		for (int i = 0; i < count1; i++) {
			String text = allOptions.get(i).getText();
			System.out.println(text);
			allElementText.add(text);
		}
		int count2 = allElementText.size();
		System.out.println("Number of elements in the hashset is :" + count2);
		if (count1 == count2) {
			System.out.println("list box has NO duplicate values");
		} else {
			System.out.println("list box has duplicate values");
		}
		System.out.println(allElementText);
		driver.close();
	}

	@Test

	public void printtheDUPLICATEItem_intheList_HashSet() {

		WebElement listbox = driver.findElement(By.id("mtr"));
		Select s = new Select(listbox);
		List<WebElement> allOptions = s.getOptions();
		int count1 = allOptions.size();
		System.out.println("Number of elements in the list is :" + count1);
		HashSet<String> allElementText = new HashSet<String>();
		for (int i = 0; i < count1; i++) {
			String text = allOptions.get(i).getText();
			/*
			 * allElementText.add(text) returns true if the element is not already added,
			 * and it returns false if the same element is trying to be added twice.
			 */
			if (!allElementText.add(text)) {
				System.out.println(text + " is the duplicate item in the list box");
			}
		}
		System.out.println(allElementText.size());
		// it will print all the unique values in the HashSet object
		System.out.println(allElementText);
		driver.close();
	}

	@Test
	public void hashMapExample_printtheOcuuranceOfPoori() throws InterruptedException {

		WebElement list = driver.findElement(By.id("mtr"));
		Select s = new Select(list);
		List<WebElement> allElements = s.getOptions();
		HashMap<String, Integer> hashMapObj = new HashMap<String, Integer>();
		for (WebElement element : allElements) {
			String text = element.getText();
			if (hashMapObj.containsKey(text)) {
				Integer value = hashMapObj.get(text);
				value++;
				hashMapObj.put(text, value);
			} else {
				hashMapObj.put(text, 1);
			}
		}
		Set<String> allKeys = hashMapObj.keySet();
		for (String key : allKeys) {
			Integer value = hashMapObj.get(key);
			System.out.println(key + " -->" + value);
			if (value > 1) {
				System.out.println("Occurance of " + key + " is :" + value);
			}
			Thread.sleep(2000);
			driver.close();
		}
	}
}
