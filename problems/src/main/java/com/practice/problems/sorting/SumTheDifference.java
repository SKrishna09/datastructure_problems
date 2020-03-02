package com.practice.problems.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SumTheDifference {

	public static int MOD = 1000000007;

	public static void main(String[] args) {
		int[] A = {4,15,4,4,15,18,20 }; // ARRAY
		//solve(A);
		//maxMin(A,A.length);
		subUnsort(A);
	}

	public static int solve(int[] A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> lis = new ArrayList<>();
		ArrayList<Integer> sumList = new ArrayList<>();
		subsetsHelper(A, lis, sumList);

		int sum = 0;
		int m = sumList.size();
		for (int i = 0; i < m; i++) {
			sum += sumList.get(i);
		}
		System.out.println("SUM:::" + sum);
		return sum;
	}

	public static void subsetsHelper(int[] A, ArrayList<Integer> lis, ArrayList<Integer> sumList) {
		if (0 == A.length) {
			Integer sum = 0;
			Collections.sort(lis);
			int n = lis.size();
			if (n > 1) {
				sum += (lis.get(n - 1) - lis.get(0));
			}
			sumList.add(sum);
			return;
		} else {
			int value = A[0];
			int[] B = new int[A.length - 1];
			for (int i = 1; i < A.length; i++) {
				B[i - 1] = A[i];
			}
			subsetsHelper(B, lis, sumList);
			ArrayList<Integer> lisCopy = new ArrayList<>(lis);
			lisCopy.add(value);
			subsetsHelper(B, lisCopy, sumList);
		}
		return;
	}

	public static long maxMin(int arr[], int n) {
		// sort all numbers
		Arrays.sort(arr);

		// iterate over array and with help of
		// horner's rule calc max_sum and min_sum
		long min_sum = 0, max_sum = 0;
		for (int i = 0; i < n; i++) {
			max_sum = 2 * max_sum + arr[n - 1 - i];
			max_sum %= MOD;
			min_sum = 2 * min_sum + arr[i];
			min_sum %= MOD;
		}
		System.out.println("SUM:::"+(max_sum - min_sum + MOD) % MOD);
		return (max_sum - min_sum + MOD) % MOD;
	}
	 
	public static int[] subUnsort(int[] A) {
	        int currElement;
	        int nextElement;
	        
	        int i = 0;
	        int firstLargeIndex = -1;
	        int lastIndex = -1;
	        while(i < A.length - 1){
	            currElement = A[i];
	            nextElement = A[i+1];
	            
	            if(currElement > nextElement) {
	            	if(firstLargeIndex < 0) {
	            		firstLargeIndex = i;
	            	}
	            	lastIndex = i+1;
	            }
	            i++;    
	        }
	        int[] result;
	        if(firstLargeIndex == -1){
	            result = new int[1];
	            result[0] = -1;
	        }else{
	            result = new int[2];
	            result[0] = firstLargeIndex;
	            result[1] = lastIndex;
	        }
	        return result;
	    }
}
