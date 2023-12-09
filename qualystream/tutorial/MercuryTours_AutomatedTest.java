package com.qualystream.tutorial;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTours_AutomatedTest {
	
	private WebDriver driver;
	//Elementos de la página de Registro
	By registerLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
	
	By usernameLocator = By.id("email");
	By passwordLocator = By.name("password");
	By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
	
	By registerBtnLocator = By.name("submit");
	
	//Elementos de la página de Sign in
	By userLocator = By.name("userName");
	By passLocator = By.name("password");
	By signInBtnLocator = By.name("submit");
	
	By homePageLocator = By.xpath("//h3");
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver15/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/");
		;
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void registerUser() throws InterruptedException {
		driver.findElement(registerLinkLocator).click();
	Thread.sleep(2000);
	if(driver.findElement(registerPageLocator).isDisplayed()) {
		driver.findElement(usernameLocator).sendKeys("qualityadmin");
		driver.findElement(passwordLocator).sendKeys("pass1");
		driver.findElement(confirmPasswordLocator).sendKeys("pass1");
		
		driver.findElement(registerBtnLocator).click();
	}
	else {
		System.out.print("Register pages was not fount");
		}
	List<WebElement> fonts = driver.findElements(By.tagName("font"));
	
	assertEquals("Note: Your user name is qualityadmin.",fonts.get(5).getText());
	
	}

	@Test
	public void singIn() {
		if(driver.findElement(userLocator).isDisplayed()) {
			driver.findElement(userLocator).sendKeys("qualityadmin");
			driver.findElement(passLocator).sendKeys("pass1");
			driver.findElement(signInBtnLocator).click();


			assertTrue(driver.findElement(homePageLocator).isDisplayed());
		}
		else
			System.out.print("username texbox was not present");
		
	}
}
