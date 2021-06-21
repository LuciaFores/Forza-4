package tests;

import gameComponents.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import org.json.simple.JSONObject;

import java.util.Date;
import java.util.Scanner;

public class Game {
	private PlayingGrid gameGrid;
	private Player player1;
	private Player player2;
	private File savedDir;
	private String savedFile;
	JSONObject gameData;
	
	public Game() {
		gameGrid = new PlayingGrid();
		player1 = new Player();
		player2 = new Player();
		savedDir = new File("savedFiles");
		savedFile = "";
		gameData = new JSONObject();
	}
	
	
	public File getSavedDir() {
		return savedDir;
	}
	
	
	public PlayingGrid getGameGrid() {
		return gameGrid;
	}
	
	
	public Player getPlayer1() {
		return player1;
	}
	
	
	public Player getPlayer2(){
		return player2;
	}
	
	public void setSavedFile() {
		String fileSuffix = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss").format(new Date());
		savedFile = player1.getPlayerName() + "_" + player2.getPlayerName() + "_" + fileSuffix + ".json";
	}
	
	/*
	 * Controlla se la directory esiste
	 */
	public boolean doesTheDirectoryExists() {
		if(savedDir.isDirectory() && savedDir.exists())
			return true;
		return false;
	}
	
	/*
	 * controlla se ci sono partite salvate
	 */
	public boolean areThereSomeSavedGames() {
		if(savedDir.list().length != 0) {
			//System.out.println("There aren't saved games, you must begin a new one");
			return true;
		}
		return false;
	}
	
	
	public boolean isSavedGameLegal(int savedGameIdentifier) {
		if(savedGameIdentifier > savedDir.list().length || (savedGameIdentifier < 1 && savedGameIdentifier != -1))
			return false;
		return true;
	}
	
	
	
	public void loadingGame(int savedGameIdentifier) {
		savedFile = savedDir.list()[savedGameIdentifier-1].toString();
		// creo i due giocatori
		player1 = new Player();
		player1.loadingPlayer1(savedFile);
		player2 = new Player();
		player2.loadingPlayer2(savedFile);
		// creo la griglia
		gameGrid = new PlayingGrid(savedFile);
	}
	
	
	
	public void playingGame(Player player, int nextMove) {
		ColoredDisc activeDisc = new ColoredDisc(player.getPlayerColor());
		activeDisc.setColumn(nextMove);
		if(gameGrid.addColoredDisc(activeDisc)) {
			if(gameGrid.isTheWinningMove(activeDisc.getRow(), activeDisc.getColumn())) {
				System.out.println("Congratulations " + player.getPlayerName() + " you won!");
				gameGrid.playingGridPrinter();
			}
			else
				gameGrid.playingGridPrinter();
		}
	}
	
	
	public void savingGame() {
		gameData = Player.savingPlayers(gameData, player1, player2);
		int[][] savedGrid = gameGrid.playingGridToJSONPlayingGrid();
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
	
	
	
	public void creatingGame(String nickname1, String nickname2) {
		Scanner in = new Scanner(System.in);
		Player firstCreatedPlayer = new Player();
		Player secondCreatedPlayer = new Player();
		firstCreatedPlayer.setPlayerName(nickname1);
		secondCreatedPlayer.setPlayerName(nickname2);
		System.out.println();
		System.out.println("Now the fate will choose the order in which you two will play.");
		firstCreatedPlayer.setPlayerNumbers(secondCreatedPlayer);
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
				System.out.println("As i already said, only red and yellow are allowed, so choose one of them");
			}
		}
	}
}
