package com.wjw.basic01;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 找寻一段数字连续中的最小数 o(n)
 * 
 * @author 汪军伍
 */
public class _双端队列 {
	public static void main(String[] args) {
		int a[] = { 1, 5, 8, 6, 2, 6, 7, 2, 6, 8 };
		int[] num = f(a, 3);
		System.out.println(Arrays.toString(num));
	}

	private static int[] f(int[] a, int k) {
		if (a == null || a.length < k)
			return new int[0];
		int[] num = new int[a.length - k + 1];
		LinkedList<Integer> list = new LinkedList<>();
		int index=0;
		for (int i = 0; i < a.length; i++) {
			// 如果队列不为空 并且后面小于
			while (!list.isEmpty() && a[i] >= a[list.getLast()]) {
				list.removeLast();
			}
			// 队尾添加元素
			list.addLast(i);
			// 如果队头过期
			if (i - k == list.getFirst())
				list.removeFirst();
			if (i >= k - 1)
				num[index++]=a[list.getFirst()];
		}
		return num;
	}
}
