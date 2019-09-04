package com.practice.problems.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.util.CollectionUtils;

public class CountOfSmallerNumberAfterSelf {
	public static void main(String[] args) {
		int[] A = { 5, 17, 100, 11 }; // ARRAY
		countSmaller(A);
	}

	public static List<Integer> countSmaller(int[] nums) {
		Integer[] ans = new Integer[nums.length];
		List<Integer> sorted = new ArrayList<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			int index = findIndex(sorted, nums[i]);
			ans[i] = index;
			sorted.add(index, nums[i]);
		}
		System.out.println(Arrays.toString(ans));
		return Arrays.asList(ans);
	}

	private static int findIndex(List<Integer> sorted, int target) {
		if (CollectionUtils.isEmpty(sorted))
			return 0;
		int start = 0;
		int end = sorted.size() - 1;
		if (sorted.get(end) < target)
			return end + 1;
		if (sorted.get(start) >= target)
			return 0;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (sorted.get(mid) < target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		if (sorted.get(start) >= target)
			return start;
		return end;
	}

}
