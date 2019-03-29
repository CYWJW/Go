package com.wjw.basic;


//黄金连分数

public class Question25 {
	static int count=0;
	static int a[]= {1,2,3,4,5,6,7,8,9};
	public static void main(String[] args) {
		dfs(0);
		
		System.out.println(count);
	}
	//确定第几位
	public static void dfs(int k)
	{
		if(k==9)
		{
			count++;
		}
		//第几位却敌函数
		for (int i = k; i < a.length; i++) {
			//k和i交换位置
			int j=a[k];
			a[k]=a[i];
			a[i]=j;
			dfs(k+1);
			j=a[k];
			a[k]=a[i];
			a[i]=j;
		}
		
		
	
		
		
	}
	private static void print() {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
		System.out.println();
	}
}
