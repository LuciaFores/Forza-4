package testsAndDemos;

import gameComponents.ColoredDisc;
import gameComponents.PlayingGrid;

/**
 * This is a test class used to test the correctness of the methods of the PlayingGrid class
 * @author lucia
 *
 */
public class PlayingGridTest {
	public static void main(String[] args) {
		// The class will test the methods of the PlayingGrid object
		
		// A PlayingGrid is created for the test
		PlayingGrid gridTest = new PlayingGrid();
		// Since it's completely emtpy at first, printing it will result into a grid with nothing in the inside
		gridTest.playingGridPrinter();
		System.out.println("Expected");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("    1 2 3 4 5 6 7");
		
		// To be sure that the grid is empty the number of free spaces is checked
		System.out.println();
		System.out.println("There are " + gridTest.getFreeSpaces() + " free spaces in the grid");
		System.out.println("Expected: There are 42 free spaces in the grid");
		System.out.println();
		
		// Now a ColoredDisc is added into the grid in the column 1 and the number of free spaces updated is checked 
		ColoredDisc discTest_1 = new ColoredDisc("red");
		discTest_1.setColumn(1);
		gridTest.addColoredDisc(discTest_1);
		gridTest.playingGridPrinter();
		System.out.println("Expected");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   |O| | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("    1 2 3 4 5 6 7");
		System.out.println();
		System.out.println("There are " + gridTest.getFreeSpaces() + " free spaces in the grid");
		System.out.println("Expected: There are 41 free spaces in the grid");
		System.out.println();
		
		// Other two ColoredDiscs are added in the grid in the column 1 and 6 and the number of free spaces updated is checked
		ColoredDisc discTest_2 = new ColoredDisc("yellow");
		discTest_2.setColumn(1);
		gridTest.addColoredDisc(discTest_2);
		gridTest.playingGridPrinter();
		System.out.println("Expected");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   |X| | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   |O| | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("    1 2 3 4 5 6 7");
		System.out.println();
		System.out.println("There are " + gridTest.getFreeSpaces() + " free spaces in the grid");
		System.out.println("Expected: There are 40 free spaces in the grid");
		System.out.println();
		ColoredDisc discTest_3 = new ColoredDisc("red");
		discTest_3.setColumn(6);
		gridTest.addColoredDisc(discTest_3);
		gridTest.playingGridPrinter();
		System.out.println("Expected");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   |X| | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   |O| | | | |O| |");
		System.out.println("    - - - - - - -");
		System.out.println("    1 2 3 4 5 6 7");
		System.out.println();
		System.out.println("There are " + gridTest.getFreeSpaces() + " free spaces in the grid");
		System.out.println("Expected: There are 39 free spaces in the grid");
		System.out.println();
		
		// Now the column 1 will be completely filled and it will be tried to add another one ColoredDisc to the full column
		ColoredDisc discTest_4 = new ColoredDisc("yellow");
		discTest_4.setColumn(1);
		gridTest.addColoredDisc(discTest_4);
		
		ColoredDisc discTest_5 = new ColoredDisc("red");
		discTest_5.setColumn(1);
		gridTest.addColoredDisc(discTest_5);
		
		ColoredDisc discTest_6 = new ColoredDisc("yellow");
		discTest_6.setColumn(1);
		gridTest.addColoredDisc(discTest_6);
		
		ColoredDisc discTest_7 = new ColoredDisc("red");
		discTest_7.setColumn(1);
		gridTest.addColoredDisc(discTest_7);
		
		gridTest.playingGridPrinter();
		System.out.println("Expected");
		System.out.println("    - - - - - - -");
		System.out.println("   |O| | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   |X| | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   |O| | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   |X| | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   |X| | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   |O| | | | |O| |");
		System.out.println("    - - - - - - -");
		System.out.println("    1 2 3 4 5 6 7");
		System.out.println();
		System.out.println("There are " + gridTest.getFreeSpaces() + " free spaces in the grid");
		System.out.println("Expected: There are 35 free spaces in the grid");
		System.out.println();
		
		ColoredDisc discTest_8 = new ColoredDisc("yellow");
		discTest_8.setColumn(1);
		gridTest.addColoredDisc(discTest_7);
		System.out.println("Expected exception: Column already totally occupied");
		System.out.println();
		
		
		// Now grids for every configuration of win will be created
		// Vertical win
		PlayingGrid verticalWinGridTest = new PlayingGrid();
		ColoredDisc verticalDiscTest_1 = new ColoredDisc("red");
		verticalDiscTest_1.setColumn(1);
		verticalWinGridTest.addColoredDisc(verticalDiscTest_1);
		verticalWinGridTest.isTheWinningMove(verticalDiscTest_1.getRow(), verticalDiscTest_1.getColumn());
		
		ColoredDisc verticalDiscTest_2 = new ColoredDisc("red");
		verticalDiscTest_2.setColumn(1);
		verticalWinGridTest.addColoredDisc(verticalDiscTest_2);
		verticalWinGridTest.isTheWinningMove(verticalDiscTest_2.getRow(), verticalDiscTest_2.getColumn());
		
		ColoredDisc verticalDiscTest_3 = new ColoredDisc("red");
		verticalDiscTest_3.setColumn(1);
		verticalWinGridTest.addColoredDisc(verticalDiscTest_3);
		verticalWinGridTest.isTheWinningMove(verticalDiscTest_3.getRow(), verticalDiscTest_3.getColumn());
		
		ColoredDisc verticalDiscTest_4 = new ColoredDisc("red");
		verticalDiscTest_4.setColumn(1);
		verticalWinGridTest.addColoredDisc(verticalDiscTest_4);
		verticalWinGridTest.isTheWinningMove(verticalDiscTest_4.getRow(), verticalDiscTest_4.getColumn());
		System.out.println("Expected: Vertically aligned win");
		verticalWinGridTest.playingGridPrinter();
		System.out.println("Expected");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   |O| | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   |O| | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   |O| | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   |O| | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("    1 2 3 4 5 6 7");
		System.out.println();
		
		// Horizontal left win
		PlayingGrid horizontalLeftWinGridTest = new PlayingGrid();
		ColoredDisc horizontalLeftDiscTest_1 = new ColoredDisc("red");
		horizontalLeftDiscTest_1.setColumn(1);
		horizontalLeftWinGridTest.addColoredDisc(horizontalLeftDiscTest_1);
		horizontalLeftWinGridTest.isTheWinningMove(horizontalLeftDiscTest_1.getRow(), horizontalLeftDiscTest_1.getColumn());
		
		ColoredDisc horizontalLeftDiscTest_2 = new ColoredDisc("red");
		horizontalLeftDiscTest_2.setColumn(2);
		horizontalLeftWinGridTest.addColoredDisc(horizontalLeftDiscTest_2);
		horizontalLeftWinGridTest.isTheWinningMove(horizontalLeftDiscTest_2.getRow(), horizontalLeftDiscTest_2.getColumn());
		
		ColoredDisc horizontalLeftDiscTest_3 = new ColoredDisc("red");
		horizontalLeftDiscTest_3.setColumn(3);
		horizontalLeftWinGridTest.addColoredDisc(horizontalLeftDiscTest_3);
		horizontalLeftWinGridTest.isTheWinningMove(horizontalLeftDiscTest_3.getRow(), horizontalLeftDiscTest_3.getColumn());
		
		ColoredDisc horizontalLeftDiscTest_4 = new ColoredDisc("red");
		horizontalLeftDiscTest_4.setColumn(4);
		horizontalLeftWinGridTest.addColoredDisc(horizontalLeftDiscTest_4);
		horizontalLeftWinGridTest.isTheWinningMove(horizontalLeftDiscTest_4.getRow(), horizontalLeftDiscTest_4.getColumn());
		System.out.println("Expected: Horizontally left aligned win");
		horizontalLeftWinGridTest.playingGridPrinter();
		System.out.println("Expected");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   |O|O|O|O| | | |");
		System.out.println("    - - - - - - -");
		System.out.println("    1 2 3 4 5 6 7");
		System.out.println();
		
		// Horizontal left win
		PlayingGrid horizontalRightWinGridTest = new PlayingGrid();
		ColoredDisc horizontalRightDiscTest_1 = new ColoredDisc("red");
		horizontalRightDiscTest_1.setColumn(7);
		horizontalRightWinGridTest.addColoredDisc(horizontalRightDiscTest_1);
		horizontalRightWinGridTest.isTheWinningMove(horizontalRightDiscTest_1.getRow(), horizontalRightDiscTest_1.getColumn());
		
		ColoredDisc horizontalRightDiscTest_2 = new ColoredDisc("red");
		horizontalRightDiscTest_2.setColumn(6);
		horizontalRightWinGridTest.addColoredDisc(horizontalRightDiscTest_2);
		horizontalRightWinGridTest.isTheWinningMove(horizontalRightDiscTest_2.getRow(), horizontalRightDiscTest_2.getColumn());
	
		ColoredDisc horizontalRightDiscTest_3 = new ColoredDisc("red");
		horizontalRightDiscTest_3.setColumn(5);
		horizontalRightWinGridTest.addColoredDisc(horizontalRightDiscTest_3);
		horizontalRightWinGridTest.isTheWinningMove(horizontalRightDiscTest_3.getRow(), horizontalRightDiscTest_3.getColumn());
		
		ColoredDisc horizontalRightDiscTest_4 = new ColoredDisc("red");
		horizontalRightDiscTest_4.setColumn(4);
		horizontalRightWinGridTest.addColoredDisc(horizontalRightDiscTest_4);
		horizontalRightWinGridTest.isTheWinningMove(horizontalRightDiscTest_4.getRow(), horizontalRightDiscTest_4.getColumn());
		System.out.println("Expected: Horizontally right aligned win");
		horizontalRightWinGridTest.playingGridPrinter();
		System.out.println("Expected");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | |O|O|O|O|");
		System.out.println("    - - - - - - -");
		System.out.println("    1 2 3 4 5 6 7");
		System.out.println();
		
		// Diagonal left bottom win
		PlayingGrid DiagonalLeftBottomWinGridTest = new PlayingGrid();
		ColoredDisc DiagonalLeftBottomDiscTest_1 = new ColoredDisc("red");
		DiagonalLeftBottomDiscTest_1.setColumn(7);
		DiagonalLeftBottomWinGridTest.addColoredDisc(DiagonalLeftBottomDiscTest_1);
		DiagonalLeftBottomWinGridTest.isTheWinningMove(DiagonalLeftBottomDiscTest_1.getRow(), DiagonalLeftBottomDiscTest_1.getColumn());
		
		ColoredDisc DiagonalLeftBottomDiscTest_2 = new ColoredDisc("yellow");
		DiagonalLeftBottomDiscTest_2.setColumn(6);
		DiagonalLeftBottomWinGridTest.addColoredDisc(DiagonalLeftBottomDiscTest_2);
		DiagonalLeftBottomWinGridTest.isTheWinningMove(DiagonalLeftBottomDiscTest_2.getRow(), DiagonalLeftBottomDiscTest_2.getColumn());
	
		ColoredDisc DiagonalLeftBottomDiscTest_3 = new ColoredDisc("red");
		DiagonalLeftBottomDiscTest_3.setColumn(6);
		DiagonalLeftBottomWinGridTest.addColoredDisc(DiagonalLeftBottomDiscTest_3);
		DiagonalLeftBottomWinGridTest.isTheWinningMove(DiagonalLeftBottomDiscTest_3.getRow(), DiagonalLeftBottomDiscTest_3.getColumn());
		
		ColoredDisc DiagonalLeftBottomDiscTest_4 = new ColoredDisc("yellow");
		DiagonalLeftBottomDiscTest_4.setColumn(5);
		DiagonalLeftBottomWinGridTest.addColoredDisc(DiagonalLeftBottomDiscTest_4);
		DiagonalLeftBottomWinGridTest.isTheWinningMove(DiagonalLeftBottomDiscTest_4.getRow(), DiagonalLeftBottomDiscTest_4.getColumn());
		
		ColoredDisc DiagonalLeftBottomDiscTest_5 = new ColoredDisc("red");
		DiagonalLeftBottomDiscTest_5.setColumn(5);
		DiagonalLeftBottomWinGridTest.addColoredDisc(DiagonalLeftBottomDiscTest_5);
		DiagonalLeftBottomWinGridTest.isTheWinningMove(DiagonalLeftBottomDiscTest_5.getRow(), DiagonalLeftBottomDiscTest_5.getColumn());
		
		ColoredDisc DiagonalLeftBottomDiscTest_6 = new ColoredDisc("yellow");
		DiagonalLeftBottomDiscTest_6.setColumn(4);
		DiagonalLeftBottomWinGridTest.addColoredDisc(DiagonalLeftBottomDiscTest_6);
		DiagonalLeftBottomWinGridTest.isTheWinningMove(DiagonalLeftBottomDiscTest_6.getRow(), DiagonalLeftBottomDiscTest_6.getColumn());
		
		ColoredDisc DiagonalLeftBottomDiscTest_7 = new ColoredDisc("red");
		DiagonalLeftBottomDiscTest_7.setColumn(5);
		DiagonalLeftBottomWinGridTest.addColoredDisc(DiagonalLeftBottomDiscTest_7);
		DiagonalLeftBottomWinGridTest.isTheWinningMove(DiagonalLeftBottomDiscTest_7.getRow(), DiagonalLeftBottomDiscTest_7.getColumn());
		
		ColoredDisc DiagonalLeftBottomDiscTest_8 = new ColoredDisc("yellow");
		DiagonalLeftBottomDiscTest_8.setColumn(4);
		DiagonalLeftBottomWinGridTest.addColoredDisc(DiagonalLeftBottomDiscTest_8);
		DiagonalLeftBottomWinGridTest.isTheWinningMove(DiagonalLeftBottomDiscTest_8.getRow(), DiagonalLeftBottomDiscTest_8.getColumn());
		
		ColoredDisc DiagonalLeftBottomDiscTest_9 = new ColoredDisc("red");
		DiagonalLeftBottomDiscTest_9.setColumn(4);
		DiagonalLeftBottomWinGridTest.addColoredDisc(DiagonalLeftBottomDiscTest_9);
		DiagonalLeftBottomWinGridTest.isTheWinningMove(DiagonalLeftBottomDiscTest_9.getRow(), DiagonalLeftBottomDiscTest_9.getColumn());
		
		ColoredDisc DiagonalLeftBottomDiscTest_10 = new ColoredDisc("yellow");
		DiagonalLeftBottomDiscTest_10.setColumn(2);
		DiagonalLeftBottomWinGridTest.addColoredDisc(DiagonalLeftBottomDiscTest_10);
		DiagonalLeftBottomWinGridTest.isTheWinningMove(DiagonalLeftBottomDiscTest_10.getRow(), DiagonalLeftBottomDiscTest_10.getColumn());
		
		ColoredDisc DiagonalLeftBottomDiscTest_11 = new ColoredDisc("red");
		DiagonalLeftBottomDiscTest_11.setColumn(4);
		DiagonalLeftBottomWinGridTest.addColoredDisc(DiagonalLeftBottomDiscTest_11);
		DiagonalLeftBottomWinGridTest.isTheWinningMove(DiagonalLeftBottomDiscTest_11.getRow(), DiagonalLeftBottomDiscTest_11.getColumn());
		System.out.println("Expected: Diagonally left bottom aligned win");
		DiagonalLeftBottomWinGridTest.playingGridPrinter();
		System.out.println("Expected");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | |O| | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | |O|O| | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | |X|O|O| |");
		System.out.println("    - - - - - - -");
		System.out.println("   | |X| |X|X|X|O|");
		System.out.println("    - - - - - - -");
		System.out.println("    1 2 3 4 5 6 7");
		System.out.println();
		
		// Diagonal left top win
		PlayingGrid DiagonalLeftTopWinGridTest = new PlayingGrid();
		ColoredDisc DiagonalLeftTopDiscTest_1 = new ColoredDisc("yellow");
		DiagonalLeftTopDiscTest_1.setColumn(1);
		DiagonalLeftTopWinGridTest.addColoredDisc(DiagonalLeftTopDiscTest_1);
		DiagonalLeftTopWinGridTest.isTheWinningMove(DiagonalLeftTopDiscTest_1.getRow(), DiagonalLeftTopDiscTest_1.getColumn());
		
		ColoredDisc DiagonalLeftTopDiscTest_2 = new ColoredDisc("red");
		DiagonalLeftTopDiscTest_2.setColumn(1);
		DiagonalLeftTopWinGridTest.addColoredDisc(DiagonalLeftTopDiscTest_2);
		DiagonalLeftTopWinGridTest.isTheWinningMove(DiagonalLeftTopDiscTest_2.getRow(), DiagonalLeftTopDiscTest_2.getColumn());
	
		ColoredDisc DiagonalLeftTopDiscTest_3 = new ColoredDisc("yellow");
		DiagonalLeftTopDiscTest_3.setColumn(1);
		DiagonalLeftTopWinGridTest.addColoredDisc(DiagonalLeftTopDiscTest_3);
		DiagonalLeftTopWinGridTest.isTheWinningMove(DiagonalLeftTopDiscTest_3.getRow(), DiagonalLeftTopDiscTest_3.getColumn());
		
		ColoredDisc DiagonalLeftTopDiscTest_4 = new ColoredDisc("red");
		DiagonalLeftTopDiscTest_4.setColumn(1);
		DiagonalLeftTopWinGridTest.addColoredDisc(DiagonalLeftTopDiscTest_4);
		DiagonalLeftTopWinGridTest.isTheWinningMove(DiagonalLeftTopDiscTest_4.getRow(), DiagonalLeftTopDiscTest_4.getColumn());
		
		ColoredDisc DiagonalLeftTopDiscTest_5 = new ColoredDisc("yellow");
		DiagonalLeftTopDiscTest_5.setColumn(2);
		DiagonalLeftTopWinGridTest.addColoredDisc(DiagonalLeftTopDiscTest_5);
		DiagonalLeftTopWinGridTest.isTheWinningMove(DiagonalLeftTopDiscTest_5.getRow(), DiagonalLeftTopDiscTest_5.getColumn());
		
		ColoredDisc DiagonalLeftTopDiscTest_6 = new ColoredDisc("red");
		DiagonalLeftTopDiscTest_6.setColumn(3);
		DiagonalLeftTopWinGridTest.addColoredDisc(DiagonalLeftTopDiscTest_6);
		DiagonalLeftTopWinGridTest.isTheWinningMove(DiagonalLeftTopDiscTest_6.getRow(), DiagonalLeftTopDiscTest_6.getColumn());
		
		ColoredDisc DiagonalLeftTopDiscTest_7 = new ColoredDisc("yellow");
		DiagonalLeftTopDiscTest_7.setColumn(2);
		DiagonalLeftTopWinGridTest.addColoredDisc(DiagonalLeftTopDiscTest_7);
		DiagonalLeftTopWinGridTest.isTheWinningMove(DiagonalLeftTopDiscTest_7.getRow(), DiagonalLeftTopDiscTest_7.getColumn());
		
		ColoredDisc DiagonalLeftTopDiscTest_8 = new ColoredDisc("red");
		DiagonalLeftTopDiscTest_8.setColumn(2);
		DiagonalLeftTopWinGridTest.addColoredDisc(DiagonalLeftTopDiscTest_8);
		DiagonalLeftTopWinGridTest.isTheWinningMove(DiagonalLeftTopDiscTest_8.getRow(), DiagonalLeftTopDiscTest_8.getColumn());
		
		ColoredDisc DiagonalLeftTopDiscTest_9 = new ColoredDisc("yellow");
		DiagonalLeftTopDiscTest_9.setColumn(5);
		DiagonalLeftTopWinGridTest.addColoredDisc(DiagonalLeftTopDiscTest_9);
		DiagonalLeftTopWinGridTest.isTheWinningMove(DiagonalLeftTopDiscTest_9.getRow(), DiagonalLeftTopDiscTest_9.getColumn());
		
		ColoredDisc DiagonalLeftTopDiscTest_10 = new ColoredDisc("red");
		DiagonalLeftTopDiscTest_10.setColumn(3);
		DiagonalLeftTopWinGridTest.addColoredDisc(DiagonalLeftTopDiscTest_10);
		DiagonalLeftTopWinGridTest.isTheWinningMove(DiagonalLeftTopDiscTest_10.getRow(), DiagonalLeftTopDiscTest_10.getColumn());
		
		ColoredDisc DiagonalLeftTopDiscTest_11 = new ColoredDisc("yellow");
		DiagonalLeftTopDiscTest_11.setColumn(6);
		DiagonalLeftTopWinGridTest.addColoredDisc(DiagonalLeftTopDiscTest_11);
		DiagonalLeftTopWinGridTest.isTheWinningMove(DiagonalLeftTopDiscTest_11.getRow(), DiagonalLeftTopDiscTest_11.getColumn());
		
		ColoredDisc DiagonalLeftTopDiscTest_12 = new ColoredDisc("red");
		DiagonalLeftTopDiscTest_12.setColumn(4);
		DiagonalLeftTopWinGridTest.addColoredDisc(DiagonalLeftTopDiscTest_12);
		DiagonalLeftTopWinGridTest.isTheWinningMove(DiagonalLeftTopDiscTest_12.getRow(), DiagonalLeftTopDiscTest_12.getColumn());
		System.out.println("Expected: Diagonally left top aligned win");
		DiagonalLeftTopWinGridTest.playingGridPrinter();
		System.out.println("Expected");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   |O| | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   |X|O| | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   |O|X|O| | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   |X|X|O|O|X|X| |");
		System.out.println("    - - - - - - -");
		System.out.println("    1 2 3 4 5 6 7");
		
		// Diagonal right bottom win
		PlayingGrid DiagonalRightBottomWinGridTest = new PlayingGrid();
		ColoredDisc DiagonalRightBottomDiscTest_1 = new ColoredDisc("red");
		DiagonalRightBottomDiscTest_1.setColumn(1);
		DiagonalRightBottomWinGridTest.addColoredDisc(DiagonalRightBottomDiscTest_1);
		DiagonalRightBottomWinGridTest.isTheWinningMove(DiagonalRightBottomDiscTest_1.getRow(), DiagonalRightBottomDiscTest_1.getColumn());
		
		ColoredDisc DiagonalRightBottomDiscTest_2 = new ColoredDisc("yellow");
		DiagonalRightBottomDiscTest_2.setColumn(2);
		DiagonalRightBottomWinGridTest.addColoredDisc(DiagonalRightBottomDiscTest_2);
		DiagonalRightBottomWinGridTest.isTheWinningMove(DiagonalRightBottomDiscTest_2.getRow(), DiagonalRightBottomDiscTest_2.getColumn());
	
		ColoredDisc DiagonalRightBottomDiscTest_3 = new ColoredDisc("red");
		DiagonalRightBottomDiscTest_3.setColumn(2);
		DiagonalRightBottomWinGridTest.addColoredDisc(DiagonalRightBottomDiscTest_3);
		DiagonalRightBottomWinGridTest.isTheWinningMove(DiagonalRightBottomDiscTest_3.getRow(), DiagonalRightBottomDiscTest_3.getColumn());
		
		ColoredDisc DiagonalRightBottomDiscTest_4 = new ColoredDisc("yellow");
		DiagonalRightBottomDiscTest_4.setColumn(3);
		DiagonalRightBottomWinGridTest.addColoredDisc(DiagonalRightBottomDiscTest_4);
		DiagonalRightBottomWinGridTest.isTheWinningMove(DiagonalRightBottomDiscTest_4.getRow(), DiagonalRightBottomDiscTest_4.getColumn());
		
		ColoredDisc DiagonalRightBottomDiscTest_5 = new ColoredDisc("red");
		DiagonalRightBottomDiscTest_5.setColumn(3);
		DiagonalRightBottomWinGridTest.addColoredDisc(DiagonalRightBottomDiscTest_5);
		DiagonalRightBottomWinGridTest.isTheWinningMove(DiagonalRightBottomDiscTest_5.getRow(), DiagonalRightBottomDiscTest_5.getColumn());
		
		ColoredDisc DiagonalRightBottomDiscTest_6 = new ColoredDisc("yellow");
		DiagonalRightBottomDiscTest_6.setColumn(4);
		DiagonalRightBottomWinGridTest.addColoredDisc(DiagonalRightBottomDiscTest_6);
		DiagonalRightBottomWinGridTest.isTheWinningMove(DiagonalRightBottomDiscTest_6.getRow(), DiagonalRightBottomDiscTest_6.getColumn());
		
		ColoredDisc DiagonalRightBottomDiscTest_7 = new ColoredDisc("red");
		DiagonalRightBottomDiscTest_7.setColumn(3);
		DiagonalRightBottomWinGridTest.addColoredDisc(DiagonalRightBottomDiscTest_7);
		DiagonalRightBottomWinGridTest.isTheWinningMove(DiagonalRightBottomDiscTest_7.getRow(), DiagonalRightBottomDiscTest_7.getColumn());
		
		ColoredDisc DiagonalRightBottomDiscTest_8 = new ColoredDisc("yellow");
		DiagonalRightBottomDiscTest_8.setColumn(4);
		DiagonalRightBottomWinGridTest.addColoredDisc(DiagonalRightBottomDiscTest_8);
		DiagonalRightBottomWinGridTest.isTheWinningMove(DiagonalRightBottomDiscTest_8.getRow(), DiagonalRightBottomDiscTest_8.getColumn());
		
		ColoredDisc DiagonalRightBottomDiscTest_9 = new ColoredDisc("red");
		DiagonalRightBottomDiscTest_9.setColumn(4);
		DiagonalRightBottomWinGridTest.addColoredDisc(DiagonalRightBottomDiscTest_9);
		DiagonalRightBottomWinGridTest.isTheWinningMove(DiagonalRightBottomDiscTest_9.getRow(), DiagonalRightBottomDiscTest_9.getColumn());
		
		ColoredDisc DiagonalRightBottomDiscTest_10 = new ColoredDisc("yellow");
		DiagonalRightBottomDiscTest_10.setColumn(6);
		DiagonalRightBottomWinGridTest.addColoredDisc(DiagonalRightBottomDiscTest_10);
		DiagonalRightBottomWinGridTest.isTheWinningMove(DiagonalRightBottomDiscTest_10.getRow(), DiagonalRightBottomDiscTest_10.getColumn());
		
		ColoredDisc DiagonalRightBottomDiscTest_11 = new ColoredDisc("red");
		DiagonalRightBottomDiscTest_11.setColumn(4);
		DiagonalRightBottomWinGridTest.addColoredDisc(DiagonalRightBottomDiscTest_11);
		DiagonalRightBottomWinGridTest.isTheWinningMove(DiagonalRightBottomDiscTest_11.getRow(), DiagonalRightBottomDiscTest_11.getColumn());
		System.out.println("Expected: Diagonally right bottom aligned win");
		DiagonalRightBottomWinGridTest.playingGridPrinter();
		System.out.println("Expected");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | |O| | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | |O|O| | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | |O|O|X| | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   |O|X|X|X| |X| |");
		System.out.println("    - - - - - - -");
		System.out.println("    1 2 3 4 5 6 7");
		System.out.println();
		
		// Diagonal right top win
		PlayingGrid DiagonalRightTopWinGridTest = new PlayingGrid();
		ColoredDisc DiagonalRightTopDiscTest_1 = new ColoredDisc("yellow");
		DiagonalRightTopDiscTest_1.setColumn(6);
		DiagonalRightTopWinGridTest.addColoredDisc(DiagonalRightTopDiscTest_1);
		DiagonalRightTopWinGridTest.isTheWinningMove(DiagonalRightTopDiscTest_1.getRow(), DiagonalRightTopDiscTest_1.getColumn());
		
		ColoredDisc DiagonalRightTopDiscTest_2 = new ColoredDisc("red");
		DiagonalRightTopDiscTest_2.setColumn(6);
		DiagonalRightTopWinGridTest.addColoredDisc(DiagonalRightTopDiscTest_2);
		DiagonalRightTopWinGridTest.isTheWinningMove(DiagonalRightTopDiscTest_2.getRow(), DiagonalRightTopDiscTest_2.getColumn());
	
		ColoredDisc DiagonalRightTopDiscTest_3 = new ColoredDisc("yellow");
		DiagonalRightTopDiscTest_3.setColumn(6);
		DiagonalRightTopWinGridTest.addColoredDisc(DiagonalRightTopDiscTest_3);
		DiagonalRightTopWinGridTest.isTheWinningMove(DiagonalRightTopDiscTest_3.getRow(), DiagonalRightTopDiscTest_3.getColumn());
		
		ColoredDisc DiagonalRightTopDiscTest_4 = new ColoredDisc("red");
		DiagonalRightTopDiscTest_4.setColumn(6);
		DiagonalRightTopWinGridTest.addColoredDisc(DiagonalRightTopDiscTest_4);
		DiagonalRightTopWinGridTest.isTheWinningMove(DiagonalRightTopDiscTest_4.getRow(), DiagonalRightTopDiscTest_4.getColumn());
		
		ColoredDisc DiagonalRightTopDiscTest_5 = new ColoredDisc("yellow");
		DiagonalRightTopDiscTest_5.setColumn(5);
		DiagonalRightTopWinGridTest.addColoredDisc(DiagonalRightTopDiscTest_5);
		DiagonalRightTopWinGridTest.isTheWinningMove(DiagonalRightTopDiscTest_5.getRow(), DiagonalRightTopDiscTest_5.getColumn());
		
		ColoredDisc DiagonalRightTopDiscTest_6 = new ColoredDisc("red");
		DiagonalRightTopDiscTest_6.setColumn(5);
		DiagonalRightTopWinGridTest.addColoredDisc(DiagonalRightTopDiscTest_6);
		DiagonalRightTopWinGridTest.isTheWinningMove(DiagonalRightTopDiscTest_6.getRow(), DiagonalRightTopDiscTest_6.getColumn());
		
		ColoredDisc DiagonalRightTopDiscTest_7 = new ColoredDisc("yellow");
		DiagonalRightTopDiscTest_7.setColumn(4);
		DiagonalRightTopWinGridTest.addColoredDisc(DiagonalRightTopDiscTest_7);
		DiagonalRightTopWinGridTest.isTheWinningMove(DiagonalRightTopDiscTest_7.getRow(), DiagonalRightTopDiscTest_7.getColumn());
		
		ColoredDisc DiagonalRightTopDiscTest_8 = new ColoredDisc("red");
		DiagonalRightTopDiscTest_8.setColumn(5);
		DiagonalRightTopWinGridTest.addColoredDisc(DiagonalRightTopDiscTest_8);
		DiagonalRightTopWinGridTest.isTheWinningMove(DiagonalRightTopDiscTest_8.getRow(), DiagonalRightTopDiscTest_8.getColumn());
		
		ColoredDisc DiagonalRightTopDiscTest_9 = new ColoredDisc("yellow");
		DiagonalRightTopDiscTest_9.setColumn(2);
		DiagonalRightTopWinGridTest.addColoredDisc(DiagonalRightTopDiscTest_9);
		DiagonalRightTopWinGridTest.isTheWinningMove(DiagonalRightTopDiscTest_9.getRow(), DiagonalRightTopDiscTest_9.getColumn());
		
		ColoredDisc DiagonalRightTopDiscTest_10 = new ColoredDisc("red");
		DiagonalRightTopDiscTest_10.setColumn(4);
		DiagonalRightTopWinGridTest.addColoredDisc(DiagonalRightTopDiscTest_10);
		DiagonalRightTopWinGridTest.isTheWinningMove(DiagonalRightTopDiscTest_10.getRow(), DiagonalRightTopDiscTest_10.getColumn());
		
		ColoredDisc DiagonalRightTopDiscTest_11 = new ColoredDisc("yellow");
		DiagonalRightTopDiscTest_11.setColumn(1);
		DiagonalRightTopWinGridTest.addColoredDisc(DiagonalRightTopDiscTest_11);
		DiagonalRightTopWinGridTest.isTheWinningMove(DiagonalRightTopDiscTest_11.getRow(), DiagonalRightTopDiscTest_11.getColumn());
		
		ColoredDisc DiagonalRightTopDiscTest_12 = new ColoredDisc("red");
		DiagonalRightTopDiscTest_12.setColumn(3);
		DiagonalRightTopWinGridTest.addColoredDisc(DiagonalRightTopDiscTest_12);
		DiagonalRightTopWinGridTest.isTheWinningMove(DiagonalRightTopDiscTest_12.getRow(), DiagonalRightTopDiscTest_12.getColumn());
		System.out.println("Expected: Diagonally right top aligned win");
		DiagonalRightTopWinGridTest.playingGridPrinter();
		System.out.println("Expected");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | | | |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | | |O| |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | | |O|X| |");
		System.out.println("    - - - - - - -");
		System.out.println("   | | | |O|O|O| |");
		System.out.println("    - - - - - - -");
		System.out.println("   |X|X|O|X|X|X| |");
		System.out.println("    - - - - - - -");
		System.out.println("    1 2 3 4 5 6 7");
	}
}
