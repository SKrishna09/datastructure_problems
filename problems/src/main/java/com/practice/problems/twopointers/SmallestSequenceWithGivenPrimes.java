package com.practice.problems.twopointers;

public class SmallestSequenceWithGivenPrimes {

	public static void main(String[] args) {
		int A = 2;
		int B = 3;
		int C = 5;
		int D = 5;
		solve(A, B, C, D);
	}

	public static int[] solve(int A, int B, int C, int D) {
		int[] answer = new int[D];

		int count = 0;
		int i = 1;
		while (count < D) {
			answer[count++] = i * A;
		}
		return answer;
	}

}
