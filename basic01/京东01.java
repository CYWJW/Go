package com.wjw.basic02;

import java.util.Scanner;


public class 京东01 {

	static int num=0;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int a[][]=new int[n+1][n+1];
		for(int i=0;i<n-1;i++)
		{
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			a[x][y]=1;
			a[y][x]=1;
		}
		f(a);
		System.out.println(++num);
	}

	private static void f(int[][] a) {
		for (int i = 1; i < a.length; i++) {
			boolean flag=false;
			for (int j = 1; j < a.length; j++) {
				if(a[i][j]==1)
				{
					flag=true;
					a[i][j]=0;
					a[j][i]=0;
				}
			}
			if(flag) num++;
		}
	}

}
