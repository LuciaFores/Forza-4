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
	 * This method will check if a point in which a colored disc has been put is a point of the grid
	 * (maybe useless or maybe useful for a stress test?)
	 * @param rowIndex The x-coordinate of the point in which the disc has been put
	 * @param columnIndex The y-coordinate of the point in which the disc has been put
	 * @return The outcome of the check: true if the point in which the disc has been put is legale, false otherwise
	 */
	public boolean isALegalPoint(int rowIndex, int columnIndex) {
		if((rowIndex >= 0 && rowIndex <= 5) && (columnIndex >= 0 && columnIndex <= 5)) return true;
		else return false;
	}
}
