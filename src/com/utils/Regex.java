package com.utils;

import java.util.regex.Pattern;

// TO DO

public class Regex {

// 	Password Validation
//	- at least 8 characters
//	- must contain at least 1 uppercase letter, 1 lowercase letter, and 1 number
//	- Can contain special characters	
//	"/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/gm";

	public static boolean regexChecker(String theRegex, String str2Check){
		boolean passwordIsValid = false;
		
		Pattern checkRegex = Pattern.compile(theRegex);
		
		
		return passwordIsValid;
	}

}
