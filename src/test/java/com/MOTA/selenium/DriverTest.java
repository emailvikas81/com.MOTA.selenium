/**
 * 
 */
package com.MOTA.selenium;

//dependent on conf2.xml - run from it
//run grid D:\Test Automation\JavaScript\SeleniumGrid\lib\SeleniumGrid.bat
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MOTA.pageobjects.LoginPage;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.vertafore.common.Global_Common;

public class DriverTest {

	// public String platform, browser, version, url;
	public static final Logger APPLICATION_LOGS = Logger
			.getLogger("devpinoyLogger");

	WebDriver driver = null; // new FirefoxDriver(); //
	WebDriver driver2 = new HtmlUnitDriver(BrowserVersion.CHROME);

	@Parameters({ "platform", "browser", "version" })
	@BeforeTest(alwaysRun = true)
	public void setup(@Optional("Windows") String platform,
			@Optional("chrome") String browser, @Optional("32") String version)
			throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities(); // Platforms

		if (platform.equalsIgnoreCase("Windows"))
			caps.setPlatform(org.openqa.selenium.Platform.WINDOWS);
		if (platform.equalsIgnoreCase("MAC"))
			caps.setPlatform(org.openqa.selenium.Platform.MAC);
		if (platform.equalsIgnoreCase("Andorid"))
			caps.setPlatform(org.openqa.selenium.Platform.ANDROID); // Browsers

		if (browser.equalsIgnoreCase("Internet Explorer"))
			caps = DesiredCapabilities.internetExplorer();
		if (browser.equalsIgnoreCase("Firefox"))
			caps = DesiredCapabilities.firefox();
		if (browser.equalsIgnoreCase("Chrome"))
			caps = DesiredCapabilities.chrome(); // path set using
													// -Dwebdriver.chrome.driver=""
													// for grid
		if (browser.equalsIgnoreCase("Safari"))
			caps = DesiredCapabilities.safari(); // path set using
													// -Dwebdriver.chrome.driver=""
													// for grid
		if (browser.equalsIgnoreCase("iPad"))
			caps = DesiredCapabilities.ipad();
		if (browser.equalsIgnoreCase("Android"))
			caps = DesiredCapabilities.android();
		if (browser.equalsIgnoreCase("Headless2"))
			caps = DesiredCapabilities.phantomjs(); // Version
													// caps.setVersion(version);
		if (browser.equalsIgnoreCase("Headless"))
			// caps = DesiredCapabilities.htmlUnit();
			// driver = new HtmlUnitDriver(caps);
			caps.setBrowserName("htmlunit");

		try {
			driver = new RemoteWebDriver(
					new URL("http://localhost:4444/wd/hub"), caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		String url = Global_Common.getEnvironmentProperty("url");
		driver.get(url);
		APPLICATION_LOGS.info("Test execution starts...");
		APPLICATION_LOGS.info("Platform: " + platform + ",Browser: " + browser);
	}

	@Test
	public void login() {
		final LoginPage loginPage = PageFactory.initElements(driver,
				LoginPage.class);
		String username = Global_Common.getEnvironmentProperty("username");
		String password = Global_Common.getEnvironmentProperty("password");
		LoginPage.login(username, password);

	}

	@AfterTest
	public void afterTest() {
		// Close the browser
		driver.quit();
	}
}
