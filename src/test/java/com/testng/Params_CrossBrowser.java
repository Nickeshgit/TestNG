package com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.adactin.Base_Class.Base_Class;

import objManager.Page_Object_Manager;

public class Params_CrossBrowser {

	RemoteWebDriver driver;
	@Parameters({"username","password", "browser"})
	@Test
	public void params_Test(String uname, String pword, String browser) throws Exception {

		switch (browser) {
		case "chrome":
			driver = Base_Class.browser_Launch(browser);
			break;

		case "firefox":
			driver = Base_Class.browser_Launch(browser);
			break;
		default:
			System.err.println("No Browser");
			break;
		}

		Page_Object_Manager pm = new Page_Object_Manager(driver);

		Base_Class.implicitily_Wait();
		Base_Class.getURL("https://adactinhotelapp.com/");
		Base_Class.send_Values(pm.getHl().getUsername(), uname);
		Base_Class.send_Values(pm.getHl().getPassword(), pword);
		Base_Class.webElement_click(pm.getHl().getLogin());

		Base_Class.driverQuit();
	}

}


