package com.wjw.basic02;

import java.util.HashMap;
public class Most_EOR2 {

	public static int mostEOR(int[] arr) {
		//记录最大数
		int ans = 0;
		int xor = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		//开始0 在负-位置
		map.put(0, 1);
		for (int i = 0; i < arr.length; i++) {
			//获取当前的值
			xor ^= arr[i];
			System.out.print(xor+" ");
			//如果之前出现过
			if (map.containsKey(xor)) {
				//原来+1
				map.put(xor,map.get(xor)+1);
				ans=Math.max(ans, map.get(xor));
			}
			else
			{
				map.put(xor,1);
				ans=Math.max(ans, map.get(xor));
			}
		}
		return ans-1;
	}

	// for test
	public static int comparator(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int[] eors = new int[arr.length];
		int eor = 0;
		for (int i = 0; i < arr.length; i++) {
			eor ^= arr[i];
			eors[i] = eor;
		}
		int[] mosts = new int[arr.length];
		mosts[0] = arr[0] == 0 ? 1 : 0;
		for (int i = 1; i < arr.length; i++) {
			mosts[i] = eors[i] == 0 ? 1 : 0;
			for (int j = 0; j < i; j++) {
				if ((eors[i] ^ eors[j]) == 0) {
					mosts[i] = Math.max(mosts[i], mosts[j] + 1);
				}
			}
			mosts[i] = Math.max(mosts[i], mosts[i - 1]);
		}
		return mosts[mosts.length - 1];
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random());
		}
		return arr;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		/*int testTime = 1;
		int maxSize = 10;
		int maxValue = 10;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr = generateRandomArray(maxSize, maxValue);
			int res = mostEOR(arr);
			System.out.println();
			int comp = comparator(arr);
			if (res != comp) {
				succeed = false;
				printArray(arr);
				System.out.println(res);
				System.out.println(comp);
				break;
			}
		}*/
		int arr[]= {0 ,8 ,9 ,2 ,10 ,8 ,10 ,2 ,5 ,0};
		int res = mostEOR(arr);
		System.out.println("\n"+res);
		//System.out.println(succeed ? "Nice!" : "Fucking fucked!");
	}

}
