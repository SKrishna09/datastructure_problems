package com.practice.problems.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

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
		LevelOrderTraversal tree = new LevelOrderTraversal();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);
		List<Integer> levelOrder = levelOrderTraversal(root);
		System.out.println("LevelOrder Traversal Of The Given Tree is:::" + levelOrder.toString());
	}

	private static List<Integer> levelOrderTraversal(TreeNode root) {
		List<Integer> levelOrder = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			levelOrder.add(node.val);

			if (null != node.left)
				q.add(node.left);

			if (null != node.right)
				q.add(node.right);
		}
		return levelOrder;
	}
}
