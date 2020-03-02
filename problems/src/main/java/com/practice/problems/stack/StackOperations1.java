package com.practice.problems.stack;

import java.util.Stack;

public class StackOperations1 {

	/*
	 * Min Stack Design a stack that supports push, pop, top, and retrieving the
	 * minimum element in constant time. push(x) -- Push element x onto stack. pop()
	 * -- Removes the element on top of the stack. top() -- Get the top element.
	 * getMin() -- Retrieve the minimum element in the stack.
	 */

	public static void main(String[] args) {
		pop();
		push(644643544);
		getMin();
		top();
		top();
		top();
		pop();
		push(723943208);
		pop();
		push(909204);
		getMin();
		top();
		getMin();
		top();
		push(481523691);
		pop();
		push(465865082);
		top();
		push(243519307);
		pop();
		top();
		pop();
		push(844871295);
		getMin();
		push(573041392);
		push(468497349);
		pop();
		top();
		getMin();
	}

	static Stack<Integer> A = new Stack<>();
	static int min;

	public static void push(int x) {
		if (A.isEmpty()) {
			min = x;
			A.push(x);
			return;
		}
		// if value which will be pushed to stack is less then current minimum value
		if (x < min) {
			// 2 * value which will be pushed to stack - currentMinValue
			A.push(2 * x - min);
			// Update currentMinValue to x
			min = x;
		} else {
			A.push(x);
		}
	}

	public static void pop() {
		if (!A.isEmpty()) {
			int val = A.pop();

			// If top of the stack element is less then current minimum value
			if (val < min) {
				// find new minimum value by - 2 * currentMinValue - Actual value which is being
				// popped
				min = (2 * min - val);
			}
			// if stack is empty set minimum value to -1
			if (A.isEmpty())
				min = -1;
		} else {
			min = -1;
		}
	}

	public static int top() {
		int value = -1;
		if (!A.isEmpty()) {
			value = A.peek();
			
			// If top of the stack element is less then current minimum value
			if (value < min) {
				// return currentMinValue value
				value = min;
			}
		}
		System.out.println("Top::" + value);
		return value;
	}

	public static int getMin() {
		System.out.println("Min::" + min);
		return min;
	}
}
