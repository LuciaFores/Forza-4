package tests;

import gameComponents.Player;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.io.FileWriter;
import java.io.IOException;

public class WritingJSONFile {
	public static void main(String[] args) {
		// Created a test player
		Player p = new Player("Lucietti");
		p.setPlayerColor("red");
		p.setPlayerNumber(1);
		
		Player p1 = new Player("Lucia");
		p.setPlayerColor("yellow");
		p.setPlayerNumber(2);
		
		// We want to create a JSON file storing player's data
		JSONObject player1 = new JSONObject();
		player1.put("nickname", p.getPlayerName());
		player1.put("color", p.getPlayerColor());
		player1.put("number", p.getPlayerNumber());
		
		JSONObject player2 = new JSONObject();
		player2.put("nickname", p1.getPlayerName());
		player2.put("color", p1.getPlayerColor());
		player2.put("number", p1.getPlayerNumber());
		
		JSONObject player = new JSONObject();
		player.put("player1", player1);
		player.put("player2", player2);
		
		
		int row = 3;
		int col = 4;
		int[][] matrix = {
				{0, 1, -1, 0},
				{1, 1, 0, -1},
				{0, 1, 0, 0}
				};
		
		JSONObject playingMatrix = new JSONObject();
		JSONObject JSONMatrix = new JSONObject();
		JSONArray firstRow = new JSONArray();
		JSONArray secondRow = new JSONArray();
		JSONArray thirdRow = new JSONArray();
		
		for(int j = 0; j < 4; j++) {
			firstRow.add(matrix[0][j]);
			secondRow.add(matrix[1][j]);
			thirdRow.add(matrix[2][j]);
		}
		
		JSONMatrix.put("firstRow", firstRow);
		JSONMatrix.put("secondRow", secondRow);
		JSONMatrix.put("thirdRow", thirdRow);
		
		player.put("matrix", JSONMatrix);
		// We want to write the JSON object into a text file
		try {
			FileWriter file = new FileWriter("player.json");
			file.write(player.toString());
			file.flush();
			file.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		// We want to read the file and assign those properties to another object
		/*Player p2 = new Player(player.get("nickname").toString().concat(" read from JSON file"));
		p2.setPlayerColor(player.get("color").toString().concat(" read from JSON file"));
		p2.setPlayerNumber(Integer.parseInt(player.get("number").toString()));
		
		System.out.println(p2.getPlayerName());
		System.out.println(p2.getPlayerColor());
		System.out.println(p2.getPlayerNumber());*/
		
		// Now we want to save a matrix into the JSON file
		
		
		// We want to write the JSON object into a text file
		try {
			FileWriter file = new FileWriter("player.json");
			file.write(player.toString());
			file.flush();
			file.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		// We want to read the file, store the matrix and then print the matrix
		int[][] readMatrix = new int[3][4];
		for(int j = 0; j < 4; j++) {
			readMatrix[0][j] = (int) firstRow.get(j);
			readMatrix[1][j] = (int) secondRow.get(j);
			readMatrix[2][j] = (int) thirdRow.get(j);
		}
		
		System.out.println();
		
		for(int i = 0; i < 3; i++) {
			if(i == 0) {
				System.out.println("[");
			}
			for(int j = 0; j < 4; j++) {
				if(j == 0) {
					System.out.print("[" + readMatrix[i][j] + ", ");
				}
				else if(j == 3) {
					System.out.println(readMatrix[i][j] + "]");
				}
				else
					System.out.print(readMatrix[i][j] + ", ");
			}
			if(i == 2) {
				System.out.print("]");
			}
		}
	}
}
