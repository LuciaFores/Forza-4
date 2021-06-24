package testsAndDemos;

import gameComponents.Player;

/**
 * This is a test class used to test the correctness of the methods of the Player class 
 * @author lucia
 *
 */
public class PlayerTest {
	public static void main(String[] args) {
		// The class will test the methods of the Player object
		
		// At first a Player without informations beside its nickname will be created
		// For test purposes it will be created only a Player with the nickname testPlayer
		Player testPlayer = new Player("testPlayer");
		
		// Since the constructor used is the one used to create a new Player and not the one used to load it the only available information
		// will be the nickname, the number and the color will be set respectively to 0 and ""
		System.out.println("Player informations:");
		System.out.println("	- nickname: " + testPlayer.getPlayerName());
		System.out.println("	- number: " + testPlayer.getPlayerNumber());
		System.out.println("	- color: " + testPlayer.getPlayerColor());
		System.out.println("Expected Player informations:");
		System.out.println("	- nickname: testPlayer");
		System.out.println("	- number: 0");
		System.out.println("	- color: ");
		System.out.println();
		
		// Another Player is created to test the method to set the numbers
		Player secondTestPlayer = new Player("secondTestPlayer");
		
		// The method to assign the number is tested
		testPlayer.setPlayerNumbers(secondTestPlayer);
		System.out.println("Player informations:");
		System.out.println("	- nickname: " + testPlayer.getPlayerName());
		System.out.println("	- number: " + testPlayer.getPlayerNumber());
		System.out.println("	- color: " + testPlayer.getPlayerColor());
		System.out.println("Expected Player informations:");
		System.out.println("	- nickname: testPlayer");
		System.out.println("	- number: 1/2");
		System.out.println("	- color: ");
		System.out.println();
		System.out.println("Player informations:");
		System.out.println("	- nickname: " + secondTestPlayer.getPlayerName());
		System.out.println("	- number: " + secondTestPlayer.getPlayerNumber());
		System.out.println("	- color: " + secondTestPlayer.getPlayerColor());
		System.out.println("Expected Player informations:");
		System.out.println("	- nickname: secondTestPlayer");
		System.out.println("	- number: 1/2");
		System.out.println("	- color: ");
		System.out.println();
		
		// Trying to reassign the numbers an exception occurs
		testPlayer.setPlayerNumbers(secondTestPlayer);
		System.out.println("Expected exception: The order has already been decided");
		System.out.println();
		
		// Now the colors will be assigned 
		testPlayer.iAmRed(secondTestPlayer);
		if(testPlayer.getPlayerNumber() == 2)
			System.out.println("Expected exception: testPlayer, you can't choose, you are the player #2");
		else {
			System.out.println("Player informations:");
			System.out.println("	- nickname: " + testPlayer.getPlayerName());
			System.out.println("	- number: " + testPlayer.getPlayerNumber());
			System.out.println("	- color: " + testPlayer.getPlayerColor());
			System.out.println("Expected Player informations:");
			System.out.println("	- nickname: testPlayer");
			System.out.println("	- number: 1");
			System.out.println("	- color: red");
			System.out.println();
			System.out.println("Player informations:");
			System.out.println("	- nickname: " + secondTestPlayer.getPlayerName());
			System.out.println("	- number: " + secondTestPlayer.getPlayerNumber());
			System.out.println("	- color: " + secondTestPlayer.getPlayerColor());
			System.out.println("Expected Player informations:");
			System.out.println("	- nickname: secondTestPlayer");
			System.out.println("	- number: 2");
			System.out.println("	- color: yellow");
			System.out.println();
		}
		
		secondTestPlayer.iAmYellow(testPlayer);
		if(secondTestPlayer.getPlayerNumber() == 2)
			System.out.println("Expected exception: secondTestPlayer, you can't choose, you are the player #2");
		else {
			System.out.println("Player informations:");
			System.out.println("	- nickname: " + testPlayer.getPlayerName());
			System.out.println("	- number: " + testPlayer.getPlayerNumber());
			System.out.println("	- color: " + testPlayer.getPlayerColor());
			System.out.println("Expected Player informations:");
			System.out.println("	- nickname: testPlayer");
			System.out.println("	- number: 2");
			System.out.println("	- color: red");
			System.out.println();
			System.out.println("Player informations:");
			System.out.println("	- nickname: " + secondTestPlayer.getPlayerName());
			System.out.println("	- number: " + secondTestPlayer.getPlayerNumber());
			System.out.println("	- color: " + secondTestPlayer.getPlayerColor());
			System.out.println("Expected Player informations:");
			System.out.println("	- nickname: secondTestPlayer");
			System.out.println("	- number: 1");
			System.out.println("	- color: yellow");
			System.out.println();
		}
		
		// This exception will be correctly displayed only if the player #1 is testPlayer
		testPlayer.iAmYellow(secondTestPlayer);
		System.out.println("Expected exception: Colors have been already decided");
		
	}
}
