package com.cb.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.cb.annotations.FrameworkAnnotation;
import com.cb.reports.ExtentLogger;
import com.cb.reports.ExtentManager;
import com.cb.reports.ExtentReport;

public class TestListener implements ISuiteListener, ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.testName(result.getMethod().getMethodName());
		ExtentReport.authorName(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).author());
		ExtentReport.Category(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).category());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
			ExtentLogger.pass(result.getMethod().getMethodName() + " is Passed", true);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
			ExtentLogger.fail(result.getMethod().getMethodName() + " is Failed", true);
			ExtentLogger.fail(result.getThrowable().toString());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + " is Skipped");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

	@Override
	public void onStart(ISuite suite) {
		
			ExtentReport.initReport();
		
	}

	@Override
	public void onFinish(ISuite suite) {
		ExtentReport.flushReports();
	}

}
