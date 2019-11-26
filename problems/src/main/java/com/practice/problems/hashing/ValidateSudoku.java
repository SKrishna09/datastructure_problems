package com.practice.problems.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ValidateSudoku {
	
	 /*Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx 
	 The Sudoku board could be partially filled, where empty cells are filled with the character ‘.’.
	 
	 The input corresponding to the above configuration :
	 ["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
	 A partially filled sudoku which is valid.
	 
	 Note:
	 A valid Sudoku board (partially filled) is not necessarily solvable. 
	 Only the filled cells need to be validated.
	 Return 0 / 1 ( 0 for false, 1 for true ) for this problem*/
	 

	public static void main(String[] args) {
		String[] sudoku = { "53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1",
				"7...2...6", ".6....28.","...419..5", "....8..79" };
		String[] sudoku1 = {"..4...63.", ".........", "5......9.", "...56....", "4.3.....1", 
				"...7.....", "...5.....", ".........", "........." };
		int isValid = isValidSudoku(sudoku);
		String message = isValid == 1 ? "Valid" : "InValid";
		System.out.println("Sudoku is " + message);
	}

	public static int isValidSudoku(String[] A) {
		Map<Integer, ArrayList<Character>> row = new HashMap<>();
		Map<Integer, ArrayList<Character>> column = new HashMap<>();
		Map<Integer, ArrayList<Character>> box = new HashMap<>();

		int isValid = 1;
		//ROW computation
		for (int i = 0; i < A.length; i++) {
			String input = A[i];
			char[] B = input.toCharArray();
			ArrayList<Character> rowList = new ArrayList<>();
			for (int k = 0; k < B.length; k++) {
				char val = B[k];
				if (val != '.') {
					if (rowList.contains(val))
						return 0;
					else
						rowList.add(val);
				}
			}
			row.put(i, rowList);
			
			//COLUMN computation
			for (int j = 0; j < B.length; j++) {
				ArrayList<Character> columnList;
				if (column.containsKey(j)) {
					columnList = column.get(j);
				} else {
					columnList = new ArrayList<>();
				}
				char val1 = B[j];
				if (val1 != '.') {
					if (columnList.contains(val1))
						return 0;
					else
						columnList.add(val1);
				}
				column.put(j, columnList);

				//BOX computation
				int boxIndex = i / 3 * 3 + j / 3;
				ArrayList<Character> boxList;
				if (box.containsKey(boxIndex)) {
					boxList = box.get(boxIndex);
				} else {
					boxList = new ArrayList<>();
				}
				
				if (val1 != '.') {
					if (boxList.contains(val1))
						return 0;
					else
						boxList.add(val1);
				}
				box.put(boxIndex, boxList);
			}
		}
		return isValid;
	}
}
