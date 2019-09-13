package com.practice.problems.trees;

import java.util.ArrayList;
import java.util.List;

public class RightViewOfABinaryTree {

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
		// RihtView of a Binary Tree: => 1,3,7,8
		RightViewOfABinaryTree tree = new RightViewOfABinaryTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);
		tree.root.left.left.left = new TreeNode(8);
		List<Integer> rightView = new ArrayList<>();
		rightView(root, 0, rightView);
		System.out.println("RightView Of The Given Binary Tree is:::" + rightView.toString());
	}

	public static int maxLevel = Integer.MIN_VALUE;

	private static void rightView(TreeNode root, int level, List<Integer> rightView) {
		if (null == root)
			return;
		if (maxLevel < level) {
			maxLevel = level;
			rightView.add(root.val);
		}
		rightView(root.right, level + 1, rightView);
		rightView(root.left, level + 1, rightView);
	}
}
