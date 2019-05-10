package com.wjw.lintcode.simple;

public class _AB问题 {
	public static void main(String[] args) {
		int ans = aplusb(-5, 1);
		System.out.println(ans);
	}

	public static int aplusb(int a, int b) {
		if (b == 0)
			return a;
		//找出不进位的结果
		int x1 = a ^ b;
		int x2 = (a & b) << 1;
		return aplusb(x1, x2);
	}
}
