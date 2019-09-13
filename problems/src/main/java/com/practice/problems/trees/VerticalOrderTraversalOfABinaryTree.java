package com.practice.problems.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversalOfABinaryTree {

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

	public static class NodeL {
		TreeNode tree;
		Integer level;

		NodeL(TreeNode t, Integer l) {
			tree = t;
			level = l;
		}
	}

	public static void main(String[] args) {
		/*
		 * TopView of a Binary Tree: => [ [2], [3], [6 5], [7], [9] ]
		 */
		VerticalOrderTraversalOfABinaryTree tree = new VerticalOrderTraversalOfABinaryTree();
		tree.root = new TreeNode(6);
		tree.root.left = new TreeNode(3);
		tree.root.right = new TreeNode(7);
		tree.root.left.left = new TreeNode(2);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.right = new TreeNode(9);

		ArrayList<ArrayList<Integer>> vertical = new ArrayList<>();
		Map<Integer, List<Integer>> map = new TreeMap();
		verticalOrderTraversal(root, 0, map);
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			vertical.add(new ArrayList<Integer>(entry.getValue()));
		}
		System.out.println("VerticalOrder Traversal Of The Given Binary Tree Using PreOrder Traversal is:::"
				+ vertical.toString());

		ArrayList<ArrayList<Integer>> _vertical = new ArrayList<>();
		Map<Integer, List<Integer>> _map = new TreeMap();
		_verticalOrderTraversal(root, 0, _map);
		for (Map.Entry<Integer, List<Integer>> entry : _map.entrySet()) {
			_vertical.add(new ArrayList<Integer>(entry.getValue()));
		}
		System.out.println("VerticalOrder Traversal Of The Given Binary Tree Using LevelOrder Travesal is:::"
				+ _vertical.toString());
	}

	public static void verticalOrderTraversal(TreeNode A, int level, Map<Integer, List<Integer>> map) {
		if (null == A)
			return;
		LinkedList<Integer> l = (LinkedList<Integer>) map.get(level);
		if (null != l && !l.isEmpty()) {
			l = (LinkedList<Integer>) map.get(level);
			l.add(A.val);
		} else {
			l = new LinkedList<>();
			l.add(A.val);
		}
		map.put(level, l);
		verticalOrderTraversal(A.left, level - 1, map);
		verticalOrderTraversal(A.right, level + 1, map);
	}

	public static void _verticalOrderTraversal(TreeNode A, Integer level, Map<Integer, List<Integer>> map) {
		Queue<NodeL> q = new LinkedList<>();
		q.add(new NodeL(A, level));
		while (!q.isEmpty()) {
			NodeL n = q.poll();
			TreeNode t = n.tree;
			Integer currL = n.level;

			LinkedList<Integer> l = (LinkedList<Integer>) map.get(currL);
			if (null != l && !l.isEmpty()) {
				l = (LinkedList<Integer>) map.get(currL);
				l.add(t.val);
			} else {
				l = new LinkedList<>();
				l.add(t.val);
			}
			map.put(currL, l);

			if (null != t && null != t.left)
				q.add(new NodeL(t.left, currL - 1));
			if (null != t && null != t.right)
				q.add(new NodeL(t.right, currL + 1));
		}
	}
}
