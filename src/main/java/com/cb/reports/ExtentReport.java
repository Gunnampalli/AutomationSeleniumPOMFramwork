package com.cb.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.cb.constants.FrameworkConstants;
import com.cb.enums.CategoryTypes;

public final class ExtentReport {

	private ExtentReport() {

	}

	private static ExtentReports report;
	public static ExtentTest etest;

	public static void initReport()  {
		if (Objects.isNull(report)) {
			report = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentreportpath());
			spark.config().setDocumentTitle("OrangeHRM Report");
			spark.config().setReportName("Login Logout TestCases");
			report.attachReporter(spark);
		}
	}

	public static void flushReports() {
		if (Objects.nonNull(report)) {
			report.flush();
		}
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentreportpath()).toURI());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void testName(String testName) {
		etest = report.createTest(testName);
		ExtentManager.SetExtentTest(etest);
	}

	public static void authorName(String[] authorName) {
		for (String name : authorName) {
			ExtentManager.getExtentTest().assignAuthor(name);
		}
	}

	public static void Category(CategoryTypes[] category) {
		for (CategoryTypes name : category) {
			ExtentManager.getExtentTest().assignCategory(name.toString());
		}
	}

}
