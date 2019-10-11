package com.wjw.lintcode.simple;

import java.util.Arrays;
import java.util.List;

public class _主元素 {
	public static void main(String[] args) {
		
		int value = majorityNumber(Arrays.asList(2,3,4,2,3,4,1,4,1,1,4));
		System.out.println(value);
	}
	
	public static int majorityNumber(List<Integer> nums) {
		// write your code here
		int value = nums.get(0);
		int count = 2;
		for (int i = 1; i < nums.size(); i++) {
			// 记录主元素数量
			if (nums.get(i) == value)
				count+=2;
			else {
				if (count > 0)
					count--;
				else {
					value = nums.get(i);
					count=2;
				}
			}
		}
		return value;
	}
}
