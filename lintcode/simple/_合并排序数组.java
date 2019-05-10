package com.wjw.lintcode.simple;

public class _合并排序数组 {

	public static int[] mergeSortedArray(int[] A, int[] B) {
		int lenA = A.length;
		int lenB = B.length;
		int[] a = new int[lenA + lenB];
		int index=0;
		int i = 0;
		int j = 0;
		while (i < lenA && j < lenB) {
			// 比较两个数
			if (A[i] < B[j]) {
				a[index++]=A[i++];
			}else {
				a[index++]=B[j++];
			}
		}
		
		while (i<lenA) {
			a[index++]=A[i++];
		}
		while (j<lenB) {
			a[index++]=B[j++];
		}
		return a;
	}

}
