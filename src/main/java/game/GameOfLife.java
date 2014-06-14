package game;

import java.util.ArrayList;
import java.util.List;

public class GameOfLife {

	private int width;
	private int height;
	private List<Cell> cells;

	public GameOfLife(int width, int height, List<Cell> cells) {
		this.width = width;
		this.height = height;
		this.cells = cells;
	}

	public String print() {
		// TODO
		String s = "";
		int flag = 0;
		for (int i = 0; i < this.width; i++) {
			for (int j = 0; j < this.height; j++) {
				for (int nbr = 0; nbr < this.cells.size(); nbr++) {
					if ((i == this.cells.get(nbr).getX())
							&& (j == this.cells.get(nbr).getY())) {
						flag = 1;
					}
				}
				if (flag == 1)
					s = s + "* ";
				else
					s = s + ". ";
				flag = 0;
			}
			s = s + "\n";
		}
		return s;
	}

	/**
	 * If the neighbors number around a cell is < 2 then the cell die
	 * 
	 * @param cell
	 * @return if the cell is underpopulated
	 */
	public boolean isUnderpopulated(Cell cell) {
		// TODO
		int nbr = 0;
		nbr = this.getNeighbors(cell).size();
		if (nbr < 2)
			return true;
		else
			return false;

	}

	/**
	 * Get a cell's neighbors
	 * 
	 * @param cell
	 * @return a list of a cell's neighbors
	 */
	private List<Cell> getNeighbors(Cell cell) {
		// TODO
		List<Cell> l = new ArrayList<Cell>();
		int x;
		int y;
		x = cell.getX();
		y = cell.getY();
		for (int i = 0; i < this.cells.size(); i++) {
			if (!(((this.cells.get(i).getX() - x) == 0) && ((this.cells.get(i)
					.getY() - y) == 0))) {
				if ((Math.abs(this.cells.get(i).getX() - x)
						+ Math.abs(this.cells.get(i).getY() - y) <= 2)
						&& (Math.abs(this.cells.get(i).getX() - x) != 2)
						&& (Math.abs(this.cells.get(i).getY() - y) != 2))
					l.add(this.cells.get(i));
			}
		}
		return l;
	}

	/**
	 * If the neighbors number around a cell is >= 3 then the cell die
	 * 
	 * @param cell
	 * @return if a cell is overcrowded
	 */
	public boolean isOvercrowded(Cell cell) {
		// TODO
		int nbr = 0;
		nbr = this.getNeighbors(cell).size();
		if (nbr >= 3)
			return true;
		else
			return false;
	}

	/**
	 * If the neighbors number around a cell equals 3 then the cell can be born
	 * 
	 * @param cell
	 * @return if a cell is born
	 */
	public boolean canBorn(Cell cell) {
		// TODO
		int nbr = 0;
		nbr = this.getNeighbors(cell).size();
		if (nbr == 3)
			return true;
		else
			return false;
	}

	public void cycle() {
		// TODO
		int flag = 0;
		List<Cell> new_list = new ArrayList<Cell>();
		for (int i = 0; i < this.width; i++) {
			for (int j = 0; j < this.height; j++) {
				Cell c = new Cell(i, j);
				for (int nbr = 0; nbr < this.cells.size(); nbr++) {
					if ((this.cells.get(nbr).getX() == i)
							&& (this.cells.get(nbr).getY() == j)) {
						flag = 1;
					}
				}
				if (flag == 1) {
					if ((this.getNeighbors(c).size() == 2)
							|| (this.getNeighbors(c).size() == 3))
						new_list.add(c);
				} else {
					if (this.canBorn(c))
						new_list.add(c);
				}
				flag = 0;
			}
		}
		this.cells = new_list;
	}

}