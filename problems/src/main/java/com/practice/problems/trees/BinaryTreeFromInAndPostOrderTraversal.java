package com.practice.problems.trees;

import java.util.HashMap;

public class BinaryTreeFromInAndPostOrderTraversal {
	
	/*Binary Tree From Inorder And Postorder
	Given inorder and postorder traversal of a tree, construct the binary tree.
	You may assume that duplicates do not exist in the tree. 
	Input : 
        Inorder : [2, 1, 3]
        Postorder : [2, 3, 1]

        Return : 
            1
           / \
          2   3*/

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
		int[] post = { 4, 5, 2, 3, 1 };
		TreeNode r = buildTree(in, post);
		System.out.println(r);
	}

	static int postIndex;
	static HashMap<Integer, Integer> inOrder = new HashMap<>();

	private static TreeNode buildTree(int[] in, int[] post) {
		postIndex = post.length - 1;
		processInOrderMap(in);
		return buildTree(in, post, 0, in.length - 1);
	}

	private static TreeNode buildTree(int[] in, int[] post, int start, int end) {
		if (start > end)
			return null;
		TreeNode node = new TreeNode(post[postIndex--]);

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
