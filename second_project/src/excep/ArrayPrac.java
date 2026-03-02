package excep;

import java.lang.reflect.Array;

public class ArrayPrac {

    public static void main(String[] args) {

        boolean[] booleanArray = { true, false, true };
        char[] charArray = { 'k', 'q', 'g' };
        int[] intArray = { 10, 20, 30 };
        Object[] objectArray = { 12233L, "string", '1' };

        arrayPrinter(booleanArray, charArray, intArray, objectArray);
    }

    public static void arrayPrinter(Object... arr) {

        for (Object obj : arr) {

            if (!obj.getClass().isArray()) {
                System.out.println("Not an array");
                continue;
            }

            int length = Array.getLength(obj);

            for (int i = 0; i < length; i++) {
                System.out.print(Array.get(obj, i) + " ");
            }
            System.out.println();
        }
    }
}
