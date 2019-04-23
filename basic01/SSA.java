package com.wjw.basic02;

import java.util.Scanner;

import org.junit.Test;

public class SSA {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 长
		int a = scanner.nextInt();
		// 宽
		int b = scanner.nextInt();
		// 采样点
		int n = scanner.nextInt();
		int nums[][] = new int[n][2];
		for (int i = 0; i < n; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			nums[i][0] = x;
			nums[i][1] = y;
		}
		// 记录落在圆内的
		int num = 0;
		for (int i = 0; i < nums.length; i++) {
			// 传入xy 计算
			num += f(nums[i][0], nums[i][1], a, b);
		}
		
		// 总面积
		int statol = a * b * 4;
		// 记录分子
		a = statol * num;
		if (a % n == 0)
			System.out.println(a / n);
		else
		{
			
			int gcd = gcd(a, n);
			a/=gcd;
			n/=gcd;
			System.out.println(a+"/"+n);
		}
	}

	private static int f(int x, int y, int a, int b) {
		int num01 = a * a * b * b;
		int num02 = x * x * b * b + a * a * y * y;
		return num02 <= num01 ? 1 : 0;
	}
	@Test
	public void f1()
	{
		System.out.println(gcd(66,55));
	}
	
	public static int gcd(int x, int y) { 
		if (y == 0)
			return x;
		else
			return gcd(y, x % y);
	}
}
