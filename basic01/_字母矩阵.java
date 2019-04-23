package com.wjw.basic02;

import java.util.Scanner;

public class _字母矩阵 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		char a[][] = new char[n][n];
		int x = 0;
		int y = 0;
		// 循环2n-1次
		for (int i = 1; i < n * 2 ; i++) {
			//进入矩阵
			f(a, x, y,i);
			if (i < n)
				x++;
			else
				y++;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}

	}

	private static void f(char[][] a, int x, int y,int i) {
		while (x>=0 && y<a.length) {
			a[x--][y++]=(char) (96+i);
		}
	}
}
