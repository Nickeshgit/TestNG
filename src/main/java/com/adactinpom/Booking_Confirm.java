package com.adactinpom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Booking_Confirm {

	public static WebDriver driver;
	
	public Booking_Confirm(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id  = "my_itinerary")
	private WebElement myitinerary;
	
	public WebElement getMyitinerary() {
		return myitinerary;
	}

	
}
