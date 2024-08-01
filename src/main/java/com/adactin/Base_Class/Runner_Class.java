package com.adactin.Base_Class;

import org.openqa.selenium.WebDriver;

import objManager.Page_Object_Manager;

public class Runner_Class {

	public static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		
		driver = Base_Class.browser_Launch("chrome");
		
		Base_Class.getURL("https://adactinhotelapp.com/");
		Page_Object_Manager pm = new Page_Object_Manager(driver);
		
		Base_Class.send_Values(pm.getHl().getUsername(), "Nickesh777");
		Base_Class.send_Values(pm.getHl().getPassword(), "Welcome@12345");
		Base_Class.webElement_click(pm.getHl().getLogin());
		
		
		Base_Class.single_selectIndex_dropdown(pm.getSh().getLocation(), 1);
		Base_Class.single_selectIndex_dropdown(pm.getSh().getHotels(), 1);
		Base_Class.single_selectIndex_dropdown(pm.getSh().getRoomtype(), 4);
		Base_Class.single_selectIndex_dropdown(pm.getSh().getRoomnos(), 4);
		Base_Class.single_selectIndex_dropdown(pm.getSh().getAdultroom(), 4);
		Base_Class.single_selectIndex_dropdown(pm.getSh().getChildroom(), 4);
		Base_Class.webElement_click(pm.getSh().getSubmit());
		
		
		Base_Class.webElement_click(pm.getSelh().getRadiobutton());
		Base_Class.webElement_click(pm.getSelh().getContinue());
		
		
		Base_Class.send_Values(pm.getBh().getFirstname(), "Nickesh");
		Base_Class.send_Values(pm.getBh().getLastname(), "Balaji");
		Base_Class.send_Values(pm.getBh().getAddress(), "VGN Krona, Gerugambakkkam, Chennai - 600122");
		Base_Class.send_Values(pm.getBh().getCard_number(), "1223455678892345");
		Base_Class.single_selectValue_dropdown(pm.getBh().getCardtype(), "VISA");
		Base_Class.single_selectIndex_dropdown(pm.getBh().getCard_expmonth(), 3);
		Base_Class.single_selectIndex_dropdown(pm.getBh().getCard_expyear(), 6);
		Base_Class.send_Values(pm.getBh().getCardcvv(), "1234");
		Base_Class.webElement_click(pm.getBh().getBooknow());
		
		Base_Class.implicitily_Wait();
		Base_Class.webElement_click(pm.getBcon().getMyitinerary());
		
	}
	
}
