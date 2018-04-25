package io.test;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		try {
			System.out.println("Enter something: ");
			while(true) {
				String s = sc.nextLine();
				System.out.println("Entered String: "+s);
				if(s.equalsIgnoreCase("exit")) {
					sc.close();
				}
			}
		} finally {
			sc.close();
		}
	}
}
