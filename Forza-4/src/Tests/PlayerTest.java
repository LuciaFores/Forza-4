package Tests;

import gameComponents.Player;
import java.util.Random;

/*
 * This class tests the correct functioning of the methods implemented in the Player class
 */
public class PlayerTest {
	public static void main(String[] args) {
		/*
		 * First of all we want to create two players
		 */
		/*Player firstPlayer = new Player("firstPlayer");
		Player secondPlayer = new Player ("secondPlayer");*/
		
		/*
		 * Now we want to test that all the parameters for the two created players are
		 * not set; now only the nickname of the players is set
		 */
		/*System.out.println(firstPlayer.getPlayerName());
		System.out.println("Expected: firstPlayer");
		System.out.println();
		
		System.out.println(firstPlayer.getPlayerColor());
		System.out.println("Expected: ");
		System.out.println();
		
		System.out.println(firstPlayer.getPlayerNumber());
		System.out.println("Expected: 0");
		System.out.println();
		
		
		System.out.println(secondPlayer.getPlayerName());
		System.out.println("Expected: secondPlayer");
		System.out.println();
		
		System.out.println(secondPlayer.getPlayerColor());
		System.out.println("Expected: ");
		System.out.println();
		
		System.out.println(secondPlayer.getPlayerNumber());
		System.out.println("Expected: 0");
		System.out.println();*/
		
		
		/*
		 * Now we want to test if the assignment of the random numbers to the player works
		 */
		/*firstPlayer.setPlayerNumbers(secondPlayer);
		System.out.println(firstPlayer.getPlayerNumber());
		System.out.println(secondPlayer.getPlayerNumber());
		System.out.println();
		secondPlayer.setPlayerNumbers(firstPlayer);
		System.out.println(firstPlayer.getPlayerNumber());
		System.out.println(secondPlayer.getPlayerNumber());
		System.out.println();*/
		
		
		/*
		 * Now we want to test if the methods to choose the color works.
		 * We have two situations: the first player wants to be red or the first player wants to be yellow
		 */
		/*firstPlayer.iAmRed(secondPlayer);
		System.out.println(firstPlayer.getPlayerColor());
		System.out.println(secondPlayer.getPlayerColor());
		System.out.println();
		secondPlayer.iAmRed(firstPlayer);
		firstPlayer.iAmYellow(secondPlayer);*/
		
		
		
		/*
		 * Now let's do a general test
		 */
		Player firstCreatedPlayer = new Player("lucia");
		Player secondCreatedPlayer = new Player("lucietti");
		
		firstCreatedPlayer.setPlayerNumbers(secondCreatedPlayer);
		
		Random rand = new Random();
		if(rand.nextInt(2) == 0) {
			firstCreatedPlayer.iAmRed(secondCreatedPlayer);
			secondCreatedPlayer.iAmYellow(firstCreatedPlayer);
		}
		else{
			firstCreatedPlayer.iAmYellow(secondCreatedPlayer);
			secondCreatedPlayer.iAmRed(firstCreatedPlayer);
		}
		
		
		System.out.println();
		System.out.println("These are the properties of the players:");
		System.out.println("nickname: " + firstCreatedPlayer.getPlayerName());
		System.out.println("number: " + firstCreatedPlayer.getPlayerNumber());
		System.out.println("color: " + firstCreatedPlayer.getPlayerColor());
		System.out.println();
		
		System.out.println("nickname: " + secondCreatedPlayer.getPlayerName());
		System.out.println("number: " + secondCreatedPlayer.getPlayerNumber());
		System.out.println("color: " + secondCreatedPlayer.getPlayerColor());
		System.out.println();
	}
}
