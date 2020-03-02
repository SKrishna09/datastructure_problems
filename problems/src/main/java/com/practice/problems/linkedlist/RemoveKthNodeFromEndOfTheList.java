package com.practice.problems.linkedlist;

public class RemoveKthNodeFromEndOfTheList {

	public ListNode node;

	public static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {
		RemoveKthNodeFromEndOfTheList h = new RemoveKthNodeFromEndOfTheList();
		h.node = new ListNode(1);
		h.node.next = new ListNode(2);
		h.node.next.next = new ListNode(3);
		h.node.next.next.next = new ListNode(4);
		h.node.next.next.next.next = new ListNode(5);
		h.node.next.next.next.next.next = new ListNode(6);

		System.out.println("Given LinkedList:::");
		printLinkedList(h.node);

		ListNode l = removeNthFromEnd(h.node, 3);

		System.out.println("LinkedList after removal of the Kth node from the last of the list:::");
		printLinkedList(l);
	}

	public static void printLinkedList(ListNode n) {
		while (null != n) {
			System.out.print(n.val + " ");
			n = n.next;
		}
		System.out.println();
	}

	public static ListNode removeNthFromEnd(ListNode A, int B) {
		ListNode fast = A;
		ListNode slow = A;
		while (B > 0) {
			if (null != fast.next) {
				fast = fast.next;
			} else {
				slow = slow.next;
				A = slow;
				System.out.println(
						"If K is greater than the size of the list, remove the first node of the list::" + A.val);
				return A;
			}
			B--;
		}
		while (null != fast.next) {
			fast = fast.next;
			slow = slow.next;
		}
		if (null != slow.next.next) {
			slow.next = slow.next.next;
		} else {
			slow.next = null;
		}
		return A;
	}

}
