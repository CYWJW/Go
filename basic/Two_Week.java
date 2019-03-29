package com.wjw.basic;

import java.util.Scanner;

public class Two_Week {
	static int arrstr[][];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 行
		int row = scanner.nextInt();
		// 列
		int colmn = scanner.nextInt();
		arrstr = new int[row][colmn];
		String next = scanner.nextLine();
		for (int i = 0; i < row; i++) {
			 next = scanner.nextLine();
			for (int j = 0; j < colmn; j++) {
				int s = next.charAt(j);
				if (s == 42)
					// 如果为* 标记为雷
					arrstr[i][j] = -1;
				if (s != 42)
					// 如果为* 标记为0
					arrstr[i][j] = 48;

			}
		}

		// 遍历数组 找出雷
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < colmn; j++) {
				int result = arrstr[i][j];
				// 如果为雷
				if (result == -1)
					addNum(i, j);
			}
		}

		// 输出
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < colmn; j++) {
				
				int result = arrstr[i][j];
				if(result==-1)
				{
					System.out.print('*');
				}
				else
				System.out.print((char)result);
			}
			System.out.println();
		}
	}

	// 传进来行和列
	public static void addNum(int r, int c) {
		try {
			// 赋值
			if (arrstr[r - 1][c - 1] != -1)
				arrstr[r - 1][c - 1]++;

		} catch (Exception e) {

		}
		try {
			// 赋值
			if (arrstr[r - 1][c] != -1)
				arrstr[r - 1][c]++;
			// 赋值

		} catch (Exception e) {
		}

		try {
			// 赋值
			if (arrstr[r - 1][c + 1] != -1)
				arrstr[r - 1][c + 1]++;
		} catch (Exception e) {
		}
		/*---------------------------------------------------*/
		try {
			// 赋值
			if (arrstr[r][c + 1] != -1)
				arrstr[r][c + 1]++;

		} catch (Exception e) {
		}
		try {
			// 赋值
			if (arrstr[r][c - 1] != -1)
				arrstr[r][c - 1]++;
		} catch (Exception e) {
		}
		/*----------------------------------------------------*/
		try {
			// 赋值
			if (arrstr[r + 1][c - 1] != -1)
				arrstr[r + 1][c - 1]++;
		} catch (Exception e) {
		}
		try {
			// 赋值
			if (arrstr[r + 1][c] != -1)
				arrstr[r + 1][c]++;
		} catch (Exception e) {
		}
		try {
			// 赋值
			if (arrstr[r + 1][c + 1] != -1)
				arrstr[r + 1][c + 1]++;
		} catch (Exception e) {
		}

	}

}
