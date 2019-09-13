package com.practice.problems.trees;

public class IsBalancedBinaryTree {

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
		IsBalancedBinaryTree tree = new IsBalancedBinaryTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);
		boolean isBalanced = isBalanced(root);
		if (isBalanced)
			System.out.println("Balanced Binary Tree");
		else
			System.out.println("NOT Balanced Binary Tree");
	}

	public static boolean isBalanced(TreeNode A) {
		if (null == A)
			return true;

		int lh = height(A.left);
		int rh = height(A.right);

		if (Math.abs(lh - rh) <= 1 && isBalanced(A.left) && isBalanced(A.right))
			return true;

		return false;
	}

	public static int height(TreeNode A) {
		if (null == A)
			return 0;
		return 1 + Math.max(height(A.left), height(A.right));
	}
}
