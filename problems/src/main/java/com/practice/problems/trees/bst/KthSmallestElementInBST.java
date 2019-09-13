package com.practice.problems.trees.bst;

import java.util.Stack;

public class KthSmallestElementInBST {

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
		KthSmallestElementInBST tree = new KthSmallestElementInBST();
		tree.root = new TreeNode(3);
		tree.root.right = new TreeNode(4);
		int val = kthsmallest(root, 2);
		System.out.println("KthSmallestElementInBST::"+val);
	}

	public static int kthsmallest(TreeNode A, int B) {
		Stack<TreeNode> s = new Stack<>();
		TreeNode curr = A;
		int val = 0;
		while (null != curr || !s.isEmpty()) {
			while (null != curr) {
				s.push(curr);
				curr = curr.left;
			}
			curr = s.pop();
			val = curr.val;
			if (B == 1) {
				break;
			} else {
				B = B - 1;
			}
			curr = curr.right;
		}
		return val;
	}

}
