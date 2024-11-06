package com.cb.utils;

import java.util.Base64;

public final class DecodeUtils {

	private DecodeUtils() {

	}

	public static String getDecryption(String encrypt) {
		return new String(Base64.getDecoder().decode(encrypt));
	}

}
