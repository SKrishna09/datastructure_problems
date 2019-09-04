package com.practice.problems.arrays.search;

import java.util.Arrays;

public class AggressiveCows {

	/*
	 * Farmer John has built a new long barn, with N stalls. Given an array of
	 * integers A of size N where each element of the array represents the location
	 * of the stall, and an integer B which represent the number of cows. His cows
	 * don't like this barn layout and become aggressive towards each other once put
	 * into a stall. To prevent the cows from hurting each other, John wants to
	 * assign the cows to the stalls, such that the minimum distance between any two
	 * of them is as large as possible. What is the largest minimum distance?
	 * 
	 * Input 1: A = [1, 2, 3, 4, 5] B = 3 Output 1: 2
	 * 
	 * Input 2: A = [5, 17, 100, 11] B = 2 Output 2: 95
	 */

	public static void main(String[] args) {
		int[] A = { 6939, 2057, 3094, 9698, 6214, 9667, 8682, 6309, 928, 1603, 3194, 6188, 1170, 923, 7887, 3932, 9083,
				1924, 2795, 1686, 3189, 303, 2254, 1148, 3312, 7357, 6162, 8194, 2923, 4763, 5314, 5499, 1271, 4919,
				1067, 9698, 8553, 8097, 1883, 3478, 3542, 1702, 1872, 9795, 4593, 8876, 9385, 4873, 1747, 3290, 6890,
				9086, 9782, 4590, 6903, 9879, 9490, 4179, 2588, 8976, 7187, 4223, 5784, 6836, 553, 3685, 9665, 943,
				2222, 3969, 8065, 953, 1269, 3293, 8518, 2915, 6713, 3349, 1516, 6851, 6451, 3950, 4186, 6825, 9691,
				1418, 2594, 286, 836, 4261, 3261, 3971, 8077, 5323, 1081, 6916, 429, 3074, 7832, 7264, 2915, 5905, 2719,
				8433, 669, 2423, 3997, 1971, 9329, 7601, 8609, 8946, 828, 9315, 4980, 9069, 842, 2360, 2675, 6945, 6568,
				7320, 1389, 7780, 1267, 9794, 983, 699, 5054, 1474, 3659, 6423, 9781, 8294, 9193, 7450, 9549, 2426,
				4218, 3161, 7385, 4354, 6944, 9244, 2901, 8350, 9416, 756, 5405, 9802, 457, 755, 1838, 5560, 3746, 1929,
				9178, 9181, 7151, 6960, 6477, 1342, 1417, 4424, 2615, 2008, 8543, 995, 1974, 4946, 2798, 7389, 1793,
				7131, 243, 5081, 1721, 5231, 5777, 3159, 8234, 8907, 326, 9823, 4002, 5947, 4584, 1060, 5042, 7445,
				9860, 9781, 6533, 2109, 1103, 2320, 1568, 7620, 1883, 5632, 5780, 3461, 6230, 7700, 4753, 4094, 7644,
				5788, 497, 3490, 1282, 1934, 7819, 2077, 1345, 2823, 1375, 4980, 2051, 1604, 9482, 6038, 7226, 2550,
				1218, 5572, 479, 5516, 9335, 1104, 5248, 6113, 2576, 9313, 1545, 9210, 7574, 4387, 4176, 7933, 2239,
				2668, 5373, 7687, 9732, 5922, 3351, 4871, 4493, 5973, 7109, 2969, 9577, 1498, 6939, 4454, 7583, 3801,
				9612, 5576, 5851, 2065, 6935, 2507, 264, 228, 6487, 1535, 1001, 6966, 3742, 3066, 7882, 7464, 5503,
				9020, 2575, 712, 5570, 5891, 9871, 8824, 4944, 1216, 441, 5537, 483, 9469, 3112, 9539, 7917, 4533, 5496,
				4435, 7368, 9814, 8041, 1349, 2166, 3730, 8035, 1940, 4595, 7965, 6930, 9387, 5433, 8094, 6429, 2350,
				7709, 1485, 6264, 2295, 8888, 5246, 9291, 7625, 9878, 7856, 7611, 9097, 3697, 1693, 6786, 9698, 1441,
				79, 3908, 8752, 8239, 1713, 9252, 4414, 7319, 7377, 586, 903, 6019, 8688, 3795, 6827, 3566, 6304, 3428,
				8786, 6831, 5478, 2020, 78, 6889, 161, 7588, 7762, 6186, 2941, 4572, 2596, 3384, 7024, 4687, 5476, 560,
				8199, 630, 817, 5304, 9265, 7389, 2093, 8507, 6748, 3047, 7190, 7136, 9913, 3375, 1609, 141, 5033, 2271,
				5654, 4775, 3702, 3145, 7692, 85, 2551, 4737, 9347, 4104, 3152, 8527, 50, 1362, 5132, 3869, 7750, 7729,
				2549, 1345, 9795, 316, 3450, 4378, 3004, 1204, 5163, 4141, 4765, 5076, 3412, 3008, 7628, 2505, 1564,
				7356, 8318, 2610, 7490, 1396 }; // FARMER STALLS
		// LOCATION
		int B = 385; // NO OF COWS

		Arrays.sort(A);
		removeDuplicateElements(A, A.length);
		int largestMinDistance = aggressiveCows(A, B);
		System.out.println("largestMinDistance:: " + largestMinDistance);
	}

	private static int aggressiveCows(int[] A, int B) {
		int largestMinDistance = 0;
		int low = A[0];
		int high = (A[A.length - 1] - A[0]) + 1;

		while (low < high) {
			int mid = low + (high - low) / 2;

			if (1 == (high - low))
				return low;
			if (isPossibleToSetAggresiveCows(A, B, mid)) {
				low = mid;
				largestMinDistance = mid;
			} else {
				high = mid;
				largestMinDistance = mid;
			}
		}
		return largestMinDistance;
	}

	public static boolean isPossibleToSetAggresiveCows(int[] A, int B, int mid) {
		boolean isPossible = false;
		B -= 1;
		int possibleValue = mid;
		while (B > 0) {
			for (int i = 1; i < A.length; i++) {
				possibleValue = A[i - 1] + mid;

				boolean valueFound = false;
				for (int j = i; j < A.length; j++) {
					int value = A[j];
					if (possibleValue == value || value > possibleValue) {
						B -= 1;
						i = j;
						valueFound = true;
						break;
					}
				}
				if (0 == B)
					return true;
				if (!valueFound)
					return isPossible;
			}
		}
		if (0 == B) {
			isPossible = true;
		}
		return isPossible;
	}

	public static void removeDuplicateElements(int arr[], int n) {
		if (n == 0 || n == 1) {
			return;
		}
		int[] temp = new int[n];
		int j = 0;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				temp[j++] = arr[i];
			}
		}
		temp[j++] = arr[n - 1];
		// Changing original array
		for (int i = 0; i < j; i++) {
			arr[i] = temp[i];
		}
	}

}
