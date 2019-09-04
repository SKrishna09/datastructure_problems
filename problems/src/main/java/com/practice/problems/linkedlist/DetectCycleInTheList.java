package com.practice.problems.linkedlist;

import java.util.HashSet;

public class DetectCycleInTheList {

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
		DetectCycleInTheList h = new DetectCycleInTheList();
		h.node = new ListNode(1);
		h.node.next = new ListNode(2);
		h.node.next.next = new ListNode(3);
		h.node.next.next.next = new ListNode(4);
		h.node.next.next.next.next = h.node.next.next;
		detectCycle(h.node);
		detectCycleHash(h.node);
	}

	public static ListNode detectCycle(ListNode a) {
		ListNode slow = a;
		ListNode fast = a;
		while (null != fast && null != fast.next && slow != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				System.out.println("Cycle");
				return slow;
			}
		}
		System.out.println("No Cycle");
		return null;
	}

	public static ListNode detectCycleHash(ListNode a) {
		HashSet<Integer> listValues = new HashSet<>();

		while (null != a) {
			if (listValues.contains(a.val)) {
				System.out.println("Cycle");
				return a;
			}
			listValues.add(a.val);
			a = a.next;
		}
		System.out.println("No Cycle");
		return null;
	}

}
