package gameComponents;

import java.util.Random;


/* CREA UN METODO CHE CONTROLLA SE SI STA PROVANDO A CREARE PIU' DI DUE GIOCATORI */

/**
 * This class models a player of Connect Four.
 * The player will be recognized during the game thanks to a nickname that they can choose before starting the game.
 * The player will have the possibility to choose the color for its colored discs and will have its turn
 * decided in a random way.
 * @author lucia
 *
 */
public class Player {
	// Instance Variables
	
	/*
	 * The name that the player choose for themselves at the beginning of the game. 
	 */
	private String playerName;
	
	/*
	 * The color that the player choose for their colored discs
	 */
	private String playerColor;
	
	/*
	 * The number that identifies the turn of the player in the flow of the game (it can be 1, if the player
	 * is the first to move the discs, or 2)
	 */
	private int playerNumber;
	
	
	// Methods
	
	/**
	 * The class constructor: it creates a new player giving them the name that they choose as the nickname
	 * in the game.
	 * It does not give a value for the playerColor because the player will choose it later and it does not
	 * give a value to playerNumber because the order will be randomly choose at the beginning of the game
	 * @param nickname The nickname that the player choose for themselves: it will be used to refer to the player
	 * during the game
	 */
	public Player(String nickname) {
		playerName = nickname;
		playerColor = "";
		playerNumber = 0;
	}
	
	/**
	 * This method is used to get the nickname of the current player
	 * @return The value of playerName: the nickname of the current player
	 */
	public String getPlayerName() {
		return playerName;
	}
	
	/**
	 * This method is used to get the color that the current player choose for its colored discs
	 * @return The value of playerColor: the color of the colored disc of the current player
	 */
	public String getPlayerColor() {
		return playerColor;
	}
	
	/**
	 * This method is used to get the number of the current player: the number identifies the order of the player
	 * during the game
	 * @return The value of playerNumber: the number that takes account of the order of the players during the
	 * game.
	 * Note that this value can only be 1 or 2
	 */
	public int getPlayerNumber() {
		return playerNumber;
	}
	
	/**
	 * This method is used to randomly assign an order to players in the game.
	 * If the players try to reassign the order after it has been decided an exception occurs.
	 * @param otherPlayer The other player of the game
	 */
	public void setPlayerNumbers(Player otherPlayer) {
		/*
		 * This method is made by two part.
		 * The first one is the part of the method that is executed when both players still not have a number
		 * that identifies their order in the game
		 */
		if(otherPlayer.getPlayerNumber() == 0) {
			Random rand = new Random();
			if(rand.nextInt(2) == 0) {
				playerNumber = 1;
				otherPlayer.setPlayerNumber(2);
			}
			else{
				playerNumber = 2;
				otherPlayer.setPlayerNumber(1);
			}
		}
		/*
		 * The second one is executed if one player already has an order in the game: an exception occurs
		 */
		else {
			System.out.println("The order has already been decided");
		}
	}
	
	/**
	 * This method is used to set the value of the instance variable playerNumber.
	 * The method also checks that the value assigned to the instance variable is a legal one
	 * @param assignedNumber The value to give to the instance variable playerNumber
	 */
	public void setPlayerNumber(int assignedNumber) {
		if(assignedNumber == 1 || assignedNumber == 2) {
			playerNumber = assignedNumber;
		}
		else
			System.out.println("The value is not valid");
	}
	
	
	/**
	 * This method let the player choose the color red as the color for it's colored discs.
	 * The method checks if the player that called the method is the first one in the game, it checks if the 
	 * players doesn't have already colors assigned and checks if the color hasn't already be taken by the other
	 * player.
	 * If the color is free the method set the value of the instance variable playerColor to the String red
	 * @param otherPlayer The other player of the game
	 */
	public void iAmRed(Player otherPlayer) {
		if(playerNumber != 1) System.out.println(playerName + ", you can't choose, you are the player number two");
		
		else {
			if(otherPlayer.getPlayerColor().equals("")) {
				this.playerColor = "red";
				otherPlayer.setPlayerColor("yellow");
			}
			else if(otherPlayer.getPlayerColor().equals("red"))
				System.out.println("There's already a player with red discs");
			// this will turn into an exception as soon as I will understand how to make them
			else System.out.println("Colors have been already decided");
		}
	}
	
	/**
	 * This method let the player choose the color red as the color for it's colored discs.
	 * The method checks if the player that called the method is the first one in the game, it checks if the 
	 * players doesn't have already colors assigned and checks if the color hasn't already be taken by the other
	 * player.
	 * If the color is free the method set the value of the instance variable playerColor to the String yellow
	 * @param otherPlayer The other player of the game
	 */
	public void iAmYellow(Player otherPlayer) {
		if(playerNumber != 1) System.out.println(playerName + ", you can't choose, you are the player number two");
		
		else {
			if(otherPlayer.getPlayerColor().equals("")) {
				this.playerColor = "yellow";
				otherPlayer.setPlayerColor("red");
			}
			else if(otherPlayer.getPlayerColor().equals("yellow"))
				System.out.println("There's already a player with yellow discs");
			// this will turn into an exception as soon as I will understand how to make them
			else System.out.println("Colors have been already decided");
		}
		
	}
	
	
	/**
	 * This method is used to set the value of the instance variable playerColor.
	 * The method also checks if the value to be set is a legal one.
	 * @param color The value to give to the instance variable playerColor
	 */
	public void setPlayerColor(String color) {
		playerColor = color;
	}
}
