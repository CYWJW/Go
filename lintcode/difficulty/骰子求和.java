package com.wjw.lintcode.difficulty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class 骰子求和 {
	
	public static void main(String[] args) {
		List<Entry<Integer, Double>> dicesSum = dicesSum(2);
		
		for(Map.Entry<Integer, Double> entry:dicesSum)
			System.out.println(entry.getKey()+" "+entry.getValue());
	}
	
	public static List<Map.Entry<Integer, Double>> dicesSum(int n) {
		List<Map.Entry<Integer, Double>> list = new ArrayList<>();
		// 暴力递归找出所有情况
		Map<Integer, Double> all = new HashMap<>();
		getAll(all, n, 1, 0);
		Set<Map.Entry<Integer, Double>> set = all.entrySet();
		for (Map.Entry<Integer, Double> entry:set) {
			Double value = entry.getValue();
			value=value/(Math.pow(6, n));
			value=(Math.round(value*100)/100d);
			entry.setValue(value);
			list.add(entry);
		}
		return list;
	}

	/**
	 * @param n
	 *            能扔多少次
	 * @param k
	 *            扔了多少次
	 * @param sum
	 *            总点数
	 */
	private static void getAll(Map<Integer, Double> all, int n, int k, int sum) {
		if (k > n) {
			Double value = all.get(sum);
			if (value != null) {
				all.put(sum, value + 1);
			} else
				all.put(sum, 1d);
		}
		else {
			// 每一次六种情况
			for (int i = 1; i < 7; i++) {
				getAll(all, n, k + 1, sum + i);
			}
		}
	}
}
