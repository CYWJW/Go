package com.wjw.basic01;

import java.util.Arrays;

public class _全排列 {
	public static void main(String[] args) {
		int a[]= {1,2,3};
		f(a,0);
	}

	private static void f(int[] a, int i) {
		if(i==a.length)
		{
			System.out.println(Arrays.toString(a));
			return;
		}
		for (int j = i; j < a.length; j++) {
				int va=a[i];
				a[i]=a[j];
				a[j]=va;
				f(a, i+1);
				va=a[i];
				a[i]=a[j];
				a[j]=va;
			}
	}
}
