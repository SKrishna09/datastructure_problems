package com.practice.problems.linkedlist;

public class MiddleElementOfTheLinkedList {

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
		MiddleElementOfTheLinkedList.addNodeToList(97);
		MiddleElementOfTheLinkedList.addNodeToList(63);
		MiddleElementOfTheLinkedList.addNodeToList(89);
		MiddleElementOfTheLinkedList.addNodeToList(34);
		MiddleElementOfTheLinkedList.addNodeToList(82);
		MiddleElementOfTheLinkedList.addNodeToList(95);
		MiddleElementOfTheLinkedList.addNodeToList(4);
		MiddleElementOfTheLinkedList.addNodeToList(70);
		MiddleElementOfTheLinkedList.addNodeToList(14);

		System.out.println("Given LinkedList:::");
		printLinkedList(node);

		int midElement = middleElementOfTheList(node);
		System.out.println("Middle Element Of The LinkedList:::" + midElement);
	}

	public static int middleElementOfTheList(ListNode A) {
		ListNode slow = A;
		ListNode fast = A;
		while (null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.val;
	}

}
