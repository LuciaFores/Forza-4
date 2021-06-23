package tests;

import gameComponents.*;

import java.util.Date;
import java.util.Scanner;

import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

public class GameTestSaveAndLoad {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean newGame = false;
		String savedFile = "";
		int[][] savedGrid; 
		JSONObject gameData = new JSONObject();
		boolean choosingTypeGame = true;
		
		while(choosingTypeGame) {
			System.out.println("WELCOME TO CONNECT 4");
			System.out.println("Hello player, do you want to begin a new game or load a previous one?");
			System.out.println("Write 'new' to begin a new game or write 'load' to load a previous one");
			
			String game = in.nextLine();
			File savedDir = new File("SavedFiles");
			try {
				if(game.equalsIgnoreCase("load")) {
					choosingTypeGame = true;
					// vedo se esiste la cartella per il salvataggio
					if(savedDir.isDirectory() && savedDir.exists()) {
						// non ci sono salvataggi pregressi
						if(savedDir.list().length == 0) {
							System.out.println("There aren't saved games, you must begin a new one");
							newGame = true;
							
						}
						// ci sono salvataggi
						else {
							System.out.println("These are the possible game to load");
							for(int i = 0; i < savedDir.list().length; i++) {
								System.out.println(i+1 +") " + savedDir.list()[i]);
							}
							System.out.println("Choose one and please tell me the number of the one you want to load, or write '-1' to begin a new game");
							boolean chosen = false;
							while(!chosen) {
								int savedGameChosen = in.nextInt();
								// è stato richiesto un salvatggio non esistente: i salvataggi vanno da 1 a quanti sono i file presenti
								// nella cartella
								if(savedGameChosen > savedDir.list().length /*|| savedGameChosen < 1 && savedGameChosen != -1*/) {
									System.out.println("That saved game doesn't exist");
								}
								else if(savedGameChosen == -1) {
									chosen = true;
									newGame = true;
								}
								// è stato scelto un savataggio esistente
								else {
									savedFile = savedDir.list()[savedGameChosen-1].toString();
									chosen = true;
								}
							}
							// procedo a caricare la partita selezionata
							if(!savedFile.equals("")) {
								// creo i due giocatori
								Player player1 = new Player();
								player1.loadingPlayer1(savedFile);
								Player player2 = new Player();
								player2.loadingPlayer2(savedFile);
								// creo la griglia
								PlayingGrid grid = new PlayingGrid(savedFile);
								
								
								grid.playingGridPrinter();
								// gioco la partita
								while(!grid.isItATie()) {
									if(grid.getFreeSpaces() % 2 == 0) {
										ColoredDisc activeDisc = new ColoredDisc(player1.getPlayerColor());
										System.out.println(player1.getPlayerName() + " in which column do you want to put your disc? (press s to save, e to exit)");
										String answer = in.next();
										if(answer.equalsIgnoreCase("s")) {
											gameData = Player.savingPlayers(gameData, player1, player2);
											savedGrid = grid.playingGridToJSONPlayingGrid();
											gameData = PlayingGrid.savingPlayingGrid(gameData, savedGrid);
											//File file = new File("SavedFiles/" + savedFile + ".json");
											try(PrintWriter savedGame = new PrintWriter("SavedFiles/" + savedFile)) {
												savedGame.write(gameData.toString());
												savedGame.flush();
												savedGame.close();
											}
											catch(FileNotFoundException e){
												e.printStackTrace();
											}
										}
										else if(answer.equalsIgnoreCase("e")) {
											System.out.println("Goodbye");
											break;
										}
										else if(answer.matches("[0-6]+")) {
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
									}
									if(grid.getFreeSpaces() % 2 == 1) {
										ColoredDisc activeDisc = new ColoredDisc(player2.getPlayerColor());
										System.out.println(player2.getPlayerName() + " in which column do you want to put your disc? (press s to save, e to exit)");
										String answer = in.next();
										if(answer.equalsIgnoreCase("s")) {
											gameData = Player.savingPlayers(gameData, player1, player2);
											savedGrid = grid.playingGridToJSONPlayingGrid();
											gameData = PlayingGrid.savingPlayingGrid(gameData, savedGrid);
											try(PrintWriter savedGame = new PrintWriter("SavedFiles/" + savedFile)) {
												savedGame.write(gameData.toString());
												savedGame.flush();
												savedGame.close();
											}
											catch(FileNotFoundException e){
												e.printStackTrace();
											}
										}
										else if(answer.equalsIgnoreCase("e")) {
											System.out.println("Goodbye");
											break;
										}
										else if(answer.matches("[0-6]+")) {
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
									}
								}
							}
						}
					}
				}
				// se non esiste la creo
				if(game.equalsIgnoreCase("new") || newGame) {
					choosingTypeGame = true;
					System.out.println("Hello player, what's your name?");
					String nickname1 = in.next();
					System.out.println("And how's your rival named?");
					String nickname2 = in.next();
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
					try {
						while(choosing) {
							String color1 = in.next();
							if(color1.equalsIgnoreCase("red")) {
								player1.iAmRed(player2);
								choosing = false;
							}
							else if(color1.equalsIgnoreCase("yellow")) {
								player1.iAmYellow(player2);
								choosing = false;
							}
							else {
								throw new IllegalAnswerException("The answer you gave is not valid");
							}
						}
					}
					catch(IllegalAnswerException invalidAnswern) {
						System.out.println("The answer you gave is not valid");
						System.out.println("Only red and yellow are allowed, so choose one of them");
					}
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
					
					// creo un salvataggio per la partita in corso
					String fileSuffix = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss").format(new Date());
					
					String fileName = player1.getPlayerName() + "_" + player2.getPlayerName() + "_" + fileSuffix + ".json";
					
					// salvataggio dello stato iniziale della partita
					// salvo i giocatori
					gameData = Player.savingPlayers(gameData, player1, player2);
					// salvo la griglia
					savedGrid = grid.playingGridToJSONPlayingGrid();
					gameData = PlayingGrid.savingPlayingGrid(gameData, savedGrid);
					
					try(PrintWriter savedGame = new PrintWriter("SavedFiles/" + fileName)) {
						savedGame.write(gameData.toString());
						savedGame.flush();
						savedGame.close();
					}
					catch(FileNotFoundException fileException){
						fileException.printStackTrace();
					}
					
					
					grid.playingGridPrinter();
					// inizio il gioco
					while(!grid.isItATie()) {
						if(grid.getFreeSpaces() % 2 == 0) {
							ColoredDisc activeDisc = new ColoredDisc(player1.getPlayerColor());
							System.out.println(player1.getPlayerName() + " in which column do you want to put your disc? (press s to save, e to exit)");
							String answer = in.next();
							try {
								if(answer.equalsIgnoreCase("s")) {
									gameData = Player.savingPlayers(gameData, player1, player2);
									savedGrid = grid.playingGridToJSONPlayingGrid();
									gameData = PlayingGrid.savingPlayingGrid(gameData, savedGrid);
									try(PrintWriter savedGame = new PrintWriter("SavedFiles/" + fileName)) {
										savedGame.write(gameData.toString());
										savedGame.flush();
										savedGame.close();
									}
									catch(FileNotFoundException fileException1){
										fileException1.printStackTrace();
									}
								}
								else if(answer.equalsIgnoreCase("e")) {
									System.out.println("Goodbye");
									break;
								}
								else if(answer.matches("[0-7]+")) {
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
								else {
									throw new IllegalAnswerException("The answer you gave is not valid");
								}
							}
							catch(IllegalAnswerException invalidAnswer1) {
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
							System.out.println(player2.getPlayerName() + " in which column do you want to put your disc? (press s to save, e to exit)");
							String answer = in.next();
							try {
								if(answer.equalsIgnoreCase("s")) {
									gameData = Player.savingPlayers(gameData, player1, player2);
									savedGrid = grid.playingGridToJSONPlayingGrid();
									gameData = PlayingGrid.savingPlayingGrid(gameData, savedGrid);
									try(PrintWriter savedGame = new PrintWriter("SavedFiles/" + fileName)) {
										savedGame.write(gameData.toString());
										savedGame.flush();
										savedGame.close();
									}
									catch(FileNotFoundException fileException1){
										fileException1.printStackTrace();
									}
								}
								else if(answer.equalsIgnoreCase("e")) {
									System.out.println("Goodbye");
									break;
								}
								else if(answer.matches("[0-7]+")) {
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
								else {
									throw new IllegalAnswerException("The answer you gave is not valid");
								}
							}
							catch(IllegalAnswerException invalidAnswer1) {
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
				else {
					throw new IllegalAnswerException("The answer you gave is not valid");
				}
			}
			catch(IllegalAnswerException firstInvalidAnswer) {
				System.out.println("The answer you gave is not valid");
				System.out.println("You can only choose between creating or loading a game");
				System.out.println();
			}
		}
		
	}
		
}


