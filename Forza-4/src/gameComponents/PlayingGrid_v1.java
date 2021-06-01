package gameComponents;


/**
 * This class models a playing grid for Connect Four.
 * The playing grid is a seven-column, six-rows grid in which colored discs can be inserted during the game.
 * @author lucia
 *
 */
public class PlayingGrid_v1 {
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
	public PlayingGrid_v1() {
		playingGrid = new ColoredDisc[ROWS][COLUMNS];
		freeSpaces = ROWS*COLUMNS;
		for(int i = 0; i<ROWS; i++) {
			for(int j = 0; j<COLUMNS; j++) {
				playingGrid[i][j] = null;
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
	 * This method checks if the move that has just been played is a valid move: a move is valid if the column
	 * in which the player wants to put the colored disc has at least a free space
	 * @param columnIndex The index of the column in which the player wants to put the colored disc
	 * @return The outcome of the check: true if the column has at least a free space, false otherwise
	 */
	public boolean isAValidMove(int rowIndex, int columnIndex) {
		if(playingGrid[rowIndex][columnIndex] == null) return true;
		else return false;
	}
	
	
	/**
	 * This methods is used to add a colored disc into the playing grid; at the beginning the methods checks if the
	 * move is valid through a call to the isAValidMove method: if the move is valid then the method add the disc into the 
	 * specified position and then update the number of free spaces in the grid through a call to the updateGrid method; if
	 * the move is not valid it calls an exception
	 * @param disc The colored disc to be added into the playing grid
	 */
	public void addColoredDisc(ColoredDisc disc) {
		if(isAValidMove(disc.getRow(), disc.getColumn())) {
			playingGrid[disc.getRow()][disc.getColumn()] = disc;
			updateGrid();
		}
		else System.out.println("Space already occupied");
	}
	
	
}
