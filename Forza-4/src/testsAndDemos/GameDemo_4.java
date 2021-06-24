package testsAndDemos;

import gameComponents.*;

import java.util.Date;

import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

/**
 * This class is a demo for a game in which the exception for choosing a missing save file occurs
 * @author lucia
 *
 */
public class GameDemo_4 {
	public static void main(String[] args) {
		boolean newGame = false;
		String savedFile = "";
		int[][] savedGrid;
		JSONObject gameData = new JSONObject();
		boolean choosingTypeGame = true;
		File savedDir = new File("FileForTests");
		
		while(choosingTypeGame) {
			System.out.println("WELCOME TO CONNECT 4");
			System.out.println("Hello player, do you want to begin a new game or load a previous one?");
			System.out.println("Write 'new' to begin a new game or write 'load' to load a previous one");
			System.out.println("load");
			// This is a wrong answer to the game choice
			String game = "load";
			// The player can give any answer they want, so if the answer doesn't match the one that the game can recognize an exception occurs
			try {
				// The player decided to load a previous game
				if(game.equalsIgnoreCase("load")) {
					choosingTypeGame = false;
					// Now it will be checked if the directory used for storing the saved files exist
					try {
						if(savedDir.isDirectory() && savedDir.exists()) {
							// There are no previously saved games, the players must begin a new game
							if(savedDir.list().length == 0) {
								System.out.println("There aren't previously saved games, you must begin a new one");
								newGame = true;
							}
							// There is at least a previously saved game
							else {
								System.out.println("These are the possible game to be loaded");
								// An ordered list of all the saved games is printed
								for(int i = 0; i < savedDir.list().length; i++) {
									// The i+1 is used to let the player see that the list begin from 1
									System.out.println(i+1 + ") " + savedDir.list()[i]);
								}
								/*
								 *  The player will now choose which of the saved game want to play, the program will also give them the possibility to exit from
								 *  the loading screen to begin a new game
								 */
								System.out.println("Choose one and tell me the number of the game you want to load or write '-1' to begin a new game");
								// This boolean variable is used to give the player the possibility to give a different answer if they give a wrong one
								boolean chosen = false;
								while(!chosen) {
									// This is used to store player's answer, it's used a String so that the possibility in which the player answer with a letter is covered
									String savedGameChosen = " ";
									System.out.println("");
									try {
										// The answer the player gave is transformed into an Integer
										int savedGame = Integer.parseInt(savedGameChosen);
										// The player gave a legal answer
										try {
											// The player asked for a saved game that isn't present
											if(savedGame > savedDir.list().length || (savedGame < 1 && savedGame != -1)) {
												throw new IllegalAnswerException("The answer you gave is not valid");
											}
											// The player asked to begin a new game
											else if(savedGame == -1) {
												chosen = true;
												newGame = true;
											}
											// The player chose an existing save file
											else {
												// The name of the chosen saved file is the one whose identifier is the one typed by the player-1 because the list began from 1 and not from 0
												savedFile = savedDir.list()[savedGame-1].toString() ;
												chosen = true;
											}
										}
										catch(IllegalAnswerException thirdIllegalAnswer) {
											System.out.println("The answer you gave is not valid");
											System.out.println("You can only choose one of the saved game that are present");
											System.out.println();
											break;
										}
									}
									catch(NumberFormatException secondIllegalAnswer) {
										System.out.println("You must tell me the identifier of the game you want to load or tell me if you want to begin a new game");
										System.out.println();
										System.exit(0);
									}
								}
							}
						}
						else
							throw new DirectoryNotFoundException("The searched directory doesn't exist");
					}
					catch(DirectoryNotFoundException missingDirectory) {
						System.out.println("The directory of the save files doesn't exist");
						missingDirectory.printStackTrace();
						break;
					}
					// The program proceeds to load the chosen saved file
					if(!newGame) {
						try {
							// This is a check to see if the file hasn't been deleted in the time in which the player was choosing it
							if(!savedFile.equals("")) {
								// All the game assets are loaded
								// The players
								Player player1 = new Player();
								player1.loadingPlayer1(savedFile);
								Player player2 = new Player();
								player2.loadingPlayer2(savedFile);
								// The grid
								PlayingGrid grid = new PlayingGrid(savedFile);
								
								// Now users can play the loaded game
								// First of all the grid is printed so the players can see how was it when they saved the game
								grid.playingGridPrinter();
								
								// Now they are ready to do their moves up until either one of them wins or the game ends with a tie
								while(!grid.isItATie()) {
									// The program choose to which player give the control of the next move
									// This means that there are an even number of free spaces so it must be the turn of the player #1
									if(grid.getFreeSpaces() % 2 == 0) {
										// A new disc to be positioned is created
										ColoredDisc activeDisc = new ColoredDisc(player1.getPlayerColor());
										/*
										 *  The program asks the player in which column they want to put their disc or if they want either
										 *  to save or exit the game
										 */
										System.out.println(player1.getPlayerName() + " in which column do you want to put your disc? (press s to save, e to exit)");
										// This is the player answer
										String answer = "";
										try {
											// The player decided to save the game
											if(answer.equalsIgnoreCase("s")) {
												// The object representing the game is created
												gameData = Player.savingPlayers(gameData, player1, player2);
												savedGrid = grid.playingGridToJSONPlayingGrid();
												gameData = PlayingGrid.savingPlayingGrid(gameData, savedGrid);
												// Now the program tries to save it to a file
												try(PrintWriter savedGame = new PrintWriter("FileForTests/" + savedFile)){
													savedGame.write(gameData.toString());
													savedGame.flush();
													savedGame.close();
												}
												catch(FileNotFoundException savedFileNotFound) {
													System.out.println("The requested save file is missing");
													savedFileNotFound.printStackTrace();
												}
											}
											// The player decided to exit the game
											else if(answer.equalsIgnoreCase("e")) {
												System.out.println("Goodbye");
												break;
											}
											// The player decided to type the column in which they want to put the disc: the column must be a single number between 1 and 7
											else if(answer.matches("[1-7]{1}")) {
												// The answer is transformed into an integer
												int columnIndex = Integer.parseInt(answer);
												// The column chosen is passed to the active disc
												activeDisc.setColumn(columnIndex);
												// Now it tries to insert the disc into the column
												if(grid.addColoredDisc(activeDisc)) {
													// The program tests if the move just played is the winning move of the game
													if(grid.isTheWinningMove(activeDisc.getRow(), activeDisc.getColumn())){
														// If so it tells the player that they win
														System.out.println("Congratulations " + player1.getPlayerName() + " you won!");
														// And print the grid with the winning discs
														grid.playingGridPrinter();
														break;
													}
													else
														// If it isn't the winning move it just print the grid
														grid.playingGridPrinter();													
												}
											}
											else
												throw new IllegalAnswerException("The answer you gave is not valid");
										}
										catch(IllegalAnswerException player1IllegalAnswer) {
											System.out.println("The answer you gave is not valid");
											System.out.println("During your turn you can:");
											System.out.println("	- make your move by telling the column in which you want to put the disc");
											System.out.println("	- save the game by wrting 's'");
											System.out.println("	- exit from the game by writing 'e'");
											System.out.println();
										}
									}
									// This means that there are an odd number of free spaces so it must be the turn of the player #2
									if(grid.getFreeSpaces() % 2 == 1) {
										// The program just works as described before
										ColoredDisc activeDisc = new ColoredDisc(player2.getPlayerColor());
										System.out.println(player2.getPlayerName() + " in which column do you want to put your disc? (press s to save, e to exit");
										String answer = "";
										try {
											if(answer.equalsIgnoreCase("s")) {
												gameData = Player.savingPlayers(gameData, player1, player2);
												savedGrid = grid.playingGridToJSONPlayingGrid();
												gameData = PlayingGrid.savingPlayingGrid(gameData, savedGrid);
												try(PrintWriter savedGame = new PrintWriter("FileForTests/" + savedFile)){
													savedGame.write(gameData.toString());
													savedGame.flush();
													savedGame.close();
												}
												catch(FileNotFoundException savedFileNotFound) {
													System.out.println("The requested save file is missing");
													savedFileNotFound.printStackTrace();
												}
											}
											else if(answer.equalsIgnoreCase("e")) {
												System.out.println("Goodbye");
												break;
											}
											else if(answer.matches("[1-7]{1}")) {
												int columnIndex = Integer.parseInt(answer);
												activeDisc.setColumn(columnIndex);
												if(grid.addColoredDisc(activeDisc)) {
													if(grid.isTheWinningMove(activeDisc.getRow(), activeDisc.getColumn())) {
														System.out.println("Congratulations " + player2.getPlayerName() + " you won!");
														grid.playingGridPrinter();
														break;
													}
													else
														grid.playingGridPrinter();
												}
											}
											else
												throw new IllegalAnswerException("The answer you gave is not valid");
										}
										catch(IllegalAnswerException player2IllegalAnswer) {
											System.out.println("The answer you gave is not valid");
											System.out.println("During your turn you can:");
											System.out.println("	- make your move by telling the column in which you want to put the disc");
											System.out.println("	- save the game by wrting 's'");
											System.out.println("	- exit from the game by writing 'e'");
											System.out.println();
										}
									}
								}
							}
							else
								throw new FileNotFoundException("Cannot find the requested file");
						}
						catch(FileNotFoundException fileNotFound) {
							System.out.println("The saved game chosen is corrupted you must begin all over again");
							choosingTypeGame = true;
						}
					}
				}
				// The player decided to create a new game
				if(game.equalsIgnoreCase("new") || newGame) {
					choosingTypeGame = false;
					
					// Now the program proceeds with the creation of the players
					System.out.println("Hello player, what's your name?");
					String nickname1 = "";
					System.out.println("And how's your rival named?");
					String nickname2 = "";
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
					// This boolean variable is used to let the user choose the color even if they give a wrong answer at first
					boolean choosing = true;
					while(choosing) {
						try {
							String color = "";
							if(color.equalsIgnoreCase("red")) {
								player1.iAmRed(player2);
								choosing = false;
							}
							else if(color.equalsIgnoreCase("yellow")) {
								player1.iAmYellow(player2);
								choosing = false;
							}
							else {
								throw new IllegalAnswerException("The answer you gave is not valid");
							}
						}
						catch(IllegalAnswerException invalidColorAnswer) {
							System.out.println("The answer you gave is not valid");
							System.out.println("Only red and yellow are allowed, so choose one of them");
						}
					}
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
					
					// A saving file for the current game is created
					String fileSuffix = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss").format(new Date());
					/*
					 *  The file will have a name with the following structure:
					 *  	player#1name_player#2name_dateAndTimeOfTheFirstSaving.json
					 */
					String fileName = player1.getPlayerName() + "_" + player2.getPlayerName() + "_" + fileSuffix + ".json";
					// The program creates the JSONObject to be saved
					// Saving players
					gameData = Player.savingPlayers(gameData, player1, player2);
					// Translating the grid
					savedGrid = grid.playingGridToJSONPlayingGrid();
					// Saving the grid
					gameData = PlayingGrid.savingPlayingGrid(gameData, savedGrid);
					// The program writes the saving file
					try(PrintWriter savedGame = new PrintWriter("FileForTests/" + fileName)){
						savedGame.write(gameData.toString());
						savedGame.flush();
						savedGame.close();
					}
					catch(FileNotFoundException savedFileNotFound) {
						System.out.println("The requested save file is missing");
						savedFileNotFound.printStackTrace();
					}
					
					// Now the game begins
					// The program works as described before
					grid.playingGridPrinter();
					while(!grid.isItATie()) {
						if(grid.getFreeSpaces() % 2 == 0) {
							ColoredDisc activeDisc = new ColoredDisc(player1.getPlayerColor());
							System.out.println(player1.getPlayerName() + " in which column do you want to put your disc? (press 's' to save, 'e' to exit)");
							String answer = "";
							try {
								if(answer.equalsIgnoreCase("s")) {
									gameData = Player.savingPlayers(gameData, player1, player2);
									savedGrid = grid.playingGridToJSONPlayingGrid();
									gameData = PlayingGrid.savingPlayingGrid(gameData, savedGrid);
									try(PrintWriter savedGame = new PrintWriter("FileForTests/" + fileName)){
										savedGame.write(gameData.toString());
										savedGame.flush();
										savedGame.close();
									}
									catch(FileNotFoundException savedFileNotFound) {
										System.out.println("The requested save file is missing");
										savedFileNotFound.printStackTrace();
									}
								}
								else if(answer.equalsIgnoreCase("e")) {
									System.out.println("Goodbye");
									break;
								}
								else if(answer.matches("[1-7]{1}")) {
									int columnIndex = Integer.parseInt(answer);
									activeDisc.setColumn(columnIndex);
									if(grid.addColoredDisc(activeDisc)) {
										if(grid.isTheWinningMove(activeDisc.getRow(), activeDisc.getColumn())) {
											System.out.println("Congratulations " + player1.getPlayerName() + " you won!");
											grid.playingGridPrinter();
											break;
										}
										else
											grid.playingGridPrinter();
									}
								}
								else
									throw new IllegalAnswerException("the answer you gave is not valid");
							}
							catch(IllegalAnswerException player1IllegalAnswer) {
								System.out.println("The answer you gave is not valid");
								System.out.println("During your turn you can:");
								System.out.println("	- make your move by telling the column in which you want to put the disc");
								System.out.println("	- save the game by wrting 's'");
								System.out.println("	- exit from the game by writing 'e'");
								System.out.println();
							}
						}
						if(grid.getFreeSpaces() % 2 == 1) {
							ColoredDisc activeDisc = new ColoredDisc(player2.getPlayerColor());
							System.out.println(player2.getPlayerName() + " in which column do you want to put your disc? (press 's' to save, 'e' to exit)");
							String answer = "";
							try {
								if(answer.equalsIgnoreCase("s")) {
									gameData = Player.savingPlayers(gameData, player1, player2);
									savedGrid = grid.playingGridToJSONPlayingGrid();
									gameData = PlayingGrid.savingPlayingGrid(gameData, savedGrid);
									try(PrintWriter savedGame = new PrintWriter("FileForTests/" + fileName)){
										savedGame.write(gameData.toString());
										savedGame.flush();
										savedGame.close();
									}
									catch(FileNotFoundException savedFileNotFound) {
										System.out.println("The requested save file is missing");
										savedFileNotFound.printStackTrace();
									}
								}
								else if(answer.equalsIgnoreCase("e")) {
									System.out.println("Goodbye");
									break;
								}
								else if(answer.matches("[1-7]{1}")) {
									int columnIndex = Integer.parseInt(answer);
									activeDisc.setColumn(columnIndex);
									if(grid.addColoredDisc(activeDisc)) {
										if(grid.isTheWinningMove(activeDisc.getRow(), activeDisc.getColumn())) {
											System.out.println("Congratulations " + player2.getPlayerName() + " you won!");
											grid.playingGridPrinter();
											break;
										}
										else
											grid.playingGridPrinter();
									}
								}
								else
									throw new IllegalAnswerException("The answer you gave is not valid");
							}
							catch(IllegalAnswerException player2IllegalAnswer) {
								System.out.println("The answer you gave is not valid");
								System.out.println("During your turn you can:");
								System.out.println("	- make your move by telling the column in which you want to put the disc");
								System.out.println("	- save the game by wrting 's'");
								System.out.println("	- exit from the game by writing 'e'");
								System.out.println();
							}
						}
					}
				}
				else
					throw new IllegalAnswerException("The answer you gave is not valid");
			}
			catch(IllegalAnswerException firstIllegalAnswer) {
				// Note that this change in the boolean variable is used only here because it must block the execution of the program
				// in the real program there isn't this command so the player can enter a new answer to the question
				choosingTypeGame = false;
				System.out.println("The answer you gave is not valid");
				System.out.println("You can only choose between creating a new game or loading a previous one");
				System.out.println();
			}
		}
	}

}
