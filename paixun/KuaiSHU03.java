package com.wjw.paixun;

/**
 * 快速排序   找出值
 * @author 汪军伍
 *
 */
public class KuaiSHU03 {
	static int a[] = { 1, 8, 9, 3, 4, 6, 4, 6, 8, 6 ,9};
	public static void main(String[] args) {
		quickSort(a);
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
/**
 * 	找出一个最左值
 * @param first
 * @param end
 */
	public static void quickSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		quickSort(arr, 0, arr.length - 1);
	}

	public static void quickSort(int[] arr, int l, int r) {
		if (l < r) {
			swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
			int[] p = partition(arr, l, r);
			quickSort(arr, l, p[0] - 1);
			quickSort(arr, p[1] + 1, r);
		}
	}

	public static int[] partition(int[] arr, int l, int r) {
		//记录小于最左区间
		int less = l - 1;
		//记录最大于的区间
		int more = r;
		while (l < more) {
			//如果 如果小于比较值的话
			if (arr[l] < arr[r]) {
				//与小于交换
				swap(arr, ++less, l++);
			} else if (arr[l] > arr[r]) {
				//与最右交换
				swap(arr, --more, l);
			} else {
				//如果相等 记录比较的指针+1
				l++;
			}
		}
		//交换 
		swap(arr, more, r);
		return new int[] { less + 1, more };
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
