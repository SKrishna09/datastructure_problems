package com.practice.problems.trees;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceBetweenNodes {

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
		DistanceBetweenNodes tree = new DistanceBetweenNodes();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);
		TreeNode lca = lca(root, 4, 5);
		System.out.println("LCA for 4 and 5 is::" + lca.val);
		int distance = levelOrderTraversal(root, 4, 5, lca.val);
		System.out.println("And distance between the node is::" + distance);
	}

	public static TreeNode lca(TreeNode A, int B, int C) {
		if (null == A)
			return null;
		if (A.val == B || A.val == C)
			return A;
		TreeNode left = lca(A.left, B, C);
		TreeNode right = lca(A.right, B, C);
		if (null != left && null != right) {
			return A;
		}
		if (null != left)
			return left;
		else
			return right;
	}

	public static int levelOrderTraversal(TreeNode root, int B, int C, int lca) {
		int rootLevel = 0;
		int Blevel = 0;
		int Clevel = 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		int level = 0;
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (null == node) {
				level++;
				if (!q.isEmpty())
					q.add(null);
			} else {
				if (node.val == lca)
					rootLevel = level;
				if (node.val == B)
					Blevel = level;
				if (node.val == C)
					Clevel = level;
				if (null != node.left)
					q.add(node.left);
				if (null != node.right)
					q.add(node.right);
			}
		}
		return (Blevel - rootLevel) + (Clevel - rootLevel);
	}

}