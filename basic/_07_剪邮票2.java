package com.wjw.basic;

import java.util.Arrays;

/*
剪邮票

如【图1.jpg】, 有12张连在一起的12生肖的邮票。
现在你要从中剪下5张来，要求必须是连着的。
（仅仅连接一个角不算相连）
比如，【图2.jpg】，【图3.jpg】中，粉红色所示部分就是合格的剪取。

请你计算，一共有多少种不同的剪取方法。

请填写表示方案数目的整数。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。
*/
public class _07_剪邮票2 {

	static int a[] = { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 };// 它的每个排列代表着12选5的一个方案
	static int a1[][] = new int[3][4];// 它的每个排列代表着12选5的一个方案
	static int ans;

	// 进行
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			f();
			System.out.println(ans);
			ans=0;
		}
		
		long endTime = System.currentTimeMillis();    //获取结束时间
		System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
	} 
	// 进行分组
	private static void f() {
		for (int i = 0; i < 8; i++) {
			a1[i/4][i%4]=1;
			for (int j = i + 1; j < 9; j++) {
				a1[j/4][j%4]=1;
				for (int k = j + 1; k < 10; k++) {
					a1[k/4][k%4]=1;
					for (int l = k + 1; l < 11; l++) {
						a1[l/4][l%4]=1;
						for (int m = l + 1; m < 12; m++) {
							a1[m/4][m%4]=1;
							if (check(a1)) 
								ans++;
							// 回溯
							a1[m/4][m%4]=0;
						}
						a1[l/4][l%4]=0;
					}
					a1[k/4][k%4]=0;
				}
				a1[j/4][j%4]=0;
			}
			a1[i/4][i%4]=0;
		}
	}

	// 判断是否连接
	private static boolean check(int a[][]) {
		int newA[][]=new int[3][4];
		for (int p = 0; p < 3; p++) {
			System.arraycopy(a[p],0 , newA[p], 0,a[p].length);
		}
		int num=0;
		
		
		
		//进行递归
		for (int i = 0; i < newA.length; i++) {
			for (int j = 0;  j < newA[i].length ; j++) {
				if(newA[i][j]==1)
				{
					dfs(newA, i, j);
					num++;
				}
			}
		}
		return num==1;
	}
	
	  static void dfs(int g[][], int i, int j) {
	    g[i][j] = 0;
	    if (i - 1 >= 0 && g[i - 1][j] == 1) dfs(g, i - 1, j);
	    if (i + 1 <= 2 && g[i + 1][j] == 1) dfs(g, i + 1, j);
	    if (j - 1 >= 0 && g[i][j - 1] == 1) dfs(g, i, j - 1);
	    if (j + 1 <= 3 && g[i][j + 1] == 1) dfs(g, i, j + 1);
	  }

}
