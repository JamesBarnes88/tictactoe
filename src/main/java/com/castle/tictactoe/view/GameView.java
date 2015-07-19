package com.castle.tictactoe.view;

import javax.swing.*;

public class GameView {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createAndShowGui();
			}
		});

	}

	private static void createAndShowGui() {
		JFrame f = new JFrame("Tic Tac Toe Demo");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500, 500);
		f.add(new BoardPanel());
		f.pack();
		f.setVisible(true);
	}
}
