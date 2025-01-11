package com.MOTA.common;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Common {

	public static String getEnvironment() {
		String environment = System.getenv("ENVIRONMENT");
		if (environment == null) {
			environment = "test";
		}
		return environment;
	}

	public static String getEnvironmentProperty(String propertyFileType,
			String propertyName) {
		ResourceBundle props = ResourceBundle.getBundle(getEnvironment()
				+ propertyFileType);
		try {
			String propertyValue = props.getString(propertyName);
			return propertyValue;
		} catch (Exception e) {
			return null;
		}
	}

	public static String getEnvironmentProperty(String propertyName) {
		return getEnvironmentProperty("", propertyName);
	}

	public static void setDriverTimeout(WebDriver driver, long time,
			TimeUnit unit) {
		driver.manage().timeouts().implicitlyWait(time, unit);
	}
}
