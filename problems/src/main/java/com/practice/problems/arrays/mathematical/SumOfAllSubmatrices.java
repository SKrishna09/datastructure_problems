package com.practice.problems.arrays.mathematical;

import java.util.ArrayList;
import java.util.Arrays;

public class SumOfAllSubmatrices {

	public static void main(String[] args) {
		/*
		 * int[][] A = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; int[] B = { 1, 2 };
		 * int[] C = { 1, 2 }; int[] D = { 2, 3 }; int[] E = { 2, 3 };
		 */
		int[][] A = { { 5, 17, 100, 11 }, { 0, 0, 2, 8 } };
		int[] B = { 1, 1 };
		int[] C = { 1, 4 };
		int[] D = { 2, 2 };
		int[] E = { 2, 4 };
		// solve(A,B,C,D,E);
		// create2DArrayList();
		// solve1(create2DArrayList());
		// int[] Z = { 4, 0, 2, 1, 3};
		// arrange(Z);
		// int[] Z = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
		// subUnsort(Z);
		// int[] x = {1, 0, 0, 0, 1};
		// int[][] y = {{2,4},{1,5},{3,5}};
		// solve(x,y);
		// int[] x = { 1, 2, 3 };
		// hammingDistance(x);
		int[] x = { 1, 2, 1, 2, 13, 1, 2 };
		// singleNumber(x);
		int[] y = { 1 };
		// countPairsSumDivisibleByK(y,1);
		int[] m = { 6, 1, 1, 4, 1, 5, 3};
		countTripletSumDivisibleByK(m,2);
		// int[] z = {11, 11, 13, 12, 12};
		// solveRe(z);
		int[] q = { 5, 17, 100, 11 };
		// pivot(q);
		int[] r = { 5, 6, 7, 1, 2, 3, 4 };
		//sortedRotated(r, 4);

	}

	private static void singleNumber(int[] A) {
		/*
		 * int value = 0; for(int i = 0; i < x.length; i++) { value = value ^ x[i]; }
		 * System.out.println("UniqueNumber::"+value);
		 */
		int result = 0;
		int x, sum;
		for (int i = 0; i < 32; i++) {

			sum = 0;
			x = (1 << i);
			for (int j = 0; j < A.length; j++) {
				if ((A[j] & x) == 0)
					sum++;
			}
			if ((sum % 3) == 0)
				result |= x;
		}
		System.out.println("Result::" + result);
	}

	static ArrayList<ArrayList<Integer>> create2DArrayList() {
		/* Declaring 2D ArrayList */
		ArrayList<ArrayList<Integer>> x = new ArrayList<ArrayList<Integer>>();

		x.add(new ArrayList<Integer>(Arrays.asList(-3, -3, -3)));
		x.add(new ArrayList<Integer>(Arrays.asList(-2, -2, 5)));
		x.add(new ArrayList<Integer>(Arrays.asList(-1, 10, 10)));

		return x;
	}

