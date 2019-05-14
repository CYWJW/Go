package com.wjw.lintcode.simple;

import java.util.Arrays;

public class _旋转字符串 {

	public static void main(String[] args) {
		rotateString(new char[] {'a','b','c','d','e','f','g'}, 3);
	}
	
	
	public static void rotateString(char[] str, int offset) {
		int n=str.length;
		if(n==0 || offset==0) return ;
		offset=offset%n;
		swap(str,n-offset,n-1);
		swap(str, 0, n-offset-1);
		swap(str, 0, n-1);
		System.out.println(Arrays.toString(str));
	}

	private static void swap(char[] str, int i, int j) {
		while (i<j) {
			char va=str[i];
			str[i++]=str[j];
			str[j--]=va;
		}
		
	}
	
}
