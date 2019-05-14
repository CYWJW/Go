package com.wjw.lintcode.middling;

import java.util.ArrayList;
import java.util.List;

public class _全排列 {

	public List<List<Integer>> permute(int[] nums) {
		// write your code here
		List<List<Integer>> list = new ArrayList<>();
		for (int k = 0; k < nums.length; k++) {
			
		}
		
		
		
		
		return list;
	}
	
	
	
	

/*	private void getList(List<List<Integer>> list, int[] nums,int k) {
		if(k==nums.length)
		{
			list.add(toList(nums));
		}
		for (int i = k; i < nums.length; i++) {
			swap(nums,k,i);
			getList(list, nums, k+1);
			swap(nums, k, i);
		}
	}*/
	


	private List<Integer> toList(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			list.add(nums[i]);
		}
		return list;
	}

	private void swap(int[] nums, int k, int i) {
		int value=nums[k];
		nums[k]=nums[i];
		nums[i]=value;
	}
	
}
