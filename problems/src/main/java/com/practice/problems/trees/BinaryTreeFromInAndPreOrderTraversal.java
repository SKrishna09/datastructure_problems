package com.practice.problems.trees;

import java.util.HashMap;

public class BinaryTreeFromInAndPreOrderTraversal {

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
		int[] in = { 4, 2, 5, 1, 3 };
		int[] pre = { 1, 2, 4, 5, 3 };
		TreeNode r = buildTree(in, pre);
	}

	public static TreeNode buildTree(int[] in, int[] pre) {
		processInorderMap(in);
		return buildTree(in, pre, 0, in.length - 1);
	}

	static int preIndex = 0;
	static HashMap<Integer, Integer> inOrder = new HashMap<>();

	public static TreeNode buildTree(int[] in, int[] pre, int start, int end) {
		if (start > end)
			return null;
		TreeNode node = new TreeNode(pre[preIndex++]);

		if (start == end)
			return node;

		int index = inOrder.get(node.val);

		node.left = buildTree(in, pre, start, index - 1);
		node.right = buildTree(in, pre, index + 1, end);
		return node;
	}

	public static void processInorderMap(int[] in) {
		for (int i = 0; i < in.length; i++)
			inOrder.put(in[i], i);
	}
}
