package com.wjw.basic;

public class _最长回文串01 {
	public static void main(String[] args) {
		String str = "babcbabcbaccba";
		getStr(str);
	}

	private static void getStr(String str) {
		int len = str.length();
		// 初始化
		int[][] cache = new int[len][len];
		// 初始化为1的
		for (int i = 0; i < len; i++) {
			// 自己到自己为1长度
			cache[i][i] = 1;
		}

		int max = 0;
		String maxStr = "";
		// 初始化为2的
		for (int i = 0; i < len - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				max = 2;
				str.substring(i, i + 2);
			}
		}
		// 定义长度 从相隔为1开始 最长回文小于长度
		for (int i = 2; i < len; i++) {
			// 左下表
			for (int j = 0; j < len - i; j++) {
				// 定义右下
				int index = i + j;
				if (str.charAt(j) == str.charAt(index)) {
					if (cache[j + 1][index - 1] > 0) {
						// 长度+2
						cache[j][index] = cache[j + 1][index - 1] + 2;
						// 如果超过
						if (cache[j][index] > max) {
							max = cache[j][index];
							maxStr = str.substring(j, index + 1);
						}
					}
				}
			}

		}
		System.out.println(max + " " + maxStr);
	}

}
