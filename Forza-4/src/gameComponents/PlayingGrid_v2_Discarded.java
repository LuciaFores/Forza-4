package gameComponents;


/**
 * This class models a playing grid for Connect Four.
 * The playing grid is a seven-column, six-rows grid in which colored discs can be inserted during the game.
 * @author lucia
 *
 */
public class PlayingGrid_v2_Discarded {
	// Instance Variables
	
	/* 
	 * The grid can only be a seven-columns, six-rows grid so both the number of rows and the number of columns
	 * are final.
	 */
	final int ROWS = 6;
	final int COLUMNS = 7;
	
	/* 
	 * The playing grid will be a grid of String objects (each cell will contain the description of what is present in the cell)
	 * so it's modeled as a bidimensional array (a matrix) of String objects 
	 */
	private String[][] playingGrid;
	
	/* 
	 * During a game a playing grid will have some cells occupied while others are still free; due to the necessity
	 * of checking if the grid still has at least a free space (if it's all occupied it's game over) this
	 * variable takes account of the free spaces still available in the playing grid
	 */
	private int freeSpaces;
	
	/*
	 * A cell of the playing grid can have only two status: "free" if a ColoredDisc is not in the cell,
	 * "red"/"yellow" if a ColoredDisc is in the cell; at the beginning of the game every cell is "free"
	 */
	private String spaceStatus;
	
	
	// Methods
	
	/**
	 * The class constructor: it creates a new playing grid for a new game; the playing grid as soon as it's
	 * created it's just a grid of ColoredDisc objects completely empty.
	 */
	public PlayingGrid_v2_Discarded() {
		playingGrid = new String[ROWS][COLUMNS];
		freeSpaces = ROWS*COLUMNS;
		for(int i = 0; i<ROWS; i++) {
			for(int j = 0; j<COLUMNS; j++) {
				playingGrid[i][j] = "free";
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
	 * This methods is used to get the current status of a cell of the playing grid: to get the status of a cell
	 * the methods needs the coordinates of the cell
	 * @param rowIndex x-coordinate of the cell in the grid
	 * @param columnIndex y-coordinate of the cell in the grid
	 * @return The status of the cell: it can be "free" or one of "red" or "yellow" if a colored disc has been 
	 * put there by a player
	 */
	public String getSpaceStatus(int rowIndex, int columnIndex) {
		spaceStatus = playingGrid[rowIndex][columnIndex];
		return spaceStatus;
	}
	
	/**
	 * This method is used whenever a valid move is made by a player: in fact, if a move is valid a cell in the
	 * playing grid will be occupied and so there will be one free space less left in the playing grid
	 */
	public void UpdateGrid() {
		freeSpaces -= 1;
	}
	
	/**
	 * This methods checks if a column still has at least a free space left; in order to control that the 
	 * method checks if the cell at the top of the column is free or occupied.
	 * @param columnIndex The index of the column in which a player want to insert a colored disc
	 * @return true if the column still has at least a free space, false otherwise
	 */
	public boolean hasColumnAFreeSpace(int columnIndex) {
		if(this.getSpaceStatus(0, columnIndex).equals("free")) return true;
		else return false;
	}
	
}
