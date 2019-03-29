package com.wjw.basic;


public class Question06 {
	public static void main(String[] args) {

		for (int i = 153; i <= 407; i++) {
			// 取个位
			int g = i % 10;
			// 取十位
			int s = i / 10 % 10;
			//取百位
			int b=i/100;
			int count=	(int) (Math.pow(g, 3)+Math.pow(s, 3)+Math.pow(b, 3));
			
			if(count==i)
			{
				System.out.println(i);
			}
			
		}
	}

}
