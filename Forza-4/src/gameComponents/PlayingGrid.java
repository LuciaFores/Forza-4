package gameComponents;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * This class models a playing grid for Connect Four.
 * The playing grid is a seven-column, six-rows grid in which colored discs can be inserted during the game.
 * @author lucia
 *
 */
public class PlayingGrid {
	// Instance Variables
	
	/* 
	 * The grid can only be a seven-columns, six-rows grid so both the number of rows and the number of columns
	 * are final.
	 */
	final int ROWS = 6;
	final int COLUMNS = 7;
	
	/* 
	 * The playing grid will be a grid of Disc objects (each cell will contain a colored disc) so it's modeled
	 * as a bidimensional array (a matrix) of ColoredDisc objects 
	 */
	private ColoredDisc[][] playingGrid;
	
	/* 
	 * During a game a playing grid will have some cells occupied while others are still free; due to the necessity
	 * of checking if the grid still has at least a free space (if it's all occupied it's game over) this
	 * variable takes account of the free spaces still available in the playing grid
	 */
	private int freeSpaces;
	
	
	// Methods
	
	/**
	 * The class constructor: it creates a new playing grid for a new game; the playing grid as soon as it's
	 * created it's just a grid of ColoredDisc objects completely empty.
	 */
	public PlayingGrid() {
		playingGrid = new ColoredDisc[ROWS][COLUMNS];
		freeSpaces = ROWS*COLUMNS;
		for(int i = 0; i<ROWS; i++) {
			for(int j = 0; j<COLUMNS; j++) {
				playingGrid[i][j] = null;
			}
		}
	}
	
	
	public PlayingGrid(String saveFile) {
		playingGrid = new ColoredDisc[ROWS][COLUMNS];
		freeSpaces = ROWS*COLUMNS;
		int[][] integerPlayingGrid = LoadJSONPlayingGridToIntegerPlayingGrid(saveFile);
		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLUMNS; j++) {
				if(integerPlayingGrid[i][j] == -1)
					playingGrid[i][j] = null;
				else if(integerPlayingGrid[i][j] == 0)
					playingGrid[i][j] = new ColoredDisc("red", i, j);
				else if(integerPlayingGrid[i][j] == 1)
					playingGrid[i][j] = new ColoredDisc("yellow", i, j);
			}
		}
	}
	
	/**
	 * This method is used to get the current value of the free spaces available in the playing grid
	 * @return Current value of freeSpaces, the counter that takes account of the free spaces available in the
	 * playing grid
	 */
	public int getFreeSpaces() {
		return freeSpaces;
	}
	
	/**
	 * This method is used whenever a valid move is made by a player: in fact, if a move is valid a cell in the
	 * playing grid will be occupied and so there will be one free space less left in the playing grid
	 */
	public void updateGrid() {
		freeSpaces -= 1;
	}
	
	
	/**
	 * This method is used to add a disc into the playing grid: the method will find the correct row
	 * in which the disc must be insert.
	 * The idea on which the method is build is the fact that when the disc is inserted in a column, this
	 * will go down until it finds the end of the grid or the last occupied cell
	 * @param disc The colored disc that the player wants to add into the playing grid
	 * @return The boolean value added: it will be true if the player managed to insert the disc into the
	 * playing grid, false if the player tried to insert the grid into a column that is full
	 */
	public boolean addColoredDisc(ColoredDisc disc) {
		boolean added = false;
		int row = 0;
		if(playingGrid[row][disc.getColumn()] == null) {
			for(int i = 0; i < ROWS; i++) {
				if(playingGrid[i][disc.getColumn()] == null) {
					row = Math.max(row, i);
					disc.setRow(row);
				}
			}
			playingGrid[row][disc.getColumn()] = disc;
			updateGrid();
			added = true;
		}
		else System.out.println("Column already totally occupied");
		return added;
	}
	
	
	
	/**
	 * This method is used to check if there are four vertical aligned discs with the same color.
	 * The method checks if the three discs that are underneath the one that has just been inserted exist
	 * and have the same color of the one that is passed as an argument: if it finds them it set the boolean
	 * value aligned as true.
	 * @param disc The last inserted colored disc
	 * @return The boolean value aligned that it will be true if there are four discs aligned with the same
	 * color, false otherwise.
	 */
	public boolean areFourVerticalAligned(ColoredDisc disc){
		boolean aligned = false;
		if(disc.getRow() < 3) {
			for(int i = 1; i < 4; i++) {
				if(playingGrid[disc.getRow() + i][disc.getColumn()] == null || 
						!playingGrid[disc.getRow() + i][disc.getColumn()].getDiscColor()
						.equals(disc.getDiscColor())) {
					aligned = false;
					break;
				}
				else
					aligned = true;
			}
		}
		return aligned;
	}
	
	
	/**
	 * This method is used to check if there are four horizontally right aligned discs with the same color.
	 * The method checks if the three discs to the right to the last inserted disc have the same color
	 * to the disc passed as an argument: if it finds them it will set the boolean value aligned as true.
	 * @param disc The last inserted colored disc
	 * @return The boolean value aligned that will be true if there are four discs aligned with the same
	 * color, false otherwise.
	 */
	public boolean areFourHorizontallyRightAligned(ColoredDisc disc){
		boolean aligned = false;
		if(disc.getColumn() < 4) {
			for(int i = 1; i < 4; i++) {
				if(playingGrid[disc.getRow()][disc.getColumn() + i] == null ||
						!playingGrid[disc.getRow()][disc.getColumn() + i].getDiscColor()
						.equals(disc.getDiscColor())) {
					aligned = false;
					break;
				}
				else 
					aligned = true;
			}
		}
		return aligned;
	}
	
	/**
	 * This method is used to check if there are four horizontally right aligned discs with the same color.
	 * The method checks if the three discs to the left to the last inserted disc have the same color
	 * to the disc passed as an argument: if it finds them it will set the boolean value aligned as true.
	 * @param disc The last inserted colored disc
	 * @return The boolean value aligned that will be true if there are four discs aligned with the same
	 * color, false otherwise.
	 */
	public boolean areFourHorizontallyLeftAligned(ColoredDisc disc){
		boolean aligned = false;
		if(disc.getColumn() >= 3) {
			for(int i = 1; i < 4; i++) {
				if(playingGrid[disc.getRow()][disc.getColumn() - i] == null ||
						!playingGrid[disc.getRow()][disc.getColumn() - i].getDiscColor()
						.equals(disc.getDiscColor())) {
					aligned = false;
					break;
				}
				else 
					aligned = true;
			}
		}
		return aligned;
	}
	
	/**
	 * This method is used to check if there are four discs left diagonally aligned.
	 * The left diagonal is the one that goes from top-left to bottom-right.
	 * The method checks, where possible, if the three discs above and underneath the one that has just
	 * been inserted exists and have the same color as the one passed as an argument: if it finds them it
	 * will set the boolean value aligned as true.
	 * @param disc The last inserted colored disc.
	 * @return The boolean value aligned that will be true if there are four discs aligned with the same
	 * color, false otherwise.
	 */
	public boolean[] areFourDiagonallyLeftAligned(ColoredDisc disc){
		boolean[] aligned = new boolean[2];
		boolean alignedBottom = false;
		boolean alignedTop = false;
		if(disc.getRow()+3 < ROWS) {
			for(int i = disc.getRow()+1; i < disc.getRow()+4; i++) {
				int j = disc.getColumn() + Math.abs(disc.getRow()-i);
				if(j < COLUMNS) {
					if(playingGrid[i][j] == null || !playingGrid[i][j].getDiscColor()
							.equals(disc.getDiscColor())) {
						alignedBottom = false;
						break;
					}
					else
						alignedBottom = true;
				}
				else {
					alignedBottom = false;
					break;
				}
			}
		}
		if(disc.getRow()-3 >= 0) {
			for(int i = disc.getRow()-1; i > disc.getRow()-4; i--) {
				int j = disc.getColumn() - Math.abs(disc.getRow()-i);
				if(j >= 0) {
					if(playingGrid[i][j] == null || !playingGrid[i][j].getDiscColor()
							.equals(disc.getDiscColor())) {
						alignedTop = false;
						break;
					}
					else
						alignedTop = true;
				}
				else {
					alignedTop = false;
					break;
				}
			}	
		}
		aligned[0] = alignedBottom;
		aligned[1] = alignedTop;
		return aligned;
	}
	
	
	/**
	 * This method is used to check if there are four discs right diagonally aligned.
	 * The left diagonal is the one that goes from top-right to bottom-left.
	 * The method checks, where possible, if the three discs above and underneath the one that has just
	 * been inserted exists and have the same color as the one passed as an argument: if it finds them it
	 * will set the boolean value aligned as true.
	 * @param disc The last inserted colored disc.
	 * @return The boolean value aligned that will be true if there are four discs aligned with the same
	 * color, false otherwise.
	 */
	public boolean[] areFourDiagonallyRightAligned(ColoredDisc disc){
		boolean[] aligned = new boolean[2];
		boolean alignedBottom = false;
		boolean alignedTop = false;
		if(disc.getRow()+3 < ROWS) {
			for(int i = disc.getRow()+1; i < disc.getRow()+4; i++) {
				int j = disc.getColumn() - Math.abs(disc.getRow()-i);
				if(j >= 0) {
					if(playingGrid[i][j] == null || !playingGrid[i][j].getDiscColor()
							.equals(disc.getDiscColor())) {
						alignedBottom = false;
						break;
					}
					else
						alignedBottom = true;
				}
				else {
					alignedBottom = false;
					break;
				}
			}
		}
		if(disc.getRow()-3 >= 0) {
			for(int i = disc.getRow()-1; i > disc.getRow()-4; i--) {
				int j = disc.getColumn() + Math.abs(disc.getRow()-i);
				if(j < COLUMNS) {
					if(playingGrid[i][j] == null || !playingGrid[i][j].getDiscColor()
							.equals(disc.getDiscColor())) {
						alignedTop = false;
						break;
					}
					else
						alignedTop = true;
				}
				else {
					alignedTop = false;
					break;
				}
			}
		}
		aligned[0] = alignedBottom;
		aligned[1] = alignedTop;
		return aligned;
	}
	
	
	/**
	 * The method is used to check if the last played move is the a move that let the player win.
	 * It finds, if they exist, the colored discs aligned with the one that has just been insert in all
	 * the directions in which is possible to find four discs connected (vertical, horizontal and the two
	 * diagonals).
	 * @param rowIndex The index of the row in which the last insert disc has been put
	 * @param columnIndex The index of the column in which the last insert disc has been put
	 * @return The boolean value win: it will be true if there are four aligned discs with the same color,
	 * false otherwise
	 */
	public boolean isTheWinningMove(int rowIndex, int columnIndex) {
		// Winning conditions has to be checked
		/* 
		 * Vertical win; it can only be applied to row 0, 1, 2 because these are the only rows that 
		 * makes possible to have four colored discs stacked
		 */
		if(areFourVerticalAligned(playingGrid[rowIndex][columnIndex])) {
			System.out.println("vertical");
			return true;
		}
		/*
		 * Horizontal win; this type of win can be achieved if we have colored discs aligned to the right
		 * or to the left, so this part of the method will be split in two
		 */
		// Right aligned colored discs
		if(areFourHorizontallyRightAligned(playingGrid[rowIndex][columnIndex])) {
			System.out.println("horizontal right");
			return true;
		}
		// Left aligned colored discs
		if(areFourHorizontallyLeftAligned(playingGrid[rowIndex][columnIndex])) {
			System.out.println("horizontal left");
			return true;
		}
		/*
		 *  Diagonal aligned colored discs: note that there are two diagonal passing through the point in
		 *  which the last colored disc has been inserted.
		 */
		// Here we want to check if there are at least four elements in the left diagonal
		boolean[] diagonallyLeftAligned = areFourDiagonallyLeftAligned(playingGrid[rowIndex][columnIndex]);
		boolean diagonallyLeftAlignedBottom = diagonallyLeftAligned[0];
		boolean diagonallyLeftAlignedTop = diagonallyLeftAligned[1];
		//Checks if there are bottom aligned disc
		if(diagonallyLeftAlignedBottom) {
			System.out.println("diagonal left bottom");
			return true;
		}
		//Checks if there are top aligned disc
		if(diagonallyLeftAlignedTop) {
			System.out.println("diagonal left top");
			return true;
		}	
		// Here we want to check if there are at least four elements in the right diagonal
		boolean[] diagonallyRightAligned = areFourDiagonallyRightAligned(playingGrid[rowIndex][columnIndex]);
		boolean diagonallyRightAlignedBottom = diagonallyRightAligned[0];
		boolean diagonallyRightAlignedTop = diagonallyRightAligned[1];
		//Checks if there are bottom aligned disc
		if(diagonallyRightAlignedBottom) {
			return true;
		}
		//Checks if there are top aligned disc
		if(diagonallyRightAlignedTop) {
			return true;
		}
		//If we don't have four aligned colored disc in any of the configuration above then the move played
		// is not the winning move
		return false;
	}
	
	
	/**
	 * This method is used to check if the game ended with a tie (the playing grid is full but there aren't
	 * four discs with the same color connected).
	 * @return true if the playing grid is full so it's a tie, false otherwise
	 */
	public boolean isItATie() {
		if(freeSpaces == 0) {
			System.out.println("Sorry it's a tie");
			return true;
		}
			
		else
			return false;
	}
	
	
	/**
	 * This method is used to print the playing grid.
	 * Each cell of the grid is delimited by | and -, the cells are numbered (the rows are from 0 to 5 and
	 * the columns are from 0 to 6), and in each cell there will be a free space if a disc is not in the 
	 * cell, a O if a red disc is in the cell and a X in a yellow disc is in the cell.
	 */
	public void playingGridPrinter() {
		System.out.println("    - - - - - - -");
		int c = 0;
		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLUMNS; j++) {
				if(j == 0) {
					System.out.print(c + "  |");
					c++;
				}
				if(playingGrid[i][j] == null)
				System.out.print(" |");
				else {
					if(playingGrid[i][j].getDiscColor().equals("red"))
						System.out.print("O|");
					else if(playingGrid[i][j].getDiscColor().equals("yellow"))
						System.out.print("X|");
				}
			}
			System.out.println();
			if(i == ROWS-1) {
				System.out.println("    - - - - - - -");
				System.out.println("    0 1 2 3 4 5 6");
			}
			else
				System.out.println("    - - - - - - -");
		}
		
	}
	
	// traduzioni
	
	/**
	 * This method is used to convert a ColoredDisc matrix into an Integer matrix so that it can be
	 * easily saved into a JSON file for saving.
	 * The matrix will be converted as it follows:
	 * - cells in which there isn't a disc (they contain the value null) will be converted in -1;
	 * - cells in which there is a red disc will be converted in 0;
	 * - cells in which there is a yellow disc will be converted in 1;
	 * @return JSONPlayingGrid The playing grid converted into an Integer matrix
	 */
	public int[][] playingGridToJSONPlayingGrid() {
		int[][] JSONPlayingGrid = new int[ROWS][COLUMNS];
		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLUMNS; j++) {
				if(playingGrid[i][j] == null)
					JSONPlayingGrid[i][j] = -1;
				else if(playingGrid[i][j].getDiscColor().equals("red"))
					JSONPlayingGrid[i][j] = 0;
				else if(playingGrid[i][j].getDiscColor().equals("yellow"))
					JSONPlayingGrid[i][j] = 1;
			}
		}
		return JSONPlayingGrid;
	}
	
	
	public int[][] LoadJSONPlayingGridToIntegerPlayingGrid(String saveFile){
		JSONParser parser = new JSONParser();
		try {
			JSONObject JSONPlayingGrid = (JSONObject)parser.parse(new FileReader("SavedFiles/" + saveFile));
			int[][] integerPlayingGrid = new int[ROWS][COLUMNS];
			String[] firstRow = JSONPlayingGrid.get("firstRow").toString().split("[\\[,\\]]");
			String[] secondRow = JSONPlayingGrid.get("secondRow").toString().split("[\\[,\\]]");
			String[] thirdRow = JSONPlayingGrid.get("thirdRow").toString().split("[\\[,\\]]");
			String[] fourthRow = JSONPlayingGrid.get("fourthRow").toString().split("[\\[,\\]]");
			String[] fifthRow = JSONPlayingGrid.get("fifthRow").toString().split("[\\[,\\]]");
			String[] sixthRow = JSONPlayingGrid.get("sixthRow").toString().split("[\\[,\\]]");
			
			for(int j = 0; j < COLUMNS; j++) {
				integerPlayingGrid[0][j] = Integer.parseInt(firstRow[j+1]);
				integerPlayingGrid[1][j] = Integer.parseInt(secondRow[j+1]);
				integerPlayingGrid[2][j] = Integer.parseInt(thirdRow[j+1]);
				integerPlayingGrid[3][j] = Integer.parseInt(fourthRow[j+1]);
				integerPlayingGrid[4][j] = Integer.parseInt(fifthRow[j+1]);
				integerPlayingGrid[5][j] = Integer.parseInt(sixthRow[j+1]);
			}
			return integerPlayingGrid;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	// salvataggio e caricamento
	public void savingPlayingGrid(FileWriter saveFile, int[][] JSONPlayingGrid) {
		JSONObject savedGrid = new JSONObject();
		JSONObject playingMatrix = new JSONObject();
		JSONArray firstRow = new JSONArray();
		JSONArray secondRow = new JSONArray();
		JSONArray thirdRow = new JSONArray();
		JSONArray fourthRow = new JSONArray();
		JSONArray fifthRow = new JSONArray();
		JSONArray sixthRow = new JSONArray();
		
		for(int j = 0; j < COLUMNS; j++) {
			firstRow.add(JSONPlayingGrid[0][j]);
			secondRow.add(JSONPlayingGrid[1][j]);
			thirdRow.add(JSONPlayingGrid[2][j]);
			fourthRow.add(JSONPlayingGrid[3][j]);
			fifthRow.add(JSONPlayingGrid[4][j]);
			sixthRow.add(JSONPlayingGrid[5][j]);
		}
		
		playingMatrix.put("firstRow", firstRow);
		playingMatrix.put("secondRow", secondRow);
		playingMatrix.put("thirdRow", thirdRow);
		playingMatrix.put("fourthRow", fourthRow);
		playingMatrix.put("fifthRow", fifthRow);
		playingMatrix.put("sixthRow", sixthRow);
		
		savedGrid.put("playingGrid", playingMatrix);
		
		try {
			saveFile.write(savedGrid.toString());
			saveFile.flush();
			//saveFile.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
