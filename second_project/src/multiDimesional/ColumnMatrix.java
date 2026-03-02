package multiDimesional;

public class ColumnMatrix {

	public static void main(String[] args) {
		
		int [][] arr = { {1}, {2}, {3} };		
		System.out.println(checkIfColumnMatrix(arr) ? "It is Column Matrix" : "It's not");
		
	}
	
	public static boolean checkIfColumnMatrix(int[][] arr) {
		if (arr == null) return false;
		
		for (int i = 0; i<arr.length; i++) {
			if(arr[i].length!=1) return false;
		}
		
		return true;
	}
}
