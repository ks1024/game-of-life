package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameLoader {

	public static GameOfLife loadFromFile(String fileName) {

		GameOfLife game = null;
		BufferedReader br;
		try {
			int rowNb = 0;
			int colNb = 0;
			List<Cell> cells = new ArrayList<Cell>();
			br = new BufferedReader(new FileReader(fileName));
			String line = br.readLine();
			while (line != null) {
				line = line.replace(" ", "");
				char[] charArray = line.toCharArray();
				colNb = charArray.length;
				for (int i = 0; i < colNb; i++) {
					if (charArray[i] == '*') {
						cells.add(new Cell(rowNb, i));
					}
				}
				line = br.readLine();
				rowNb++;
			}
			game = new GameOfLife(colNb, rowNb, cells);
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return game;
	}
}
