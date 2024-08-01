package com.testng;

import org.testng.annotations.Test;

public class Groups_Test {

	@Test(priority = 2, groups = {"reg", "sanity"})
	public void signout() {
		System.out.println("Signout");
	}
	
	@Test(priority = -1, groups = "reg")
	public void buyroll() {
		System.out.println("Buyroll");
	}
	
	@Test(priority = -2, groups = "sanity")
	public void signin() {
		System.out.println("signin");
	}
	
	@Test(groups = "sanity")
	public void pay() {
		System.out.println("Pay");
	}
	
}
