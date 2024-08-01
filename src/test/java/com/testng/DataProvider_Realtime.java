package com.testng;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.adactin.Base_Class.Base_Class;

public class DataProvider_Realtime {

	RemoteWebDriver driver;
	
	@Parameters({"browser"})
	@Test
	public void amazon_login(String browser) throws Exception {
		
		switch (browser) {
		case "chrome":
			driver = Base_Class.browser_Launch("chrome");
			break;

		case "firefox":
			driver = Base_Class.browser_Launch("firefox");
			break;

		default:
			System.err.println("No such Browser");
			break;
		}
		driver.get("https://www.amazon.in/ref=nav_logo");
		
	}
	
}
