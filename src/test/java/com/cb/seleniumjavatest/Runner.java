package com.cb.seleniumjavatest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Runner {

	private WebDriver driver;

	@BeforeMethod
	public void setUP() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void pageFactoryDemoTest() {
		PageFactoryDemo pfd = new PageFactoryDemo(driver);
		pfd.findElement10Times();
	}

	@Test(priority = 2)
	public void PageFactoryDemoWithCacheLookupTest() {
		PageFactoryDemoWithCacheLookUp pfdc = new PageFactoryDemoWithCacheLookUp(driver);
		pfdc.findElement10Times();
	}

	@Test(priority = 3)
	public void noPageFactoryTest() {
		NoPageFactory npf = new NoPageFactory(driver);
		npf.findElement10Times();
	}
}
