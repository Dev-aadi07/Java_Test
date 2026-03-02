package encapsulation;

public class Demo {

	public static void main(String[] args) {
		String word = "madam";
		
		int n = word.length();
		
		for (int i = 0; i<n/2; i++) {
			
			if (word.charAt(i) != word.charAt(n-i-1)) {
				
				System.out.println("Not a palindrome");
				break;
			}
		}
		
		System.out.println("Its a palindrome");
	}
}
