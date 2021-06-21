package tests;

import java.util.Scanner;

public class GameClassTest {
	public static void main(String[] args) {
		Game game = new Game();
		Scanner in = new Scanner(System.in);
		boolean newGame= false;
		
		System.out.println("WELCOME TO CONNECT 4");
		System.out.println("Hello player, do you want to begin a new game or load a previous one?");
		System.out.println("Write 'new' to begin a new game or write 'load' to load a previous one");
		
		String choice = in.nextLine();
		
		if(choice.equalsIgnoreCase("load")) {
			// controllo se esiste la directory
			if(game.doesTheDirectoryExists()) {
				// vedo se ci sono partite salvate
				if(!game.areThereSomeSavedGames()) {
					System.out.println("There aren't saved games, you must begin a new one");
					//nuova partita
					System.out.println("Hello player, what's your name?");
					String nickname1 = in.next();
					System.out.println("And how's your rival named?");
					String nickname2 = in.next();
					game.creatingGame(nickname1, nickname2);
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
					newGame = true;
				}
				
				else {
					System.out.println("These are the possible game to load");
					for(int i = 0; i < game.getSavedDir().list().length; i++) {
						System.out.println(i+1 +") " + game.getSavedDir().list()[i]);
					}
					System.out.println("Choose one and please tell me the number of the one you want to load, or write '-1' to begin a new game");
					boolean choosing = true;
					while(choosing) {
						int savedGameChosen = in.nextInt();
						if(savedGameChosen > -1) {
							if(game.isSavedGameLegal(savedGameChosen)) {
								choosing = false;
								game.loadingGame(savedGameChosen);
							}
							else
								System.out.println("That saved game doesn't exist");
						}
						else {
							choosing = true;
							//nuova partita
							System.out.println("Hello player, what's your name?");
							String nickname1 = in.next();
							System.out.println("And how's your rival named?");
							String nickname2 = in.next();
							game.creatingGame(nickname1, nickname2);
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
							newGame = true;
						}
					}
				}
			}
		}
		if(choice.equalsIgnoreCase("new") || newGame) {
			//nuova partita
			System.out.println("Hello player, what's your name?");
			String nickname1 = in.next();
			System.out.println("And how's your rival named?");
			String nickname2 = in.next();
			game.creatingGame(nickname1, nickname2);
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
		}
		//salvo
		game.setSavedFile();
		game.savingGame();
		// stampo la prima volta
		game.getGameGrid().playingGridPrinter();
		while(!game.getGameGrid().isItATie()) {
			if(game.getGameGrid().getFreeSpaces() % 2 == 0) {
				System.out.println(game.getPlayer1().getPlayerName() + " in which column do you want to put your disc? (press s to save)");
				String answer = in.next();
				if(answer.equalsIgnoreCase("s")) {
					//salvo
					game.setSavedFile();
					game.savingGame();
				}
				else if(answer.matches("[0-6]+")) {
					//faccio la mossa
					int nextMove = Integer.parseInt(answer);
					game.playingGame(game.getPlayer1(), nextMove);
				}
			}
			if(game.getGameGrid().getFreeSpaces() % 2 == 0) {
				System.out.println(game.getPlayer2().getPlayerName() + " in which column do you want to put your disc? (press s to save)");
				String answer = in.next();
				if(answer.equalsIgnoreCase("s")) {
					//salvo
					game.setSavedFile();
					game.savingGame();
				}
				else if(answer.matches("[0-6]+")) {
					//faccio la mossa
					int nextMove = Integer.parseInt(answer);
					game.playingGame(game.getPlayer2(), nextMove);
				}
			}
		}
		in.close();
	}
}
