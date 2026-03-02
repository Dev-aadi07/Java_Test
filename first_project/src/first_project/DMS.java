package first_project;

import java.util.*;

public class DMS {

	public static void main(String[] args) {
//		Scanner userInput = new Scanner();
		char ch = 'A';
		
//		if (ch>='A' && ch<='Z') {
//			System.out.println("Uppercase");
//		} else if (ch>='a' && ch<='z') {
//			System.out.println("Lowercase");
//		} else if (ch>='0' && ch<='9') {
//			System.out.println("Number");
//		} else {
//			System.out.println("Special Char");
//		}
		
		switch(ch) {
		case'A' : case'B' : 
			System.out.println("UpperCase");
			break;
		case'a' : case'b':
			System.out.println("LowerCase");
		}
	}

}
