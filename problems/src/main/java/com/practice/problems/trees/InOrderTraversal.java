package com.practice.problems.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {

	//Using recursion is not allowed
	
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
		// InOrder Traversal: LEFT - ROOT - RIGHT => 4,2,5,1,3
		InOrderTraversal tree = new InOrderTraversal();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		List<Integer> inOrder = inorderTraversal(root);
		System.out.println("InOrder Traversal Of The Given Tree is:::" + inOrder.toString());
	}

	public static List<Integer> inorderTraversal(TreeNode A) {
		ArrayList<Integer> inOrder = new ArrayList<>();
		Stack<TreeNode> s = new Stack<>();
		TreeNode curr = A;
		while (null != curr || !s.isEmpty()) {
			while (null != curr) {
				s.push(curr);
				curr = curr.left;
			}
			curr = s.pop();
			inOrder.add(curr.val);
			curr = curr.right;
		}
		return inOrder;
	}
}
