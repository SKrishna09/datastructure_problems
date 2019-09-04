package com.practice.problems.arrays.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SubsetsOfAnArray {

	public static void main(String[] args) {
		int[] A = { 12,13}; // ARRAY
		subsets(A);
	}

	public static int[][] subsets(int[] A) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> lis = new ArrayList<>();
		Arrays.sort(A);
		subsetsHelper(A, lis, result);

		System.out.println(Arrays.toString(result.toArray()));
		
		Collections.sort(result, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> a, List<Integer> b) {
                int an = a.size();
                int bn = b.size();
                for (int i = 0; i < Math.min(an, bn); i++) {
                    int cmp = Integer.compare(a.get(i), b.get(i));
                    if (cmp != 0)
                        return cmp;
                }
                return Integer.compare(a.size(), b.size());
            }
        });
		System.out.println(Arrays.toString(result.toArray()));
		
		int m = result.size();
		int[][] resultArr = new int[m][];
		for (int i = 0; i < m; i++) {
			List<Integer> column = result.get(i);
			if (null != column && !column.isEmpty()) {
				int size = column.size();
				int[] inSide = new int[column.size()];
				for (int j = 0; j < size; j++) {
					int value = column.get(j);
					inSide[j] = value;
				}
				resultArr[i] = inSide;
			}else {
				int[] inSide = new int[0];
				resultArr[i] = inSide;
			}
		}
		return resultArr;
	}

	public static void subsetsHelper(int[] A, List<Integer> lis, List<List<Integer>> result) {
		if (0 == A.length) {
			List<Integer> lisCopy = new ArrayList<>(lis);
			result.add(lisCopy);
			return;
		} else {
			int value = A[0];
			int[] B = new int[A.length - 1];
			for (int i = 1; i < A.length; i++) {
				B[i - 1] = A[i];
			}
			subsetsHelper(B, lis, result);
			List<Integer> lisCopy = new ArrayList<>(lis);
			lisCopy.add(value);
			subsetsHelper(B, lisCopy, result);
		}
	}

}
