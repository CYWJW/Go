package com.wjw.lintcode.simple;

public class _反转三位整数 {
	public int reverseInteger(int number) {
		// write your code here
		String num = number + "";
		if (num.charAt(2) != '0') 
			num = "" + num.charAt(2) + num.charAt(1) + num.charAt(0);
		else if (num.charAt(2) == '0' && num.charAt(1) != 0) 
			num = "" +num.charAt(1) + num.charAt(0);
		else 
			num = "" + num.charAt(0);
		return Integer.valueOf(num);
	}
}
