package com.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class ServiceUtils {
	@SuppressWarnings("restriction")
	public static String md5(String message) {
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte md5[] = md.digest(message.getBytes());
			sun.misc.BASE64Encoder base64Encoder = new sun.misc.BASE64Encoder();
			return base64Encoder.encode(md5);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException();
		}
	}
}
