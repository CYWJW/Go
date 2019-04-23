package com.wjw.basic02;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _果巨品种 {
	static Map<Integer, BigInteger>map=new HashMap<>();
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		//n 10五次方
		long a = n * (n - 1);
		BigInteger sum = new BigInteger("0");
		
		for (int i = 2; i <= n; i++) {
		}
		System.out.println(sum);
	}

	// 计算阶乘
	static long f(int n,int m) {
		long sum=1;
		for (int i = 1; i<n; i++) {
		}
		return sum;
	}

}


