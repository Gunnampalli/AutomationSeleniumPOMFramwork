package com.cb.seleniumjavatest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NoPageFactory {

	private final By searchBox = By.name("q");

	private WebDriver driver;

	public NoPageFactory(WebDriver driver) {
		this.driver = driver;
	}

	public void findElement10Times() {
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < 10; i++) {
			WebElement element = driver.findElement(searchBox);
			element.clear();
			element.sendKeys("Testing");
		}
		System.out.println(System.currentTimeMillis() - startTime);
	}

}
