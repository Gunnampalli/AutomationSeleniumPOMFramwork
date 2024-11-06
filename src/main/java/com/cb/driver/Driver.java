package com.cb.driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cb.constants.FrameworkConstants;
import com.cb.enums.ConfigProperties;
import com.cb.exceptions.BrowserInvocationFailedException;
import com.cb.factories.DriverFactory;
import com.cb.utils.ReadPropertyFile;

public final class Driver {

	private Driver() {

	}

	public static void initDriver(String browser) {

		if (Objects.isNull(DriverManager.getDriver())) {
			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser));
			} catch (MalformedURLException e) {
				throw new BrowserInvocationFailedException("Browser Failed.Please check config.properties");
			}
		}

		DriverManager.getDriver().get(ReadPropertyFile.get(ConfigProperties.URL));
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts()
				.pageLoadTimeout(Duration.ofSeconds(FrameworkConstants.getPageloadtime()));
		DriverManager.getDriver().manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(FrameworkConstants.getImplicitwait()));
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}