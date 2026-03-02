package threadUnderstanding;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileDemo {

	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\aadar\\OneDrive\\Desktop\\java//test.txt");
		f.createNewFile();

//		FileInputStream fis = new FileInputStream(f);
//		System.out.println(fis.read());
//		Scanner sc = new Scanner(f);
//		while (sc.hasNext()) {
//			System.out.print(sc.next());
//		}

		// =================================== Using BufferedReader
		// ==========================
//		FileReader f1 = new FileReader(f);
//        BufferedReader br = new BufferedReader(f1);
//
//        String line;
//        while ((line = br.readLine()) != null) {
//            System.out.println(line);
//        }
//        br.close();

//		int count;
//		while ((count=fis.read()) != -1) {
//			System.out.print((char)count);
//		}

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter text to write into file:");
		String input = sc.nextLine();

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(f, true))) {

            bw.write(input);
            bw.newLine();  // move to next line

        }

		System.out.println("Data written successfully!");
		sc.close();

	}

}
