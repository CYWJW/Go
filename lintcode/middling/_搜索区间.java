package com.wjw.lintcode.middling;

public class _搜索区间 {
	public int[] searchRange(int[] A, int target) {
		// write your code here
		if (A.length == 0) {
			return new int[] { -1, -1 };
		}
		int left = 0;
		int right = A.length - 1;
		// 确定左边界
		while (left <= right) {
			int mid = (left + right) >> 1;
			// 如果当前等于它 并且前一个不是它
			if (A[mid] == target && (mid == 0 || A[mid - 1] != target)) {
				left = mid;
				break;
			} else if (target<=A[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		// 如果没有值
		if (left > right) {
			return new int[] { -1, -1 };
		}
		right=A.length-1;
		// 确定右边界
		int left_1 = left;
		while (left_1 <= right) {
			int mid = (left_1 + right) >> 1;
			if (A[mid] == target && (mid == right || A[mid = 1] != target)) {
				right = mid;
				break;
			} else if (target>=A[mid]) {
				left = mid + 1;
			} else {
				right = mid-1;
			}
		}
		return new int[] { left, right };
	}
}
