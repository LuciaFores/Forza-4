package exceptions;
import java.util.InputMismatchException;

/**
 * This class is used to model an exception that occurs in the game when the user gives an answer that doesn't match the expected pattern
 * @author lucia
 *
 */
public class IllegalAnswerException extends InputMismatchException{
	/**
	 * The constructor without parameters: it creates an exception without message for the user
	 */
	public IllegalAnswerException() {
		
	}
	
	/**
	 * The constructor with parameters: it creates an exception with a message for the user
	 * @param message The message to be shown to the user
	 */
	public IllegalAnswerException(String message) {
		super(message);
	}
}
