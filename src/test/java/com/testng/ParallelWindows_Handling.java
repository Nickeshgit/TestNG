package com.testng;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.adactin.Base_Class.Base_Class;

public class ParallelWindows_Handling {

	public static WebDriver driver;
	
	@Test
	public void win_Handling() throws Exception {
		
		driver = Base_Class.browser_Launch("chrome");
		Base_Class.getURL("https://letcode.in/windows");
		
		driver.findElement(By.id("home")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> listwindows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(listwindows.get(1));
		System.out.println(driver.getTitle()); 
		
		driver.switchTo().window(listwindows.get(0)).close();
		driver.switchTo().window(listwindows.get(1)).close();
		
		driver = Base_Class.browser_Launch("chrome");
		Base_Class.getURL("https://letcode.in/windows");
		
		driver.findElement(By.id("multi")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		
		List<String> listwindows2 = new ArrayList<>(windowHandles2);
		
		for (String string : listwindows2) {
			driver.switchTo().window(string);
			System.out.println(driver.getTitle());
		}
		driver.quit();
	}
	
}
