package com.Junit2;

public class Junit2 {
	public boolean isPalindrome(String a, String b) {
		StringBuilder sb = new StringBuilder(b);
		
		return a.equals(sb.reverse().toString());
	}
	
	public boolean isOdd(int num) {
		return ((num&1)==1);
	}
}
