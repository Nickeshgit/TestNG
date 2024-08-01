package com.adactinpom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Book_Hotel {

	public static WebDriver driver;
	
	public Book_Hotel(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "first_name")
	private WebElement firstname;

	@FindBy(id = "last_name")
	private WebElement lastname;

	@FindBy(id  = "address")
	private WebElement address;

	@FindBy(id = "cc_num")
	private WebElement cardnumber;

	@FindBy(id  = "cc_type")
	private WebElement cardtype;

	@FindBy(id = "cc_exp_month")
	private WebElement cardexpmonth;

	@FindBy(id = "cc_exp_year")
	private WebElement cardexpyear;

	@FindBy(id = "cc_cvv")
	private WebElement cardcvv;

	@FindBy(id  = "book_now")
	private WebElement booknow;

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCard_number() {
		return cardnumber;
	}

	public WebElement getCardtype() {
		return cardtype;
	}

	public WebElement getCard_expmonth() {
		return cardexpmonth;
	}

	public WebElement getCard_expyear() {
		return cardexpyear;
	}

	public WebElement getCardcvv() {
		return cardcvv;
	}

	public WebElement getBooknow() {
		return booknow;
	}


}