	public static int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
		/*
		 * int m = A.length; int n = A[0].length; for (int i = 0; i < m; i++) { for (int
		 * j = 1; j < n; j++) { A[i][j] += A[i][j-1]; } } for (int j = 0; j < n; j++) {
		 * for (int i = 1; i < m; i++) { A[i][j] += A[i-1][j]; } }
		 * 
		 * int querySize = B.length; int[] sum = new int[querySize];
		 * 
		 * int queryStart = 0; while (queryStart < querySize) { int subArraySum = 0; int
		 * i1, j1, i2, j2; i1 = B[queryStart]-1; j1 = C[queryStart]-1; i2 =
		 * D[queryStart]-1; j2 = E[queryStart]-1;
		 * 
		 * subArraySum += A[i2][j2];
		 * 
		 * if ((i1 - 1) >= 0) subArraySum -= A[i1 - 1][j2]; if ((j1 - 1) >= 0)
		 * subArraySum -= A[i2][j1 - 1]; if ((i1 - 1) >= 0 && (j1 - 1) >= 0) subArraySum
		 * += A[i1 - 1][j1 - 1]; sum[queryStart] = subArraySum; queryStart++; } return
		 * sum;
		 */
		int m = A.length;
		int n = A[0].length;
		long[][] subArrSum = new long[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				subArrSum[i][j] += A[i][j];
				if (j - 1 >= 0)
					subArrSum[i][j] += subArrSum[i][j - 1];
			}
		}
		for (int j = 0; j < n; j++) {
			for (int i = 1; i < m; i++) {
				subArrSum[i][j] += subArrSum[i - 1][j];
			}
		}

		int querySize = B.length;
		int[] sum = new int[querySize];

		int queryStart = 0;
		while (queryStart < querySize) {
			long subArraySum = 0;
			int i1, j1, i2, j2;
			i1 = B[queryStart] - 1;
			j1 = C[queryStart] - 1;
			i2 = D[queryStart] - 1;
			j2 = E[queryStart] - 1;

			subArraySum += subArrSum[i2][j2];

			if ((i1 - 1) >= 0)
				subArraySum -= subArrSum[i1 - 1][j2];
			if ((j1 - 1) >= 0)
				subArraySum -= subArrSum[i2][j1 - 1];
			if ((i1 - 1) >= 0 && (j1 - 1) >= 0)
				subArraySum += subArrSum[i1 - 1][j1 - 1];
			sum[queryStart] = (int) (subArraySum % 1000000007);
			queryStart++;
		}
		return sum;
	}

	public static int solve1(ArrayList<ArrayList<Integer>> A) {
		int sum = 0;
		int m = A.size();
		int n = A.get(0).size();
		int[][] arr = new int[m][n];
		for (int i = 0; i < m; i++) {
			ArrayList<Integer> column = A.get(i);
			for (int j = 0; j < n; j++) {
				int value = column.get(j);
				arr[i][j] = value;
			}
		}

		int[][] suffixSumArray = new int[m][n];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				suffixSumArray[i][j] += arr[i][j];
				if (j + 1 <= n - 1)
					suffixSumArray[i][j] += suffixSumArray[i][j + 1];
			}
		}

		for (int j = n - 1; j >= 0; j--) {
			for (int i = m - 1; i >= 0; i--) {
				suffixSumArray[i][j] = suffixSumArray[i][j];
				if (i + 1 <= m - 1)
					suffixSumArray[i][j] += suffixSumArray[i + 1][j];
			}
		}

		sum = arr[m - 1][n - 1];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int value = suffixSumArray[i][j];
				if (value > sum)
					sum = value;
			}
		}
		return sum;
	}

	public static void arrange(int[] A) {
		/*
		 * int originalValue = -1; int originalValueIndex = 0; for(int i =
		 * originalValueIndex; i < A.length; i++){ int value1 = A[i]; if(originalValue
		 * >= 0) value1 = originalValue; int value2 = A[value1]; originalValue = value2;
		 * A[value1] = -(originalValueIndex+1); originalValueIndex = value1;
		 * 
		 * }
		 * 
		 * for(int i = 0; i < A.length; i++) { int value = A[i]; A[i] = (value * (-1)) -
		 * 1; } System.out.println(Arrays.toString(A));
		 */;

		int n = A.length;
		for (int i = 0; i < A.length; i++) {
			A[i] += (A[A[i]] % n) * n;
		}

		for (int i = 0; i < A.length; i++) {
			A[i] /= n;
		}
		System.out.println(Arrays.toString(A));
	}

	public static int[] subUnsort(int[] A) {
		Arrays.sort(A);
		int[] result;
		int maxValue = Integer.MIN_VALUE;
		int minValue = Integer.MAX_VALUE;

		boolean flag = false;
		for (int i = 1; i < A.length; i++) {
			if (A[i] < A[i - 1]) {
				flag = true;
			}
			if (flag)
				minValue = Math.min(minValue, A[i]);
		}
		flag = false;
		for (int i = A.length - 2; i >= 0; i--) {
			if (A[i] > A[i + 1]) {
				flag = true;
			}
			if (flag)
				maxValue = Math.max(maxValue, A[i]);
		}
		int left;
		for (left = 0; left < A.length; left++) {
			if (minValue < A[left])
				break;
		}
		int right;
		for (right = A.length - 1; right >= 0; right--) {
			if (maxValue > A[right])
				break;
		}
		if (right - left < 0) {
			result = new int[1];
			result[0] = -1;
			System.out.println(Arrays.toString(result));
			return result;
		} else {
			result = new int[2];
			result[0] = left;
			result[1] = right;
			System.out.println(Arrays.toString(result));
			return result;
		}
	}

	public static int[][] solve(int[] A, int[][] B) {
		int row = B.length;
		int column = B[0].length;
		int[][] ans = new int[row][column];

		int left;
		int right;
		for (int i = 0; i < row; i++) {
			left = B[i][0] - 1;
			right = B[i][1] - 1;

			int count0 = 0;
			int value = A[left];
			for (int j = left + 1; j <= right; j++) {
				value = value ^ A[j];
				if (0 == A[j])
					count0++;
			}
			if (0 == A[left])
				count0++;
			ans[i][0] = value;
			ans[i][1] = count0;
		}
		return ans;
	}

	public static int hammingDistance(final int[] A) {
		int sum = 0;
		for (int i = 0; i <= 32; i++) {
			int count = 0;
			for (int j = 0; j < A.length; j++) {
				if ((A[j] & 1 << i) == 0) {
					count++;
				}
				sum += (count * (A.length - count) * 2);
			}
		}
		return sum;
	}

	public static int countPairsSumDivisibleByK(int[] A, int B) {
		int[] bucket = new int[B];

		for (int i = 0; i < A.length; i++)
			bucket[A[i] % B]++;

		int pairs = 0;
		pairs += bucket[0] * (bucket[0] - 1) / 2;

		for (int i = 1; i <= B / 2 - 1; i++) {
			pairs += bucket[i] * bucket[B - i];
		}
		if (B % 2 == 0)
			pairs += (bucket[B / 2] * (bucket[B / 2] - 1)) / 2;
		else if ((B / 2 + 1) < B)
			pairs += bucket[B / 2] * bucket[B / 2 + 1];

		return pairs;
	}

	public static int countTripletSumDivisibleByK(int[] A, int B) {
		long[] bucket = new long[B];
        
        for(int i = 0; i < A.length; i++){
            bucket[A[i]%B]++;
        }
        
        long pairs = 0;
        for(int i = 0; i < bucket.length; i++){
            for(int j = i; j < bucket.length; j++){
                int r1 = (i+j)%B;
                int k = 0;
                if(0 == r1)
                	k = 0;
                else
                	k = B - r1;
                if(k < j)
                	continue;
                
                if(i == j && j == k){
                    pairs += (bucket[i] * (bucket[i]-1) * (bucket[i]-2))/6;
                    pairs = (int) (pairs % 1000000007);
                }else if(i == j && i != k){
                    pairs += (bucket[i] * (bucket[i]-1))/2 * bucket[k];
                    pairs = (int) (pairs % 1000000007);
                }else if(j == k && j != i){
                    pairs += (bucket[j] * (bucket[j]-1))/2 * bucket[i];
                    pairs = (int) (pairs % 1000000007);
                }else if(i == k && i != j){
                    pairs += (bucket[i] * (bucket[i]-1))/2 * bucket[j];
                    pairs = (int) (pairs % 1000000007);
                }else{
                    pairs += bucket[i] * bucket[j] * bucket[k];
                    pairs = (int) (pairs % 1000000007);
                }
            }
        }
        return (int) (pairs % 1000000007);
	}

	public static int solveRe(int[] A) {
		int length = A.length - 1;
		int low = 0;
		int high = length;

		while (low < high) {
			int mid = low + (high - low) / 2;

			if (0 == mid % 2) {
				if (A[mid] == A[mid + 1])
					low = mid + 2;
				else
					high = mid;
			} else if (1 == mid % 2) {
				if (A[mid] == A[mid - 1])
					low = mid + 1;
				else
					high = mid - 1;
			}
		}
		if (low == high)
			return A[low];
		else
			return -1;
	}

	public static int pivot(int[] A) {
		int length = A.length - 1;
		int low = 0;
		int high = length;

		while (low < high) {
			int mid = low + (high - low) / 2;

			if (A[mid + 1] < A[mid])
				high = mid - 1;
			if (A[mid + 1] > A[mid])
				low = mid + 1;
		}
		if (low == high)
			return A[low];
		else
			return -1;
	}

	// 5,6,7,1,2,3,4 - 4
	public static int sortedRotated(int[] A, int B) {
		int low = 0;
		int high = A.length - 1;

		while (low < high) {
			int mid = low + (high - low) / 2;

			if (B == A[mid])
				return mid;

			if (A[low] <= A[mid]) {
				if (B >= A[low] && B <= A[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			if (B >= A[mid] && B <= A[high]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		if (low == high)
			return low;
		return -1;
	}
}
