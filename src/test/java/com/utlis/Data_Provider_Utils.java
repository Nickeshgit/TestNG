package com.utlis;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.datadriven.Excel_Read;

public class Data_Provider_Utils {

	@DataProvider(parallel =! true)  									//indices = {0,2}, 
	public String[][] getData() throws IOException {
		
		String[][] excelData = Excel_Read.read_Excel();
		/* String[][] data = new String[3][2];
		 * data[0][0] = "nick@ce.com"; data[0][1] = "welc12345"; data[1][0] =
		 * "Nickesh777"; data[1][1] = "Welcome@12345"; data[2][0] = "Sanju"; data[2][1]
		 * = "Welcome@12345";
		 */
		
		return excelData;
	}
	
}
