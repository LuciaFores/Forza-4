package gameComponents;


/**
 * This class models a playing grid for Connect Four.
 * The playing grid is a seven-column, six-rows grid in which colored discs can be inserted during the game.
 * @author lucia
 *
 */
public class PlayingGrid_v1 {
	// Instance Variables
	
	/* The grid can only be a seven-columns, six-rows grid so both the number of rows and the number of columns
	 * are final.
	 */
	final int ROWS = 6;
	final int COLUMNS = 7;
	
	/* The playing grid will be a grid of Disc objects (each cell will contain a colored disc) so it's modeled
	 * as a bidimensional array (a matrix) of Disc objects 
	 */
	private ColoredDisc[][] playingGrid;
	
	/* During a game a playing grid will have some cells occupied while others are still free; due to the necessity
	 * of checking if the grid still has at least a free space (if it's all occupied it's game over) this
	 * variable takes account of the free spaces still available in the playing grid
	 */
	private int freeSpaces;
	
	
	// Methods
	
	/**
	 * The class constructor: it creates a new playing grid for a new game; the playing grid as soon as it's
	 * created it's just a grid of ColoredDisc objects completely empty.
	 */
	public PlayingGrid_v1() {
		playingGrid = new ColoredDisc[ROWS][COLUMNS];
		freeSpaces = ROWS*COLUMNS;
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
	public void UpdateGrid() {
		freeSpaces -= 1;
	}
	
	/**
	 * This method checks if a column of the playing grid has been completely occupied.
	 * Note that the rowIndex will be the row in which a ColoredDisc will be placed
	 * @param rowIndex The index of the row in which it has just been placed a Disc by a player
	 * @return The result of the check: true if the column still has at least a free space, false otherwise.
	 */
	public boolean hasColumnAFreeSpace(int rowIndex) {
		if(rowIndex != 0) return true;
		else return false;
	}
	
}
