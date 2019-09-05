package com.practice.problems.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {

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
		// PostOrder Traversal: LEFT - RIGHT - ROOT => 4,5,2,6,7,3,1
		PostOrderTraversal tree = new PostOrderTraversal();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);
		List<Integer> inOrder = postorderTraversal(root);
		System.out.println("InOrder Traversal Of The Given Tree is:::" + inOrder.toString());
	}

	public static List<Integer> postorderTraversal(TreeNode A) {
		List<Integer> postOrder = new ArrayList<>();
		Stack<TreeNode> s = new Stack<>();
		TreeNode curr = A;
		s.push(curr);
		while (!s.isEmpty()) {
			curr = s.pop();
			postOrder.add(curr.val);
			if (null != curr.left)
				s.push(curr.left);
			if (null != curr.right) {
				s.push(curr.right);
			}
		}
		Collections.reverse(postOrder);
		return postOrder;
	}
}
