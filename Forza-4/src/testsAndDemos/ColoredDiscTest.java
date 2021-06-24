package testsAndDemos;

import gameComponents.ColoredDisc;

/**
 * This is a test class used to test the correctness of the methods of the ColoredDisc class
 * @author lucia
 *
 */
public class ColoredDiscTest {
	public static void main(String[] args) {
		// The class will test the methods of the ColoredDisc object
		
		// At first a ColoredDisc without informations beside its color will be created
		// For test purposes it will be created only a ColoredDisc with the yellow color
		ColoredDisc discTest = new ColoredDisc("yellow");
		
		// Since the constructor used is the one used to create a new ColoredDisc and not the one used to load it the only available information
		// will be the color, the row and the column will be set to -1
		System.out.println("ColoredDisc informations:");
		System.out.println("	- color: " + discTest.getDiscColor());
		System.out.println("	- row: " + discTest.getRow());
		System.out.println("	- column: " + discTest.getColumn());
		System.out.println("Expected ColoredDisc informations:");
		System.out.println("	- color: yellow");
		System.out.println("	- row: -1");
		System.out.println("	- column: -1");
		System.out.println();
		
		// Now the row and the column of the ColoredDisc will be set
		// At first there will be put two illegal values so that the exceptions will be raised
		System.out.println("Setting the row to 7 (illegal value)");
		discTest.setRow(7);
		System.out.println("Expected exception: The row doesn't exist");
		System.out.println();
		System.out.println("Setting the column to 8 (illegal value)");
		discTest.setColumn(8);
		System.out.println("Expected exception: The column doesn't exist");
		System.out.println();
		
		// Now row and column will be set to legal values
		System.out.println("Setting the row to 3 (legal value)");
		discTest.setRow(3);
		System.out.println("Setting the column to 5 (legal value)");
		discTest.setColumn(6);
		System.out.println("ColoredDisc informations:");
		System.out.println("	- color: " + discTest.getDiscColor());
		System.out.println("	- row: " + discTest.getRow());
		System.out.println("	- column: " + discTest.getColumn());
		System.out.println("Expected ColoredDisc informations:");
		System.out.println("	- color: yellow");
		System.out.println("	- row: 3");
		System.out.println("	- column: 5");
		System.out.println();
		
		// Now a ColoredDisc to load is created
		ColoredDisc discTest_2 = new ColoredDisc("red", 3, 6);
		System.out.println("ColoredDisc informations:");
		System.out.println("	- color: " + discTest_2.getDiscColor());
		System.out.println("	- row: " + discTest_2.getRow());
		System.out.println("	- column: " + discTest_2.getColumn());
		System.out.println("Expected ColoredDisc informations:");
		System.out.println("	- color: red");
		System.out.println("	- row: 3");
		System.out.println("	- column: 6");
		System.out.println();
	}
}
