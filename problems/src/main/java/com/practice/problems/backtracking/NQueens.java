package com.practice.problems.backtracking;

import java.util.ArrayList;

public class NQueens {

	public static void main(String[] args) {
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		int[][] visited = new int[4][4];
		_SolveNQueens(0, 4, result, visited);

		System.out.println("DONE");
	}

	public static void _SolveNQueens(int currentRow, int n, ArrayList<ArrayList<String>> result, int[][] visited) {
		if (n == currentRow) {
			ArrayList<String> ans = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				String s = new String();
				for (int j = 0; j < n; j++) {
					int value = visited[i][j];
					if (1 == value) {
						s += "Q";
					} else {
						s += ".";
					}
				}
				ans.add(s);
			}
			result.add(ans);
			return;
		}
		for (int j = 0; j < n; j++) {
			if (isValidMove(n, currentRow, j, visited)) {
				visited[currentRow][j] = 1;
				_SolveNQueens(currentRow + 1, n, result, visited);
				visited[currentRow][j] = 0;
			}
		}
	}

	public static boolean isValidMove(int n, int i, int j, int[][] visited) {
		boolean isValid = false;
		// up
		for (int k = i - 1; k >= 0; k--) {
			int value = visited[k][j];
			if (1 == value)
				return isValid;
		}
		// diagonal1
		int k = i-1;
		int l = j-1;
		while(k >= 0 && l >= 0) {
			int value = visited[k][l];
			if (1 == value)
				return isValid;
			if(k == 0 || l == 0)
				break;
			k--;
			l--;
		}
		
		// diagonal2
		int x = i-1;
		int y = j+1;
		while(x >= 0 && y < n) {
			int value = visited[x][y];
			if (1 == value)
				return isValid;
			if(x == 0 || y == (n-1))
				break;
			x--;
			y++;
		}
		
		if (i == 0 && j == 0) {
			return true;
		}
		return true;
	}

}
