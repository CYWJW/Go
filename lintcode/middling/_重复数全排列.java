package com.wjw.lintcode.middling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _重复数全排列 {
	public static void main(String[] args) {
		List<List<Integer>> list = permuteUnique(new int[] { 1,2,3,4});
		System.out.println(list);
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		// 排序
		Arrays.sort(nums);
		list.add(toList(nums));
		int n = nums.length;
		// 找到第一个右边比它小的
		int index = -1;
		while ((index = haveMax(nums)) != -1) {
			// 定位右边最小
			int minMax = index+1;
			//最小的数是
			int min=nums[minMax];
			for (int i = minMax; i < n; i++) {
				if(nums[i]<=min && nums[i]>nums[index])
				{
					minMax=i;
					min=nums[i];
				}
			}
			//交换
			swap(nums, index,minMax);
			//倒转
			reverse(nums, index+1, n-1);
			list.add(toList(nums));
		}
		return list;
	}

	public static int haveMax(int[] nums) {
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1])
				return i-1;
		}
		return -1;
	}

	  public static void reverse(int[] nums,int i,int j){
	        while(i<j){
	            swap(nums,i++,j--);
	        }
	    }
	
	
	private static List<Integer> toList(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			list.add(nums[i]);
		}
		return list;
	}

	private static void swap(int[] nums, int k, int i) {
		int value = nums[k];
		nums[k] = nums[i];
		nums[i] = value;
	}
}
