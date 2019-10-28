package com.wjw.lintcode.middling;

public class _背包问题 {

	public static void main(String[] args) {
		int backPack = backPack(10, new int[] { 3, 4, 8, 5 });

		System.out.println(backPack);
	}

	public static int backPack(int m, int[] A) {
		// write your code here

		boolean[][] dp = new boolean[m + 1][A.length];
		int result = Integer.MAX_VALUE;

		if (m == A[0]) {
			return m;
		}

		if (m > A[0]) {
			dp[m - A[0]][0] = true;
		}
		dp[m][0] = true;

		for (int i = 1; i < dp[0].length; i++) {
			for (int j = 0; j < dp.length; j++) {
				int value = j - A[i];
				if (dp[j][i - 1]) {
					if (value >= 0) {
						if (value == 0) {
							return m;
						}
						dp[value][i] = true;
						result = Math.min(value, result);

					}
					dp[j][i] = true;
				}

			}
		}
		return m - result;
	}

	private int getMax(int m, int i, int[] a) {
		// TODO Auto-generated method stub
		if (i == a.length || m == 0) {
			return m;
		}
		int value = Integer.MAX_VALUE;
		if (m >= a[i]) {
			value = getMax(m - a[i], i + 1, a);
		}
		if (value == 0) {
			return value;
		}
		return Math.min(value, getMax(m, i + 1, a));
	}
}
