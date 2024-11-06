package com.cb.pages;

import org.openqa.selenium.By;

import com.cb.enums.WaitStrategy;
import com.cb.reports.ExtentLogger;

public final class OrangeHRMHomepage extends BasePage {

	private final By profileName = By.xpath("//p[.='manda user']");
	private final By logOutLink = By.xpath("//a[.='Logout']");

	public OrangeHRMHomepage clickProfile() {
		click(profileName, WaitStrategy.CLICKABLE,"Profile Link");
		
		return this;
	}

	public OrangeHRMLoginpage clickLogout() {
		click(logOutLink, WaitStrategy.CLICKABLE,"LogOut button");
		return new OrangeHRMLoginpage();
	}

}
