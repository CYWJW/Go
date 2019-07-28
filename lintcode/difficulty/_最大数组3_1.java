package com.wjw.lintcode.difficulty;

public class _最大数组3_1 {
	
	public static void main(String[] args) {
		int maxValue = maxSubArray(new int[] {-1,0,1},3 );
		System.out.println(maxValue);
	}
	
	public static int maxSubArray(int[] nums, int k) {
		// 定义两个一个是当前必须包含的 一个是全局的
		int must[][] = new int[nums.length+1][k + 1];
		int golab[][] = new int[nums.length+1][k + 1];
		// 遍历数组 依次找寻
		for (int i = 1; i <= nums.length; i++) {
			// 初始化
			must[i][0] = Integer.MIN_VALUE;
			for (int j = 1; j <= k; j++) {
				// 当分组小于的时候初始化最小
				if (i < j) {
					must[i][j] = Integer.MIN_VALUE;
					golab[i][j] = Integer.MIN_VALUE;
					continue;
				}
				// 当到当前的时候
				must[i][j] = Math.max(must[i - 1][j], golab[i - 1][j - 1]) + nums[i-1];
				// 刷新全局
				if (i == j) {
					golab[i][j] = must[i][j];
				} else {
					//如果选择要这个 还是不要这个
					golab[i][j]=Math.max(must[i][j], golab[i-1][j]);
				}

			}
		}

		return golab[nums.length][k];
	}
}
