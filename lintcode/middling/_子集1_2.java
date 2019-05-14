package com.wjw.lintcode.middling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _子集1_2 {
	public static void main(String[] args) {
		List<List<Integer>> list = subsets(new int[] { 1, 2, 3 });
		System.out.println(list);
	}

	public static List<List<Integer>> subsets(int[] nums) {
		// write your code here
		List<List<Integer>> list = new ArrayList<>();
		// 判断数组
		int is[] = new int[nums.length];
		Arrays.sort(nums);
		getSet(nums, 0, is,list);
		return list;
	}

	private static void getSet(int[] nums, int k, int[] is,List<List<Integer>> list) {
		if (k == nums.length)
			list.add(toList(nums, is));
		else {
			is[k]=0;
			getSet(nums, k+1, is, list);
			//我要这个
			is[k]=1;
			getSet(nums, k+1, is,list);
	
		}
	}

	private static List<Integer> toList(int[] nums, int[] is) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if(is[i]==0) continue;
			list.add(nums[i]);
		}
		return list;
	}

}
