package com.adactin.Base_Class;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Base_Class {

	public static RemoteWebDriver driver;

	// Browser Launch:
	public static RemoteWebDriver browser_Launch(String browser) throws Exception {

		// is break required ??
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ASUS\\eclipse-workspace\\Letcode_TestNG\\Chrome\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Chrome");

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\ASUS\\eclipse-workspace\\Letcode_TestNG\\FireFox\\geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("Fire Fox");
		} else {
			throw new Exception("Invalid Browser");
		}
		driver.manage().window().maximize();
		return driver;

	}

	// Launch URL :
	public static void getURL(String url) {
		driver.get(url);
	}

	// sendkeys(input value):
	public static void send_Values(WebElement element, String values) {
		element.sendKeys(values);
	}

	// Click:
	public static void webElement_click(WebElement element) {
		element.click();
	}

	// Close:
	public static void driverClose() {
		driver.close();
	}

	// Quit:
	public static void driverQuit() {
		driver.quit();
	}

	// Get current URL:
	public static String current_url() {

		String curl = driver.getCurrentUrl();
		System.out.println("The current url is : " + curl);
		return curl;
	}

	// Get title:
	public static String get_Title() {

		String title = driver.getTitle();
		System.out.println("The Title is : " + title);
		return title;
	}

	// Get Text:
	public static void get_Text(WebElement element) {

		System.out.println(element.getText());
	}

	// Get Attiribute:
	public static void get_Attribute(WebElement element) {

		String attribute = element.getAttribute("type");
		System.out.println(attribute);
	}

	// Get Options:
	public static void get_Options(WebElement element) {

		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		for (WebElement opt : options) {
			System.out.println("Options : " + opt);
		}

	}

	// Navigate to:
	public static void navigate_to(String url) {

		driver.navigate().to(url);
	}

	// Navigate forward:
	public static void navigate_forward() {

		driver.navigate().forward();
	}

	// Navigate back:
	public static void navigate_back() {

		driver.navigate().back();
	}

	// Navigate refersh:
	public static void navigate_refersh() {

		driver.navigate().refresh();
	}

	// Actions_ Click (Mouse based):
	public static void actions_mouse_Click(WebElement element, String click) throws Exception {
		Actions a = new Actions(driver);

		// is break required ??

		if (click.equalsIgnoreCase("click")) {
			a.click(element).build().perform();
		} else if (click.equalsIgnoreCase("doubleclick")) {
			a.doubleClick(element).build().perform();
		} else if (click.equalsIgnoreCase("rightclick")) {
			a.contextClick(element).build().perform();
		} else if (click.equalsIgnoreCase("clickandhold")) {
			a.clickAndHold(element).build().perform();
		} else {
			throw new Exception("Wrong Actions click");
		}

	}

	// Actions_Move to element (Mouse based):
	public static void mouse_moveToElement(WebElement element) {

		Actions ac = new Actions(driver);
		ac.moveToElement(element).build().perform();
	}

	// Actions_Drag and Drop (Mouse based):
	public static void mouse_drag_and_drop(WebElement element1, WebElement element2) {

		Actions ac = new Actions(driver);
		ac.dragAndDrop(element1, element2).build().perform();
		// why double click ?? ac.doubleClick().build().perform();
	}

	// Actions_ Robot (Keyboard based):
	public static void keyboard_robot(WebElement element) throws Exception, InterruptedException {

		Actions ac = new Actions(driver);
		ac.contextClick(element).build().perform();
		Robot ro = new Robot();

		ro.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(3000);
		ro.keyRelease(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(3000);
		ro.keyPress(KeyEvent.VK_ENTER);
		ro.keyRelease(KeyEvent.VK_ENTER);
	}

	/*
	 * public static void keyboard_Robot(WebElement element) throws AWTException {
	 * Actions a = new Actions(driver); a.contextClick(element);
	 * 
	 * Robot builder = new Robot(); builder.keyPress(KeyEvent.VK_DOWN);
	 * builder.keyRelease(KeyEvent.VK_DOWN); builder.keyPress(KeyEvent.VK_ENTER);
	 * builder.keyRelease(KeyEvent.VK_ENTER);
	 * 
	 * }
	 */

	// Simple Alert:
	public static void simple_Alert(WebElement element) {

		element.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	// Confirm Alert:
	public static void confirm_Alert(WebElement element, String options) {

		element.click();
		Alert con = driver.switchTo().alert();

		if (options.equalsIgnoreCase("ok")) {

			con.accept();
		} else {

			con.dismiss();
		}
	}

	// Prompt Alert:
	public static void prompt_alert(WebElement element, String send_Values) throws InterruptedException {

		// why thread.sleep ??

		element.click();
		Thread.sleep(3000);
		Alert al = driver.switchTo().alert();
		al.sendKeys(send_Values);
		al.accept();
		Thread.sleep(3000);
	}

	// Single Select by Index Drop Down:
	public static void single_selectIndex_dropdown(WebElement element, int selectIndex) {

		Select sel = new Select(element);
		sel.selectByIndex(selectIndex);
	}

	// Single Select by Value Drop Down:
	public static void single_selectValue_dropdown(WebElement element, String selectValue) {

		Select sel = new Select(element);
		sel.selectByValue(selectValue);
	}

	// Multiple Select by Index Drop Down:
	public static void multiple_selectIndex_dropdown(WebElement element) {
		Select multi = new Select(element);

		// selections may differ ??

		multi.selectByIndex(1);
		multi.selectByIndex(2);
		multi.selectByIndex(3);
	}

	// IsMultiple :
	public static void elementIsMultiple(WebElement element) {

		Select ismulti = new Select(element);
		boolean multiple = ismulti.isMultiple();
		System.out.println("Is Multiple Dropdown : " + multiple);
	}

	// Get first selected option :
	public static void firstSelected_Option(WebElement element, int selectIndex) {

		Select sel = new Select(element);
		sel.selectByIndex(selectIndex);
		WebElement fso = sel.getFirstSelectedOption();
		System.out.println("First Selected Option is : " + fso.getText());
	}

	// Get all selected option :
	public static void allSelected_Option(WebElement element) throws InterruptedException {

		Select multi = new Select(element);
		Thread.sleep(3000);
		multi.selectByIndex(1);
		multi.selectByIndex(2);
		multi.selectByIndex(3);
		multi.selectByIndex(4);
		List<WebElement> aso = multi.getAllSelectedOptions();
		for (WebElement kk : aso) {
			System.out.println(kk.getText());
		}
	}

	// Scroll Down :
	public static void scroll_Down() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,800)");
	}

	// Scroll Up :
	public static void scroll_Up() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-800)");
	}

	// Scroll To Particular Portion :
	public static void scrollTo_Particular_Portion(WebElement element) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	// Click by Java script Executor :
	public static void JavascriptExecutor_Click(WebElement element) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		js.executeScript("arguments[0].click()", element);
	}

	// Scroll to the bottom of the website :
	public static void scrollTo_BottomOfWebsite() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	// Scroll to the top or Home page of the website :
	public static void scrollTo_TopOfWebsite() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		js.executeScript("window.scrollTo(0,0)");
	}

	// IsEnabled :
	public static boolean elementIsEnabled(WebElement element) {

		/* boolean enabled = element.isEnabled() */
		boolean enabled = false;
		enabled = element.isEnabled();
		System.out.println(enabled);
		return enabled;
	}

	// IsSelected :
	public static boolean elementIsSelected(WebElement element) {

		/* boolean selected = element.isSelected() */
		boolean selected = false;
		selected = element.isSelected();
		System.out.println(selected);
		return selected;
	}

	// IsDisplayed :
	public static boolean elementIsDisplayed(WebElement element) {

		/* boolean displayed = element.isDisplayed() */
		boolean displayed = false;
		displayed = element.isDisplayed();
		System.out.println(displayed);
		return displayed;
	}

	// Implicitly Wait :
	public static void implicitily_Wait() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// WebDriver Wait or Explicitily Wait for click
	public static void explicitily_Wait_click(WebElement element) {

		WebDriverWait ww = new WebDriverWait(driver, 20);
		ww.until(ExpectedConditions.visibilityOf(element)).click();
	}

	// Screen Shot:
	public static void take_Screenshot(String dest) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File(dest));

		/*
		 * TakesScreenshot ts = (TakesScreenshot) driver; File from =
		 * ts.getScreenshotAs(OutputType.FILE); File to = new File(
		 * "C:\\Users\\vpssu\\eclipse-workspace\\Selenium_Testing\\Screenshot\\facebookHomePage.png"
		 * ); FileHandler.copy(from, to);
		 */
	}

	// Iframe:
	public static void i_Frame(WebElement element) {
		driver.switchTo().frame(element);

	}

	// Window Handles:
	public static void window_handles(WebElement element) throws InterruptedException {

		String oldwindow = driver.getWindowHandle();
		System.out.println("Window Name : " + oldwindow);
		element.click();

		Set<String> newWindow = driver.getWindowHandles();
		for (String handler : newWindow) {
			driver.switchTo().window(handler);
		}

		/*
		 * for (String handler : newWindow) { String titles =
		 * driver.switchTo().window(handler).getTitle();
		 * System.out.println("Windows Title : " + titles); }
		 */

	}

	// Radio Button:
	public static void radio_Button(WebElement element) {

		element.click();
	}

	// Check Box:
	public static void checkBox(WebElement element) {

		element.click();
	}
}


