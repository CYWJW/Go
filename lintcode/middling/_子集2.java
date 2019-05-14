package com.wjw.lintcode.middling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _子集2 {
	public static void main(String[] args) {
		List<List<Integer>> list = subsets(new int[] { 1, 2, 2 });
		System.out.println(list);
	}

	public static List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		// write your code here
		List<List<Integer>> list = new ArrayList<>();
		for (int k = 0; k <= nums.length; k++) {
			int arr[] = new int[k];
			getSet(nums, arr, list, 0, k, 0);
		}
		return list;
	}

	/**
	 * @param nums
	 * @param arr
	 *            集合数组
	 * @param list
	 * @param n
	 *            上一个取得第几个
	 * @param k
	 *            这次需要几个
	 * @param len
	 *            已经取了几个
	 */
	private static void getSet(int[] nums, int[] arr, List<List<Integer>> list, int n, int k, int len) {
		// 如果已经选完
		if (len >= k) {
			list.add(toList(arr));
			return;
		}
		// 选未选的几个
		for (int i = n; i < nums.length; i++) {
			arr[len] = nums[i];
			// 取第几个
			getSet(nums, arr, list, i + 1, k, len + 1);
			while (i < nums.length - 1 && nums[i] == nums[i + 1])
				i++;
		}
	}

	private static List<Integer> toList(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			list.add(nums[i]);
		}
		return list;
	}

}
