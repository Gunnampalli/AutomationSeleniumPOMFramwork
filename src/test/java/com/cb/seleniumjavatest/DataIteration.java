package com.cb.seleniumjavatest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataIteration {

	@BeforeMethod()
	public void bmethod(Object[] data)
	{
		System.out.println(data.length);
		for(int i=0;i<data.length;i++)
		{
			System.out.println(data[i]);
		}
	}
	@Test(dataProvider = "getData")
	public void validateData(String fName, String lName) {
	
	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "Venkatesh", "Reddy" }, { "Dilip", "kumar" } };
	}

}
