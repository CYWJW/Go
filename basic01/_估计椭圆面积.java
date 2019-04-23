package com.wjw.basic02;

import java.math.BigInteger;
import java.util.Scanner;

public class _估计椭圆面积 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 长
		long a = scanner.nextInt();
		// 宽
		long b = scanner.nextInt();
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
		long num = 0;
		for (int i = 0; i < nums.length; i++) {
			// 传入xy 计算
			num += f(nums[i][0], nums[i][1], a, b);
		}
		long statol = a * b * 4;

		// 记录分子
		a = statol * num;
		if (a % n == 0)
			System.out.println(a / n);
		else {
			long gcd = gcd(a, n);
			a /= gcd;
			n /= gcd;
			System.out.println(a + "/" + n);
		}
	}

	private static int f(long x, long y, long a, long b) {
		/* long num01 = a * a * b * b; */
		// b*b*x*x
		// a*a*y*y
		/*
		 * System.out.println(num01+""+num02); System.out.println(
		 * num01.compareTo(num02));
		 */
		
		long toB = b * b;
		long toX = x * x;
		long toY = y * y;
		long toA = a * a;
		//十的十六次方
		long sum01=toB*toX+toY*toA;
		
		long sum02=toA*toB;
		
		return sum02>=sum01?1:0;
	}

	public static long gcd(long x, long y) {
		if (y == 0)
			return x;
		else
			return gcd(y, x % y);
	}
}
