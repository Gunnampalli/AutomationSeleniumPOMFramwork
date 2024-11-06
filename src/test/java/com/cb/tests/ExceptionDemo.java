package com.cb.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

public class ExceptionDemo {

	@Test
	public void test1() {

		try(FileInputStream fip = new FileInputStream("")) 
		{
			
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

}
