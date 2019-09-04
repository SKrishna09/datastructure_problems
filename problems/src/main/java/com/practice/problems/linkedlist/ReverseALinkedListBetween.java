package com.practice.problems.linkedlist;

public class ReverseALinkedListBetween {

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
		ReverseALinkedListBetween.addNodeToList(97);
		ReverseALinkedListBetween.addNodeToList(63);
		ReverseALinkedListBetween.addNodeToList(89);
		ReverseALinkedListBetween.addNodeToList(34);
		ReverseALinkedListBetween.addNodeToList(82);
		ReverseALinkedListBetween.addNodeToList(95);
		ReverseALinkedListBetween.addNodeToList(4);
		ReverseALinkedListBetween.addNodeToList(70);
		ReverseALinkedListBetween.addNodeToList(14);
		ReverseALinkedListBetween.addNodeToList(41);
		ReverseALinkedListBetween.addNodeToList(38);
		ReverseALinkedListBetween.addNodeToList(83);
		ReverseALinkedListBetween.addNodeToList(49);
		ReverseALinkedListBetween.addNodeToList(32);
		ReverseALinkedListBetween.addNodeToList(68);
		ReverseALinkedListBetween.addNodeToList(56);
		ReverseALinkedListBetween.addNodeToList(99);
		ReverseALinkedListBetween.addNodeToList(52);
		ReverseALinkedListBetween.addNodeToList(33);
		ReverseALinkedListBetween.addNodeToList(54);

		System.out.println("Given LinkedList:::");
		printLinkedList(node);

		ListNode ln = reverseBetween(node, 13, 15);

		System.out.println("Reversed LinkedList:::");
		printLinkedList(ln);
	}

	public static ListNode reverseBetween(ListNode A, int B, int C) {
		if (B == C)
			return A;
		ListNode revPrev = null;
		ListNode revStart = null;
		ListNode revEnd = null;
		ListNode revEndNext = null;
		ListNode current = A;

		int i = 1;
		while (null != current && i <= C) {
			if (i < B)
				revPrev = current;
			if (i == B)
				revStart = current;
			if (i == C) {
				revEnd = current;
				revEndNext = current.next;
			}
			current = current.next;
			i++;
		}
		revEnd = reverseAList(revStart, revEndNext);
		if (null == revPrev) {
			A = revEnd;
		} else {
			revPrev.next = revEnd;
		}
		revStart.next = revEndNext;

		return A;
	}

	public static ListNode reverseAList(ListNode revStart, ListNode revEndNext) {
		ListNode next = null;
		ListNode prev = null;
		while (null != revStart) {
			if (null != revEndNext && (revStart.val == revEndNext.val))
				break;
			next = revStart.next;
			revStart.next = prev;
			prev = revStart;
			revStart = next;
		}
		revStart = prev;
		return revStart;
	}

}
