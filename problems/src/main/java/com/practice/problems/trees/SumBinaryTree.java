package com.practice.problems.trees;

public class SumBinaryTree {

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
		SumBinaryTree tree = new SumBinaryTree();
		tree.root = new TreeNode(26);
		tree.root.left = new TreeNode(10);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(6);
		tree.root.right.right = new TreeNode(4);
		boolean isSumtree = isSumBinayTree(root);
		if (isSumtree)
			System.out.println("SUM Binary Tree");
		else
			System.out.println("NOT SUM Binary Tree");
	}

	private static boolean isSumBinayTree(TreeNode root) {
		if (null == root)
			return true;

		int ls = sum(root.left);
		int rs = sum(root.right);

		if ((root.val == (ls + rs) || (ls == 0 && rs == 0)) && isSumBinayTree(root.left) && isSumBinayTree(root.right))
			return true;
		return false;
	}

	private static int sum(TreeNode root) {
		if (null == root)
			return 0;
		return root.val + sum(root.left) + sum(root.right);
	}
}
