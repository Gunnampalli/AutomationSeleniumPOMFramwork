package com.cb.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cb.annotations.FrameworkAnnotation;
import com.cb.driver.DriverManager;
import com.cb.enums.CategoryTypes;
import com.cb.pages.OrangeHRMLoginpage;
import com.cb.reports.ExtentReport;
import com.cb.utils.DataProviderUtils;

public class OrangeHRMTests extends BaseTest {

	@FrameworkAnnotation(author = { "Venkatesh","Dilip" },category = { CategoryTypes.SMOKE,CategoryTypes.SANITY,CategoryTypes.REGRESSION})
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void loginLogOutTest(Map<String, String> m) {
		OrangeHRMLoginpage ohlp = new OrangeHRMLoginpage();
		ohlp.enterUserName(m.get("UserName")).enterPassword(m.get("Password")).clickLogin().clickProfile()
				.clickLogout();
		ExtentReport.etest.pass("Clicked On LogOut");

		Assert.assertEquals(ohlp.getTitle(), "OrangeHRM");

	}

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void newTest(Map<String, String> m) {
		OrangeHRMLoginpage ohlp = new OrangeHRMLoginpage();
		ohlp.enterUserName(m.get("UserName")).enterPassword(m.get("Password")).clickLogin().clickProfile()
				.clickLogout();
		ExtentReport.etest.pass("Clicked On LogOut");

		Assert.assertEquals(ohlp.getTitle(), "OrangeHRM");
	}

	

}
