package gameComponents;

import java.util.ArrayList;

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
	 * AGGIORNA
	 * This methods is used to add a colored disc into the playing grid; at the beginning the methods checks if the
	 * move is valid through a call to the isAValidMove method: if the move is valid then the method add the disc into the 
	 * specified position and then update the number of free spaces in the grid through a call to the updateGrid method; if
	 * the move is not valid it calls an exception
	 * @param disc The colored disc to be added into the playing grid
	 */
	public boolean addColoredDisc(ColoredDisc disc) {
		// at first we need to find the row in which we will put the disc
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
	
	
	/*
	 * AGGIUNGI JAVADOC
	 * CREA UNA FUNZIONE ARETHEREFOURALIGNED CHE VEDE PRIMA SE CI SONO QUATTRO PEDINE ALLINEATE E POI NE
	 * CONTROLLA IL COLORE SE NO NON FA NEANCHE I CONTROLLI
	 */
	public boolean isTheWinningMove(int rowIndex, int columnIndex) {
		boolean win = false;
		// Winning conditions has to be checked
		
		/* 
		 * Vertical win; it can only be applied to row 0, 1, 2 because these are the only rows that 
		 * makes possible to have four colored discs stacked
		 */
		ArrayList<Integer> verticalAligned = areFourVerticalAligned(playingGrid[rowIndex][columnIndex]);
		if(!verticalAligned.isEmpty()) {
			for(int i = 0; i < verticalAligned.size(); i = i+2) {
				int row = verticalAligned.get(i);
				int col = verticalAligned.get(i+1);
				if(playingGrid[row][col].getDiscColor()
						.equals(playingGrid[rowIndex][columnIndex].getDiscColor()))
					win = true;
				else
					win = false;
			}
			if(win)
				return true;
		}
		
		/*
		 * Horizontal win; this type of win can be achieved if we have colored discs aligned to the right
		 * or to the left, so this part of the method will be split in two
		 */
		// Right aligned colored discs
		ArrayList<Integer> horizontallyRightAligned = areFourHorizontallyRightAligned(playingGrid[rowIndex][columnIndex]);
		if(!horizontallyRightAligned.isEmpty()) {
			for(int i = 0; i < horizontallyRightAligned.size(); i = i+2) {
				int row = horizontallyRightAligned.get(i);
				int col = horizontallyRightAligned.get(i+1);
				if(playingGrid[row][col].getDiscColor()
						.equals(playingGrid[rowIndex][columnIndex].getDiscColor()))
					win = true;
				else
					win = false;
			}
			if(win)
				return true;
		}
		
		// Left aligned colored discs
		ArrayList<Integer> horizontallyLeftAligned = areFourHorizontallyLeftAligned(playingGrid[rowIndex][columnIndex]);
		if(!horizontallyLeftAligned.isEmpty()) {
			for(int i = 0; i < horizontallyLeftAligned.size(); i = i+2) {
				int row = horizontallyLeftAligned.get(i);
				int col = horizontallyLeftAligned.get(i+1);
				if(playingGrid[row][col].getDiscColor()
						.equals(playingGrid[rowIndex][columnIndex].getDiscColor()))
					win = true;
				else
					win = false;
			}
			if(win)
				return true;
		}
		
		/*
		 *  Diagonal aligned colored discs: note that there are two diagonal passing through the point in
		 *  which the last colored disc has been inserted.
		 */
		// Here we want to check if there are at least four elements in the left diagonal
		ArrayList<ArrayList<Integer>> diagonallyLeftAligned = areFourDiagonallyLeftAligned(playingGrid[rowIndex][columnIndex]);
		ArrayList<Integer> diagonallyLeftAlignedBottom = diagonallyLeftAligned.get(0);
		ArrayList<Integer> diagonallyLeftAlignedTop = diagonallyLeftAligned.get(1);
		//Checks if there are bottom aligned disc
		if(!diagonallyLeftAlignedBottom.isEmpty()) {
			for(int i = 0; i < diagonallyLeftAlignedBottom.size(); i = i+2) {
				int row = diagonallyLeftAlignedBottom.get(i);
				int col = diagonallyLeftAlignedBottom.get(i+1);
				if(playingGrid[row][col].getDiscColor()
						.equals(playingGrid[rowIndex][columnIndex].getDiscColor()))
					win = true;
				else
					win = false;
			}
			if(win)
				return true;
		}
		//Checks if there are top aligned disc
		if(!diagonallyLeftAlignedTop.isEmpty()) {
			for(int i = 0; i < diagonallyLeftAlignedTop.size(); i = i+2) {
				int row = diagonallyLeftAlignedTop.get(i);
				int col = diagonallyLeftAlignedTop.get(i+1);
				if(playingGrid[row][col].getDiscColor()
						.equals(playingGrid[rowIndex][columnIndex].getDiscColor()))
					win = true;
				else
					win = false;
			}
			if(win)
				return true;
		}
				
		// Here we want to check if there are at least four elements in the right diagonal
		ArrayList<ArrayList<Integer>> diagonallyRightAligned = areFourDiagonallyRightAligned(playingGrid[rowIndex][columnIndex]);
		ArrayList<Integer> diagonallyRightAlignedBottom = diagonallyRightAligned.get(0);
		ArrayList<Integer> diagonallyRightAlignedTop = diagonallyRightAligned.get(1);
		//Checks if there are bottom aligned disc
		if(!diagonallyRightAlignedBottom.isEmpty()) {
			for(int i = 0; i < diagonallyRightAlignedBottom.size(); i = i+2) {
				int row = diagonallyRightAlignedBottom.get(i);
				int col = diagonallyRightAlignedBottom.get(i+1);
				if(playingGrid[row][col].getDiscColor()
						.equals(playingGrid[rowIndex][columnIndex].getDiscColor()))
					win = true;
				else
					win = false;
			}
			if(win)
				return true;
		}
		//Checks if there are top aligned disc
		if(!diagonallyRightAlignedTop.isEmpty()) {
			for(int i = 0; i < diagonallyRightAlignedTop.size(); i = i+2) {
				int row = diagonallyRightAlignedTop.get(i);
				int col = diagonallyRightAlignedTop.get(i+1);
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
	
	
	// OKAY FUNZIONA
	public ArrayList<Integer> areFourVerticalAligned(ColoredDisc disc){
		ArrayList<Integer> aligned = new ArrayList<Integer>();
		if(disc.getRow() < 3) {
			for(int i = 1; i < 4; i++) {
				if(playingGrid[disc.getRow() + i][disc.getColumn()] == null || 
						!playingGrid[disc.getRow() + i][disc.getColumn()].getDiscColor()
						.equals(disc.getDiscColor())) {
					aligned = new ArrayList<Integer>();
					break;
				}
				else {
					aligned.add(disc.getRow() + i);
					aligned.add(disc.getColumn());
				}
			}
		}
		return aligned;
	}
	
	
	// OKAY FUNZIONA
	public ArrayList<Integer> areFourHorizontallyRightAligned(ColoredDisc disc){
		ArrayList<Integer> aligned = new ArrayList<Integer>();
		if(disc.getColumn() < 4) {
			for(int i = 1; i < 4; i++) {
				if(playingGrid[disc.getRow()][disc.getColumn() + i] == null ||
						!playingGrid[disc.getRow()][disc.getColumn() + i].getDiscColor()
						.equals(disc.getDiscColor())) {
					aligned = new ArrayList<Integer>();
					break;
				}
				else {
					aligned.add(disc.getRow());
					aligned.add(disc.getColumn() + i);
				}
			}
		}
		return aligned;
	}
	
	// OKAY FUNZIONA
	public ArrayList<Integer> areFourHorizontallyLeftAligned(ColoredDisc disc){
		ArrayList<Integer> aligned = new ArrayList<Integer>();
		if(disc.getColumn() >= 3) {
			for(int i = 1; i < 4; i++) {
				if(playingGrid[disc.getRow()][disc.getColumn() - i] == null ||
						!playingGrid[disc.getRow()][disc.getColumn() - i].getDiscColor()
						.equals(disc.getDiscColor())) {
					aligned = new ArrayList<Integer>();
					break;
				}
				else {
					aligned.add(disc.getRow());
					aligned.add(disc.getColumn() - i);
				}
			}
		}
		return aligned;
	}
	
	//OKAY FUNZIONA
	public ArrayList<ArrayList<Integer>> areFourDiagonallyLeftAligned(ColoredDisc disc){
		ArrayList<ArrayList<Integer>> aligned = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> alignedBottom = new ArrayList<Integer>();
		ArrayList<Integer> alignedTop = new ArrayList<Integer>();
		if(disc.getRow()+3 < ROWS) {
			for(int i = disc.getRow()+1; i < disc.getRow()+4; i++) {
				int j = disc.getColumn() + Math.abs(disc.getRow()-i);
				if(j < COLUMNS) {
					if(playingGrid[i][j] == null || !playingGrid[i][j].getDiscColor()
							.equals(disc.getDiscColor())) {
						alignedBottom = new ArrayList<Integer>();
						break;
					}
					else {
						alignedBottom.add(i);
						alignedBottom.add(j);
					}
				}
			}
		}
		if(disc.getRow()-3 >= 0) {
			for(int i = disc.getRow()-1; i > disc.getRow()-4; i--) {
				int j = disc.getColumn() - Math.abs(disc.getRow()-i);
				if(j >= 0) {
					if(playingGrid[i][j] == null || !playingGrid[i][j].getDiscColor()
							.equals(disc.getDiscColor())) {
						alignedTop = new ArrayList<Integer>();
						break;
					}
					else {
						alignedTop.add(i);
						alignedTop.add(j);
					}
				}
			}	
		}
		aligned.add(alignedBottom);
		aligned.add(alignedTop);
		return aligned;
	}
	
	
	//OKAY FUNZIONA
	public ArrayList<ArrayList<Integer>> areFourDiagonallyRightAligned(ColoredDisc disc){
		ArrayList<ArrayList<Integer>> aligned = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> alignedBottom = new ArrayList<Integer>();
		ArrayList<Integer> alignedTop = new ArrayList<Integer>();
		if(disc.getRow()+3 < ROWS) {
			for(int i = disc.getRow()+1; i < disc.getRow()+4; i++) {
				int j = disc.getColumn() - Math.abs(disc.getRow()-i);
				if(j >= 0) {
					if(playingGrid[i][j] == null || !playingGrid[i][j].getDiscColor()
							.equals(disc.getDiscColor())) {
						alignedBottom = new ArrayList<Integer>();
						break;
					}
					else {
						alignedBottom.add(i);
						alignedBottom.add(j);
					}
				}
			}
		}
		if(disc.getRow()-3 >= 0) {
			for(int i = disc.getRow()-1; i > disc.getRow()-4; i--) {
				int j = disc.getColumn() + Math.abs(disc.getRow()-i);
				if(j < COLUMNS) {
					if(playingGrid[i][j] == null || !playingGrid[i][j].getDiscColor()
							.equals(disc.getDiscColor())) {
						alignedTop = new ArrayList<Integer>();
						break;
					}
					else {
						alignedTop.add(i);
						alignedTop.add(j);
					}
				}
			}
		}
		aligned.add(alignedBottom);
		aligned.add(alignedTop);
		return aligned;
	}
}
