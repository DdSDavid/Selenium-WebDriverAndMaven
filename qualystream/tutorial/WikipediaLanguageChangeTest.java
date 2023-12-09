package com.qualystream.tutorial;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WikipediaLanguageChangeTest {

	public WikipediaLanguageChangeTest() {
		// TODO Auto-generated constructor stub
	}


	    private WebDriver driver;
	    private By languageDropdownLocator = By.id("//*[@id=\"js-link-box-en\"]");
	    private By searchInputLocator = By.name("search");
	    private By searchButtonLocator = By.name("go");
	    private By pageTitleLocator = By.id("firstHeading");

	    @Before
	    public void setUp() {
	    	System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver15/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
	        driver.get("https://www.wikipedia.org");
	    }

	    @After
	    public void tearDown() {
	        driver.quit();
	    }

	    @Test
	    public void testLanguageChangeAndTitleTranslation() {
	        driver.findElement(languageDropdownLocator).sendKeys("es");
	        driver.findElement(searchInputLocator).sendKeys("Selenium WebDriver");
	        driver.findElement(searchButtonLocator).click();

	        WebElement pageTitle = driver.findElement(pageTitleLocator);
	        String pageTitleText = pageTitle.getText();

	        assertEquals("Selenium", pageTitleText);
	    }
	}

