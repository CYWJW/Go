package com.wjw.lintcode.middling;

import java.util.LinkedList;
import java.util.Stack;

public class _132模式 {

	public static void main(String[] args) {
		boolean flag = find132pattern(new int[] { -10, -3, -11, -8 });
		System.out.println(flag);
	}

	public static boolean find132pattern(int[] nums) {
		// write your code here
		if (nums.length < 3) {
			return false;
		}
		Stack<Integer> stack = new Stack<>();
		int second = Integer.MIN_VALUE;
		for (int i = nums.length - 1; i >= 0; i--) {
			while (stack.size() > 0 && stack.peek() >= nums[i]) {
				second = Math.max(second, stack.pop());
			}
			stack.push(nums[i]);
			if (nums[i] < second) {
				return true;
			}
		}
		return false;
	}
}
