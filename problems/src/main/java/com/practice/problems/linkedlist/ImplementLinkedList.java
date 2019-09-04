package com.practice.problems.linkedlist;

public class ImplementLinkedList {

	public static ListNode node;

	public static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {
		insert_node(1, 1);
		insert_node(2, 2);
		insert_node(3, 3);
		insert_node(4, 4);
		insert_node(2, 5);
		insert_node(1, 6);
		insert_node(7, 7);
		print_ll();
		delete_node(3);
		delete_node(1);
		delete_node(5);
		delete_node(8);
		print_ll();
	}

	public static void insert_node(int position, int value) {
		ListNode newNode = new ListNode(value);
		if (null == node && position == 1) {
			node = newNode;
			return;
		}
		ListNode previousNode = null;
		ListNode currentNode = node;
		while (null != currentNode && (position - 1) > 0) {
			previousNode = currentNode;
			currentNode = currentNode.next;
			position--;
		}
		if (position >= 1 && null != previousNode) {
			previousNode.next = newNode;
			newNode.next = currentNode;
		}
		if (null == previousNode && 1 == position) {
			newNode.next = currentNode;
			node = newNode;
		}
	}

	public static void delete_node(int position) {
		ListNode previousNode = null;
		ListNode currentNode = node;
		while (null != currentNode && (position - 1) > 0) {
			previousNode = currentNode;
			currentNode = currentNode.next;
			position--;
		}
		if(position > 1)
			return;
		ListNode tempNode = null;
		if (null != currentNode && null != currentNode.next) {
			tempNode = currentNode.next;
		}
		if (null != previousNode) {
			previousNode.next = tempNode;
		}else {
			node = tempNode;
		}
	}

	public static void print_ll() {
		ListNode printNode = node;
		while (null != printNode) {
			System.out.print(printNode.val + " ");
			printNode = printNode.next;
		}
		System.out.println();
	}

}
