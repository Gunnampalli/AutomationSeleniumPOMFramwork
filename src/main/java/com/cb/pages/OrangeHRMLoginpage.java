package com.cb.pages;

import org.openqa.selenium.By;

import com.cb.driver.DriverManager;
import com.cb.enums.WaitStrategy;
import com.cb.utils.DecodeUtils;

public final class OrangeHRMLoginpage extends BasePage {

	private final By userNameTxtbox = By.xpath("//input[@name='username']");
	private final By passwordTxtbox = By.xpath("//input[@name='password' and @type='password']");
	private final By loginBtn = By.xpath("//button[@type='submit']");

	public OrangeHRMLoginpage enterUserName(String name) {
		sendKeys(userNameTxtbox, name, WaitStrategy.PRESENCE, "UserName Textbox");
		return this;
	}

	public OrangeHRMLoginpage enterPassword(String pwd) {
		sendKeys(passwordTxtbox, DecodeUtils.getDecryption(pwd), WaitStrategy.PRESENCE, "Password TextBox");

		return this;
	}

	public OrangeHRMHomepage clickLogin() {
		click(loginBtn, WaitStrategy.CLICKABLE, "Login Button");
		return new OrangeHRMHomepage();

	}

	public String getTitle() {
		return DriverManager.getDriver().getTitle();

	}

}
