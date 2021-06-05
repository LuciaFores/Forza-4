package Tests;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadingJSONFile {
	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		
		try {
			/*Object readFile = parser.parse(new FileReader("matrix.json"));
			JSONObject readJSONFile = (JSONObject)readFile;
			String[] firstRow = readJSONFile.get("firstRow").toString().split("[\\[,\\]]");
			String[] secondRow = readJSONFile.get("secondRow").toString().split("[\\[,\\]]");
			String[] thirdRow = readJSONFile.get("thirdRow").toString().split("[\\[,\\]]");
			int[][] matrix = new int[3][4];
			for(int j = 0; j < 4; j++ ) {
				matrix[0][j] = Integer.parseInt(firstRow[j+1]);
				matrix[1][j] = Integer.parseInt(secondRow[j+1]);
				matrix[2][j] = Integer.parseInt(thirdRow[j+1]);
			}
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 4; j++) {
					System.out.print(matrix[i][j] + ", ");
				}
				System.out.println();
			}*/
			Object readPlayerFile = parser.parse(new FileReader("player.json"));
			JSONObject readJSONPlayerFile = (JSONObject)readPlayerFile;
			JSONObject player1 = (JSONObject) readJSONPlayerFile.get("player1");
			System.out.println(player1.get("nickname"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
