package gameComponents;

import java.util.ArrayList;

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
	//RIVEDI CHE CI SONO PROBLEMI PRATICAMENTE DEVI AGGIUNGERE UN CONTROLLO PER VEDERE CHE LA PEDINA VENGA
	//INSERITA NELLA CELLA GIUSTA OSSIA CHE SE SOTTO NON CI STA UNA PEDINA ALLORA SCENDE SE NO SI FERMA ALLA
	//CELLA INDICATA
	public void addColoredDisc(ColoredDisc disc) {
		if(isAValidMove(disc.getRow(), disc.getColumn())) {
			playingGrid[disc.getRow()][disc.getColumn()] = disc;
			updateGrid();
		}
		else System.out.println("Space already occupied");
	}
	
	
	// AGGIUNGI JAVADOC
		public ArrayList<ArrayList<Integer>> getPlayingGridDiagonals(int rowIndex, int columnIndex) {
			ArrayList<Integer> leftDiagonal = new ArrayList<Integer>();
			ArrayList<Integer> rightDiagonal = new ArrayList<Integer>();
			
			for(int i = 0; i < ROWS; i++) {
				if(i < rowIndex) {
					int j = columnIndex - Math.abs(rowIndex - i);
					if(j >= 0) {
						leftDiagonal.add(i);
						leftDiagonal.add(j);
					}
					j = columnIndex + Math.abs(rowIndex - i);
					if(j < COLUMNS) {
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
					j = columnIndex + Math.abs(rowIndex - 1);
					if(j < COLUMNS) {
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
	
	
	/*
	 * AGGIUNGI JAVADOC
	 */
	public boolean isTheWinningMove(int rowIndex, int columnIndex) {
		boolean win = false;
		// Winning conditions has to be checked
		
		/* 
		 * Vertical win; it can only be applied to row 0, 1, 2 because these are the only rows that 
		 * makes possible to have four colored discs stacked
		 */
		if(rowIndex < 3) {
			for(int i = 0; i < 4; i++) {
				if(playingGrid[rowIndex + i][columnIndex].getDiscColor()
						.equals(playingGrid[rowIndex][columnIndex].getDiscColor()))
					win = true;
				else 
					win = false;
			}
		}
		if (win)
			return true;
		
		/*
		 * Horizontal win; this type of win can be achieved if we have colored discs aligned to the right
		 * or to the left, so this part of the method will be split in two
		 */
		// Right aligned colored discs
		if(columnIndex < 4) {
			for(int i = 0; i < 4; i++) {
				if(playingGrid[rowIndex][columnIndex + i].getDiscColor()
						.equals(playingGrid[rowIndex][columnIndex].getDiscColor()))
					win = true;
				else
					win = false;
			}
		}
		if (win)
			return true;
		
		// Left aligned colored discs
		if(columnIndex >= 3) {
			for(int i = 0; i < 4; i++) {
				if(playingGrid[rowIndex][columnIndex - i].getDiscColor()
						.equals(playingGrid[rowIndex][columnIndex].getDiscColor()))
					win = true;
				else
					win = false;
			}
		}
		if(win)
			return true;
		
		/*
		 *  Diagonal aligned colored discs: there are two diagonal passing through the point in which the
		 *  last colored disc has been inserted.
		 *  We will use a method to find the two diagonals and then we compute the checks to see if there are
		 *  four colored discs aligned
		 */
		
		// Finding the diagonals
		ArrayList<ArrayList<Integer>> diagonals = getPlayingGridDiagonals(rowIndex, columnIndex);
		
		ArrayList<Integer> leftDiagonal = diagonals.get(0);
		ArrayList<Integer> rightDiagonal = diagonals.get(1);
		
		// Here we want to check if there are at least four elements in the left diagonal: if it has then 
		// we will check if there are four aligned colored disc
		if(leftDiagonal.size()/2 >= 4) {
			for(int i = 0; i < leftDiagonal.size(); i = i+2) {
				int row = leftDiagonal.get(i);
				int col = leftDiagonal.get(i+1);
				if(playingGrid[row][col].getDiscColor()
						.equals(playingGrid[rowIndex][columnIndex].getDiscColor()))
					win = true;
				else
					win = false;
			}
			if(win)
				return true;
		}
		
		// Here we want to check if there are at least four elements in the right diagonal: if it has then 
		// we will check if there are four aligned colored disc
		if(rightDiagonal.size()/2 >= 4) {
			for(int i = 0; i < rightDiagonal.size(); i = i+2) {
				int row = rightDiagonal.get(i);
				int col = rightDiagonal.get(i+1);
				if(playingGrid[row][col].getDiscColor()
						.equals(playingGrid[rowIndex][columnIndex].getDiscColor()))
					win = true;
				else
					win = false;
			}
			if(win)
				return true;
		}
		
		//If we don't have four aligned colored disc in any of the configuration above then the move played
		// is not the winning move
		return false;
	}
	
	
	// il metodo viene chiamato dopo il controllo se la mossa era vincente per controllare che non sia un pareggio
	//AGGIUNGI JAVADOC
	public boolean isItATie() {
		if(freeSpaces == 0)
			return true;
		else
			return false;
	}
	
	
}
