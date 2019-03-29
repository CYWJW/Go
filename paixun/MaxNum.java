package com.wjw.paixun;

public class MaxNum {
	static int a[] = { 1, 8, 9, 3, 4, 6, 4, 8, 8, 6 };
	public static void main(String[] args) {
	System.out.println(f(0, a.length-1));	
	}
	/**
	 * 
	 * @param b 开始下标
	 * @param e 结束下标
	 * @return
	 */
	private static int f(int b,int e) {
		//如果两个相等
		if(b==e)
		{
			return b;
		}
		
		if (e-b==1) {
			return Math.max(a[b], a[e]);
		}
		 
		
		
		//右边 比上左边 返回最大边
		return f((b+e)/2, e)>f(b, (b+e)/2)?f((b+e)/2, e):f(b, (b+e)/2);
		
	}
	
}
