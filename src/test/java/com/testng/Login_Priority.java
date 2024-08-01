package com.testng;

import org.testng.annotations.Test;

public class Login_Priority {

	@Test(priority = 2)
	public void signout() {
		System.out.println("Signout");
	}
	
	@Test(priority = -1)
	public void buyroll() {
		System.out.println("Buyroll");
	}
	
	@Test(priority = -2)
	public void signin() {
		System.out.println("signin");
	}
	
	@Test
	public void pay() {
		System.out.println("Pay");
	}
	
}
