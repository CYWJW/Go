package com.wjw.basic01;

public class _最长回文串 {

	public static char[] manacherString(String str) {
		char[] charArr = str.toCharArray();
		//初始化长度+1得数组
		char[] res = new char[str.length() * 2 + 1];
		int index = 0;
		
		for (int i = 0; i != res.length; i++) {
			//奇偶判断 如果是偶数 那么填#
			res[i] = (i & 1) == 0 ? '#' : charArr[index++];
		}
		return res;
	}
	public static int maxLcpsLength(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		//转化字符串
		char[] charArr = manacherString(str);
		//记录相应位置的半径
		int[] pArr = new int[charArr.length];
		//记录中心点
		int index = -1;
		//右边界
		int pR = -1;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i != charArr.length; i++) {
			//右边界是否大于指针 如果小于就是1 如果大于就是 左对应点 和 右边界小的值
			pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
			
			//如果半径没越界
			while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
				//如果两边相等
				if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
					pArr[i]++;
				else {
					break;
				}
			}
			if (i + pArr[i] > pR) {
				pR = i + pArr[i];
				index = i;
			}
			max = Math.max(max, pArr[i]);
		}
		return max - 1;
	}

	public static void main(String[] args) {
		String str1 = "abc1234321ab";
		System.out.println(maxLcpsLength(str1));
	}

}
