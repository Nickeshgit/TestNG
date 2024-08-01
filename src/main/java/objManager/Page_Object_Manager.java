package objManager;

import org.openqa.selenium.WebDriver;

import com.adactinpom.Book_Hotel;
import com.adactinpom.Booking_Confirm;
import com.adactinpom.Hotel_Login;
import com.adactinpom.Search_Hotel;
import com.adactinpom.Select_Hotel;

public class Page_Object_Manager {

	public static WebDriver driver;
	
	private Hotel_Login hl;
	private Search_Hotel sh;
	private Select_Hotel selh;
	private Book_Hotel bh;
	private Booking_Confirm bcon;
	

	public Page_Object_Manager(WebDriver driver2) {
		this.driver = driver2;
	}

	public Hotel_Login getHl() {
		hl = new Hotel_Login(driver);
		return hl;
	}
	
	public Search_Hotel getSh() {
		sh = new Search_Hotel(driver);
		return sh;
	}

	public Select_Hotel getSelh() {
		selh = new Select_Hotel(driver);
		return selh;
	}

	public Book_Hotel getBh() {
		bh = new Book_Hotel(driver);
		return bh;
	}

	public Booking_Confirm getBcon() {
		bcon = new Booking_Confirm(driver);
		return bcon;
	}

}
