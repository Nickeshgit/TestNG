package com.testng;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.adactin.Base_Class.Base_Class;

public class ExpectExpection_Pool_Tout {

	public static WebDriver driver;

	@Test(expectedExceptions = {NoSuchElementException.class, ArithmeticException.class})
	public void findElements() throws Exception {

		driver = Base_Class.browser_Launch("chrome");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Base_Class.getURL("https://www.google.in/");

		driver.findElement(By.xpath("//wtextarea[@title = 'Search']")).sendKeys("cricket", Keys.ENTER);
		List<WebElement> cricket = driver
				.findElements(By.xpath("//*[contains(text(), 'cricket') or contains(text(), 'Cricket') ]"));
		System.out.println(cricket.size());

		driver.quit();
	}
}

/*   threadPoolSize
 * @Test(invocationCount = 3, threadPoolSize = 3, timeOut = 6000) 
 * public void findElements()
 * throws Exception {
 * 
 * driver = Base_Class.browser_Launch("chrome");
 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 * Base_Class.getURL("https://www.google.in/");
 * 
 * driver.findElement(By.xpath("//textarea[@title = 'Search']")).sendKeys(
 * "cricket", Keys.ENTER); List<WebElement> cricket = driver .findElements(By.
 * xpath("//*[contains(text(), 'cricket') or contains(text(), 'Cricket') ]"));
 * System.out.println(cricket.size());
 * 
 * driver.quit(); }
 */