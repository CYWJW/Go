package com.wjw.basic;

import java.math.BigDecimal;
//ROUND_UP 只要后面不为0 就+1
//ROUND_HALF_UP 四舍五入 ROUND_HALF_down 大于五才入
public class Question22 {
	public static void main(String[] args) {
		System.out.println(new BigDecimal(3).divide(new BigDecimal(7),9, BigDecimal.ROUND_HALF_UP));
		double a=3;
		double b=7;
		System.out.println(a/b);
	}
	
	private static double  f(int n) {
		if(n==3) return 1;
		
		return 1/(1+f(n+1));
	}
}
