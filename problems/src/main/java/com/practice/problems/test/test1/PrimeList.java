package com.practice.problems.test.test1;

public class PrimeList {

	public ListNode node;

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
		PrimeList h = new PrimeList();
		h.node = new ListNode(67);
		h.node.next = new ListNode(9);
		h.node.next.next = new ListNode(70);
		h.node.next.next.next = new ListNode(84);
		h.node.next.next.next.next = new ListNode(57);
		h.node.next.next.next.next.next = new ListNode(51);
		h.node.next.next.next.next.next.next = new ListNode(26);
		h.node.next.next.next.next.next.next.next = new ListNode(14);
		h.node.next.next.next.next.next.next.next.next = new ListNode(95);
		h.node.next.next.next.next.next.next.next.next.next = new ListNode(95);
		h.node.next.next.next.next.next.next.next.next.next.next = new ListNode(61);
		h.node.next.next.next.next.next.next.next.next.next.next.next = new ListNode(36);
		h.node.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(1);

		ListNode l = solve(h.node);
		System.out.println("LinkedList after prime operations of the list:::");
		printLinkedList(l);

		ListNode ll = specialLL(h.node);
		System.out.println("LinkedList after prime operations of the list:::");
		printLinkedList(ll);
	}

	public static ListNode solve(ListNode A) {
		ListNode prime = null;
		ListNode nPrime = null;
		ListNode curr = A;
		ListNode dummyNoden = new ListNode(0);
		ListNode n = dummyNoden;
		ListNode dummyNodem = new ListNode(0);
		ListNode m = dummyNodem;
		while (null != curr) {
			if (isPrime(curr.val)) {
				prime = curr;
				n.next = prime;
				n = n.next;
			} else {
				nPrime = curr;
				m.next = nPrime;
				m = m.next;
			}
			curr = curr.next;
		}
		n.next = null;
		m.next = null;
		if (null != nPrime) {
			n.next = dummyNodem.next;
			return dummyNoden.next;
		} else {
			return dummyNoden.next;
		}
	}

	public static ListNode specialLL(ListNode A) {
		ListNode curr = A;
		ListNode hp = new ListNode(0);
		ListNode hnp = new ListNode(0);
		ListNode p = new ListNode(0);
		ListNode np = new ListNode(0);
		hp.next = p;
		hnp.next = np;
		while (null != curr) {
			if (isPrime(curr.val)) {
				p.next = new ListNode(curr.val);
				p = p.next;
			} else {
				np.next = new ListNode(curr.val);
				np = np.next;
			}
			curr = curr.next;
		}
		if (null != p) {
			p.next = hnp.next.next;
			return hp.next.next;
		} else {
			return hnp.next.next;
		}
	}

	public static boolean isPrime(Integer a) {
		Integer sum = 0;
		while (0 != a) {
			sum += a % 10;
			a = a / 10;
		}
		if (sum <= 1)
			return false;
		for (int i = 2; i <= Math.sqrt(sum); i++) {
			if ((sum % i) == 0)
				return false;
		}
		return true;
	}

}
