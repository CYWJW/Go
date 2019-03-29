package com.wjw.basic;
//黄金连分数
import java.math.BigDecimal;
import java.math.BigInteger;
public class Question23 {
	public static void main(String[] args) {
		BigInteger a=BigInteger.ONE;
		BigInteger b=BigInteger.ONE;
		
		for (int i = 0; i < 400; i++) {
			BigInteger t=b;
			b=a.add(b);
			a=t;
		}
		
		System.out.println(new BigDecimal(a).divide(new BigDecimal(b), 100,BigDecimal.ROUND_HALF_UP));
		
		
		
	}
	
	
}
