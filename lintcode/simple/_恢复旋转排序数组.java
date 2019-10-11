package com.wjw.lintcode.simple;

import java.util.ArrayList;
import java.util.List;

public class _恢复旋转排序数组 {
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<>();
		list.add(4);
		list.add(5);
		list.add(1);
		list.add(2);
		list.add(3);
		recoverRotatedSortedArray(list);
		System.out.println(list);
	}
	
	public static void recoverRotatedSortedArray(List<Integer> nums) {
		int index = 0;
		// 判断旋转点
		for (int i = 0; i < nums.size() - 1; i++) {
			if (nums.get(i) > nums.get(i + 1)) {
				index = i + 1;
				break;
			}
		}
		//进行交换
		reverse(index,nums.size()-1,nums);
		reverse(0,index-1,nums);
		reverse(0,nums.size()-1,nums);
	}

	private static void reverse(int index, int i, List<Integer> nums) {
		// TODO Auto-generated method stub
		while (index<i) {
			int value=nums.get(index);
			nums.set(index++, nums.get(i));
			nums.set(i--, value);
		}
	}

}
