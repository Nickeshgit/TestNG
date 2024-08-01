package com.testng;

import java.util.NoSuchElementException;

import org.testng.annotations.Test;

public class Enabledes_AlwaysRun {

	@Test(enabled = true, description = "This signs out", dependsOnMethods = "buyroll", alwaysRun = true)
	public void signout() {
		System.out.println("Signout");
	}

	@Test(enabled = true, description = "This buys roll", dependsOnMethods = "signin" )
	public void buyroll() {
		System.out.println("Buyroll");
		throw new NoSuchElementException("No element");
	}

	@Test(enabled = true, description = "This signs in")
	public void signin() {
		System.out.println("signin");
	}

}
