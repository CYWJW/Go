package com.wjw.basic;


public class _湊算数 {
	static int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	static int sum = 0;

	public static void main(String[] args) {
		System.out.println();
		int n = 10;
		f(n, 0);
		System.out.println(sum);
	}

	private static void f(int n, int k) {
		if (k == array.length) {
			f1(n);
		}
		// 确定第k位
		for (int i = k; i < array.length; i++) {
			// 交换
			int tem = array[k];
			array[k] = array[i];
			array[i] = tem;
			f(n, k + 1);
			// 回溯
			tem = array[k];
			array[k] = array[i];
			array[i] = tem;
		}
	}
	/**
	 * 	0 1 2 345 678       2   y     3  y   x   2
	 *  a+b/c+def/ghi=10    c*ghi     b*ghi  def*c
	 * @param n
	 */
	// 验证是否相等
	private static void f1(int n) {
		//计算x
		int x=array[3] * 100 + array[4] * 10+array[5];
		int y=array[6] * 100+array[7] * 10+ array[8];
		if ((array[1]*y+x*array[2]) % (array[2]*y)==0) 
		if(array[0]+(array[1]*y+x*array[2]) / (array[2]*y) ==n )
		{
			sum++;
		}
	}
}
