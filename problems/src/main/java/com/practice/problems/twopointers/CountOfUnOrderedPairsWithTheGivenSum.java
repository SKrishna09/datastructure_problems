package com.practice.problems.twopointers;

public class CountOfUnOrderedPairsWithTheGivenSum {

	public static void main(String[] args) {
		int[] A = { 2, 2, 3, 5 }; // 3
		int K = 5;

		int j = A.length - 1;

		int count = 0;
		for(int i = 0; i < A.length - 1; i++) {
			while((A[i]+A[j]) > K && (j > i)){
				j--;
			}
			if (j < i)
				break;
			count += (j-i);
		}
		System.out.println("Count:::" + count);
	}

}
