package com.practice.problems.arrays.mathematical;

import java.util.ArrayList;
import java.util.Scanner;

public class PairFetching {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		/*ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int count = 0;
		while (scan.hasNext() && count < n) {
			String str = scan.nextLine();
			if (!str.isEmpty()) {
				String[] strArray = str.split(" ");
				ArrayList<Integer> l1 = new ArrayList<>();
				for (int j = 0; j < strArray.length; j++) {
					l1.add(j, Integer.parseInt(strArray[j]));
				}
				list.add(count, l1);
				count++;
			}
		}
		int m = scan.nextInt();
		while (scan.hasNext()) {
			String str1 = scan.nextLine();
			if (!str1.isEmpty()) {
				String[] strArray1 = str1.split(" ");
				int p = Integer.parseInt(strArray1[0]);
				int q = Integer.parseInt(strArray1[1]);
				ArrayList<Integer> isList = list.get(p - 1);
				if (!isList.isEmpty()) {
					if (q < isList.size()) {
						Integer val = isList.get(q);
						System.out.println(val);
					} else {
						System.out.println("ERROR!");
					}
				} else {
					System.out.println("ERROR!");
				}
			}
		}*/
		ArrayList<Integer> list = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		while (scan.hasNext()) {
			String str = scan.nextLine();
			if (!str.isEmpty()) {
				String[] strArray = str.split(" ");
				for (int j = 0; j < strArray.length; j++) {
					list.add(j, Integer.parseInt(strArray[j]));
				}
				break;
			}
		}
		int m = scan.nextInt();
		while (scan.hasNext()) {
			String str1 = scan.nextLine();
			if (!str1.isEmpty()) {
				String str2 = scan.nextLine();
				if (str1.equals("Insert")) {
					String[] strArray1 = str2.split(" ");
					int p = Integer.parseInt(strArray1[0]);
					int q = Integer.parseInt(strArray1[1]);
					list.add(p , q);
				}
				if (str1.equals("Delete")) {
					if (Integer.parseInt(str2) < list.size()) {
						list.remove(Integer.parseInt(str2));
					}
				}
			}
		}
		for (int k = 0; k < list.size(); k++) {
			System.out.println(list.get(k));
		}
	}

}
