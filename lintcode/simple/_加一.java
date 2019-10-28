package com.wjw.lintcode.simple;

public class _加一 {

	public int[] plusOne(int[] digits) {
		// write your code here
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] >= 9) {
				digits[i] = 0;
			}else {
				digits[i]++;
				return digits;
			}

		}
		int[] newDigits = new int[digits.length + 1];
		newDigits[0] = 1;
		return newDigits;
	}
}
