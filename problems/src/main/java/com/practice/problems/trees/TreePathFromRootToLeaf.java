package com.practice.problems.trees;

import java.util.ArrayList;
import java.util.LinkedList;

public class TreePathFromRootToLeaf {

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
		TreePathFromRootToLeaf tree = new TreePathFromRootToLeaf();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		LinkedList<Integer> sub = new LinkedList<>();
		preOrder(root, sub, ans);
		System.out.println("TreePathFromRootToLeaf::" + ans.toString());

	}

	public static void preOrder(TreeNode node, LinkedList<Integer> sub, ArrayList<ArrayList<Integer>> ans) {
		if (null == node)
			return;
		sub.addLast(node.val);
		if (null == node.left && null == node.right) {
			ans.add(new ArrayList<>(sub));
		}
		preOrder(node.left, sub, ans);
		preOrder(node.right, sub, ans);
		sub.removeLast();
	}
}
