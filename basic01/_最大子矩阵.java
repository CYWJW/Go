package com.wjw.basic02;

public class _最大子矩阵 {
	public static void main(String[] args) {
		int a[][] = { { 8, -5, 6 }, { -10, 8, 5 }, { 3, 8, -5 } };
		int sum = getMaxArr(a);
		System.out.println(sum);
	}

	private static int getMaxArr(int[][] a) {
		if (a == null || a.length < 1)
			return -1;
		int sum[] = new int[a[0].length];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				//保存现在加上上一次的数组
				if (i == 0) {
					// 如果当前
					sum[j] = a[i][j];
				} else {
					sum[j] += a[i][j];
				}
			}
			//保存当前最大值
			int bnowMax=Integer.MIN_VALUE;
			int bbfMax=Integer.MIN_VALUE;
			//加了之前的
			for (int k = 0; k < sum.length; k++) {
				//要不要之前那个？
				bbfMax=bbfMax>0? bbfMax+sum[k]:sum[k];
				bnowMax=Math.max(bnowMax, bbfMax);
			}
			
			//保存当前最大值
			int nowMax=Integer.MIN_VALUE;
			int bfMax=Integer.MIN_VALUE;
			//没加之前的
			for (int k = 0; k < sum.length; k++) {
				//要不要之前那个？
				bfMax=bfMax>0? bfMax+a[i][k]:a[i][k];
				nowMax=Math.max(nowMax, bfMax);
			}
			max=bnowMax;
			//如果当前 大于合并
			if(nowMax>bnowMax)
			{
				max=nowMax;
				//最大数组等于现在
				sum=a[i];
			}
		}

		return max;
	}

}
