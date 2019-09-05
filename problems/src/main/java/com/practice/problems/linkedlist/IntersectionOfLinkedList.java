package com.practice.problems.linkedlist;

import java.util.HashMap;

public class IntersectionOfLinkedList {

	/*Intersection of Linked Lists
	Write a program to find the node at which the intersection of two singly linked lists begins.
	For example, the following two linked lists:
		
		A:    	 	a1 → a2
        					↘
        						c1 → c2 → c3
        					↗
        B:     b1 → b2 → b3
        begin to intersect at node c1.
        
        If the two linked lists have no intersection at all, return null.
		The linked lists must retain their original structure after the function returns.*/

	public static ListNode node;
	public static ListNode node1;

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
		IntersectionOfLinkedList rl = new IntersectionOfLinkedList();
		rl.node = new ListNode(10);
		rl.node.next = new ListNode(20);
		rl.node.next.next = new ListNode(30);
		rl.node.next.next.next = new ListNode(40);
		rl.node.next.next.next.next = new ListNode(50);

		IntersectionOfLinkedList rl1 = new IntersectionOfLinkedList();
		rl1.node1 = new ListNode(60);
		rl1.node1.next = new ListNode(70);
		rl1.node1.next.next = new ListNode(80);
		rl1.node1.next.next.next = new ListNode(90);
		rl1.node1.next.next.next.next = new ListNode(100);
		rl1.node1.next.next.next.next.next = node.next.next.next;

		System.out.println("Given LinkedList1:::");
		printLinkedList(node);
		System.out.println("Given LinkedList2:::");
		printLinkedList(node1);
		ListNode ans = getIntersectionNode(node, node1);
		System.out.println("Intersection of LinkedList:::" + ans.val);
	}

	public static ListNode getIntersectionNode(ListNode a, ListNode b) {
		HashMap<ListNode, Boolean> listTracker = new HashMap<>();
		while (null != a) {
			listTracker.put(a, true);
			a = a.next;
		}
		while (null != b) {
			if (listTracker.containsKey(b))
				return b;
			else {
				b = b.next;
			}
		}
		return null;
	}

}
