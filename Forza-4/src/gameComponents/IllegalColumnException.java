package gameComponents;

/**
 * This class models an exception that occurs when the user tries to put the disc into a column which index is less greater the 0 or greater than 7
 * @author lucia
 *
 */
public class IllegalColumnException extends IllegalArgumentException{
	public IllegalColumnException() {
		
	}	
	
	public IllegalColumnException(String message) {
		super(message);
	}
}
