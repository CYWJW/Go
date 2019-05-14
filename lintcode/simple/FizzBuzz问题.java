package com.wjw.lintcode.simple;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz问题 {
	public static void maii(String[] args) {

	}

	public List<String> fizzBuzz(int n) {
		// write your code here
		List<String> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0) {
				String result = i % 5 == 0 ? "fizz buzz" : "fizz";
				list.add(result);
			} else {
				String result = i % 5 == 0 ? "buzz" : i+"";
				list.add(result);
			}
		}
		return list;
	}
}
