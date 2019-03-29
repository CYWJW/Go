package com.wjw.paixun;

/**
 * 希尔排序 分成若干个子序列排序 最后进行全体排序基于O(n²)和O(nlog2n)之间
 * 
 * @author 汪军伍
 *
 */
public class MaoPao {
	static int array[] = { 1, 8, 9, 3, 4, 6, 4, 60, 8, 6 };

	public static void main(String[] args) {
		// 记录区间
		int echange = array.length;
		while (echange != -1) {
			//记录最后一次交换，
			int index = echange - 1;
			// 如果都有徐的话就不用进入if 就直接跳出
			echange = -1;
			for (int i = 0; i < index; i++) {
				// 进行判断是否交换
				if (array[i] > array[i + 1]) {
					int value = array[i + 1];
					array[i + 1] = array[i];
					array[i] = value;
					// 记录到哪里
					echange = i + 1;
					
				}
			}

		}

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}
}
