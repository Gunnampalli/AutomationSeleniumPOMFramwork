package com.cb.tests;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cb.driver.DriverManager;

public final class HomepageTest extends BaseTest {
	private HomepageTest() {

	}

	@Test
	public void test3() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Selenium Testing", Keys.ENTER);
		String title = DriverManager.getDriver().getTitle();
		assertTrue(Objects.nonNull(title));
		assertTrue(title.toLowerCase().contains("google search"));
		assertTrue(title.length() > 15, "Title is less than 15 characters");
		assertTrue(title.length() < 100);
		List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//h3"));

		assertTrue(elements.size() > 15);

		boolean isElementPresent = false;

		for (WebElement webElement : elements) {
			if (webElement.getText().toLowerCase().contains("selenium webdriver")) {
				isElementPresent = true;
				break;
			}
		}

		assertTrue(isElementPresent, "Element not found");
	}

}
