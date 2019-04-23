package com.wjw.basic02;

public class _最大子数组 {
	public static void main(String[] args) {
		int a[] = { 8, -5, 6, -10, 8, 5 };
		int sum = getMaxArr(a);
		System.out.println(sum);
	}

	private static int getMaxArr(int[] a) {
		int sum=Integer.MIN_VALUE;
		int befMax=Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			//选择到底哟不要之前的数组 如果+之前的最大值是比自己大 就要
			befMax=befMax>0?befMax+a[i]:a[i];
			sum=Math.max(sum,befMax);
		}
		
		return sum;
	}

}
