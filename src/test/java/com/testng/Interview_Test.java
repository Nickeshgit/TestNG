package com.testng;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.adactin.Base_Class.Base_Class;

public class Interview_Test {

	public static RemoteWebDriver driver;
	public static void main(String[] args) throws Exception {
		
		driver = Base_Class.browser_Launch("chrome");
		driver.get("https://iascertification.com/");
		driver.findElement(By.xpath("//*[text()= 'Contact us']")).click();
		String title = driver.getTitle();
		System.out.println(title);
		
		if ("Contact Us Today | Integrated Assessment Services India".equals(title)) {
			System.out.println("Contact us column is working fine");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//input[@name='title']")).sendKeys("Mr.");
			driver.findElement(By.xpath("//input[@name='your-name']")).sendKeys("ABC");
			driver.findElement(By.xpath("//input[@name='company-name']")).sendKeys("IASEAS");
			driver.findElement(By.xpath("//input[@name='Job-Title']")).sendKeys("Tester");
			driver.findElement(By.xpath("//input[@name='country']")).sendKeys("India");
			driver.findElement(By.xpath("//input[@name='phone_no']")).sendKeys("9876543210");
			driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("nickesh777@gmail.com");
			/*
			 * Actions a = new Actions(driver); a.moveToElement(enqsel);
			 */
			Base_Class.scrollTo_Particular_Portion(driver.findElement(By.xpath("//span[@title='Select Enquiry Type']")));
			WebElement enq = driver.findElement(By.xpath("//select[@name = 'enquiry-type']"));
			Select sel = new Select(enq);
			sel.selectByIndex(1);
			driver.findElement(By.xpath("//textarea[@name = 'remarks']")).sendKeys("Providing proper training with Guidance will be helpful");
			driver.findElement(By.xpath("//input[@type = 'checkbox']")).click();
			
			WebElement send = driver.findElement(By.xpath("//input[@type='submit']"));
			Base_Class.scrollTo_Particular_Portion(send);
			
			WebElement agree = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
			driver.switchTo().frame(agree);
			
			driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-spinner']")).click();
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			
		} else {
			System.out.println(" Contact us column is not working");
		}
		
		
	} 
	
}
