package com.wjw.qus;

/**
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy. Children with a higher rating get
 * more candies than their neighbors.
 * 
 * What is the minimum candies you must give?
 * 
 * @author 汪军伍
 *
 */
public class CanDy {

	public static void main(String[] args) {
		int ratings[] = { 1, 6, 5, 4, 3 };
		candy(ratings);
	}

	public static int candy(int[] ratings) {
		// 保存分数
		int[] num = new int[ratings.length];
		// 从左到右扫描
		for (int i = 0; i < ratings.length-1; i++) {
			// 如果下一个比当前的更高
			if (ratings[i] < ratings[i + 1])
				num[i + 1] = num[i]+1;
			// 其余情况不管
		}
		// 从右到左
		for (int i = ratings.length - 1; i > 0; i--) {
			// 如果前一个比当前的更高 并且糖果一样或者更低
			if (ratings[i] < ratings[i - 1] && num[i] >= num[i - 1])
				num[i - 1] = num[i]+1;
			// 其余情况不管
		}
		int nums = num.length;
		for (int i = 0; i < num.length; i++) {
			nums += num[i];
		}

		System.out.println(nums);
		return nums;
	}
}
