package com.practice.problems.trees.bst;

import java.util.LinkedList;
import java.util.Queue;

public class DifferenceBetweenOddAndEvenLevels {

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
		DifferenceBetweenOddAndEvenLevels tree = new DifferenceBetweenOddAndEvenLevels();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);
		tree.root.left.left.left = new TreeNode(8);
		int diff = differenceBetweenOddAndEvenLevels(root);
		System.out.println("DifferenceBetweenOddAndEvenLevel Nodes:::" + diff);
	}

	public static int differenceBetweenOddAndEvenLevels(TreeNode A) {
		int oddLevelSum = 0;
		int evenLevelSum = 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(A);
		q.add(null);

		boolean odd = true;
		while (!q.isEmpty()) {
			TreeNode t = q.poll();
			if (null != t) {
				if (odd)
					oddLevelSum += t.val;
				else
					evenLevelSum += t.val;
			} else {
				odd = !odd;
				if (!q.isEmpty())
					q.add(null);
			}

			if (null != t && null != t.left)
				q.add(t.left);
			if (null != t && null != t.right)
				q.add(t.right);
		}
		System.out.println("Sum of nodes at odd level:" + oddLevelSum);
		System.out.println("Sum of ndoes at even level:" + evenLevelSum);
		return (oddLevelSum - evenLevelSum);
	}
}
