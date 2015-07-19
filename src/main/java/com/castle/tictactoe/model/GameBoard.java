package com.castle.tictactoe.model;

import java.awt.*;

public class GameBoard {

	private static GameBoard instance = null;

	private int x;
	private int y;

	Block [][] blocks;

	protected GameBoard() {

	}

	public void setup() {
		blocks = new Block[x][y];
		for (int i =0; i< blocks.length; i++){
			for (int j =0; j< blocks.length; j++) {
				blocks[i][j] = new Block();
			}
		}
	}

	public static GameBoard getInstance() {
		if(instance == null) {
			instance = new GameBoard();
		}
		return instance;
	}

	public Block getBlock(int x, int y) {
		return blocks[x][y];
	}

	public Block getBlock(Point point) {
		int x = (int) point.getX();
		int y = (int) point.getY();

		return blocks[x][y];
	}

	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
