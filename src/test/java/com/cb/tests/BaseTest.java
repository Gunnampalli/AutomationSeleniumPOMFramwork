package com.cb.tests;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.cb.driver.Driver;

public class BaseTest {

	protected BaseTest() {

	}

	@BeforeMethod
	public void setUp(Object[] data) throws Exception {

	//Map<String, String> map = (Map<String, String>) data[0];
	  //System.out.println(data[0].toString());
		Driver.initDriver("chrome");//map.get("Browser"));
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		Driver.quitDriver();
	}

}
