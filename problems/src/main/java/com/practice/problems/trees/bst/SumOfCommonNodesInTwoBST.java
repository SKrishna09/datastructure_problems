package com.practice.problems.trees.bst;

import java.util.Stack;

public class SumOfCommonNodesInTwoBST {

	public static TreeNode root1;
	public static TreeNode root2;

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
		SumOfCommonNodesInTwoBST tree1 = new SumOfCommonNodesInTwoBST();
		tree1.root1 = new TreeNode(5);
		tree1.root1.left = new TreeNode(1);
		tree1.root1.right = new TreeNode(10);
		tree1.root1.left.left = new TreeNode(0);
		tree1.root1.left.right = new TreeNode(4);
		tree1.root1.right.left = new TreeNode(7);
		tree1.root1.right.left.right = new TreeNode(9);

		SumOfCommonNodesInTwoBST tree2 = new SumOfCommonNodesInTwoBST();
		tree2.root2 = new TreeNode(10);
		tree2.root2.left = new TreeNode(7);
		tree2.root2.right = new TreeNode(20);
		tree2.root2.left.left = new TreeNode(4);
		tree2.root2.left.right = new TreeNode(9);

		int sum = sumOfCommonNodesInBST(root1, root2);
		System.out.println("SumOfCommonNodesInTwoBST::" + sum);
	}

	private static int sumOfCommonNodesInBST(TreeNode root1, TreeNode root2) {
		int sum = 0;
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();

		while (true) {
			if (null != root1) {
				s1.push(root1);
				root1 = root1.left;
			} else if (null != root2) {
				s2.push(root2);
				root2 = root2.left;
			} else if (!s1.isEmpty() && !s2.isEmpty()) {
				root1 = s1.peek();
				root2 = s2.peek();

				if (root1.val < root2.val) {
					s1.pop();
					root1 = root1.right;
					root2 = null;
				} else if (root1.val > root2.val) {
					s2.pop();
					root2 = root2.right;
					root1 = null;
				} else {
					sum += root1.val;
					s1.pop();
					s2.pop();
					root1 = root1.right;
					root2 = root2.right;
				}
			} else {
				break;
			}
		}
		return sum;
	}
}
