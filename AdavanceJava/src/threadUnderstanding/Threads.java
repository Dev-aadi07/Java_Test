package threadUnderstanding;

import java.util.Scanner;

//Thread is a set of instruction which will execute independently
//extending thread or implementing Runnable interface
//run method present inside the runnable interface
//multithreading execute the CPU efficiently

class D1 extends Thread{
	@Override
	public void run() {
		System.out.println("Program started.");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter num 1");
		int a = sc.nextInt();
		System.out.println("Enter num 2");
		int b = sc.nextInt();
		System.out.println(a);
		System.out.println(b);
	}
}
class D2 extends Thread{
	@Override
	public void run() {
		System.out.println("Printing characters:");
		for(int i=65;i<=70;i++) {
			System.out.println((char)i);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class D3 extends Thread{
	@Override
	public void run() {
		System.out.println("Printing integers:");
		for(int i=1;i<=10;i++) {
			System.out.println(i);
			try {
				Thread.sleep(3000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Threads {
	public static void main(String[] args) throws InterruptedException {
//		System.out.println("Program started.");
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter num 1");
//		int a = sc.nextInt();
//		System.out.println("Enter num 2");
//		int b = sc.nextInt();
//		System.out.println(a);
//		System.out.println(b);
//
//		
//		System.out.println("Printing characters:");
//		for(int i=65;i<=75;i++) {
//			System.out.println((char)i);
//			try {
//				Thread.sleep(3000);
//			}catch(InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		
		D1 d1 = new D1();
		D2 d2 = new D2();
		D3 d3 = new D3();
		d1.start();
		d2.start();
		d3.start();
	}
}















