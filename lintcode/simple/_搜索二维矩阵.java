package com.wjw.lintcode.simple;

public class _搜索二维矩阵 {
	
	public static void main(String[] args) {
		
	}
	public  boolean searchMatrix(int[][] matrix, int target) {
		if( matrix.length==0) return false;
		// write your code here
		int x = 0;
		int y = matrix[0].length - 1;
		// 循环条件
		while (x < matrix.length && y > -1) {
			if (matrix[x][y] == target)
				return true;
			//如果大于当前数 那么一定在下一行
			else if (target > matrix[x][y]) 
				x++;
			else
				y--;
		}
		return false;
	}
}
