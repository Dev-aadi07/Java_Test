package excep;

public class Demo {

	public static void main(String[] args) {
		Object[] arr = new Object[5];
		arr[0] = true;
		arr[1] = (byte)1;
		arr[2] = 'k';
		arr[3] = "someString";
		arr[4] = 121234;
//		arr[5] = false;
		try {
			arr[7] = false;
		} catch (ArrayIndexOutOfBoundsException e){
			String msg = e.getMessage();
			System.out.println(msg);
			
		} finally {
			System.out.println("Hello");
		}
		for (int i = 0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}		
	}
}
