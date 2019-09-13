package com.practice.problems.trees;

import java.util.ArrayList;
import java.util.List;

public class LeftViewOfABinaryTree {

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
		// LeftView of a Binary Tree: => 1,2,4,8
		LeftViewOfABinaryTree tree = new LeftViewOfABinaryTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);
		tree.root.left.left.left = new TreeNode(8);
		List<Integer> leftView = new ArrayList<>();
		leftView(root, 0, leftView);
		System.out.println("LeftView Of The Given Binary Tree is:::" + leftView.toString());
	}

	public static int maxLevel = Integer.MIN_VALUE;

	private static void leftView(TreeNode root, int level, List<Integer> leftView) {
		if (null == root)
			return;
		if (maxLevel < level) {
			maxLevel = level;
			leftView.add(root.val);
		}
		leftView(root.left, level + 1, leftView);
		leftView(root.right, level + 1, leftView);
	}
}
