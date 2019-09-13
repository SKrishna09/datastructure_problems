package com.practice.problems.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalLevelWise {

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
		// LevelOrder Traversal: => 1,2,3,4,5,6,7
		LevelOrderTraversalLevelWise tree = new LevelOrderTraversalLevelWise();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);
		List<List<Integer>> levelOrder = levelOrderTraversalLevelWise(root);
		System.out.println("LevelOrder Traversal(Level Wise)Of The Given Tree is:::" + levelOrder.toString());
	}

	private static List<List<Integer>> levelOrderTraversalLevelWise(TreeNode root) {
		List<List<Integer>> levelOrder = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		List<Integer> qlevel = new ArrayList<>();
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (null != node) {
				qlevel.add(node.val);
			} else {
				levelOrder.add(qlevel);
				qlevel = new ArrayList<>();
				if (!q.isEmpty())
					q.add(null);
			}

			if (null != node && null != node.left)
				q.add(node.left);

			if (null != node && null != node.right)
				q.add(node.right);
		}
		return levelOrder;
	}
}
