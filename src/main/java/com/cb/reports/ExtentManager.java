package com.cb.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

	private ExtentManager() {

	}

	private static ThreadLocal<ExtentTest> th = new ThreadLocal<>();

	public static void SetExtentTest(ExtentTest test) {
		th.set(test);
	}

	public static ExtentTest getExtentTest() {
		return th.get();
	}

	public static void removeTest() {
		th.remove();
	}

}
