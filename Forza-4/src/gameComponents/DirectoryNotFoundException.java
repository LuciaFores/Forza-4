package gameComponents;

import java.io.FileNotFoundException;

/**
 * This class is used to model an exception that occurs in the game when the program tries to access to a directory that doesn't exist
 * @author lucia
 *
 */
public class DirectoryNotFoundException extends FileNotFoundException {
	public DirectoryNotFoundException() {
		
	}
	
	public DirectoryNotFoundException(String message) {
		super(message);
	}
}
