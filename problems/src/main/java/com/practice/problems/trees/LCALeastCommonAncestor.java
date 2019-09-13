package com.practice.problems.trees;

public class LCALeastCommonAncestor {

	public static TreeNode root;

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) {
		LCALeastCommonAncestor tree = new LCALeastCommonAncestor();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);
		TreeNode lca = lca(root, 4, 5);
		System.out.println("LCA for 4 and 5 is::" + lca.val);
	}

	public static TreeNode lca(TreeNode root, int n1, int n2) {
		if (null == root)
			return null;

		if (root.val == n1 || root.val == n2)
			return root;

		TreeNode left = lca(root.left, n1, n2);
		TreeNode right = lca(root.right, n1, n2);

		if (null != left && null != right)
			return root;

		if (null == left)
			return right;
		else
			return left;
	}
}
