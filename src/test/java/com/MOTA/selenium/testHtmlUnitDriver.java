package com.MOTA.selenium;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testHtmlUnitDriver {

	public class DriverTest {
		WebDriver driver = null;
		String baseUrl;

		@BeforeTest
		public void setup() {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true); // not really needed: JS enabled by
												// default
			caps.setCapability(
					PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
					"C://phantomjs.exe");
			caps.setCapability("takesScreenshot", true);
			WebDriver driver = new PhantomJSDriver(caps);
			baseUrl = "http://www.xyz.com";
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

		@Test
		public void test01() throws Exception {
			driver.get(baseUrl + "/");
			long iStart = System.currentTimeMillis(); // start timing
			// <your script>
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("c:\\sample.jpeg"), true);
			System.out.println("Single Page Time:"
					+ (System.currentTimeMillis() - iStart)); // end timing
		}
	}
}