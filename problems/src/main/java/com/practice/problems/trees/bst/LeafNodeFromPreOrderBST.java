package com.practice.problems.trees.bst;

public class LeafNodeFromPreOrderBST {

	public static void main(String[] args) {
		int[] A = { 20, 17, 10, 13, 18, 2, 7, 6, 7, 9 };
		leafNode(A);
	}

	public static void leafNode(int[] A) {
		Integer min = Integer.MIN_VALUE;
		Integer max = Integer.MAX_VALUE;
		int index = 0;
		_leafNode(A, index, min, max);
	}

	public static boolean _leafNode(int[] A, int index, int min, int max) {
		if (A[index] > min && A[index] < max) {
			index++;
			boolean left = _leafNode(A, index, min, A[index - 1]);
			boolean right = _leafNode(A, index, A[index - 1], max);
			if (!left && !right) {
				System.out.println(A[index]);
				return false;
			}
			return true;
		} else {
			return false;
		}
	}
}
