package com.security;

import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

public class HashFunction {
	
	//Available algorithms are: MD2, MD5, SHA-1, SHA-224, SHA-256, SHA-384, SHA-512	
	
	public static String getHash(byte[] inputBytes, String algorithm){
		String hasValue = "";
		
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(inputBytes);
			byte[] disgestedBytes = messageDigest.digest();
			hasValue = DatatypeConverter.printHexBinary(disgestedBytes).toLowerCase();
			
		}catch(Exception e){
			
		}
		return hasValue;
	}
}
