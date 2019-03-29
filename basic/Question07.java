package com.wjw.basic;


public class Question07 {
	public static void main(String[] args) {

		// 生成六位数的回文数
		for (int i = 10; i <= 99; i++) {
			// 取个位
			int g = i % 10;
			// 取十位
			int s = i / 10 % 10;
			// 如果加起来有一半
			System.out.println("" + i + g + s);
		}
	}

}
