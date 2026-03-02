package p1;

public class Demo {
	//global member -> static block, non-static block, variable, constructor
	public static int i;
	public static void main(String[] args) {
		
	}
	
	public static String whatIsIt(char c) {
		String rtn = null;
		System.out.println(i);
		System.out.println(rtn);
		if (c>='a' && c<='z') {
			rtn="LCA";
		} else if (c>='A' && c<='Z') {
			rtn="UCA";
		} else if (c>='0' && c<='9') {
			rtn="num";
		} else {
			rtn="SC";
		}
		return rtn;
	}
}
