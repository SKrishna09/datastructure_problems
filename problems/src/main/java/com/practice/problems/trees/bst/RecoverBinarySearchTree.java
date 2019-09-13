package com.practice.problems.trees.bst;

import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree {

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
		RecoverBinarySearchTree tree = new RecoverBinarySearchTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		List<Integer> nodes = recoverTree(root);
		System.out.println("Recover Nodes:::" + nodes.toString());
	}

	public static ArrayList<Integer> recoverTree(TreeNode A) {
		ArrayList<Integer> recover = new ArrayList<>();
		ArrayList<Integer> inorder = new ArrayList<>();
		inOrder(A, inorder);

		Integer first = null;
		Integer mid = null;
		Integer last = null;
		Integer prev = null;

		for (Integer curr : inorder) {
			if (null == prev)
				prev = curr;
			if (curr < prev) {
				if (null == first) {
					first = prev;
					mid = curr;
				}
				if (null == last) {
					last = curr;
				}
			}
		}
		if (null != last)
			recover.add(last);
		else
			recover.add(mid);
		recover.add(first);

		return recover;
	}

	public static void inOrder(TreeNode A, ArrayList<Integer> inOrder) {
		if (null == A)
			return;
		inOrder(A.left, inOrder);
		inOrder.add(A.val);

		inOrder(A.right, inOrder);
	}
}
