package com.wjw.basic;

import java.util.Scanner;

public class Question02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		
		// 获取输入的树
		for (int i = 0; i < num; i++) {
			// 读取16进制 自动转换为十进制
			System.out.println(Integer.toOctalString(scanner.nextInt(16)));
		}
		// 其余进制转换为十
		// Integer.parseInt(s, radix);
	}

}
