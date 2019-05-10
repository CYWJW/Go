package com.wjw.lintcode.simple;

import java.util.Arrays;

public class _数组循环右移k位 {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int n = a.length;
		int k = 2;
		// 倒置后k个 1 2 3 4 5 6 8 7
		reverse(a, n - k, n - 1);
		// 倒置前n-k个 6 5 4 3 2 1 8 7
		reverse(a, 0, n - 1 - k);
		//倒置整个数组
		reverse(a, 0, n-1);
		System.out.println(Arrays.toString(a));
	}

	private static void reverse(int[] a, int b, int e) {
		while (b < e) {
			// 交换
			int num = a[e];
			a[e--] = a[b];
			a[b++] = num;
		}
	}

}
