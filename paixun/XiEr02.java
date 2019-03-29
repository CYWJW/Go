package com.wjw.paixun;

/**
 * 希尔排序 分成若干个子序列排序 最后进行全体排序基于O(n²)和O(nlog2n)之间
 * 
 * @author 汪军伍
 *
 */
public class XiEr02 {
	static int a[] = { 1, 8, 9, 3, 4, 6, 4, 60, 8, 6 ,90};
	public static void main(String[] args) {
		int d=a.length;
		//每次步长缩短二
		while((d=d>>1)>0)
		{
			//从最开始开始
			for (int i = d; i < a.length; i++) {
				//与前面的比较
				for (int j = i; j >=d; j=j-d) {
					//进行判断 如果小于就交换
					if(a[j]<a[j-d])
					{
						int a1=a[j-d];
						a[j-d]=a[j];
						a[j]=a1;
					}
				}
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
}
