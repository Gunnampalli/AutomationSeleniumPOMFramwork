package com.cb.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class DriverManager {

	private DriverManager() {

	}

	public static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

	public static void setDriver(WebDriver driverref) {
		dr.set(driverref);
	}

	public static WebDriver getDriver() {
		return dr.get();
	}

	public static void unload() {
		dr.remove();
	}

}
