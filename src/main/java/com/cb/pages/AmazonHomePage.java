package com.cb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cb.driver.DriverManager;

public final class AmazonHomePage {
	
	@FindBy(id="nav-hamburger-menu")
	private WebElement hamburgerMenu;
	
	public AmazonHomePage()
	{
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public AmazonHamburgerSubMenuPage clickHamburgerMenu()
	{
		hamburgerMenu.click();
		return new AmazonHamburgerSubMenuPage();
	}

}
