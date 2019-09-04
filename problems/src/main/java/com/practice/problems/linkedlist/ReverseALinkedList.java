package com.practice.problems.linkedlist;

public class ReverseALinkedList {

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
		ReverseALinkedList.addNodeToList(1);
		ReverseALinkedList.addNodeToList(2);
		ReverseALinkedList.addNodeToList(3);
		ReverseALinkedList.addNodeToList(4);

		System.out.println("Given LinkedList:::");
		printLinkedList(node);

		ListNode ln = reverseALinkedList(node);

		System.out.println("Reversed LinkedList:::");
		printLinkedList(ln);
	}

	public static ListNode reverseALinkedList(ListNode node) {
		ListNode prev = null;
		ListNode next = null;
		ListNode current = node;

		while (null != current) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}

}
