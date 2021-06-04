package Tests;

import gameComponents.*;

import java.util.Scanner;


/**
 * This is the first test of the game.
 * Not all the functionality has been implemented: in this game there will be the creation of the two players,
 * their attributes will be set and then they will play a game that cannot be saved or loaded
 * @author lucia
 *
 */
public class GameTest {
	public static void main(String[] args) {
		/*
		 * First of all let's create the players so they will be able to insert their nicknames from keyboard
		 */
		Scanner in = new Scanner(System.in);
		System.out.println("WELCOME TO CONNECT 4");
		System.out.println("Hello player, what's your name?");
		String nickname1 = in.nextLine();
		System.out.println("And how's your rival named?");
		String nickname2 = in.nextLine();
		Player firstCreatedPlayer = new Player(nickname1);
		Player secondCreatedPlayer = new Player(nickname2);
		System.out.println();
		System.out.println("Nice, now the fate will choose the order in which you two will play.");
		firstCreatedPlayer.setPlayerNumbers(secondCreatedPlayer);
		Player player1;
		Player player2;
		if(firstCreatedPlayer.getPlayerNumber() == 1) {
			player1 = firstCreatedPlayer;
			player2 = secondCreatedPlayer;
		}
		else {
			player1 = secondCreatedPlayer;
			player2 = firstCreatedPlayer;
		}
		System.out.println();
		System.out.println("This is what the fate decided:");
		System.out.println();
		System.out.println(player1.getPlayerName() + " you will play as the player number 1");
		System.out.println("and you " + player2.getPlayerName() + " will play as the player number 2");
		System.out.println(player1.getPlayerName() + " choose your color, remember only red and yellow are allowed:");
		boolean choosing = true;
		while(choosing) {
			String color1 = in.nextLine();
			if(color1.equalsIgnoreCase("red")) {
				player1.iAmRed(player2);
				choosing = false;
			}
			else if(color1.equalsIgnoreCase("yellow")) {
				player1.iAmYellow(player2);
				choosing = false;
			}
			else {
				System.out.println("As i already said, only red and yellow are allowed, so choose one of them");
			}
		}
		System.out.println("Before starting the game, let's check who you players are");
		System.out.println("Player 1");
		System.out.println("nickname: " + player1.getPlayerName());
		System.out.println("order: " + player1.getPlayerNumber());
		System.out.println("color: " + player1.getPlayerColor());
		System.out.println();
		System.out.println("Player 2");
		System.out.println("nickname: " + player2.getPlayerName());
		System.out.println("order: " + player2.getPlayerNumber());
		System.out.println("color: " + player2.getPlayerColor());
		
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
		
		PlayingGrid grid = new PlayingGrid();
		while(!grid.isItATie()) {
			grid.playingGridPrinter();
			// CONTROLLA E SISTEMA NON PRENDE I GIOCATORI CORRETTI
			if(grid.getFreeSpaces() % 2 == 0) {
				ColoredDisc activeDisc = new ColoredDisc(player1.getPlayerColor());
				System.out.println(player1.getPlayerName() + " in which row do you want to put your disc?");
				int rowIndex = in.nextInt();
				System.out.println("and in which column do you want to put your disc?");
				int columnIndex = in.nextInt();
				activeDisc.setMove(rowIndex, columnIndex);
				grid.addColoredDisc(activeDisc);
				if(grid.isTheWinningMove(activeDisc.getRow(), activeDisc.getColumn())) {
					System.out.println("Congratulations " + player1.getPlayerName() + " you won!");
					grid.playingGridPrinter();
					break;
				}
				else
					grid.playingGridPrinter();
			}
			if(grid.getFreeSpaces() % 2 == 1) {
				ColoredDisc activeDisc = new ColoredDisc(player2.getPlayerColor());
				System.out.println(player2.getPlayerName() + " in which row do you want to put your disc?");
				int rowIndex = in.nextInt();
				System.out.println("and in which column do you want to put your disc?");
				int columnIndex = in.nextInt();
				activeDisc.setMove(rowIndex, columnIndex);
				grid.addColoredDisc(activeDisc);
				if(grid.isTheWinningMove(activeDisc.getRow(), activeDisc.getColumn())) {
					System.out.println("Congratulations " + player2.getPlayerName() + " you won!");
					grid.playingGridPrinter();
					break;
				}
				else
					grid.playingGridPrinter();
			}
		}
		
	}
}
