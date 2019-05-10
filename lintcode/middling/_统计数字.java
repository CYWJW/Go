package com.wjw.lintcode.middling;

public class _统计数字 {
	public static void main(String[] args) {
		int counts = digitCounts(1, 12);
		System.out.println(counts);
	}

	public static int digitCounts(int k, int n) {
		int ans = 0;
		char m = (char) (k + 48);
		for (int i = 0; i <= n; i++) {
			char[] array = (i + "").toCharArray();

			for (int j = 0; j < array.length; j++) {
				if (array[j] == m)
					ans++;
			}

		}
		return ans;
	}
}
