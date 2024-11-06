package com.cb.tests;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cb.annotations.FrameworkAnnotation;
import com.cb.driver.DriverManager;
import com.cb.enums.CategoryTypes;
import com.cb.pages.AmazonHomePage;
import com.cb.reports.ExtentManager;

public final class AmazonDemoTest extends BaseTest {

	private AmazonDemoTest() {

	}

	@FrameworkAnnotation(author = { "Venkatesh","Dilip" },category = { CategoryTypes.SMOKE,CategoryTypes.SANITY,CategoryTypes.REGRESSION})
	@Test(description = "Validate Laptops Page")
	public void amazonTest(Method m) {
		

		
		  new AmazonHomePage().clickHamburgerMenu()
		                      .clickMobileAndComputers()
		                       .clickSubMenu("Laptops");
		  Assert.assertEquals(DriverManager.getDriver().getTitle(),  "Laptops: Buy Laptop Online with Up to 60% OFF at Amazon.in");
		 
	}

}
