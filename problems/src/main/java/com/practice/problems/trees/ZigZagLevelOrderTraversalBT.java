package com.practice.problems.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ZigZagLevelOrderTraversalBT {

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
		ZigZagLevelOrderTraversalBT tree = new ZigZagLevelOrderTraversalBT();
		tree.root = new TreeNode(3);
		tree.root.left = new TreeNode(9);
		tree.root.left.left = new TreeNode(10);
		tree.root.left.right = new TreeNode(11);
		tree.root.right = new TreeNode(20);
		tree.root.right.left = new TreeNode(15);
		tree.root.right.right = new TreeNode(7);
		
		List<List<Integer>> inOrder = zigzagLevelOrder(root);
		System.out.println("InOrder Traversal Of The Given Tree is:::" + inOrder.toString());
	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode A) {
		List<List<Integer>> result = new ArrayList<>();

		Stack<TreeNode> currentLevel = new Stack();
		Stack<TreeNode> nextLevel = new Stack<>();
		boolean rightToLeft = true;
		currentLevel.add(A);

		ArrayList<Integer> level = new ArrayList<>();
		while (!currentLevel.isEmpty()) {
			TreeNode node = currentLevel.pop();
			level.add(node.val);

			if (rightToLeft) {
				if (null != node.left)
					nextLevel.add(node.left);
				if (null != node.right)
					nextLevel.add(node.right);
			} else {
				if (null != node.right)
					nextLevel.add(node.right);
				if (null != node.left)
					nextLevel.add(node.left);
			}
			if (currentLevel.isEmpty()) {
				result.add(level);
				Stack<TreeNode> temp = new Stack<>();
				temp = nextLevel;
				nextLevel = currentLevel;
				currentLevel = temp;
				rightToLeft = !rightToLeft;
				level = new ArrayList<>();
			}
		}
		return result;
	}
}
