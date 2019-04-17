package com.wjw.basic01;

import java.util.Random;

public class _唯一成对的数 {

	public static void main(String[] args) {
		int N = 11;
		int[] arr = new int[N];
		for (int i = 0; i < arr.length - 1; i++) {
			arr[i] = i + 1;
		}
		// 最后一个数，是随机数
		arr[arr.length - 1] = new Random().nextInt(N - 1) + 1;
		// 随机下标
		int index = new Random().nextInt(N);
		swap(arr, index, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
		int x1 = 0;
		for (int i = 1; i <= N - 1; i++) {
			x1 = (x1 ^ i); // 求得1到N-1这些连续的数的异或
		}
		System.out.println();
		for (int i = 0; i < N; i++) {
			x1 = (x1 ^ arr[i]); // 再与原来的数组arr异或，这样重复的数就有三个，不重复的数有两个，异或消除重复后，剩下的就是重复的数了
		}
		System.out.println(x1);

	}

	public static void swap(int[] array, int x, int y) {
		int xx = array[x];
		int yy = array[y];
		array[x] = yy;
		array[y] = xx;
	}

}
