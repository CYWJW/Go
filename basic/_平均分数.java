package com.wjw.basic;

import java.util.Scanner;

public class _平均分数 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] values = new String[8];
		for (int i = 0; i < 8; i++) {
			values[i] = scanner.nextLine();
		}
		// 存入成绩
		int score[] = new int[8];
		for (int i = 0; i < values.length; i++) {
			String value = values[i];
			String[] split = value.split(" ");
			values[i] = split[0];
			score[i] = Integer.valueOf(split[1]);
		}
		// 保存最小 分数
		int min = Integer.MAX_VALUE;
		// 保存最小的下标
		int minIndex = 0;
		// 保存最大
		int max = Integer.MIN_VALUE;
		// 保存最大下标
		int maxIndex = 0;
		// 保存总和
		int num = 0;
		for (int i = 0; i < score.length; i++) {
			if (score[i] < min) {
				maxIndex = i;
				min = score[i];
			}
			if (score[i] > max) {
				maxIndex=i;
				max = score[i];
			}
			num += score[i];
		}
		System.out.println("最小是"+values[minIndex]+" "+ min + "分 最大是" +values[maxIndex]+" "+ max + "分  平均分是" + num / 8);

	}
}
