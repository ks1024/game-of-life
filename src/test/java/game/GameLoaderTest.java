package game;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameLoaderTest {
	
	public static final String FILENAME = "src/test/resources/smallExploder.txt";

	@Test
	public void loadFromFile() {
		GameOfLife gameOfLife = GameLoader.loadFromFile(FILENAME);
		System.out.println(gameOfLife.print());
		String[] lines = gameOfLife.print().split("\n");
		assertEquals(". . . . . . . . . . . . . . . ", lines[0]);
		assertEquals(". . . * * * . . . * * * . . . ", lines[1]);
		assertEquals(". . . . . . . . . . . . . . . ", lines[2]);
		assertEquals(". * . . . . * . * . . . . * . ", lines[3]);
		assertEquals(". * . . . . * . * . . . . * . ", lines[4]);
		assertEquals(". * . . . . * . * . . . . * . ", lines[5]);
		assertEquals(". . . * * * . . . * * * . . . ", lines[6]);
		assertEquals(". . . . . . . . . . . . . . . ", lines[7]);
		assertEquals(". . . * * * . . . * * * . . . ", lines[8]);
		assertEquals(". * . . . . * . * . . . . * . ", lines[9]);
		assertEquals(". * . . . . * . * . . . . * . ", lines[10]);
		assertEquals(". * . . . . * . * . . . . * . ", lines[11]);
		assertEquals(". . . . . . . . . . . . . . . ", lines[12]);
		assertEquals(". . . * * * . . . * * * . . . ", lines[13]);
		assertEquals(". . . . . . . . . . . . . . . ", lines[14]);
	}
}
