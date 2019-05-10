package com.wjw.lintcode.simple;

public class _阶乘0个数 {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			long n=5555550000000l;
			long num = trailingZeros(n);
			long nu01 = trailingZeros01(n);
			if(nu01!=num)
				System.out.println(num+" "+nu01);
		}
		
	}

	public static long trailingZeros(long n) {
		int num = 0;
		//找寻倍数为5的个数 然后因为5倍数前面必有多个偶数 所以我们找寻
		for (int i = 5; i <=n; i=i+5) {
			int m=i;
			while (m%5==0) {
				num++;
				m/=5;
			}
		}
		return num;
	}
	

	public static long trailingZeros01(long n) {
		long num = 0;
		//找寻倍数为5的个数 然后因为5倍数前面必有多个偶数 所以我们找寻5 
		//5个5的倍数又会多个 往复
		while (n>0) {
			n/=5;
			num+=n;
		}
		return num;
	}
}
