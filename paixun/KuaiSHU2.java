package com.wjw.paixun;

/**
 * 快速排序   找出值
 * @author 汪军伍
 *
 */
public class KuaiSHU2 {
	static int a[] = { 1, 8, 9, 3, 4, 6, 4, 60, 8, 6 ,90};

	public static void main(String[] args) {
		quickSort(0, a.length - 1);
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
/**
 * 	找出一个最左值
 * @param first
 * @param end
 */
	static void quickSort(int first, int end)
	{
		if(first>=end)
		{
			return;
		}
		
		//一次划分
		int parTition = parTition(first, end);
		//左边排序
		quickSort(first, parTition-1);
		quickSort(parTition+1, end);
		
	}
	
	/**
	 * 传入开始和结束下标
	 * @param first
	 * @param end
	 * @return 返回中心坐标
	 */
	static int parTition(int first, int end)
	{
		for (int i = first; i <= end; i++) {
			//如果比值小就交换  
			if(a[i]<a[end])
			{
				//交换后指针加一
				int value=	a[first];
				a[first++]=a[i];
				a[i]=value;
			}
			else if(i==end)
			{
				//交换
				int value=	a[first];
				a[first]=a[i];
				a[i]=value;
			}
		}
		return first;
	}
}
