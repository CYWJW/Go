package com.wjw.lintcode.middling;

import java.util.Stack;

public class _装最多水的容器 {

	public static void main(String[] args) {
		int area = maxArea(new int[] { 5, 10, 1, 1, 1, 4 });
		System.out.println(area);
	}

	// write your code here
	public static int maxArea(int[] height) {
		int res = 0, i = 0, j = height.length - 1;
		while (i < j) {
			res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
			if (height[i] < height[j])
				++i;
			else
				--j;
		}
		return res;
	}
}
