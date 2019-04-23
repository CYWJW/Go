package com.wjw.basic02;

import java.util.Scanner;
public class _二进制反转 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = f(scanner.nextLong());
		System.out.println(Long.parseLong(string,2));
	}

	static String f(long x) {
		String str = "";
		for (int i = 0; i < 32; i++) {
			str += (x & 1);
			x >>= 1;
		}
		return str;
	}

}
