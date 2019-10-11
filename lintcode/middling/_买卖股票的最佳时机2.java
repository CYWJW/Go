package com.wjw.lintcode.middling;

public class _买卖股票的最佳时机2 {
	public static void main(String[] args) {
		
	}
	
	public int maxProfit(int[] prices) {
        // write your code here
		int reslut=0;
		int min=Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			min=Math.min(min, prices[i]);
			reslut=Math.max(reslut, prices[i]-min);
		}
		return reslut;
    }

}
