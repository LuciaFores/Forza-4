package exceptions;

import java.io.FileNotFoundException;

/**
 * This class is used to model an exception that occurs in the game when the program tries to access to a directory that doesn't exist
 * @author lucia
 *
 */
public class DirectoryNotFoundException extends FileNotFoundException {
	/**
	 * The constructor without parameters: it creates an exception without message for the user
	 */
	public DirectoryNotFoundException() {
		
	}
	
	/**
	 * The constructor with parameters: it creates an exception with a message for the user
	 * @param message The message to be shown to the user
	 */
	public DirectoryNotFoundException(String message) {
		super(message);
	}
}
