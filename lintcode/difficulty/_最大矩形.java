package com.wjw.lintcode.difficulty;

import java.util.Stack;

public class _最大矩形 {

	public int maximalRectangle(boolean[][] matrix) {
		// write your code here
		int result = 0;
		if (matrix == null || matrix.length == 0) {
			return result;
		}

		int[][] numArray = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < numArray[0].length; i++) {
			if (matrix[0][i]) {
				numArray[0][i] = 1;
			}
		}

		result = getMaxNum(numArray[0]);

		for (int i = 1; i < numArray.length; i++) {
			for (int j = 0; j < numArray[i].length; j++) {
				if (matrix[i][j]) {
					numArray[i][j] = numArray[i - 1][j] + 1;
				}
			}
			result=Math.max(result, getMaxNum(numArray[i]));
		}

		return result;
	}

	private int getMaxNum(int[] a) {
		// TODO Auto-generated method stub
		int maxNum = 0;
		// 0 为大小 1为下标
		Stack<int[]> stack = new Stack<>();
		for (int i = 0; i < a.length; i++) {
			while (!stack.isEmpty() && stack.peek()[0] >= a[i]) {
				int[] pop = stack.pop();
				if (stack.isEmpty()) {
					maxNum = Math.max(maxNum, pop[0] * (pop[1] + 1));
				} else {
					maxNum = (i - stack.peek()[1] - 1) * pop[0];
				}

			}
			stack.push(new int[] { a[i], i });
		}

		while (!stack.isEmpty()) {
			int[] pop = stack.pop();
			if (!stack.isEmpty()) {
				maxNum = (a.length - stack.peek()[1] - 1) * pop[0];
			} else {
				maxNum = Math.max(maxNum, pop[0] * (pop[1] + 1));
			}
		}

		return maxNum;
	}

	public static void main(String[] args) {
		int a[][] = new int[1][3];
		System.out.println(a.length);
	}
}
