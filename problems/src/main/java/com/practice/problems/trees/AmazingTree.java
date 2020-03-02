package com.practice.problems.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AmazingTree {
	
	/*Amazing Tree
	Given a binary tree with root node pointer A and an integer B.
	A number S is lost in the tree but you somehow find how to restore it.
	S is formed by concatenating all the node values from left to right at level B.
	Find and return the number S. If there are no nodes at level B then return an empty string.
			Input 1:

			       1
			      / \
			     2   3
			    / \  \
			   3   4  5

			   B = 1

			Output 1:
			    "23"
			    Explanation 1:
			        Nodes at level 1: 2 and 3

			Input 2:

			       7
			      / \
			     2   3
			    / \  \
			   0   1  0

			   B = 2

			Output 1:
			    "010"
			    Explanation 1:
			        Nodes at level 1: 0, 1,and 0    */		

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
