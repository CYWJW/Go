package com.wjw.paixun;

import java.util.Arrays;

/**
 * 堆排序 平均log2n
 * 
 * @author 汪军伍
 *
 */
public class Dui {
	static int a[] = { 1, 8, 9, 3, 4, 6, 4, 60, 8, 6, 5, 9, 88 };

	public static void main(String[] args) {
		// 最后一个节点到根节点初始排序
		for (int i = a.length >> 1; i > 0; i--)
			soft(i, a.length - 1);

		for (int i = 1; i <= a.length; i++) {
			// 第一个和最后一个交换位置
			int value = a[0];
			a[0] = a[a.length - i];
			a[a.length - i] = value;
			soft(1, a.length - 1 - i);
		}
		
		System.out.println(Arrays.toString(a));
	}

	/**
	 * 一次堆排序算法
	 * 
	 * @param l
	 * 
	 *            节点
	 * @param n
	 *            结束下标
	 * 
	 * 
	 */
	public static void soft(int n, int l) {
		int c = 0;
		// 如果没到叶子节点
		while ((c = n * 2-1) <= l) {
			// 比较两个子节点取较大者,,,,,,,,,,,,
			if (c + 1 <= l && a[c] < a[c+1]) c++;
			// 判断是否大于子节点最大
			if (a[n - 1] > a[c]) return;
			
			int value = a[n - 1];
			a[n - 1] = a[c];
			a[c] = value;
			n = c+1;
		}
	}
}
