package game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * This a test class for testing GameOfLife class
 * 
 * @author kyan
 * 
 */
public class GameOfLifeTest {

	@Test
	public void generateAndPrint() {
		List<Cell> cells = new ArrayList<Cell>();
		cells.add(new Cell(1, 1));
		cells.add(new Cell(3, 3));
		GameOfLife game = new GameOfLife(4, 4, cells);
		assertEquals(". . . . \n. * . . \n. . . . \n. . . * \n", game.print());
	}

	@Test
	public void underpopulation() {
		// alone
		List<Cell> cells = new ArrayList<Cell>();
		Cell alone = new Cell(0, 1);
		cells.add(alone);
		GameOfLife game = new GameOfLife(4, 4, cells);
		System.out.println(game.print());
		assertTrue(game.isUnderpopulated(alone));

		// with one neighbors
		cells = new ArrayList<Cell>();
		Cell firstNeighbor = new Cell(0, 0);
		cells.add(firstNeighbor);
		cells.add(alone);
		game = new GameOfLife(4, 4, cells);
		System.out.println(game.print());
		assertTrue(game.isUnderpopulated(alone));

		// with two neighbors
		cells = new ArrayList<Cell>();
		Cell secondNeighbor = new Cell(0, 2);
		cells.add(firstNeighbor);
		cells.add(secondNeighbor);
		cells.add(alone);
		game = new GameOfLife(4, 4, cells);
		System.out.println(game.print());
		assertFalse(game.isUnderpopulated(alone));

		// with five neighbors
		cells = new ArrayList<Cell>();
		Cell thirdNeighbor = new Cell(1, 0);
		Cell fourthNeighbor = new Cell(1, 1);
		Cell fifthNeighbor = new Cell(1, 2);
		cells.add(firstNeighbor);
		cells.add(secondNeighbor);
		cells.add(thirdNeighbor);
		cells.add(fourthNeighbor);
		cells.add(fifthNeighbor);
		cells.add(alone);
		game = new GameOfLife(4, 4, cells);
		System.out.println(game.print());
		assertFalse(game.isUnderpopulated(alone));
	}

	@Test
	public void overcrowding() {
		// alone
		List<Cell> cells = new ArrayList<Cell>();
		Cell alone = new Cell(0, 1);
		cells.add(alone);
		GameOfLife game = new GameOfLife(4, 4, cells);
		System.out.println(game.print());
		assertFalse(game.isOvercrowded(alone));

		// with three neighbors
		cells = new ArrayList<Cell>();
		Cell firstNeighbor = new Cell(0, 0);
		Cell secondNeighbor = new Cell(0, 2);
		Cell thirdNeighbor = new Cell(1, 0);
		cells.add(firstNeighbor);
		cells.add(secondNeighbor);
		cells.add(thirdNeighbor);
		cells.add(alone);
		game = new GameOfLife(4, 4, cells);
		System.out.println(game.print());
		assertTrue(game.isOvercrowded(alone));

		// with five neighbors
		cells = new ArrayList<Cell>();
		Cell fourthNeighbor = new Cell(1, 1);
		Cell fifthNeighbor = new Cell(1, 2);
		cells.add(firstNeighbor);
		cells.add(secondNeighbor);
		cells.add(thirdNeighbor);
		cells.add(fourthNeighbor);
		cells.add(fifthNeighbor);
		cells.add(alone);
		game = new GameOfLife(4, 4, cells);
		System.out.println(game.print());
		assertTrue(game.isOvercrowded(alone));
	}

	@Test
	public void born() {
		// alone
		List<Cell> cells = new ArrayList<Cell>();
		Cell alone = new Cell(0, 1);
		cells.add(alone);
		GameOfLife game = new GameOfLife(4, 4, cells);
		System.out.println(game.print());
		assertFalse(game.canBorn(alone));

		// with two neighbors
		cells = new ArrayList<Cell>();
		Cell firstNeighbor = new Cell(0, 0);
		Cell secondNeighbor = new Cell(0, 2);
		cells.add(firstNeighbor);
		cells.add(secondNeighbor);
		cells.add(alone);
		game = new GameOfLife(4, 4, cells);
		System.out.println(game.print());
		assertFalse(game.canBorn(alone));

		// with three neighbourgs
		cells = new ArrayList<Cell>();
		Cell thirdNeighbor = new Cell(1, 0);
		cells.add(firstNeighbor);
		cells.add(secondNeighbor);
		cells.add(thirdNeighbor);
		cells.add(alone);
		game = new GameOfLife(4, 4, cells);
		System.out.println(game.print());
		assertTrue(game.canBorn(alone));

		// with four neighbourgs
		cells = new ArrayList<Cell>();
		Cell fourthNeighbor = new Cell(1, 1);
		cells.add(firstNeighbor);
		cells.add(secondNeighbor);
		cells.add(thirdNeighbor);
		cells.add(fourthNeighbor);
		cells.add(alone);
		game = new GameOfLife(4, 4, cells);
		// System.out.println("\r\e");
		System.out.println(game.print());
		assertFalse(game.canBorn(alone));
	}

