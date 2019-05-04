package com.wjw.basic03;

import java.util.HashMap;
import java.util.Map;

public class _最长子数组 {
	public static void main(String[] args) {
		int[] a = { 3, 2, 1, 5, 1, 1, 1, 1, 1, 1 };
		int k = 6;
		int len = getMaxArrLen(a, k);
		System.out.println(len);
	}

	private static int getMaxArrLen(int[] a, int k) {
		int len = 0;
		if (a == null || a.length < 1)
			return len;
		// 缓存
		Map<Integer, Integer> cache = new HashMap<>();
		cache.put(0, -1);
		// 当前之和
		int cout = 0;
		for (int i = 0; i < a.length; i++) {
			cout += a[i];
			// 如果之前出现过这个数
			if (cache.containsKey(cout - k)) {
				len = Math.max(len, i - cache.get(cout - k));
			}
			// 如果不包含现在的数 加进去 只加第一个出现的
			if (!cache.containsKey(cout))
				cache.put(cout, i);
		}
		return len;
	}
}
