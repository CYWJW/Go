package com.wjw.basic;

public class _最长相同字串 {
	public static void main(String[] args) {
		String str1 = "abcdeffff";
		String str2 = "bcddffff";
		getMaxSameStr(str1, str2);
	}

	private static void getMaxSameStr(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		// 定义一个二维辅助空间
		int str[][] = new int[len1][len2];
		int max = 1;
		int x=0;
		// 进行遍历
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				// 处理初始化边界
				if (i == 0 || j == 0) {
					if (str1.charAt(i) == str2.charAt(j))
						str[i][j] = 1;
				}
				// 为上一个储存的i j +1
				else if (str1.charAt(i) == str2.charAt(j)) {
					str[i][j] = str[i - 1][j - 1] + 1;
					if (str[i][j] > max)
					{
						max = str[i][j];
						//保存最后一位的数
						x=i;
					}
				}
			}
		}
		
		System.out.println(max);
		for (int i = 0; i <max; i++) {
			//找到第一位
			System.out.print(str1.charAt(x-max+i+1));
		}
	}
}
