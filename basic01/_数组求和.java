package com.wjw.basic01;

public class _数组求和 {

	public static void main(String[] args) {
		int a[] = { 1, 4, 5, 6, 8, -1 ,6,-6};
		int N = 0;
		int k = 7;
		System.out.println(f(a, k, N));
	}

	
	private static boolean f(int[] a, int k, int N) {
		// 只要找到就输出
		if (N == a.length) {
			return k==0;
		}
		// 如果当前数要
		return	f(a, k - a[N], N + 1)||f(a, k, N + 1);
	}
	private static void f(int[] a, int k, String str, int N) {
		// 只要找到就输出
		if (k == 0) {
			System.out.println(str);
			return;
		}
		// 如果k小于0 或者越界
		if (N == a.length)
			return;
		else {
			// 如果当前数要
			f(a, k - a[N], str + a[N], N + 1);
			// 如果我不要
			f(a, k, str, N + 1);
		}
	}
}
