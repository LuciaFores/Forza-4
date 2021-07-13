package exceptions;

/**
 * This class models an exception that occurs when the user tries to put the disc into a row which is less greater than 0 or greater than 6
 * @author lucia
 *
 */
public class IllegalRowException extends IllegalArgumentException{
	public IllegalRowException() {
		
	}
	
	public IllegalRowException(String message) {
		super(message);
	}
}
