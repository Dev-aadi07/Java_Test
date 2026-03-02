package com.Junit;

public class Junit {
	public String rev(String str) {
		String result = "";
		for (int i = str.length()-1; i>=0; i--) {
			result += str.charAt(i);
		}
		return result;
	}
}
