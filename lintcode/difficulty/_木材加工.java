package com.wjw.lintcode.difficulty;

public class _木材加工 {
	public static void main(String[] args) {
		int maxValue = woodCut(new int[] { 6, 6 }, 4);
		System.out.println(maxValue);
	}

	public static int woodCut(int[] L, int k) {
		if (L.length == 0) {
			return 0;
		}
		long sum = L[0];
		long max = L[0];

		for (int i = 1; i < L.length; i++) {
			sum += L[i];
			max = Math.max(L[i], max);
		}
		if (sum < k) {
			return 0;
		}

		long i = 1;
		long j = max;

		while (i <= j) {
			long mid = (i + j) / 2;
			if (judge(L, k, mid)) {
				i = mid + 1;
			} else {
				j = mid - 1;
			}
		}

		return (int) j;
	}

	public static boolean judge(int[] L, int k, long l) {
		int num = 0;
		for (int x : L) {
			num += x / l;
		}
		if (num >= k) {
			return true;
		}
		return false;
	}
}
