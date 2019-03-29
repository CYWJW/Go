package com.wjw.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 生命之树 {
	static	int  max;
	static int core[];
	 //构建链表
	static List<Integer> a [];
	public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    //节点数
    int nodeNums=scanner.nextInt();
    core=new int[nodeNums+1];
    //取分数
    for (int i = 1; i < nodeNums+1; i++) {
		core[i]=scanner.nextInt();
	}
    a=new ArrayList [nodeNums+1];
    for (int i = 1; i <=nodeNums; i++) {
		a[i]=new ArrayList<>();
	}
    
    //邻接链表
    for (int i = 0; i < nodeNums-1; i++) {
    	int x=scanner.nextInt();
    	int y=scanner.nextInt();
		a[x].add(y);
		a[y].add(x);
	}
    
    //进行遍历
    dfs(1,0);
    System.out.println(max);
  }

	/**
	 * 
	 * @param root 当前节点
	 * @param father 父节点  用于判断不走重复
	 */
	private static void dfs(int root, int father) {
		//遍历子节点
		for (int i = 0; i < a[root].size(); i++) {
			//子节点
			Integer son = a[root].get(i);
			//如果这是通往父节点得直接跳过
			if(son==father) continue;
			dfs(son, root);
			//每一个节点的总分为子节点相加 如果是负数我就不加
			if(core[son]>0)
				core[root]+=core[son];
		}
		//记录最大值
		if(core[root]>max) max=core[root];
		
	}

}
