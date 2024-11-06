package com.cb.reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.cb.driver.DriverManager;
import com.cb.enums.ConfigProperties;
import com.cb.utils.ReadPropertyFile;
import com.cb.utils.ScreenshotsUtils;

public final class ExtentLogger {

	private ExtentLogger() {

	}

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}

	public static void info(String message) {
		ExtentManager.getExtentTest().info(message);
	}

	public static void warning(String message) {
		ExtentManager.getExtentTest().warning(message);
	}

	public static void pass(String message, boolean isScreenshotNeeded) {
		if (ReadPropertyFile.get(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
				&& isScreenshotNeeded) {
			ExtentManager.getExtentTest().pass(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotsUtils.getBase64Image()).build());
		} else {
			pass(message);
		}
	}

	public static void fail(String message, boolean isScreenshotNeeded)  {
		if (ReadPropertyFile.get(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
				&& isScreenshotNeeded) {
			ExtentManager.getExtentTest().fail(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotsUtils.getBase64Image()).build());
		} else {
			fail(message);
		}
	}

	public static void skip(String message, boolean isScreenshotNeeded)  {
		if (ReadPropertyFile.get(ConfigProperties.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
				&& isScreenshotNeeded) {
			ExtentManager.getExtentTest().skip(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotsUtils.getBase64Image()).build());
		} else {
			skip(message);
		}
	}

}
