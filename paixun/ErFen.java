package com.wjw.paixun;

import java.util.Arrays;

/**
 * 希尔排序 分成若干个子序列排序 最后进行全体排序基于O(n²)和O(nlog2n)之间
 * 
 * @author 汪军伍
 *
 */
public class ErFen {
	static int a[] = { 1, 8, 9, 3, 4, 6, 4, 12, 8, 6 };
	public static void main(String[] args) {
		Arrays.sort(a);
		for (int i = 0; i <a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		System.out.println(f(0, a.length-1, 9));
	}
	
	
	
	
	
	/**
	 * @param b 开始位置 
	 * @param e 末尾位置
	 * @param obj 查找的数
	 * @return
	 */
	public static int f(int b,int e,int obj) {
		if(b<0 ||  e>a.length-1)
		{
			return -1;
		}
		//如果在右边
		if(a[(b+e)/2]<obj)
		{
		return	f((b+e)/2+1,e,obj);
		}
		
		else if (a[(b+e)/2]>obj) {
			return	f(b,(b+e)/2-1,obj);
		} else {
			return (b+e)/2;
		}
	}
}
