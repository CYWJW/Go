package com.wjw.lintcode.difficulty;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _滑动窗口的中位数 {

	static class ReverseOrder implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1 > o2 ? -1 : (o1 == o2 ? 0 : 1);
		}
	}

	public static void main(String[] args) {
		PriorityQueue<Integer> min = new PriorityQueue(new ReverseOrder());
		List<Integer> list = medianSlidingWindow(new int[] { -2147483648, 2147483647, 2147483647 }, 3);
		System.out.println(list);
	}

	public static List<Integer> medianSlidingWindow(int[] nums, int k) {
		// write your code here
		// 思路是我们使用两个有序的队列，一个小值，一个放大值，
		// 那么中位数就是小值队列里边的最大值，
		// 每次保证小队列里边的数据个数要么比大队列的多一个，要么相等。
		PriorityQueue<Integer> max = new PriorityQueue();
		// 因为我们要操作的是小值队列的最大值，所以要把它逆序。
		PriorityQueue<Integer> min = new PriorityQueue(new ReverseOrder());
		// 存放结果
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			// 如果完全没有数据，优先添加到小队列里边
			if (min.size() == 0) {
				min.add(nums[i]);
			} else if (min.peek() > nums[i]) {
				// 如果当前元素比小队列的最大值小，添加到小队列，
				min.add(nums[i]);
			} else {
				// 否则添加到大队列
				max.add(nums[i]);
			}
			// 判断是否有元素需要删除，
			if (i - k >= 0) {
				int delete = nums[i - k];
				// 如果要删除的元素比小队列的最大值小或者相等。说明它在小队列里边，删除，
				// 否则说明它在大队列里边
				if (min.peek() >= delete) {
					min.remove(delete);
				} else {
					max.remove(delete);
				}
			}
			// 调整大队列和小队列的元素个数
			while (min.size() > max.size() + 1) {
				max.add(min.poll());
			}
			while (max.size() > min.size()) {
				min.add(max.poll());
			}
			// 当有k个元素时，添加入结果集，直接使用小队列的最大值
			if (i >= k - 1) {
				list.add(min.peek());
			}
		}
		return list;
	}

}
