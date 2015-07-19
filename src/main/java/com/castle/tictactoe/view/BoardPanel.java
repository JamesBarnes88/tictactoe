package com.castle.tictactoe.view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.*;

import com.castle.tictactoe.controller.GameController;
import com.castle.tictactoe.model.piece.Piece;

public class BoardPanel extends JPanel{

	GameController gameController = GameController.getInstance();
	
	private int width = 500;
	private int height = 500;

	private int xBlocks;
	private int yBlocks;
	
	public BoardPanel() {
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setBackground(new Color(255,248,220));

		//setup the game and board ui
		gameController.startGame();
		xBlocks = gameController.getGameBoard().getX();
		yBlocks = gameController.getGameBoard().getY();

		//listen for mouse clicks
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				System.out.println(getBlock(e.getX(), e.getY()));
				System.out.println("Mouse event- x: " + e.getX() + " y: "
						+ e.getY());
				if (gameController.makeMove(getBlock(e.getX(), e.getY())))
					repaint();
			}
		});
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}

	public Point getBlock(int x, int y) {
		int xpos = 0;
		int ypos = 0;

		// Get x block of the x point
		for (int i = 0; i <= xBlocks; i++) {
			if (x >= (width / xBlocks) * i && x <= (width / xBlocks) * (i + 1)) {
				xpos = i;
				break;
			}
		}

		// Get y block of the y point
		for(int i = 0; i<=yBlocks; i++){
			if (y >= (height/yBlocks) * i && y <= (height/yBlocks) * (i + 1)){
				ypos = i;
				break;
			}
		}

		return new Point(xpos, ypos);
	}

	public Point getDrawPoint(Point grid) {
		int x = (int) ((width/xBlocks) * grid.getX());
		int y = (int) ((height/yBlocks) * grid.getY());

		return new Point(x, y);
	}

	public Point getDrawPoint(int xPoint, int yPoint) {
		int x = (width/xBlocks) * xPoint;
		int y = (height/yBlocks) * yPoint;

		return new Point(x, y);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Draw lines
		for (int i = 1; i < xBlocks; i++) {
			// draw x line
			g.drawLine((height / xBlocks) * i, 0, (height / xBlocks) * i, height);

			// draw y line
			g.drawLine(0, (height / yBlocks) * i, width, (height / yBlocks) * i);
			
		}

		// Draw pieces if applicable
		for (int y = 0; y < yBlocks; y++) {
			for (int x = 0; x < xBlocks; x++) {
				Piece piece = gameController.getboardPiece(x, y);
				if (piece != null) {
					Point point = getDrawPoint(x, y);
					BufferedImage image = (BufferedImage) piece.getImage();
					Image image1 = image.getScaledInstance(-1, height/yBlocks, -1);
					g.drawImage(image1, (int)point.getX(), (int)point.getY(), this);
				}
			}
		}
	}
}

