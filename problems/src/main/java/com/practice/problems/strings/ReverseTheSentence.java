package com.practice.problems.strings;

public class ReverseTheSentence {

	public static void main(String[] args) {
		String a = "the   sky is blue";
		String reversedSentence = reverseWords(a);
		System.out.println(reversedSentence);
	}

	public static String reverseWords(String a) {
		String[] A = a.split("\\s");
		String ans = "";
		
		for (int i = A.length - 1; i >= 0; i--) {
			if (!A[i].isEmpty())
				ans += (A[i].trim() + " ");
		}
		return ans.trim();
	}

}
