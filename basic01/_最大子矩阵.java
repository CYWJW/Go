package com.wjw.basic01;

import java.util.Stack;

public class _最大子矩阵 {
	public static void main(String[] args) {
		int[][] a= {{1,0,0,1},{1,1,0,0},{0,1,0,1}};
		int num[][]=getNum(a);
		int max=0;
		//进行单调栈
		for (int i = 0; i < num.length; i++) {
			max=Math.max(max, getMax(num[i]));
		}
		System.out.println(max);
		
	}
	
	private static int getMax(int[] is) {
		int max=0;
		//进行判断
		Stack<Integer>stack=new Stack<>();
		for (int i = 0; i < is.length; i++) {
			//如果当前元素等于栈顶的
			if(!stack.isEmpty() && is[i]==is[stack.peek()]) continue;
			//如果小于就计算
			while (!stack.isEmpty() && is[i]<is[stack.peek()]) {
				//记录当前的
				int n=stack.pop();
				//是否为空
				int l=stack.isEmpty()?-1:stack.peek();
				max=Math.max(max, (i-l-1)*is[n]);
			}
			//记录下标
			stack.push(i);
		}
		//站内剩余
		while (!stack.isEmpty()) {
			int n=stack.pop();
			//记录当前的
			int r=is.length;
			//是否为空
			int l=stack.isEmpty()?-1:stack.peek();
			max=Math.max(max, (r-l-1)*is[n]);
			
		}
		return max;
	}

	private static int[][] getNum(int[][] a) {
		if(a==null || a.length==0) return new int[0][0];
		int[][] num=new int[a.length][a[0].length];
		for (int i = 0; i < num[0].length; i++) {
			num[0][i]=a[0][i];
		}
		//x
		for (int i = 1; i < a.length; i++) {
			//y
			for (int j = 0; j < a[i].length; j++) {
				//如果当前为1 为上一排+1
				if(a[i][j]==1)
					num[i][j]=num[i-1][j]+1;
			}
		}
		return num;
	}
}
