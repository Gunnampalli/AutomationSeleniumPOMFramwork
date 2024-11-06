package com.cb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cb.enums.WaitStrategy;
import com.cb.factories.ExplicitWaitStrategy;
import com.cb.reports.ExtentLogger;

public class BasePage {

	public void click(By by, WaitStrategy waitStrategy,String elementName) {
		WebElement element = ExplicitWaitStrategy.performExplicitWait(by, waitStrategy);
		element.click();
	
			ExtentLogger.pass(elementName + " is clicked",true);
		
	}

	public void sendKeys(By by, String value, WaitStrategy waitStrategy,String elementName) {
		WebElement element = ExplicitWaitStrategy.performExplicitWait(by, waitStrategy);
		element.clear();
		element.sendKeys(value);
		
			ExtentLogger.pass("Entered the text : " + value+ " in "+ elementName,true);
	
	}

}
