package com.wjw.lintcode.middling;

public class _交叉字符串 {
	public static void main(String[] args) {

		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		boolean os = isInterleave(s1, s2, s3);
		System.out.println(os);
	}

	public static boolean isInterleave(String s1, String s2, String s3) {
		// write your code here
		if (s1.length() + s2.length() != s3.length())
			return false;
		if (s1.equals("") || s2.equals(""))
			return s3.equals(s1 + s2);
		char[] s1Str = s1.toCharArray();
		char[] s2Str = s2.toCharArray();
		char[] s3Str = s3.toCharArray();
		int i = s1Str.length;
		int j = s2Str.length;
		// 动态规划
		boolean dp[][] = new boolean[i + 1][j + 1];
		// 初始化dp
		init(dp, s3Str, s1Str, s2Str, i, j);
		
		// 进行dp推进
		for (int str1Index = i - 1; str1Index >= 0; str1Index--) {
			for (int str2Index = j - 1; str2Index >= 0; str2Index--) {
				int k =str1Index+str2Index;
				// 这一个依赖 下一个 或者左边一个
				if (s1Str[str1Index] == s3Str[k] || s2Str[str2Index] == s3Str[k])
					dp[str1Index][str2Index] = (dp[str1Index + 1][str2Index] || dp[str1Index][str2Index + 1]);
			}
		}
		
		return dp[0][0];
	}

	private static void init(boolean[][] dp, char[] s3Str, char[] s1Str, char[] s2Str, int i, int j) {
		dp[i][j]=true;
		for (int i2 = i-1; i2>-1; i2--) {
			int k=j+i2;
			if(s1Str[i2] == s3Str[k])
				dp[i2][j]=dp[i2+1][j];
		}
		for (int j2 = j-1; j2 >-1; j2--) {
			int k=i+j2;
			if(s2Str[j2] == s3Str[k])
				dp[i][j2]=dp[i][j2+1];
		}
	}
	/**
	 * @param i
	 *            s1
	 * @param j
	 *            s2
	 * @return 暴力递归
	 */
	private static boolean isInterleaveTest(char[] s1Str, char[] s2Str, char[] s3Str, int i, int j, int k) {
		// 如果匹配完成
		if (s1Str.length == i && s2Str.length == j)
			return true;
		// 如果当前是s1Str匹配上的
		if (i < s1Str.length && s1Str[i] == s3Str[k] && isInterleaveTest(s1Str, s2Str, s3Str, i + 1, j, k + 1))
			// 继续匹配下去
			return true;
		if (j < s2Str.length && s2Str[j] == s3Str[k] && isInterleaveTest(s1Str, s2Str, s3Str, i, j + 1, k + 1))
			// 继续匹配下去
			return true;
		// 如果都没有匹配上 返回false
		return false;
	}

}
