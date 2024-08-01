package com.testng;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.adactin.Base_Class.Base_Class;


public class Invocation_Test {
	public static WebDriver driver ;
	
	@Test(invocationCount = 2, invocationTimeOut = 40000)
	public void invocation() throws Exception {
		
		driver = Base_Class.browser_Launch("chrome");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Base_Class.getURL("https://www.google.in/");

		driver.findElement(By.xpath("//textarea[@title = 'Search']")).sendKeys("cricket", Keys.ENTER); 
		List<WebElement> cricket = driver.findElements(By.xpath("//*[contains(text(), 'cricket') or contains(text(), 'Cricket') ]"));
		System.out.println(cricket.size());

		driver.quit();
	}
}
