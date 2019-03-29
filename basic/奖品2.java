package com.wjw.basic;

import java.util.LinkedList;
import java.util.Scanner;

public class 奖品2 {
	static LinkedList<int[]> list = new LinkedList<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 样列
		int nextInt = scanner.nextInt();
		for (int i = 0; i < nextInt; i++) {

			int k = scanner.nextInt();
			int a[] = new int[k];
			for (int j = 0; j < k; j++) {
				a[j] = scanner.nextInt();
			}
			list.add(a);
		}
		for (int j = 0; j < list.size(); j++) {
			getNum(list.get(j));
		}
	}

	private static void getNum(int[] a) {
		int n = 1;
		int index = 0;// 保存最大值的位置
		int max = 0;// 保存给的最大值
		int sum = 0;
		int N = a.length;
		for (int i = 1; i < N; i++) {
			if (a[i] < a[i - 1])
				n++;
			else
				n = 1;
			if (n < max) {
				index = i;
				max = n;
			}
		}
		int m = max;// 将最大的值保存下来
		/* 从最大值的位置开始算起，分别向两个方向扩展 */
		/* 从中间向左边算起 */
		for (int i = index; i > 1; i--) {
			sum += m;
			if (a[i] > a[i - 1] && a[i - 1] > a[i - 2]) {
				m--;
				sum += m;
			} else if (a[i] > a[i - 1] && a[i - 1] <= a[i - 2]) {
				m = 1;
				sum += m;
			} else if (a[i] < a[i - 1]) {
				m++;
				sum += m;
			} else
				sum += m;

		}
		/* 最左边一个值的判定 */
		if (a[1] > a[0])
			sum++;
		else if (a[1] == a[0])
			sum += m;
		else
			sum = (m + 1 + sum);
		m = max;
		/* 从中间向右边算起 */
		for (int i = index; i < N - 2; i++) {
			if (a[i] > a[i + 1] && a[i + 1] > a[i + 2]) {
				m--;
				sum += m;
			} else if (a[i] > a[i + 1] && a[i + 1] <= a[i + 2]) {
				m = 1;
				sum += m;
			} else if (a[i] < a[i + 1]) {
				m++;
				sum += m;

			} else
				sum += m;
		}
		/* 最右边一个值的判定 */
		if (a[N - 2] > a[N - 1])
			sum++;
		else if (a[N - 2] == a[N - 1])
			sum += m;
		else
			sum = (m + 1 + sum);
		
		System.out.println(sum-1);
	}

}
