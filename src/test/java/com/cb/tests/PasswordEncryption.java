package com.cb.tests;

import java.util.Base64;

import org.testng.annotations.Test;

public class PasswordEncryption {

	@Test
	public void encryption() {
		String password = "admin123";
		String encrypt = new String(Base64.getEncoder().encode(password.getBytes()));

		System.out.println(encrypt);
		
		System.out.println(Base64.getDecoder().decode(encrypt));

	}

}
