package p1;

public class C4 {

	public static void main(String[] args) {
		System.out.println("Start");
//		varArgs();
		varArgs("Hello", 7);
		System.out.println("End");
	}
	public static void varArgs(String ... d, int ... a) {
		for (int i = 0; i < d.length; i++) {
			System.out.println(d[i]);
		}
	}
}
