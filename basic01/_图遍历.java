package com.wjw.basic01;

import java.util.Scanner;

public class _图遍历 {
	// 是否走过
	static int is[];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int a[][] = new int[n + 1][n + 1];
		for (int i = 1; i < n; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			a[x][y] = 1;
			a[y][x] = 1;
		}
		is = new int[n + 1];
		int i = dfs(a, 1);
		System.out.println(i);
	}

	private static int dfs(int[][] a, int k) {
		int max = 0;
		if (k < a.length) {
			// 遍历自己的每一个节点
			for (int j = 0; j < a.length; j++) {
				// 如果k是通的 并且没走过
				if (a[k][j] != 0 && is[j] != 1) {
					is[j] = 1;
					max = Math.max(max, dfs(a, k + 1));
				}
			}
			return max+1;
		}
		return max;
	}
}
