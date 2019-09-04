package com.practice.problems.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class BClosestPointsToOrigin {

	public static void main(String[] args) {
		int[][] A = { { -450, 114 }, { -370, 81 }, { -286, 228 }, { 50, 34 }, { 18, 28 } };
		int B = 5;
		solve(A, B);
		kClosest(A, B);
	}

	public static int[][] kClosest(int[][] points, int K) {
		int N = points.length;
		int[] dists = new int[N];
		for (int i = 0; i < N; ++i)
			dists[i] = calculateDistance(points[i][0], points[i][1]);

		Arrays.sort(dists);
		int distK = dists[K - 1];

		int[][] ans = new int[K][2];
		int t = 0;
		for (int i = 0; i < N; ++i)
			if (calculateDistance(points[i][0], points[i][1]) <= distK)
				ans[t++] = points[i];
		return ans;
	}

	public static int[][] solve(int[][] A, int B) {
		HashMap<String, Integer> allDistance = new HashMap<>();
		findDistance(A, allDistance);
		allDistance = sortMapByValue(allDistance);

		int[][] answer = new int[B][2];
		int i = 0;

		for (Entry<String, Integer> entry : allDistance.entrySet()) {
			if (B > 0) {
				String key = entry.getKey();
				String[] val = key.split(",");
				int[] innerArray = new int[2];
				innerArray[0] = Integer.parseInt(val[0]);
				innerArray[1] = Integer.parseInt(val[1]);
				answer[i] = innerArray;
				i++;
				B--;
			} else {
				break;
			}

		}
		return answer;
	}

	public static LinkedHashMap<String, Integer> sortMapByValue(HashMap<String, Integer> allDistance) {
		return allDistance.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}

	public static void findDistance(int[][] A, HashMap<String, Integer> allDistance) {
		int m = A.length;
		for (int i = 0; i < m; i++) {
			int a = A[i][0];
			int b = A[i][1];
			Integer value = calculateDistance(a, b);
			String key = a + "," + b;
			allDistance.put(key, value);
		}
	}

	public static Integer calculateDistance(int a, int b) {
		Integer value;
		double c = Math.pow((0 - a), 2);
		double d = Math.pow((0 - b), 2);
		value = (int) Math.sqrt(c + d);
		return value;
	}

}
