package com.practice.problems.twopointers;

public class ContainerWithMostWater {

	/*Container With Most Water
	Given n non-negative integers a1,a2,...,an, where each represents a point at
	coordinate (i, ai). 'n' vertical lines are drawn such that the two end points of line i
    is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, 
    such that the container contains the most water.
    
    Input : [1, 5, 4, 3]
    Output : 6
    Explanation : 5 and 3 are distance 2 apart. 
    So size of the base = 2. Height of container = min(5, 3) = 3. 
    So total area = 3 * 2 = 6*/

	public static void main(String[] args) {
		int[] A = { 1, 5, 4, 3 };
		maxArea(A);
	}

	public static int maxArea(int[] A) {
		int maxArea = 0;

		int i = 0;
		int j = A.length - 1;

		while (i < j) {
			maxArea = Math.max(maxArea, ((j - i) * Math.min(A[i], A[j])));
			if (A[i] < A[j]) {
				i++;
			} else {
				j--;
			}
		}
		return maxArea;
	}

}
