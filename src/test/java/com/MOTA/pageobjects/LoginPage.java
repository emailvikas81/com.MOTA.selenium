package com.MOTA.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.Global_Common;

public class LoginPage {
	private static WebDriver driver;

	// Address Purpose
	// @FindBy(how = How.XPATH, using = ".(//a[contains(text(),'Images')])[2]")
	// private static WebElement addressPurposeDropdown;

	// From Date
	@FindBy(how = How.ID, using = "eid")
	private static WebElement usernameEditBox;

	// From Date
	@FindBy(how = How.ID, using = "pw")
	private static WebElement passwordEditBox;

	// // Submit Button
	@FindBy(how = How.NAME, using = "submit")
	private static WebElement submitButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Entering Data to the Address according to the Search Result
	public static void login(String userName, String password) {
		Global_Common.setDriverTimeout(driver, 60, TimeUnit.SECONDS);
		usernameEditBox.sendKeys(userName);
		passwordEditBox.sendKeys(password);
		submitButton.click();
	}
}
