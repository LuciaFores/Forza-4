package Tests;

import java.util.ArrayList;

public class DiagonalTest {
	public static ArrayList<ArrayList<Integer>> getPlayingGridDiagonals(int rowIndex, int columnIndex) {
		ArrayList<Integer> leftDiagonal = new ArrayList<Integer>();
		ArrayList<Integer> rightDiagonal = new ArrayList<Integer>();
		
		for(int i = 0; i < 6; i++) {
			if(i < rowIndex) {
				int j = columnIndex - Math.abs(rowIndex - i);
				if(j >= 0) {
					leftDiagonal.add(i);
					leftDiagonal.add(j);
				}
				j = columnIndex + Math.abs(rowIndex - i);
				if(j < 7) {
					rightDiagonal.add(i);
					rightDiagonal.add(j);
				}
			}
			else if(i > rowIndex) {
				int j = columnIndex - Math.abs(rowIndex - i);
				if(j >= 0) {
					rightDiagonal.add(i);
					rightDiagonal.add(j);
				}
				j = columnIndex + Math.abs(rowIndex - i);
				if(j < 7) {
					leftDiagonal.add(i);
					leftDiagonal.add(j);
				}
			}
			else {
				int j = columnIndex;
				leftDiagonal.add(i);
				leftDiagonal.add(j);
				rightDiagonal.add(i);
				rightDiagonal.add(j);
			}
		}
		
		ArrayList<ArrayList<Integer>> diagonals = new ArrayList<ArrayList<Integer>>();
		
		diagonals.add(leftDiagonal);
		diagonals.add(rightDiagonal);
		
		return diagonals;
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[6][7];
		
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j< 7; j++) {
				matrix[i][j] = 0;
			}
		}
		
		ArrayList<ArrayList<Integer>> diagonals = getPlayingGridDiagonals(1,1);
		
		ArrayList<Integer> leftDiagonal = diagonals.get(0);
		ArrayList<Integer> rightDiagonal = diagonals.get(1);
		
		System.out.println("Diagonale sinistra");
		for(int i = 0; i < leftDiagonal.size(); i = i+2) {
			System.out.println("(" + leftDiagonal.get(i) + ", " + leftDiagonal.get(i+1) + ")");
		}
		
		System.out.println();
		System.out.println("Diagonale destra");
		for(int i = 0; i < rightDiagonal.size(); i = i+2) {
			System.out.println("(" + rightDiagonal.get(i) + ", " + rightDiagonal.get(i+1) + ")");
		}
		
	}
}
