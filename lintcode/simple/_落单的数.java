package com.wjw.lintcode.simple;

public class _落单的数 {
	public int singleNumber(int[] A) {
		// write your code here
		int result = 0;
		for(int value:A) {
			result ^=value;
		}
		return result;
	}
}
