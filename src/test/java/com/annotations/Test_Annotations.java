package com.annotations;

import org.testng.annotations.Test;

import com.datadriven.Excel_Read;
import com.utlis.Data_Provider_Utils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Test_Annotations {
  @Test (priority = -1, invocationCount = 1, groups = "a", dataProvider = "getData", dataProviderClass = Data_Provider_Utils.class)
  public void test(String data[]) throws IOException {
	  System.out.println("DataProvider0 : " + data[0]);
	  System.out.println("DataProvider1 : " + data[1]);
  }
  @Test(priority = -2, invocationCount = 2, groups = "a")
  public void test1() {
	  System.out.println("Test1");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("BeforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("AfterMethod");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("BeforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("AfterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("BeforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("AfterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("BeforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("AfterSuite");
  }

}
