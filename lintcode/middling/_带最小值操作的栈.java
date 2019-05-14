package com.wjw.lintcode.middling;

public class _带最小值操作的栈 {
	public static void main(String[] args) {
		_带最小值操作的栈 stak = new _带最小值操作的栈();
		stak.push(1);
		int value = stak.pop();
		System.out.println(value);
		stak.push(2);
		stak.push(3);
		value = stak.min();
		System.out.println(value);
		stak.push(1);
		value = stak.min();
		System.out.println(value);
	}
	
	int  stack[]=new int[1024];
	int  min[]=new int[1024];
	//栈顶指针
	int pop=-1;
	//栈的长度
	int size=0;
	//最小栈顶指针
	int minPop=-1;
	//最小栈的长度
	int minSize=0;
	public void push(int number) {
		//压栈
		stack[++pop]=number;
		size++;
		//压最小
		if (minSize==0 || min[minPop] >= number ) {
			min[++minPop]=number;
			minSize++;
		}
	}

	
	public int pop() {
		// write your code here
		//if(size==0) return 
		int value=stack[pop--];
		size--;
		//最小出栈
		if(value==min[minPop])
		{
			minPop--;
			minSize--;
		}
		return value;
	}

	
	public int min() {
		return min[minPop];
	}
}
