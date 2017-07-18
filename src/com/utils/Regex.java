package com.utils;

import java.util.regex.*;

public class Regex {

	// 	Password Validation
	//	Minimum eight characters, at least one letter and one number:
	private static String passwordValidation = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
	
	public static void regexChecker(String theRegex, String str2Check){
		boolean passwordIsValid = false;
		
		Pattern checkRegex = Pattern.compile(theRegex);
		Matcher regexMatcher = checkRegex.matcher(str2Check );
				
		// Cycle through the positive matches and print them to screen
		// Make sure string isn't empty and trim off any whitespace
				
		while (regexMatcher.find()){
			if (regexMatcher.group().length() != 0){
				System.out.println( regexMatcher.group().trim() );
						
				// You can get the starting and ending indexs	
				System.out.println( "Start Index: " + regexMatcher.start());
				System.out.println( "Start Index: " + regexMatcher.end());
				}
			}
				
		System.out.println();
	}
}
