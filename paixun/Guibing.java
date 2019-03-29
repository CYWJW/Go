package com.wjw.paixun;

import java.util.Arrays;

/**
 * 希尔排序 分成若干个子序列排序 最后进行全体排序基于O(n²)和O(nlog2n)之间
 * 
 * @author 汪军伍
 *
 */
public class Guibing {
	static int a[] = { 1, 8, 9, 3, 4, 6, 4, 60, 8, 6 };
	

	public static void main(String[] args) {
		mergeSort(0, a.length-1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	/**
	 * 
	 * @param s
	 *            第一个数组开始下标
	 * @param m
	 *            第二个数组最后下标
	 */
	static void mergeSort(int s, int t) {
		if (s < t) {
			int m = (s + t)/2;
			// 排序左边
			mergeSort(s, m);
			// 排序右边
			mergeSort(m + 1, t);
			// 进行归并
			merGe( s, m + 1, t);
		}
	}

	/**
	 * 
	 * @param s
	 *            第一个数组第一个下标
	 * @param m
	 *            第二个数组第一个下标
	 * @param t
	 *            最后一个下标 a 1, 8, 0, 0, 0, 0, 0, 0, 0, 0]
	 */
	// 传入 比较a的数 比较的数是有序的 返回的b是是有序的
	static void merGe(int s, int m, int t) {
		 int b[] = new int[t-s+1];
			// 如果只要一个数组
		// 第一个 b数组开始 第二个 记录初始
		int index = 0;
		int k = m;
		int l=s;
		while (s < k && m <= t) {
			// 如果 大的话
			if (a[m] > a[s])
				b[index++] = a[s++];
			else
				b[index++] = a[m++];
		}
		// 如果没有排完得话
		while (s < k)
			b[index++] = a[s++];
		while (m <= t)
			b[index++] = a[m++];
		
		// b 原数组 0 开始位置 a目标数组 s目标数组起始位置 长度
		 System.arraycopy(b, 0, a, l, b.length);
	}

}
