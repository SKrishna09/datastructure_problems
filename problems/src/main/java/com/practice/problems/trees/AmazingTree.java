package com.practice.problems.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AmazingTree {

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
		// B = 1 => 23
		AmazingTree tree = new AmazingTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(3);
		tree.root.left.right = new TreeNode(4);
		tree.root.right.left = new TreeNode(5);
		String amazing = amazingTree(root, 1);
		System.out.println("Amazing number is:::" + amazing);
	}

	public static String amazingTree(TreeNode A, int B) {
		List<String> levelOrder = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(A);
		q.add(null);

		String qlevel = new String();
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (null != node) {
				qlevel += node.val;
			} else {
				levelOrder.add(qlevel);
				qlevel = new String();
				if (!q.isEmpty())
					q.add(null);
			}

			if (null != node && null != node.left)
				q.add(node.left);

			if (null != node && null != node.right)
				q.add(node.right);
		}

		int i = 0;
		for (String l : levelOrder) {
			if (i == B)
				return l;
			i++;
		}
		return new String();
	}
}
