package com.cb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cb.driver.DriverManager;
import com.cb.enums.WaitStrategy;

public final class AmazonHamburgerSubMenuPage extends BasePage {

	@FindBy(xpath = "//div[.='Mobiles, Computers']/parent::a")
	private WebElement mobileAndComputerLink;

	@FindBy(xpath = "//a[text()='Laptops']")
	private WebElement laptopsLink;

	@FindBy(xpath = "//a[text()='Drives & Storage']")
	private WebElement drivesAndStorageLink;

	@FindBy(xpath = "//a[text()='Printers & Ink']")
	private WebElement printersAndInkLink;

	private String items = "//a[text()='%s']";

	public AmazonLaptopPage clickSubMenu(String menuItem)

	{
		String newXpath = String.format(items, menuItem);
		click(By.xpath(newXpath), WaitStrategy.CLICKABLE, menuItem);
		if (menuItem.contains("Laptops"))
			return new AmazonLaptopPage();
		else
			return null;
	}

	public AmazonHamburgerSubMenuPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public AmazonHamburgerSubMenuPage clickMobileAndComputers() {
		mobileAndComputerLink.click();
		return this;
	}

	public AmazonLaptopPage clickLaptops() {
		laptopsLink.click();
		return new AmazonLaptopPage();
	}

	public AmazonDrivesAndStoragePage clickDrivesAndStorage() {
		drivesAndStorageLink.click();
		return new AmazonDrivesAndStoragePage();
	}

	public AmazonPrintersAndInkPage clickPrinterAndInk() {
		printersAndInkLink.click();
		return new AmazonPrintersAndInkPage();
	}
}
