package com.wjw.lintcode.middling;

public class _寻找旋转排序数组中的最小值 {

	public static void main(String[] args) {
		int findMin = findMin(new int[] { 2, 0 });
		System.out.println(findMin);
	}

	public static int findMin(int[] nums) {
		// write your code here
		if (nums[0] <= nums[nums.length - 1]) {
			return nums[0];
		}
		int left = 0;
		int right = nums.length - 1;

		while (nums[left] > nums[right]) {
			int mid = (left + right) >> 1;
			if (nums[mid] < nums[left]) {
				right = mid;
			} else if (nums[mid] > nums[left]) {
				left = mid;
			} else {
				return nums[right];
			}
		}
		return nums[left];
	}

}
