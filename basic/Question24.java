package com.wjw.basic;

import java.lang.reflect.GenericDeclaration;

//黄金连分数

public class Question24 {
	public static void main(String[] args) {
		int m = 50;
		int n = 100;
		System.out.println(g(m, n));

	}
	/**
	 * @param m m为被除数
	 * @param n m为除数
	 */
	private static int g(int m,int n) {
		if((m=m%n)==0)
			return  n;
		return	g(n, m);
	}

}
