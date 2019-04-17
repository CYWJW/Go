package com.wjw.basic01;

import java.util.Stack;

public class _网易烽火问题 {
	static class node {
		int num;
		int index;
		int value;

		public node(int num, int index, int value) {
			this.num = num;
			this.index = index;
			this.value = value;
		}
	}

	public static void main(String[] args) {

		int a[] = { 1, 5, 8, 6, 5 };
		// 找第一个最大下标
		int maxIndex = getMaxIndex(a);
		// 从最大下标开始找两边最大值
		int count = getCount(a, maxIndex);
		System.out.println(count);
	}

	private static int getCount(int[] a, int maxIndex) {
		if (a == null || a.length < 2)
			return 0;
		// 记录总数
		int count = 0;
		Stack<node> stack = new Stack<>();
		stack.push(new node(1, maxIndex, a[maxIndex]));
		// 获取开始比较下标
		int i = getNext(maxIndex, a);
		while (i != maxIndex) {
			// 如果栈不为空 并且栈顶是大于此的就出栈
			while (!stack.isEmpty() && a[i] > stack.peek().value) {
				node pop = stack.pop();
				// 获取数量
				count += getNum(pop, 2);
			}
			// 如果栈不为空 并且 栈顶的值相等的情况下
			if (!stack.isEmpty() && a[i] == stack.peek().value) {
				stack.peek().num++;
			} else {
				stack.push(new node(1, i, a[i]));
			}
			i = getNext(i, a);
		}
		while (!stack.isEmpty()) {
			node pop = stack.pop();
			//如果不是最后两个个
			if ( stack.size()>1||(stack.size()==1 && stack.peek().num>1 )) {
				count += getNum(pop,2);
			} else if(stack.size()==1 && stack.peek().num==1 ){
				count += getNum(pop,1);
			}
			else {
				count+=getNum(pop, 0);
			}
		}

		return count;
	}
	/**
	 * 
	 * @param pop
	 * @param num 相邻有几个数
	 * @return
	 */
	private static int getNum(node pop, int n) {
		int num = pop.num;
		return num * (num - 1) / 2 + num * n;
	}



	// 判断是否循环
	private static int getNext(int index, int a[]) {
		return ++index >= a.length ? 0 : index;
	}

	private static int getMaxIndex(int[] a) {
		if (a == null || a.length == 0)
			return -1;
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[max] < a[i])
				max = i;
		}
		return max;
	}
}