package com.wjw.basic01;
/**
 * @author 汪军伍
 * 顺时针打印矩阵
 */
public class _打印矩阵 {
	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 5, 6, 6 }, { 4, 5, 6 }, { 5, 8, 9 } };
		int x = 0, y = 0, endX = a.length - 1, endY = a[0].length - 1;

		while (x <= endX && y <= endY)
			f(a, x++, y++, endX--, endY--);
	}

	private static void f(int[][] a, int x, int y, int endX, int endY) {
		if (x == endX) {
			while (y <= endY)
				System.out.print(a[x][y++]);
		} else if (y == endY) {
			while (x <= endX)
				System.out.print(a[x++][y]);
		} else {
			int bx = x;
			int by = y;
			// 打印第一列
			while (y < endY) {
				System.out.print(a[x][y++]);
			}
			while (x < endX) {
				System.out.print(a[x++][y]);
			}
			while (y > by) {
				System.out.print(a[x][y--]);
			}
			while (x > bx) {
				System.out.print(a[x--][y]);
			}
		}
	}
}
