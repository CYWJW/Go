package com.wjw.basic01;

import java.util.Arrays;

public class Manacher {

	public static char[] manacherString(String str) {
		char[] array = str.toCharArray();
		char[] newStr = new char[array.length * 2 + 1];
		for (int i = 0; i < newStr.length; i++) {
			// 是否为偶数 是填#
			newStr[i] = (i & 1) == 0 ? '#' : array[i >> 1];
		}

		return newStr;
	}

	public static int[] maxLcpsLength(String str) {
		if (str == null || str.length() == 0) {
			return new int[] { 0 };
		}
		// 获得处理字符串
		char[] maStr = manacherString(str);
		// 定义半径 存多少個
		int[] radii = new int[maStr.length];
		// 定义中心点
		int index = -1;
		// 定义右边界
		int R = -1;
		int start = 1;
		int max = Integer.MIN_VALUE;
		// 循环
		for (int i = 0; i != maStr.length; i++) {
			// 判断下标是否大于半径 如果不是就选最小的半径 如果i<r 那么必有中心点来到这 就选择对称最小的
			radii[i] = R > i ? Math.min(radii[2 * index - i], R - i) : 1;
			// 判断半径之外
			while (i + radii[i] < radii.length && i - radii[i] > -1) {
				// 如果两边相同
				if (maStr[i + radii[i]] == maStr[i - radii[i]])
					radii[i]++;
				else
					break;
			}
			// 如果超出右边界了
			if (i + radii[i] > R) {
				R = i + radii[i];
				index = i;
			}

			if (max < radii[i]) {
				max = radii[i];
				start = (i - radii[i] + 1) / 2;
			}
		}
		return new int[] { max - 1, start };
	}

	public static void main(String[] args) {
		String str1 = "d22a";
		System.out.println(Arrays.toString(maxLcpsLength(str1)));
	}

}
