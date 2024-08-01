package com.testng;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.adactin.Base_Class.Base_Class;

import objManager.Page_Object_Manager;

public class Param_Test {
	
	public static WebDriver driver;
	
	@Parameters({"username", "password"})
	@Test
	public void params_Test(String uname, String pword) throws Exception {

		driver =  Base_Class.browser_Launch("chrome");
		Page_Object_Manager pm = new Page_Object_Manager(driver);
		
		Base_Class.implicitily_Wait();
		Base_Class.getURL("https://adactinhotelapp.com/");
		Base_Class.send_Values(pm.getHl().getUsername(), uname); 
		Base_Class.send_Values(pm.getHl().getPassword(), pword);
		Base_Class.webElement_click(pm.getHl().getLogin());
		
	}
}
