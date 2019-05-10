package com.wjw.lintcode.middling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _三数之和 {
	public static void main(String[] args) {
		List<List<Integer>> list = threeSum(new int[] { -8,0,-7,-101,-123,-1,-2,0,-1,0,-1111,0,-1,-2,-3,-4,-5,-6,-100,-98,-111,-11});
		System.out.println(list);
	}

	public static List<List<Integer>> threeSum(int[] numbers) {
		// write your code here
		List<List<Integer>> result = new ArrayList<>();
		// 两数之和
		Set<String> is = new HashSet<>();
		Arrays.sort(numbers);
		int n = numbers.length;
		for (int i = 0; i < n - 2; i++) {
			int left = i + 1;
			int right = n - 1;
			if (numbers[i]>0 || numbers[right] < 0)
				break;
			if (i > 1 && numbers[i] == numbers[i - 1])
				continue;

			// 配对结果
			int rt = 0 - numbers[i];
			while (left < right) {
				if (numbers[right] < 0)
					break;
				int st = numbers[left] + numbers[right];
				if (st == rt) {
					String key = numbers[i] + "_" + numbers[left] + "_" + numbers[right];
					if (!is.contains(key)) {
						List<Integer> list = new ArrayList<>();
						list.add(numbers[i]);
						list.add(numbers[left++]);
						list.add(numbers[right--]);
						result.add(list);
						is.add(key);
					}
					else 
					{
						left++;right--;
					}

				}
				// 如果小于
				else if (st < rt) {
					if(numbers[left] == numbers[left + 1])
					while (left+1<n && numbers[left] == numbers[left + 1]) {
						left++;
					}
					else left++;
					
				} else {
					if(numbers[right - 1] == numbers[right])
					while (right-1>i && numbers[right - 1] == numbers[right]) {
						right--;
					}
					else right--;
				}
			}
		}
		return result;
	}
}
