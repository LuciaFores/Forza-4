package exceptions;
import java.util.InputMismatchException;

/**
 * This class is used to model an exception that occurs in the game when the user gives an answer that doesn't match the expected pattern
 * @author lucia
 *
 */
public class IllegalAnswerException extends InputMismatchException{
	public IllegalAnswerException() {
		
	}
	
	public IllegalAnswerException(String message) {
		super(message);
	}
}
