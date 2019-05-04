package com.wjw.basic03;


public class _最长正子数组 {
	public static void main(String[] args) {
		int[] a = { 3, 2, 1, 5, 1, 1, 1, 1, 1, 1 };
		int k = 6;
		int len = getMaxArrLen(a, k);
		System.out.println(len);
	}

	private static int getMaxArrLen(int[] a, int k) {
		int len = 0;
		if (a == null || a.length < 1)
			return len;
		int cout = 0;
		int left = -1;
		int right = 0;
		while (right < a.length) {
			//如果当前数小于累加和  那么右指针动
			if (cout <= k) {
				cout += a[right];
				if(cout==k)
					//左指针还未移动
					len=Math.max(len, right-left);
				right++;
			}
			//如果大于 那么左指针动
			else
				cout-=a[++left];
		}
		return len;
	}
}
