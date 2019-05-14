package com.wjw.lintcode.simple;

public class _二分查找 {

	public static void main(String[] args) {
		int a[] = { 1, 4, 4, 5, 7, 7, 8, 9, 9, 10 };
		int k = binarySearch(a, 1);
		System.out.println(k);
	}

	public static int binarySearch(int[] nums, int target) {
		// write your code here
		int index = -1;
		int left = 0;
		int rigth = nums.length - 1;
		while (left <= rigth) {
			int mid = (left + rigth) / 2;
			if (nums[mid] == target && (mid == 0 || nums[mid - 1] != target)) {
				index = mid;
				break;
			} else {
				if ( target <=nums[mid])
					rigth = mid - 1;
				else
					left = mid + 1;
			}

		}

		return index;
	}
}
