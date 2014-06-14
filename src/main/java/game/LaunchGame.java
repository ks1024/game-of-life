package game;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class LaunchGame {

	final static Font labelFont = new Font("Monospaced", Font.PLAIN, 12);

	final static String filename = "src/main/resources/line.txt";

	// final static String filename = "src/main/resources/glider.txt";

	// final static String filename = "src/main/resources/smallExploder.txt";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Game of Life");
		final JTextArea label = new JTextArea();
		label.setFont(labelFont);
		label.setLineWrap(true);
		frame.getContentPane().add(label, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setVisible(true);

		GameOfLife game = GameLoader.loadFromFile(filename);

		for (int i = 0; i < 1000; i++) {
			label.setText(game.print());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			game.cycle();
		}
	}

}
