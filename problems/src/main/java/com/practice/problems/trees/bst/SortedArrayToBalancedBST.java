package com.practice.problems.trees.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.practice.problems.trees.InOrderTraversal.TreeNode;

public class SortedArrayToBalancedBST {

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
		List<Integer> sortedArray = new LinkedList<>();
		sortedArray.add(1);
		sortedArray.add(2);
		sortedArray.add(3);
		sortedArray.add(4);
		sortedArray.add(5);
		sortedArray.add(6);
		TreeNode root = sortedArrayToBST(sortedArray, 0, sortedArray.size() - 1);
		List<Integer> inOrder = inorderTraversal(root);
		System.out.println("InOrder Traversal Of The Given Tree is:::" + inOrder.toString());
	}

	public static TreeNode sortedArrayToBST(final List<Integer> a, Integer start, Integer end) {
		if (start > end)
			return null;
		Integer mid = (start + end) / 2;
		TreeNode root = new TreeNode(a.get(mid));

		root.left = sortedArrayToBST(a, start, mid - 1);
		root.right = sortedArrayToBST(a, mid + 1, end);
		return root;
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
