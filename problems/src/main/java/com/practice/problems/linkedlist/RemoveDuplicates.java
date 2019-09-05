package com.practice.problems.linkedlist;

import java.util.HashMap;

public class RemoveDuplicates {
	
	/*Remove Duplicates from Sorted List.
	Given a sorted linked list, delete all duplicates such that each element appear only once.
	For example, 
	Given 1->1->2,
	return 1->2.
	
	Given 1->1->2->3->3,
	return 1->2->3.*/

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
		RemoveDuplicates.addNodeToList(1);
		RemoveDuplicates.addNodeToList(1);
		RemoveDuplicates.addNodeToList(2);
		RemoveDuplicates.addNodeToList(3);
		RemoveDuplicates.addNodeToList(3);
		RemoveDuplicates.addNodeToList(4);
		RemoveDuplicates.addNodeToList(5);
		RemoveDuplicates.addNodeToList(5);

		System.out.println("Given Sorted LinkedList:::");
		printLinkedList(node);
		ListNode ans = deleteDuplicates(node);
		System.out.println("Sorted LinkedList after removing duplicates:::");
		printLinkedList(ans);

	}

	public static ListNode deleteDuplicates(ListNode A) {
		ListNode a = A;
		ListNode dummyNode = new ListNode(0);
		ListNode n = dummyNode;
		HashMap<Integer, Boolean> tracker = new HashMap<>();

		while (null != a) {
			if (tracker.containsKey(a.val)) {
				n.next = a.next;
				a = a.next;
			} else {
				tracker.put(a.val, true);
				n.next = a;
				a = a.next;
				n = n.next;
			}
		}
		return dummyNode.next;
	}
}
