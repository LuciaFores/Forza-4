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
	
	
	public ColoredDisc(String color, int rowIndex, int columnIndex) {
		discColor = color;
		row = rowIndex;
		column = columnIndex;
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
	 * This method is used to set the value of the instance variable column.
	 * The method will also checks if the column index that should be set is a legal one.
	 * @param columnIndex The value to give to the instance variable column.
	 */
	public void setColumn(int columnIndex) {
		if(columnIndex < 7)
			column = columnIndex;
		else
			System.out.println("The column doesn't exist");
	}
	
	
	/**
	 * This method is used to set the value of the instance variable row.
	 * The method will also checks if the row index that should be set is a legal one.
	 * @param rowIndex The value to give to the instance variable row.
	 */
	public void setRow(int rowIndex) {
		if(rowIndex < 6) {
			row = rowIndex;
		}
		else
			System.out.println("the row doesn't exist");
	}
	
}
