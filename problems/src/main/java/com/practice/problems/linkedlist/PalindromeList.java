package com.practice.problems.linkedlist;

public class PalindromeList {
	public static ListNode node;

	public static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void addNodeToList(int data) {
		ListNode newNode = new ListNode(data);
		if (null == node) {
			node = newNode;
		} else {
			ListNode temp = node;
			while (null != temp.next) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	public static void printLinkedList(ListNode n) {
		while (null != n) {
			System.out.print(n.val + " ");
			n = n.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		PalindromeList.addNodeToList(1);
		PalindromeList.addNodeToList(2);
		PalindromeList.addNodeToList(3);
		PalindromeList.addNodeToList(4);
		PalindromeList.addNodeToList(3);
		PalindromeList.addNodeToList(2);
		PalindromeList.addNodeToList(1);
		System.out.println("Given LinkedList:::");
		printLinkedList(node);

		int isPalindrome = lPalin(node);
		if (isPalindrome == 1)
			System.out.println("Given List is Palindrome");
		else
			System.out.println("Given List is not Palindrome");

	}

	public static int lPalin(ListNode A) {
		if (null == A.next)
			return 1;

		ListNode slow = A;
		ListNode fast = A;
		int i = 1;
		while (null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
			if (null != fast)
				i = i + 2;
			else
				i = i + 1;
		}
		ListNode midNode = null;
		if ((i % 2) != 0) {
			midNode = reverseAList(slow.next);
		} else {
			midNode = reverseAList(slow);
		}
		if (null != midNode)
			return compareList(A, midNode, (i / 2));

		return 0;
	}

	public static int compareList(ListNode start1, ListNode start2, int noToMatch) {
		while (null != start1 && null != start2 && noToMatch >= 0) {
			if (start1.val != start2.val)
				return 0;
			start1 = start1.next;
			start2 = start2.next;
			noToMatch--;
		}
		if (noToMatch == 0)
			return 1;
		return 0;
	}

	public static ListNode reverseAList(ListNode current) {
		ListNode next = null;
		ListNode prev = null;
		while (null != current) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		current = prev;
		return current;
	}

}
