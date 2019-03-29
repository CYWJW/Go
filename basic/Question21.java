package com.wjw.basic;

import java.util.Calendar;
import java.util.Date;

public class Question21 {
	public static void main(String[] args) {
		//
		System.out.println(f(0,0));
	}
	
	private static int  f(int i, int j) {
	if(i==4 || j==5) return 0;
	if (i==3 && j==4) 
		return 1;
	
	
	return f(i+1,j)+f(i,j+1);
	}
}
