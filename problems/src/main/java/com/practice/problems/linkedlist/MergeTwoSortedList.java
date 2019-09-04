package com.practice.problems.linkedlist;

public class MergeTwoSortedList {
	public ListNode node1;
	public ListNode node2;

	public static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
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
		MergeTwoSortedList L1 = new MergeTwoSortedList();
		L1.node1 = new ListNode(5);
		L1.node1.next = new ListNode(8);
		L1.node1.next.next = new ListNode(20);

		System.out.println("Given LinkedList 1:::");
		printLinkedList(L1.node1);

		MergeTwoSortedList L2 = new MergeTwoSortedList();
		L2.node2 = new ListNode(4);
		L2.node2.next = new ListNode(11);
		L2.node2.next.next = new ListNode(15);

		System.out.println("Given LinkedList 2:::");
		printLinkedList(L2.node2);

		ListNode m = mergeTwoLists(L1.node1, L2.node2);

		System.out.println("Merged LinkedList:::");
		printLinkedList(m);

	}

	public static ListNode mergeTwoLists(ListNode A, ListNode B) {
		ListNode a = A;
		ListNode b = B;
		ListNode dummyNode = new ListNode(0);
		ListNode n = dummyNode;

		while (null != a && null != b) {
			if (a.val <= b.val) {
				n.next = a;
				a = a.next;
			} else {
				n.next = b;
				b = b.next;
			}
			n = n.next;
		}
		if (null != a) {
			n.next = a;
			a = a.next;
			n = n.next;
		}
		if (null != b) {
			n.next = b;
			b = b.next;
			n = n.next;
		}
		return dummyNode.next;
	}
}
