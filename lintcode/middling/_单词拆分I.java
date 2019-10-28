package com.wjw.lintcode.middling;

import java.util.HashSet;
import java.util.Set;

public class _单词拆分I {
	public static boolean wordBreak(String s, Set<String> dict) {
		// write your code here
		if (s == null || dict == null)
			return false;
		int maxLen = 0;
		for (String word : dict) {
			maxLen = Math.max(maxLen, word.length());
		}

		boolean[] f = new boolean[s.length() + 1];
		f[0] = true;
		for (int i = 1; i < s.length() + 1; i++) {
			for (int j = Math.max(0, i - maxLen); j < i; j++) {
				if (f[j] && dict.contains(s.substring(j, i))) {
					f[i] = true;
				}
			}

		}
		return f[s.length()];
	}

	static boolean wordBreak(int i, String s, Set<String> dict) {
		if (i >= s.length()) {
			return true;
		}
		for (String str : dict) {
			int size = str.length();
			if (i + size <= s.length() && dict.contains(s.substring(i, i + size))) {
				if (!wordBreak(i + size, s, dict)) {
					continue;
				}
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String s = "aaaaaaa";
		Set<String> dict = new HashSet<>();
		dict.add("aaaa");
		dict.add("aaa");

		boolean b = wordBreak(0, s, dict);
		System.out.println(b);
	}

}
