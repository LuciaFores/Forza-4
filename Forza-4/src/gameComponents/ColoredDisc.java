package gameComponents;

/**
 * This class models a colored disc for Connect Four.
 * The colored disc has different colors for each player.
 * @author lucia
 *
 */
public class ColoredDisc {
	// Instance Variables
	
	/*
	 * The color of the colored disc will change every turn because the discs have a different color for each
	 * player
	 */
	private String discColor;
	
	/*
	 * The colored disc will be put into a point of the grid: to be able to do checks on the point of the grid
	 * the index of the row and the index of the column are saved.
	 */
	private int row;
	private int column;
	
	
	// Methods
	
	/**
	 * The class constructor: it creates a new colored disc whose color is the one chose by the current player
	 * at the beginning of the game; the position is set to (-1,-1) because when the colored disc is
	 * created it's not in the grid.
	 * @param activePlayerColor The color of the discs chose by a player
	 */
	public ColoredDisc(String activePlayerColor) {
		discColor = activePlayerColor;
		row = -1;
		column = -1;
	}
	
	/**
	 * This method is used to get the color of the current colored disc
	 * @return Current value of discColor
	 */
	public String getDiscColor() {
		return discColor;
	}
	
	/**
	 * This method is used to get the index of the row in which the disc has been put
	 * @return Current index of the row
	 */
	public int getRow() {
		return row;
	}
	
	/**
	 * This method is used to get the index of the column in which the disc has been put
	 * @return Current index of the column
	 */
	public int getColumn() {
		return column;
	}
	
	/**
	 * The method is used to set the potential move that the player want to do;
	 * at first the method checks if the point of the grid in which the colored disc should be put exists: if exists sets
	 * the row index to the index given in the parameters and the column index given in the parameters, otherwise the method
	 * launch an exception
	 * @param rowMove The index of the row in which the player wants to put the colored disc
	 * @param columnMove The index of the column in which the player wants to put the colored dis pèc
	 */
	public void setColumn(int columnMove) {
		if(columnMove < 7)
			column = columnMove;
		else
			System.out.println("The column doesn't exist");
	}
	
	
	//AGGIUNGI JAVADOC
	public void setRow(int rowIndex) {
		row = rowIndex;
	}
	
}
