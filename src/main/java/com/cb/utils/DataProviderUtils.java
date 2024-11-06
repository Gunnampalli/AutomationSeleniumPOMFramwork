package com.cb.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.cb.constants.FrameworkConstants;

public final class DataProviderUtils {

	private DataProviderUtils() {

	}

	static List<Map<String, String>> list = new ArrayList<>();

	@DataProvider
	public static Object[] getData(Method m) {
		if (list.isEmpty()) {
			list = ExcelUtils.getTestDetails(FrameworkConstants.getDatasheet());
		}
		List<Map<String, String>> iterationList = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).get("TestName").equalsIgnoreCase(m.getName())
					&& (list.get(i).get("Execute").equalsIgnoreCase("yes"))) {
				iterationList.add(list.get(i));
			}
		}

		return iterationList.toArray();

	}
}
