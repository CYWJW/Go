package com.wjw.basic03;

public class Code_05_LongestSubarrayLessSumAwesomeSolution {

	public static int maxLengthAwesome(int[] arr, int k) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		//累加和
		int[] sums = new int[arr.length];
		//当前最小扩展下标
		int[] ends = new int[arr.length];
		sums[arr.length - 1] = arr[arr.length - 1];
		ends[arr.length - 1]=arr.length - 1;
		//求累加和 和下标
		for (int i = arr.length - 2; i >= 0; i--) {
			//如果上一个小于0
			if (sums[i + 1] < 0) {
				sums[i] = arr[i] + sums[i + 1];
				//当前最小 等于上一个最小
				ends[i]=ends[i+1];
			} else {
				sums[i] = arr[i];
				ends[i]=i;
			}
		}
		int R = 0;
		int sum = 0;
		int len = 0;
		for (int i = 0; i < arr.length; i++) {
			while (R < arr.length && sum + sums[R] <= k) {
				//扩充
				sum += sums[R];
				//R右+1
				R = ends[R] + 1;
			}
			//如果我阔出去了
			sum -= R > i ? arr[i] : 0;
			//取len
			len = Math.max(len, R - i);
			//取最大
			R = Math.max(R, i + 1);
		}
		return len;
	}

	public static int maxLength(int[] arr, int k) {
		int[] h = new int[arr.length + 1];
		int sum = 0;
		h[0] = sum;
		for (int i = 0; i != arr.length; i++) {
			sum += arr[i];
			h[i + 1] = Math.max(sum, h[i]);
		}
		sum = 0;
		int res = 0;
		int pre = 0;
		int len = 0;
		for (int i = 0; i != arr.length; i++) {
			sum += arr[i];
			pre = getLessIndex(h, sum - k);
			len = pre == -1 ? 0 : i - pre + 1;
			res = Math.max(res, len);
		}
		return res;
	}

	public static int getLessIndex(int[] arr, int num) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		int res = -1;
		while (low <= high) {
			mid = (low + high) / 2;
			if (arr[mid] >= num) {
				res = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return res;
	}

	// for test
	public static int[] generateRandomArray(int len, int maxValue) {
		int[] res = new int[len];
		for (int i = 0; i != res.length; i++) {
			res[i] = (int) (Math.random() * maxValue) - (maxValue / 3);
		}
		return res;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 1000000; i++) {
			int[] arr = generateRandomArray(10, 20);
			int k = (int) (Math.random() * 20) - 5;
			if (maxLengthAwesome(arr, k) != maxLength(arr, k)) {
				System.out.println("oops!");
			}
		}
	}
}
