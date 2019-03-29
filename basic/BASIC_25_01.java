package com.wjw.basic;

import java.util.Scanner;

public class BASIC_25_01 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int m = in.nextInt();
			int[][] a = new int[n][m];
			int[][] f = new int[n][m];// 标志数组用来判断是否已经取过
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					a[i][j] = in.nextInt();
					f[i][j] = 0;
				}
			}
			int cnt = 1;
			int x = 0, y = 0;
			int[] b = new int[n * m];
			b[0] = a[x][y];
			f[x][y] = -1;
			while (cnt < m * n) {
				while (x + 1 < n && f[x + 1][y] != -1) {
					b[cnt++] = a[++x][y];
					f[x][y] = -1;
				}
				while (y + 1 < m && f[x][y + 1] != -1) {
					b[cnt++] = a[x][++y];
					f[x][y] = -1;
				}
				while (x - 1 >= 0 && f[x - 1][y] != -1) {
					b[cnt++] = a[--x][y];
					f[x][y] = -1;
				}
				while (y - 1 >= 0 && f[x][y - 1] != -1) {
					b[cnt++] = a[x][--y];
					f[x][y] = -1;
				}
			}
			for (int i = 0; i < b.length - 1; i++)
				System.out.print(b[i] + " ");
			System.out.println(b[b.length - 1]);// 检查空格
		}
	}
}