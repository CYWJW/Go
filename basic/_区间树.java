package com.wjw.basic;

public class _区间树 {
	static int a[] = { 1, 8, 9, 3, 4, 6, 4, 60, 8, 6 };

	static class TreeNode {
		// 区间和 左右边界
		int sum, l, r;
		// 左区间
		TreeNode lnode;
		// 右区间
		TreeNode rnode;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		genderNode(root, 0, a.length - 1);
		int sum = qureSum(root, 5, 7);
		System.out.println(sum);
	}

	// 前序
	static void preNode(TreeNode root) {
		if (root == null)
			return;

		System.out.println(root.sum + " "+ root.l+" "+root.r);
		// 遍历左子树
		preNode(root.lnode);
		preNode(root.rnode);
	}

	/**
	 * 查询区间树
	 * 
	 * @param root
	 * @param l左边界
	 * @param r右边界
	 * @return
	 */
	static int qureSum(TreeNode treeNode, int l, int r) {
		//如果区间在这之中就返回
		if (l<=treeNode.l && r>=treeNode.r) {
			return treeNode.sum;
		}
		int sum=0;
		//进行左边界右边界的判定
		int mid=(treeNode.l+treeNode.r)>>1;
		//进入左子树
		if(l<=mid) sum+=qureSum(treeNode.lnode, l, r);
		//如果右边界在它之内 进入
		if(r>mid) sum+=qureSum(treeNode.rnode, l, r);
		return sum;
	}

	/**
	 * 
	 * @param l左区间
	 * @param r右区间
	 * @return
	 */
	public static int genderNode(TreeNode node, int l, int r) {
		if (l == r) {
			node.sum = a[l];
			node.l=l;
			node.r=r;
			return a[l];
		}
		// 创建分界点
		int mid = (l + r) >> 1;
		TreeNode ltree = new TreeNode();
		TreeNode rtree = new TreeNode();
		// 建立左子树 并传入节点
		int lsum = genderNode(ltree, l, mid);
		int rsum = genderNode(rtree, mid + 1, r);
		// 建立现在节点
		node.sum = lsum + rsum;
		// 建立关系
		node.lnode = ltree;
		node.rnode = rtree;
		node.l=l;
		node.r=r;
		return node.sum;
	}
}
