package com.cb.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.cb.enums.ConfigProperties;
import com.cb.utils.ReadPropertyFile;

public class RetryListener implements IRetryAnalyzer {

	private int count = 0;
	private int retryLimit = 1;

	@Override
	public boolean retry(ITestResult result) {
		try {
			if (ReadPropertyFile.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
				if (count < retryLimit) {
					count++;
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
