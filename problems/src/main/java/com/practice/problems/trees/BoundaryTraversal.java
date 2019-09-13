package com.practice.problems.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BoundaryTraversal {

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
		BoundaryTraversal tree = new BoundaryTraversal();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);

		Set<Integer> ans = new LinkedHashSet<>();

		List<Integer> left = new ArrayList<>();
		leftNodes(root, 0, left);
		ans.addAll(left);

		List<Integer> leaf = new ArrayList<>();
		leafNodes(root, leaf);
		ans.addAll(leaf);

		List<Integer> right = new ArrayList<>();
		rightNodes(root, 0, right);
		Collections.reverse(right);
		ans.addAll(right);
		System.out.println(new ArrayList<>(ans).toString());
	}

	static Integer leftLevel = Integer.MIN_VALUE;

	public static void leftNodes(TreeNode node, int currLevel, List<Integer> left) {
		if (null == node)
			return;
		if (leftLevel < currLevel) {
			left.add(node.val);
			leftLevel = currLevel;
		}
		leftNodes(node.left, currLevel + 1, left);
		leftNodes(node.right, currLevel + 1, left);
	}

	public static void leafNodes(TreeNode root, List<Integer> leaf) {
		if (root == null)
			return;

		leafNodes(root.left, leaf);
		if (root.left == null && root.right == null)
			leaf.add(root.val);
		leafNodes(root.right, leaf);
	}

	static Integer rightLevel = Integer.MIN_VALUE;

	public static void rightNodes(TreeNode node, int currLevel, List<Integer> right) {
		if (null == node)
			return;
		if (rightLevel < currLevel) {
			right.add(node.val);
			rightLevel = currLevel;
		}
		rightNodes(node.right, currLevel + 1, right);
		rightNodes(node.left, currLevel + 1, right);
	}
}
