package com.cb.seleniumjavatest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryDemo {

	private WebDriver driver;

	@FindBy(name = "q")
	private WebElement searchBox;

	public PageFactoryDemo(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void findElement10Times() {
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < 10; i++) {
			searchBox.clear();
			searchBox.sendKeys("Testing");
		}
		System.out.println(System.currentTimeMillis() - startTime);
	}

}
