package com.wjw.lintcode.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

	// @return true if this NestedInteger holds a single integer,
	// rather than a nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds,
	// if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds,
	// if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}

/**
 * 
 * @author 汪军伍
 *
 */
public class _平面列表 {
	class Node {
		List<NestedInteger> list;
		Integer index;
	}
	

	public List<Integer> flatten(List<NestedInteger> nestedList) {
		// Write your code here
		List<Integer> list = new ArrayList<>();
		Stack<Node> stack = new Stack<>();
		List<NestedInteger> cur = nestedList;
		for (int i = 0; i <= cur.size(); i++) {
			// 如果当前满了 出栈
			if (i == cur.size() && !stack.isEmpty()) {
				Node pop = stack.pop();
				i = pop.index;
				cur = pop.list;
			} else if (i != cur.size() && cur.get(i).isInteger())
				list.add(cur.get(i).getInteger());
			else if (i != cur.size()) {
				// 压栈
				Node node = new Node();
				node.index = i;
				node.list = cur;
				stack.push(node);
				cur = cur.get(i).getList();
				i = -1;
			}
		}

		return list;
	}

	// 递归
	private void addList(List<NestedInteger> nestedList, List<Integer> list) {
		// 如果这一层当前是整数
		for (int i = 0; i < nestedList.size(); i++) {
			if (nestedList.get(i).isInteger()) {
				list.add(nestedList.get(i).getInteger());
			}
			// 交给下一层
			else
				addList(nestedList.get(i).getList(), list);
		}
	}
}
