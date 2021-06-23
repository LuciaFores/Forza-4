package gameComponents;

/**
 * This class models an exception that occurs when a player that isn't the first one tries to decide the color in the game
 * @author lucia
 *
 */
public class IllegalPlayerException extends IllegalArgumentException{
	public IllegalPlayerException() {
		
	}
	
	public IllegalPlayerException(String message) {
		super(message);
	}
}
