package com.wjw.paixun;

/**
 * 希尔排序 分成若干个子序列排序 最后进行全体排序基于O(n²)和O(nlog2n)之间
 * 
 * @author 汪军伍
 *
 */
public class XiEr {
	static int a[] = { 1, 8, 9, 3, 4, 6, 4, 60, 8, 6 };
	public static void main(String[] args) {
		quickSort(0,a.length-1);
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
	
	static void quickSort(int first,int end)
	{
		if(first<end)
		{
			//进行第一次 返回中间值
			int index = partTion(first, end);
			//进行左侧拍寻
			quickSort(first, index-1);
			//进行右侧
			quickSort(index+1, end);
		}
		
	}
	
	/**
	 * 排序划分函数
	 * @param a 数组
	 * @param first 开始下表
	 * @param end 结束下标
	 * @return
	 */
	static int partTion(int first, int end) {
		int i=first,j=end;
		//开始在结束后面一直循环
		while (i<j) {
			//右侧扫描
			while (i<j&&a[i]<a[j]) j--;
			if(i<j)
			{
				//交换
				int value=a[j];
				a[j]=a[i];
				a[i]=value;
				//进行加一
				i++;
			}
			//左侧扫描
			while (i<j&&a[i]<a[j]) i++;
			if(i<j)
			{
				//交换
				int value=a[j];
				a[j]=a[i];
				a[i]=value;
				//进行加一
				j--;
			}
		}
		return i;
	}
}
