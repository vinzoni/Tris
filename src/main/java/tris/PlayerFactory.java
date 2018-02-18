package tris;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PlayerFactory {
	
	static int playerCount = 0;
	
	public static Player getInstance(Properties properties) throws FileNotFoundException, IOException {
		
		String player_1_Type = properties.getProperty("player_1_type");
		String player_1_Name = properties.getProperty("player_1_name");
		String player_2_Type = properties.getProperty("player_2_type");
		String player_2_Name = properties.getProperty("player_2_name");

		playerCount ++;
		return buildPlayerInstance(
					playerCount % 2 == 1 ? player_1_Type : player_2_Type, 
					playerCount % 2 == 1 ? player_1_Name : player_2_Name,					
					playerCount % 2 == 1 ? 'X' : 'O');
	}

	private static Player buildPlayerInstance(String type, String name, char symbol) {
		
		switch (type) {
			case "human":
				return new HumanPlayer(name, symbol);
			case "ai":
			default:
				return new AIPlayer(name, symbol);
		}
	}
}
