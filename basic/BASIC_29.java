package com.wjw.basic;

import java.util.Scanner;

public class BASIC_29 {
	public static int n;
	public static int count;
	public static int map[][];
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		map = new int[n][n];
		// 输入的行数
		for (int i = 0; i < n; i++) { // 列数
			for (int j = 0; j < n; j++) {
				map[i][j]=scanner.nextInt();
			}
		}
		Dfs(0, 2);
		System.out.println(count);
	}
	
	public static void Dfs(int row,int s)
	{
		//如果都满足
		if(row==n)
		{
			//如果是白
			if(s==2)
				Dfs(0, 3);
			else
				count++;
			return;
		}
		
		//进行循环
		for(int i=0;i<n;i++)
		{
			//如果不能占 就下一个位置 如果不为一 就不能做
			if(map[row][i]!=1 || !Check(row,i,s)) 
				continue;
		
			//然后把当前位置加入
			map[row][i]=s;
			//递归
			Dfs(row+1, s);
			//如果返回了 就把原来的占的位置释放
			map[row][i]=1;
		}
		return;
	}
	
	//t当前行 i当前列  s当前的黄后
	public static boolean Check(int t, int i, int s)
	{
		for(int q=0;q<t;q++)
		{
			//如果前面几排的列当前黄后
			if(map[q][i]==s)
				return false;
		}
		//判断正对角线 q为行 w为列
		for(int q = t - 1, w = i - 1;q >= 0 && w >= 0; q--,w--)
		{
			if(map[q][w]==s)
			{
				return false;
			}
		}
		
		//判断正对角线
		for(int q=t-1, w=i+1 ; q >= 0 && w < n;q--,w++)
		{
			if(map[q][w]==s)
			{
				return false;
			}
		}
		
		//如果都满足
		return true;
		
	}
	
}