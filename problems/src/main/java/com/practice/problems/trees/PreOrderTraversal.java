package com.practice.problems.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {

	// Using recursion is not allowed

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
		// PreOrder Traversal: ROOT - LEFT - RIGHT => 1,2,4,5,3
		PreOrderTraversal tree = new PreOrderTraversal();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		List<Integer> inOrder = preOrderTraversal(root);
		System.out.println("PreOrder Traversal Of The Given Tree is:::" + inOrder.toString());
	}

	public static List<Integer> preOrderTraversal(TreeNode A) {
		ArrayList<Integer> preOrder = new ArrayList<>();
		Stack<TreeNode> s = new Stack<>();
		TreeNode curr = A;
		s.push(curr);
		while (!s.isEmpty()) {
			curr = s.pop();
			preOrder.add(curr.val);
			if (null != curr.right) {
				s.push(curr.right);
			}
			if (null != curr.left)
				s.push(curr.left);
		}
		return preOrder;
	}

}
