package com.MOTA.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.Global_Common;

public class SearchPage {
	private static WebDriver driver;

	// Address Purpose
	// @FindBy(how = How.XPATH, using = ".(//a[contains(text(),'Images')])[2]")
	// private static WebElement addressPurposeDropdown;

	// From Date
	@FindBy(how = How.ID, using = "gbqfq")
	private static WebElement SearchField;

	// From Date
	@FindBy(how = How.ID, using = "gbqfb")
	private static WebElement SearchButton;

	// // Save Button
	// @FindBy(how = How.LINK_TEXT, using =
	// "Speedtest.net by Ookla - The Global Broadband Speed Test")
	// private static WebElement saveButton;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	// Entering Data to the Address according to the Search Result
	public void searchString(String searchString) {
		Global_Common.setDriverTimeout(driver, 60, TimeUnit.SECONDS);
		SearchField.sendKeys(searchString);
		SearchButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			WebElement bmi = driver.findElement(By.id("resultStats"));
			// assertEquals(bmi.getAttribute("value"), "24.4");
		} catch (Error e) {
			// Capture and append Exceptions/Errors
		}
	}
}
