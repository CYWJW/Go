package com.wjw.lintcode.simple;

public class _爬楼梯 {
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			int n=(int) (Math.random()*20);
			if(climbStairs(n)!=climbStairs01(n))
				System.out.println("no");
		}
	}

	public static int climbStairs(int n) {
		if (n == 1 || n == 2)
			return n;
		int num = 0;
		// n=1
		int a = 1;
		// n=2
		int b = 2;
		for (int i = 3; i <= n; i++) {
			// f(n)=f(n-1)+f(n-2);
			num = a + b;
			a=b;
			b=num;
		}
		return num;
	}
	
	 public static int climbStairs01(int n) {
	        // write your code here
	        if (n == 1)
				return 1;
			if (n == 2)
				return 2;
			return climbStairs(n - 1) + climbStairs(n - 2);
	    }
}
