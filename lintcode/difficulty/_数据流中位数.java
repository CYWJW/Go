package lintcode.difficulty;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _数据流中位数 {

	static class IntComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o1 > o2 ? -1 : 1;
		}

	}

	public static void main(String[] args) {
		System.out.println(medianII(new int[] { 1, 2, 3, 4, 5 }));
	}

	public static int[] medianII(int[] nums) {
		// write your code here
		int[] result = new int[nums.length];
		if (nums.length == 0) {
			return result;
		}

		PriorityQueue<Integer> minQueue = new PriorityQueue<>();
		PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new IntComparator());

		maxQueue.add(nums[0]);
		result[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] <= maxQueue.peek()) {
				maxQueue.add(nums[i]);
			} else {
				minQueue.add(nums[i]);
			}
			while (maxQueue.size() > minQueue.size() + 1) {
				minQueue.add(maxQueue.poll());
			}

			while (minQueue.size() > maxQueue.size()) {
				maxQueue.add(minQueue.poll());
			}
			result[i] = maxQueue.peek();
		}
		return result;
	}
}
