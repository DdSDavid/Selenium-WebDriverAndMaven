package com.project.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class SignIn_Test {
	
	private WebDriver driver;
	SignInPage singInPage;

	@Before
	public void setUp() throws Exception {
		singInPage = new SignInPage(driver);
		driver = singInPage.chromeDriverConnection();
		singInPage.visit("https://demo.guru99.com/test/newtours/");
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		singInPage.signIn();
		Thread.sleep(2000);
		assertTrue(singInPage.isHomePageDisplayed());
	
	}

}
