package com.cb.seleniumjavatest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLocators {
	
	private String menuItems = "//a[@class='hmenu-item']/div[.='%value%']";
	
	private WebDriver driver;
	
	
	public void clickMenuItems(String name)
	{
		driver.findElement(By.xpath(menuItems.replace("%value%", name)));
	}

}