	@Test
	public void exploder() {
		List<Cell> cells = new ArrayList<Cell>();
		cells.add(new Cell(1, 3));
		cells.add(new Cell(1, 4));
		cells.add(new Cell(1, 5));
		cells.add(new Cell(1, 9));
		cells.add(new Cell(1, 10));
		cells.add(new Cell(1, 11));
		cells.add(new Cell(3, 1));
		cells.add(new Cell(3, 6));
		cells.add(new Cell(3, 8));
		cells.add(new Cell(3, 13));
		cells.add(new Cell(4, 1));
		cells.add(new Cell(4, 6));
		cells.add(new Cell(4, 8));
		cells.add(new Cell(4, 13));
		cells.add(new Cell(5, 1));
		cells.add(new Cell(5, 6));
		cells.add(new Cell(5, 8));
		cells.add(new Cell(5, 13));
		cells.add(new Cell(6, 3));
		cells.add(new Cell(6, 4));
		cells.add(new Cell(6, 5));
		cells.add(new Cell(6, 9));
		cells.add(new Cell(6, 10));
		cells.add(new Cell(6, 11));
		cells.add(new Cell(8, 3));
		cells.add(new Cell(8, 4));
		cells.add(new Cell(8, 5));
		cells.add(new Cell(8, 9));
		cells.add(new Cell(8, 10));
		cells.add(new Cell(8, 11));
		cells.add(new Cell(9, 1));
		cells.add(new Cell(9, 6));
		cells.add(new Cell(9, 8));
		cells.add(new Cell(9, 13));
		cells.add(new Cell(10, 1));
		cells.add(new Cell(10, 6));
		cells.add(new Cell(10, 8));
		cells.add(new Cell(10, 13));
		cells.add(new Cell(11, 1));
		cells.add(new Cell(11, 6));
		cells.add(new Cell(11, 8));
		cells.add(new Cell(11, 13));
		cells.add(new Cell(13, 3));
		cells.add(new Cell(13, 4));
		cells.add(new Cell(13, 5));
		cells.add(new Cell(13, 9));
		cells.add(new Cell(13, 10));
		cells.add(new Cell(13, 11));
		GameOfLife game = new GameOfLife(15, 15, cells);
		String inital = game.print();
		String[] lines = inital.split("\n");
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
		System.out.println(game.print());
		game.cycle();
		lines = game.print().split("\n");
		assertEquals(". . . . * . . . . . * . . . . ", lines[0]);
		assertEquals(". . . . * . . . . . * . . . . ", lines[1]);
		assertEquals(". . . . * * . . . * * . . . . ", lines[2]);
		assertEquals(". . . . . . . . . . . . . . . ", lines[3]);
		assertEquals("* * * . . * * . * * . . * * * ", lines[4]);
		assertEquals(". . * . * . * . * . * . * . . ", lines[5]);
		assertEquals(". . . . * * . . . * * . . . . ", lines[6]);
		assertEquals(". . . . . . . . . . . . . . . ", lines[7]);
		assertEquals(". . . . * * . . . * * . . . . ", lines[8]);
		assertEquals(". . * . * . * . * . * . * . . ", lines[9]);
		assertEquals("* * * . . * * . * * . . * * * ", lines[10]);
		assertEquals(". . . . . . . . . . . . . . . ", lines[11]);
		assertEquals(". . . . * * . . . * * . . . . ", lines[12]);
		assertEquals(". . . . * . . . . . * . . . . ", lines[13]);
		assertEquals(". . . . * . . . . . * . . . . ", lines[14]);
		System.out.println(game.print());
		game.cycle();
		System.out.println(game.print());
		game.cycle();
		System.out.println(game.print());
		assertEquals(inital, game.print());
	}

}
