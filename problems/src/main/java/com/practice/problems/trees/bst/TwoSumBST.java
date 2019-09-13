package com.practice.problems.trees.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.practice.problems.trees.PreOrderTraversal.TreeNode;

public class TwoSumBST {

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
		TwoSumBST tree = new TwoSumBST();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		// twoSumBST(root,9);
		LinkedList<Integer> preOrder = new LinkedList<>();
		inorderTraversal(root, preOrder);
	}

	private static void twoSumBST(TreeNode A, Integer B) {
		Stack<TreeNode> s = new Stack<>();

		while (true) {
			if (null != A) {
				s.push(A);
				A = A.left;
			} else if (!s.isEmpty()) {
				A = s.peek();
				Integer remain = B - A.val;

				if (remain < A.val) {
					A = s.pop();
					A = A.right;
				} else if (remain > A.val) {
					A = A.right;
				} else {
					System.out.println(A.val + " " + remain);
					s.pop();
					A = A.right;
					break;
				}
			} else {
				break;
			}
		}
	}

	public static void inorderTraversal(TreeNode A, LinkedList<Integer> preOrder) {
		if (null == A)
			return;
		preOrder.addLast(A.val);
		if (null == A.left && null == A.right) {
			System.out.println(preOrder.toString());
		}
		inorderTraversal(A.left, preOrder);
		inorderTraversal(A.right, preOrder);
		preOrder.removeLast();

	}
}
