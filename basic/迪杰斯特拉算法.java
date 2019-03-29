package com.wjw.basic;

import java.util.Arrays;

public class 迪杰斯特拉算法 {

	static int a[][]={
			{0,10,-1,30,100},
			{-1,0,50,-1,-1},
			{-1,-1,1,-1,10},
			{-1,-1,20,1,60},
			{-1,-1,-1,-1,1}
	};
	
	static	int[] length=new int[5];
	static boolean ifOk[]= new boolean[5]; 
	//用邻接矩阵存放
	public static void main(String[] args) {
		//初始化0 的链表
		for (int i = 0; i < a[0].length; i++) {
			length[i]=a[0][i];
		}
		//循环节点次 每一次寻找一个节点
		for (int j = 0; j < a[0].length; j++) {
			int minIndex=0;
			//找最短的
			for ( int sort = 1; sort < length.length; sort++) {
				//如果节点比最小节点还小 就换位  找出可以通的 并且不是已经纳入集合的
				if (length[sort]!=-1 && !ifOk[sort] ) 
				{
					//先每次指向自己
					minIndex=sort;
					if(length[sort]<length[minIndex])
					minIndex=sort;
				}
			}
			//把最短的标记
			ifOk[minIndex]=true;
			for (int k = 1; k < length.length; k++) {
				//如果是不可到达的 或者加入短的后更短的
				if (length[k]==-1 ||(a[minIndex][k]!=-1 && length[k]>length[minIndex]+a[minIndex][k])) 
					length[k]=length[minIndex]+a[minIndex][k];
			}
		}
	System.out.println(Arrays.toString(length));
	}
}
