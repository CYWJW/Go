package com.wjw.lintcode.simple;

public class _删除元素 {

	public static void main(String[] args) {

		int element = removeElement(new int[] { 0, 4, 4, 0, 0, 2, 4, 4 }, 4);
		System.out.println(element);
	}

	public static int removeElement(int[] A, int elem) {
		// write your code here
		int right = A.length - 1;
		int left = 0;

		swap(A, right, left);

		while (right > left) {
			if (A[left] == elem) {
				swap(A, right--, left);
				continue;
			}
			left++;
		}
		return A[right] == elem ? right : right + 1;
	}

	private static void swap(int[] a, int right, int left) {
		// TODO Auto-generated method stub
		int value = a[right];
		a[right] = a[left];
		a[left] = value;

	}

}
