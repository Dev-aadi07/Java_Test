package multiDimesional;

public class setMatrixZero {
	static int[][] arr = {
	        {1, 4, 7},
	        {2, 0, 8},
	        {3, 6, 9}
	    };
	
	public static void main(String[] args) {
		printArr(arr);
		setZero(arr);
		System.out.println("======");
		printArr(arr);
	}
	
	public static void setZero(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		
		boolean[] row = new boolean[n];
		boolean[] col = new boolean[m];
		
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<m; j++) {
				if (arr[i][j] == 0) {
					row[i] = true; //[f,t,f]
					col[j] = true; //[f,t,f]
				}
			}
		}
		
		//Assigning zeroes 
		for(int i = 0; i<n; i++) {
			for (int j = 0; j<m; j++) {
				if (arr[i][j] != 0 && (row[i] || col[j])) arr[i][j] = 0;
			}
		}
	}
	
	public static void printArr(int[][]arr) {
		for (int i = 0; i<arr.length; i++) {
			for (int j = 0; j<arr[0].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
