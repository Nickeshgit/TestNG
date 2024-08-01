package com.testng;

import org.testng.annotations.Test;

public class DependsOn_Test {

	@Test(dependsOnMethods = "pay", priority = 3)
	public void signout() {
		System.out.println("Signout");
	}
	
	@Test(dependsOnMethods = "dependsn_Test.DependsOn2_Test.signin", priority = 2)
	public void buyroll() {
		System.out.println("Buyroll");
	}
	
	@Test(dependsOnMethods = "buyroll", priority = 4 )
	public void pay() {
		System.out.println("Pay");
		throw new RuntimeException();
	}
}
