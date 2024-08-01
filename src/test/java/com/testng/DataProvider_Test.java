package com.testng;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.adactin.Base_Class.Base_Class;
import com.utlis.Data_Provider_Utils;

import objManager.Page_Object_Manager;

public class DataProvider_Test {

	// @Parameters({"id"})
	@Test(dataProvider = "getData", dataProviderClass = Data_Provider_Utils.class)
	public void dataparams(String data[]) throws Exception {

		System.out.println( "id :" + data[0]);
		System.out.println( "name :" + data[1]);

		RemoteWebDriver driver = Base_Class.browser_Launch("chrome");
		Page_Object_Manager pm = new Page_Object_Manager(driver);
		Base_Class.implicitily_Wait();
		Base_Class.getURL("https://adactinhotelapp.com/");
		Base_Class.send_Values(pm.getHl().getUsername(), data[0]);
		Base_Class.send_Values(pm.getHl().getPassword(), data[1]);
		Base_Class.webElement_click(pm.getHl().getLogin());

		Base_Class.driverQuit();

	}

}
