package com.wjw.lintcode.middling;

import java.util.HashMap;

public class _最长无重复字符的子串 {

	public static int lengthOfLongestSubstring(String s) {
		// write your code here
		if (s.length() == 0) {
			return 0;
		}
		HashMap<Character, Integer> map = new HashMap<>();
		char[] charArray = s.toCharArray();
		int len = 1, left = 0;
		for (int i = 0; i < charArray.length; i++) {
			Integer index = map.get(charArray[i]);
			if (index == null) {
				if (i == charArray.length - 1) {
					len = Math.max(len, i - left + 1);
				} 
				map.put(charArray[i], i);
				continue;
			}
			len = Math.max(len, i - left);

			while (left <= index) {
				map.remove(charArray[left++]);
			}

			map.put(charArray[i], i);
		}
		return len;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}
}
