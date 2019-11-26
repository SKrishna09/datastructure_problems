package com.practice.problems.arrays.search;

public class MaximumheightoftheStaircase {
	
	/*Maximum height of the staircase
	Given an integer A representing the square blocks.
	The height of each square block is 1.
	The task is to create a staircase of max height using these blocks.
	The first stair would require only one block, the second stair would require two blocks and so on.
	Find and return the maximum height of the staircase. 
	
	10 => 4
	20 => 5*/

	public static void main(String[] args) {
		int A = 912147; //1350
		int A1 = 10; //4
		System.out.println("MaximumheightoftheStaircase:::" + solve(A1));
	}
	
	/*say n=10
	then show many steps can be constructed?
	after 1st step 9 stones left. (10 – “1 stone for 1 step” )
	after 2nd step 7 stones left. (9 – “2 stone for 2nd step” )
	after 3rd step 4 stones left. (7 – “3 stone for 3rd step” )
	after 4th step 0 stones left. (4 – “4 stone for 4th step” )*/

	public static int solve(int blocks) {
		int stairs = 0;
		while (blocks != 0) {
			if (stairs + 1 <= blocks) {
				stairs++;
				blocks = blocks - stairs;
			} else {
				break;
			}
		}
		return stairs;
	}
}
