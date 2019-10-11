package com.wjw.lintcode.middling;

public class _买卖股票的最佳时机 {
	public static void main(String[] args) {
		maxProfit(new int[] { 2, 1, 2, 0, 1 });
	}

	public static int maxProfit(int[] prices) {
		// write your code here
		int reslut = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length - 1; i++) {
			min = Math.min(min, prices[i]);
			if (prices[i + 1] < prices[i]) {
				reslut += prices[i] - min;
				min = prices[i + 1];
			}
		}
		if (prices.length > 1 && prices[prices.length - 1] > prices[prices.length - 2]) {
			reslut += prices[prices.length - 1] - min;
		}

		return reslut;
	}

}
