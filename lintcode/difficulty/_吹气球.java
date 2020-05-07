package lintcode.difficulty;

import java.util.Arrays;

public class _吹气球 {

	public int maxCoins(int[] nums) {
		// write your code here

		// getMaxCoins(nums, 0, 1);
		return 0;
	}

	static int maxScore = 0;

	public static void main(String[] args) {
	}
	private static void getMaxCoins(int[] nums, int index, int score) {
		// TODO Auto-generated method stub
		if (index == nums.length) {
			
		}

		for (int i = index; i < nums.length; i++) {
			swap(nums, i, index);
			getMaxCoins(nums, index + 1, score);
			swap(nums, i, index);
		}
	}

	private static void swap(int[] nums, int i, int index) {
		int value = nums[i];
		nums[i] = nums[index];
		nums[index] = value;
	}

}
