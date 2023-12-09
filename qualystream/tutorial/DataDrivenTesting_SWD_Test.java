package com.qualystream.tutorial;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenTesting_SWD_Test {

	private WebDriver driver;
	private WriteExcelFile WriteFile;
	private ReadExcelFile readFile;
	private WriteExcelFile writeFile;
	private By searchBoxLocator = By.id("search_product");
	private By searchBtnLocator = By.id("submit_search");
	private By resulttexLocator = By.cssSelector("h2.title.text-center");
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver15/chromedriver.exe");
		driver = new ChromeDriver();
		writeFile = new WriteExcelFile();
		readFile = new ReadExcelFile();
		
		driver.get("https://automationexercise.com/products");
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws IOException {
		String filepath = "C:\\Users\\Administrador\\Documents\\Eclipse Excel Test\\Test.xlsx";
		
		String searchText = readFile.getCellValue(filepath, "Sheet1", 0, 0);
		
		driver.findElement(searchBoxLocator).sendKeys(searchText);
		driver.findElement(searchBtnLocator).click();
		WebElement resultElement = driver.findElement(resulttexLocator);
		String resultText = driver.findElement(resulttexLocator).getText();
		
		System.out.println("Page result text: " + resultText);
		
		
		readFile.readExcel(filepath, "Sheet1");
		
		writeFile = new WriteExcelFile();
		writeFile.writeCellValue(filepath, "Sheet1", 0, 1, resultText);
		
		
		readFile.readExcel(filepath, "Sheet1");
		
	}

}
