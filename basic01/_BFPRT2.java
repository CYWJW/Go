package com.wjw.basic01;

import java.util.Arrays;

public class _BFPRT2 {

	public static void swap(int[] arr, int index1, int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}

	public static void main(String[] args) {
		int[] arr = { 6, 9, 1, 3, 1, 2, 2, 5, 6, 1, 3, 5, 9, 7, 2, 5, 6, 1, 9 };
		int value = getMinKthByBFPRT(arr, 10);
		System.out.println(value);
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	// 获取第k大的数
	private static int getMinKthByBFPRT(int[] arr, int k) {
		if(k<1 || k>arr.length)
			return -1;
		int[] copyArray = new int[arr.length];
		System.arraycopy(arr, 0, copyArray, 0, arr.length);
		return select(copyArray, 0, copyArray.length - 1, k);
	}

	// 传入开始和结束下标 k找寻多大的数
	private static int select(int[] copyArray, int b, int e, int k) {
		// 进行判断 递归调用结束
		if (b == e)
			return copyArray[b];
		// 返回中位数
		int mid = getMid(copyArray, b, e);
		// 中位数排序、
		int[] partition = partition(copyArray, b, e, mid);

		if (k > partition[0] && k <= partition[1]+1)
			return copyArray[partition[0]];
		else if (k <= partition[0])
			return select(copyArray, b, partition[0] - 1, k);
		else
			return select(copyArray, partition[1] + 1, e, k);
	}

	private static int[] partition(int[] copyArray, int b, int e, int value) {
		int min = b - 1;
		int max = e + 1;
		int index = b;
		while (index < max) {
			// 如果大于这个值
			if (copyArray[index] > value)
				swap(copyArray, index, --max);
			// 如果小于这个值
			else if (copyArray[index] < value)
				swap(copyArray, index++, ++min);
			else
				index++;
		}
		return new int[] { min + 1, max - 1 };
	}

	// 获取中位数
	private static int getMid(int[] copyArray, int b, int e) {
		// 找寻之和
		int sum = e - b + 1;
		int s = sum / 5 + (sum % 5 == 0 ? 0 : 1);
		// 分组
		int mid[] = new int[s];
		for (int i = 0; i < mid.length; i++) {
			// 获取每一次开始
			int big = b + i * 5;
			// 输入每一组的开始和结束
			mid[i] = sort(copyArray, big, Math.min(big + 4, e));
		}
		return select(mid, 0, mid.length - 1, mid.length / 2);
	}

	private static int sort(int[] copyArray, int big, int end) {
		for (int i = big + 1; i <= end; i++)
			for (int j = i; j > big; j--) {
				// 如果插入的比前面小 交换
				if (copyArray[j] < copyArray[j - 1])
					swap(copyArray, j, j - 1);
				else
					break;
			}
		int sum = end + big;
		// 返回数组低中位数
		int mid = (sum / 2) + (sum % 2);
		return copyArray[mid];
	}

}
