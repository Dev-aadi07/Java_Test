package multiDimesional;

public class CheckMatrix {

    static int[][] arr = {
    		{1,0,0},
    		{1,0,1},
    		{1,1,0}
    };   

    public static void main(String[] args) {
    	printArr(arr);
    	detect(arr);
    }

    

    public static void detect(int[][] arr) {
        // EC1: null 
        if (arr == null) {
            System.out.println("Matrix reference is null (No matrix)");
            return;
        }

        // EC2: empty matrix
        if (arr.length == 0) {
            System.out.println("Empty Matrix (0×0)");
            return;
        }

        // EC 3: if there is null row
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                System.out.println("Invalid Matrix (Null row at index " + i + ")");
                return;
            }
        }

        // EC 4: unequal rows length
        if (!isProperMatrix(arr)) {
            System.out.println("Not a Matrix (Jagged Array)");
            return;
        }

        
        masterMethod(arr);
    }

    // ================= Checking Matrix =================

    public static void masterMethod(int[][] arr) {

        int rows = arr.length;
        int cols = arr[0].length;

        // Singleton
        if (rows == 1 && cols == 1) {
            if (arr[0][0] == 0)
                System.out.println("Singleton Null Matrix");
            else
                System.out.println("Singleton Matrix");
            return;
        }

        // Null matrix
        if (isNullMatrix(arr)) {
            System.out.println("Null Matrix");
            return;
        }

        // Row matrix
        if (rows == 1) {
            System.out.println("Row Matrix");
            return;
        }

        // Column matrix
        if (cols == 1) {
            System.out.println("Column Matrix");
            return;
        }

        // Square matrix
        if (rows == cols) {
            if (isDiagonalMatrix(arr))
                System.out.println("Diagonal Matrix");
            else
                System.out.println("Square Matrix");
            return;
        }

        // Rectangular matrix
        if (rows < cols)
            System.out.println("Horizontal Rectangular Matrix");
        else
            System.out.println("Vertical Rectangular Matrix");
    }

    public static boolean isProperMatrix(int[][] arr) {
        int cols = arr[0].length;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].length != cols)
                return false;
        }
        return true;
    }

    public static boolean isNullMatrix(int[][] arr) {
        for (int[] row : arr)
            for (int val : row)
                if (val != 0)
                    return false;
        return true;
    }

    public static boolean isDiagonalMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++)
                if (i != j && arr[i][j] != 0)
                    return false;
        return true;
    }

    public static void printArr(int[][] arr) {
        for (int[] row : arr) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}
