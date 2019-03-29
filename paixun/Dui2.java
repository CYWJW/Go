package com.wjw.paixun;

/**
 * 堆排序 平均nlog2n
 * 
 * @author 汪军伍
 *
 */
public class Dui2 {
	static int a[] = {0, 1, 8, 9, 3, 4, 62, 4, 60, 80, 6 };

	public static void main(String[] args) {
		soft(1, a.length-1);
		for (int i = 1; i<a.length-1; i++) {
			//交换然后继续
			int value =a[a.length-i];
			a[a.length-i]=a[1];
			a[1]=value;
			soft(1, a.length-1-i);
		}
		
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+ " ");
		}
	}

	/**
	 * 一次堆排序算法
	 * 
	 * @param l
	 *            排序数组的长度
	 * @param n
	 *           节点
	 * 
	 * 
	 */
	public static int soft(int n, int l) {
		//如果节点不存在
		if(n>l)
		{
			return 0; 
		}
		 int m=n<<1;
		//左节点最大值
		int left = soft(m, l);
		//右节点最大值
		int rigth = soft(m+1,l);
		//取最大值
		int max=left>rigth?left:rigth;
		if(left<rigth)
		{
			//指向最大值
			m++;
		}
		//如果最大值是根节点直接返回给
		if (a[n]>max) {
			return a[n];
		}
		//如果不是 
		else {
			int value =a[n];
			a[n]=a[m];
			a[m]=value;
			//交换后继续比较
			soft(m, l);
			return a[n];
		}
	}
}
