package com.cb.factories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cb.constants.FrameworkConstants;
import com.cb.driver.DriverManager;
import com.cb.enums.WaitStrategy;

public class ExplicitWaitStrategy {

	public static WebElement performExplicitWait(By by, WaitStrategy waitStrategy) {
		WebElement element = null;
		if (waitStrategy == WaitStrategy.CLICKABLE) {
			element = isElementTobeClickable(by);
		} else if (waitStrategy == WaitStrategy.PRESENCE) {
			element = isElementTobePresent(by);
		} else if (waitStrategy == WaitStrategy.VISIBLE) {
			element = isElementTobeVisible(by);
		} else if (waitStrategy == WaitStrategy.NONE) {
			element = null;
		}
		return element;
	}

	private static WebElement isElementTobeClickable(By by) {
		return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
				.until(ExpectedConditions.elementToBeClickable(by));
	}

	private static WebElement isElementTobePresent(By by) {
		return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
				.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	private static WebElement isElementTobeVisible(By by) {
		return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
				.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

}
