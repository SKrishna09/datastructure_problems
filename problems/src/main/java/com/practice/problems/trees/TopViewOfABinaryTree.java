package com.practice.problems.trees;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.practice.problems.trees.VerticalOrderTraversalOfABinaryTree.NodeL;

public class TopViewOfABinaryTree {

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

		public static void main(String[] args) {
			// TopView of a Binary Tree: => 1,2,4,8,3,7
			TopViewOfABinaryTree tree = new TopViewOfABinaryTree();
			tree.root = new TreeNode(1);
			tree.root.left = new TreeNode(2);
			tree.root.right = new TreeNode(3);
			tree.root.left.left = new TreeNode(4);
			tree.root.left.right = new TreeNode(5);
			tree.root.right.left = new TreeNode(6);
			tree.root.right.right = new TreeNode(7);
			tree.root.left.left.left = new TreeNode(8);
			List<Integer> topView = topViewOfATree(root);
			System.out.println("TopView Of The Given Binary Tree is:::" + topView.toString());
		}

		private static List<Integer> topViewOfATree(TreeNode A) {
			ArrayList<Integer> topView = new ArrayList<>();
			Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
			topView(A, 0, map);
			for (Map.Entry<Integer, Integer> itr : map.entrySet()) {
				topView.add(itr.getValue());
			}
			return topView;
		}

		public static void topView(TreeNode A, Integer level, Map<Integer, Integer> map) {
			Queue<NodeL> q = new LinkedList<>();
			q.add(new NodeL(A, level));

			while (!q.isEmpty()) {
				NodeL node = q.poll();
				TreeNode t = node.tree;
				Integer l = node.level;

				if (null != t) {
					if (!map.containsKey(l))
						map.put(l, t.val);

					if (null != t.left)
						q.add(new NodeL(t.left, l - 1));
					if (null != t.right)
						q.add(new NodeL(t.right, l + 1));
				}
			}
		}
	}
}
