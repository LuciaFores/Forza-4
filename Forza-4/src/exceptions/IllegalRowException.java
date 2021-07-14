package exceptions;

/**
 * This class models an exception that occurs when the user tries to put the disc into a row which is smaller than 0 or greater than 6
 * @author lucia
 *
 */
public class IllegalRowException extends IllegalArgumentException{
	/**
	 * The constructor without parameters: it creates an exception without message for the user
	 */
	public IllegalRowException() {
		
	}
	
	/**
	 * The constructor with parameters: it creates an exception with a message for the user
	 * @param message The message to be shown to the user
	 */
	public IllegalRowException(String message) {
		super(message);
	}
}
