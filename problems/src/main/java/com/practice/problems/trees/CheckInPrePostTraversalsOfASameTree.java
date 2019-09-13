package com.practice.problems.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class CheckInPrePostTraversalsOfASameTree {

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
		int[] in = { 33, 23, 44, 61, 71, 88, 50, 99, 13, 12, 82, 58 };
		int[] post = { 61, 44, 23, 12, 33, 71, 50, 99, 13, 82, 88, 58 };
		int[] pre = { 13, 12, 61, 44, 23, 33, 82, 99, 71, 58, 88, 50 };
		TreeNode r = buildTree(in, post);
		List<Integer> preOrder = preOrderTraversal(r);
		if (Arrays.toString(pre).equalsIgnoreCase(preOrder.toString()))
			System.out.println("All traversals are from same tree");
		else
			System.out.println("All traversals are from different tree");
	}

	public static List<Integer> preOrderTraversal(TreeNode node) {
		List<Integer> preOrder = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<>();
		TreeNode a = node;
		s.push(a);
		while (!s.isEmpty()) {
			a = s.pop();
			preOrder.add(a.val);

			if (null != a.right)
				s.push(a.right);
			if (null != a.left)
				s.push(a.left);
		}
		return preOrder;
	}

	static int postIndex;
	static HashMap<Integer, Integer> inOrder = new HashMap<>();

	private static TreeNode buildTree(int[] in, int[] post) {
		postIndex = post.length - 1;
		processInOrderMap(in);
		return buildTree(in, post, 0, in.length - 1);
	}

	private static TreeNode buildTree(int[] in, int[] post, int start, int end) {
		if (start > end || postIndex < 0)
			return null;
		TreeNode node = new TreeNode(post[postIndex]);
		postIndex--;

		if (start == end)
			return node;

		int index = inOrder.get(node.val);

		node.right = buildTree(in, post, index + 1, end);
		node.left = buildTree(in, post, start, index - 1);

		return node;
	}

	public static void processInOrderMap(int[] in) {
		for (int i = 0; i < in.length; i++)
			inOrder.put(in[i], i);
	}
}
