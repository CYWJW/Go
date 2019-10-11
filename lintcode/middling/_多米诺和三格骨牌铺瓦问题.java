package com.wjw.lintcode.middling;

public class _多米诺和三格骨牌铺瓦问题 {
	public static void main(String[] args) {
		System.out.println((Math.pow(10, 9) + 7) > 222194076);
		numTilings(29);
	}

	public static int numTilings(int N) {
		// write your code here
		int M = (int) (Math.pow(10, 9) + 7);
		if (N == 1 || N == 2) {
			return N * 2;
		}

		long[] DP = new long[N + 1];
		DP[1] = 1;
		DP[2] = 2;
		DP[3] = 5;

		for (int i = 4; i < DP.length; i++) {
			DP[i] = (2 * DP[i - 1] + DP[i - 3]) % M;
		}
		return (int) DP[N];
	}

}
