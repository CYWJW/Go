package com.wjw.paixun;
public class LongestPalindromicSubString {

	public static String longestPalindrome2(String s) {
		if (s == null)
			return null;
	 
		if(s.length() <=1)
			return s;
	 
		int maxLen = 0;
		String longestStr = null;
		//记录s长度
		int length = s.length();
	 
		int[][] table = new int[length][length];
	 
		for (int i = 0; i < length; i++) {
			//自己肯定是回文
			table[i][i] = 1;
		}
	 
		for (int i = 0; i <= length - 2; i++) {
			//找出相同的
			if (s.charAt(i) == s.charAt(i + 1)){
				table[i][i + 1] = 1;
				//记录连个相同的
				longestStr = s.substring(i, i + 2);
			}	
		}
		
		//从第三个开始
		for (int l = 3; l <= length; l++) {
			for (int i = 0; i <= length-l; i++) {
				//从相隔两个字符串 慢慢递增
				int j = i + l - 1;
				//如果相等
				if (s.charAt(i) == s.charAt(j)) {
					//判断子的是否是回文子串  如果不是 自己也不是
					table[i][j] = table[i + 1][j - 1];
					if (table[i][j] == 1 && l > maxLen)
						longestStr = s.substring(i, j + 1);
					
				} else {
					table[i][j] = 0;
				}
			}
		}
	 
		return longestStr;
	}
	public static void main(String[] args) {
		System.out.println(longestPalindrome2("babcbabcbaccba"));//babcbabcbaccba

	}
}