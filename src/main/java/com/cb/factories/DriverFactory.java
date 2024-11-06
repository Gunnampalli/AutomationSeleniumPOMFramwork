package com.cb.factories;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cb.enums.ConfigProperties;
import com.cb.utils.ReadPropertyFile;

public final class DriverFactory {

	private DriverFactory() {

	}

	public static WebDriver getDriver(String browser) throws MalformedURLException {
		String runmode = ReadPropertyFile.get(ConfigProperties.RUNMODE);
		WebDriver driver = null;

		if (browser.equalsIgnoreCase("chrome")) {
			if (runmode.equalsIgnoreCase("remote")) {
				ChromeOptions opt = new ChromeOptions();
				driver =  new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), opt);
			}
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			if (runmode.equalsIgnoreCase("remote")) {
				FirefoxOptions opt = new FirefoxOptions();
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), opt);
			}
			driver = new FirefoxDriver();
		}
		return driver;
	}

	
}
