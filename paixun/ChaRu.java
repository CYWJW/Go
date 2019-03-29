package com.wjw.paixun;

/**
 * 插入排序 分为有序区和无序区 将无序区的插入到有序区的合适未知 为O(n²)
 * 
 * @author 汪军伍
 *
 */
public class ChaRu {
	static int array[] = { 1, 8, 9, 3, 4, 6, 4, 6, 8, 6 };
	public static void main(String[] args) {
		for (int i = 1; i < array.length; i++) {
			//暂存值
			int value = array[i];
			// 从第二个位置开始 如果value小于就继续循环 并两个交换位置
			for (int j = i-1;value<array[j]&&j>=0;j--) {
				//后移
				array[j+1]=array[j];
				array[j]=value;
			}
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
}
