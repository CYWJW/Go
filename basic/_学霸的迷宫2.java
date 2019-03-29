package com.wjw.basic;

import java.util.LinkedList;
import java.util.Scanner;

public class _学霸的迷宫2 {
	public final static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };// 分别表示向上、下、左、右移动一步
	public final static String[] onePath = { "U", "D", "L", "R" };// 分别表示向上、下、左、右行走
	private static Scanner in;

	static class point { // 内部类，用于表示当前行走到达点信息
		int x;
		int y;
		int step;
		String path;
		public point(int x, int y, int step, String path) {
			this.x = x;
			this.y = y;
			this.step = step;
			this.path = path;
		}
		@Override
		public String toString() {
			return "point [x=" + x + ", y=" + y + ", step=" + step + ", path=" + path + "]";
		}
		
	}

	// 判断当前位置是否是可行走的位置，如不能返回false，否则返回true

	// 依据字典序{D,L,R,U}，比较字符串A和B的大小，如果A > B返回true，否则返回false(PS:两者字符个数相同)
	public static boolean judge(String A, String B) {
		char[] arrayA = A.toCharArray();
		char[] arrayB = B.toCharArray();
		for (int i = 0, len = A.length(); i < len; i++) {
			if (arrayA[i] < arrayB[i])
				return false;
		}
		return true;
	}

	// 把输入数据，变换为矩阵
	public static int[][] getMatrix(String[] A, int m) {
		int[][] matrix = new int[A.length + 1][m + 1];
		for (int i = 0; i < A.length; i++) {
			char[] charArray = A[i].toCharArray();
			for (int j = 0; j < m; j++) {
				matrix[i+1][j+1]=charArray[j]-'0';
			}
		}
		return matrix;
	}
	/**
	 * 
	 * @param A
	 * @param m 列
	 */
	public static void bfs(String[] A, int m) {
		//转化为数组
		int[][] matrix = getMatrix(A, m);
		//存步数队列
		LinkedList<point> list = new LinkedList<>();
		//进行广搜索 当前节点为1，1
		list.add(new point(1, 1, 0,""));
		matrix[1][1]=1;
		//记录最小的节点
		point min=new point(0, 0, Integer.MAX_VALUE, "");
		//进行遍历
		while (!list.isEmpty()) {
			//获取队头元素
			point point = list.removeFirst();
			//判断是否时最终节点
			if(point.x==matrix.length-1 && point.y==m)
			{
				//保存最小节点
				if(point.step<min.step)
				{
					min=point;
				}
				//保存最小字母
				else if (point.step==min.step && judge(point.path, min.path)) {
					min=point;
				}
				continue;
			}
			//进行下一步节点搜索
			for (int i = 0; i < 4; i++) {
				int x=point.x;
				int y=point.y;
				//上下左右
				x+=move[i][0];
				y+=move[i][1];
				if(check(x,y,matrix))
				{
					//新节点记录之前的步数
					point newPoint = new point(x, y, point.step+1, point.path+onePath[i]);
					list.addLast(newPoint);
					//因为广度 最先到的时最近的节点
					matrix[x][y]=1;
				}
			}
		}
		System.out.println(min.step);
		System.out.println(min.path);
	}
	//判断当前点是否可以走
	private static boolean check(int x, int y,int a[][]) {
		//判断越界或者走过
		if(x<1 || x>a.length-1 || y<1 || y>a[0].length-1 || a[x][y]==1) return false;
		return true;
	}

	public static void main(String[] args) {
		in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		in.nextLine(); // 此处特别注意，输入完整数，下面接着输出字符串，此处处理换行操作
		String[] A = new String[n];
		for (int i = 0; i < n; i++)
			A[i] = in.nextLine();
		//三行
		bfs(A, m);
	}
}
