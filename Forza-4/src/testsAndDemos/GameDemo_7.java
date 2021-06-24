package testsAndDemos;

import gameComponents.*;

/**
 * This is a demo class for a sample game won by player #2
 * @author lucia
 *
 */
public class GameDemo_7 {
	public static void main(String[] args) {
		// Now the program proceeds with the creation of the players
		System.out.println("Hello player, what's your name?");
		String nickname1 = "testPlayer";
		System.out.println("And how's your rival named?");
		String nickname2 = "rivalTestPlayer";
		// First of all two temporary players with no order are created
		Player player = new Player(nickname1);
		Player rival = new Player(nickname2);
		System.out.println();
		System.out.println("The fate will now choose the order in which you two will play.");
		// The order in which the player will play is randomly decided
		player.setPlayerNumbers(rival);
		// Now the two real player are created
		Player player1;
		Player player2;
		if(player.getPlayerNumber() == 1) {
			player1 = player;
			player2 = rival;
		}
		else {
			player1 = rival;
			player2 = player;
		}
		System.out.println();
		System.out.println("This is what the fate decided:");
		System.out.println();
		System.out.println(player1.getPlayerName() + " you will play as the player #1");
		System.out.println("and you " + player2.getPlayerName() + " will play as player #2");
		// The player #1 has the right to choice its color, the color of the player #2 is consequently assigned
		System.out.println(player1.getPlayerName() + " choose your color, remember only red and yellow are allowed:");
		System.out.println("red");
		player1.iAmRed(player2);
		// The rules of the game are displayed
		System.out.println();
		System.out.println("Seems like you are ready to play so let me tell you two the rules of this game");
		System.out.println("Your goal is to align four discs of your color vertically, horizontally or diagonally, "
				+ "the first one to achive this will win.");
		System.out.println("You will play in the order chosen before.");
		System.out.println("Please remember that the red discs will be displayed with O and the yellow discs will be "
				+ "displayed with X");
		System.out.println("Also remember that if none of you will be able to align four discs the game will end with a tie.");
		
		System.out.println();
		System.out.println("Let's begin the game, good luck to all of you");
		// The playing grid for the game is created
		PlayingGrid grid = new PlayingGrid();
		// The game will be won by the player #2
		grid.playingGridPrinter();
		ColoredDisc redDisc_1 = new ColoredDisc("red");
		System.out.println(player1.getPlayerName() + " in which column do you want to put your disc? (press 's' to save, 'e' to exit)");
		System.out.println("1");
		redDisc_1.setColumn(1);
		grid.addColoredDisc(redDisc_1);
		grid.isTheWinningMove(redDisc_1.getRow(), redDisc_1.getColumn());
		grid.playingGridPrinter();
		
		System.out.println(player2.getPlayerName() + " in which column do you want to put your disc? (press 's' to save, 'e' to exit)");
		System.out.println("1");
		ColoredDisc yellowDisc_1 = new ColoredDisc("yellow");
		yellowDisc_1.setColumn(1);
		grid.addColoredDisc(yellowDisc_1);
		grid.isTheWinningMove(yellowDisc_1.getRow(), yellowDisc_1.getColumn());
		grid.playingGridPrinter();
		
		System.out.println(player1.getPlayerName() + " in which column do you want to put your disc? (press 's' to save, 'e' to exit)");
		System.out.println("2");
		ColoredDisc redDisc_2 = new ColoredDisc("red");
		redDisc_2.setColumn(2);
		grid.addColoredDisc(redDisc_2);
		grid.isTheWinningMove(redDisc_2.getRow(), redDisc_2.getColumn());
		grid.playingGridPrinter();
		
		System.out.println(player2.getPlayerName() + " in which column do you want to put your disc? (press 's' to save, 'e' to exit)");
		System.out.println("3");
		ColoredDisc yellowDisc_2 = new ColoredDisc("yellow");
		yellowDisc_2.setColumn(3);
		grid.addColoredDisc(yellowDisc_2);
		grid.isTheWinningMove(yellowDisc_2.getRow(), yellowDisc_2.getColumn());
		grid.playingGridPrinter();
		
		System.out.println(player1.getPlayerName() + " in which column do you want to put your disc? (press 's' to save, 'e' to exit)");
		System.out.println("2");
		ColoredDisc redDisc_3 = new ColoredDisc("red");
		redDisc_3.setColumn(2);
		grid.addColoredDisc(redDisc_3);
		grid.isTheWinningMove(redDisc_3.getRow(), redDisc_3.getColumn());
		grid.playingGridPrinter();
		
		System.out.println(player2.getPlayerName() + " in which column do you want to put your disc? (press 's' to save, 'e' to exit)");
		System.out.println("3");
		ColoredDisc yellowDisc_3 = new ColoredDisc("yellow");
		yellowDisc_3.setColumn(3);
		grid.addColoredDisc(yellowDisc_3);
		grid.isTheWinningMove(yellowDisc_3.getRow(), yellowDisc_3.getColumn());
		grid.playingGridPrinter();
		
		System.out.println(player1.getPlayerName() + " in which column do you want to put your disc? (press 's' to save, 'e' to exit)");
		System.out.println("4");
		ColoredDisc redDisc_4 = new ColoredDisc("red");
		redDisc_4.setColumn(4);
		grid.addColoredDisc(redDisc_4);
		grid.isTheWinningMove(redDisc_4.getRow(), redDisc_4.getColumn());
		grid.playingGridPrinter();
		
		System.out.println(player2.getPlayerName() + " in which column do you want to put your disc? (press 's' to save, 'e' to exit)");
		System.out.println("3");
		ColoredDisc yellowDisc_4 = new ColoredDisc("yellow");
		yellowDisc_4.setColumn(3);
		grid.addColoredDisc(yellowDisc_4);
		grid.isTheWinningMove(yellowDisc_4.getRow(), yellowDisc_4.getColumn());
		grid.playingGridPrinter();
		
		System.out.println(player1.getPlayerName() + " in which column do you want to put your disc? (press 's' to save, 'e' to exit)");
		System.out.println("5");
		ColoredDisc redDisc_5 = new ColoredDisc("red");
		redDisc_5.setColumn(5);
		grid.addColoredDisc(redDisc_5);
		grid.isTheWinningMove(redDisc_5.getRow(), redDisc_5.getColumn());
		grid.playingGridPrinter();
		
		System.out.println(player2.getPlayerName() + " in which column do you want to put your disc? (press 's' to save, 'e' to exit)");
		System.out.println("3");
		ColoredDisc yellowDisc_5 = new ColoredDisc("yellow");
		yellowDisc_5.setColumn(3);
		grid.addColoredDisc(yellowDisc_5);
		System.out.println("Congratulations " + player2.getPlayerName() + " you won!");
		grid.isTheWinningMove(yellowDisc_5.getRow(), yellowDisc_5.getColumn());
		grid.playingGridPrinter();
	}
}
