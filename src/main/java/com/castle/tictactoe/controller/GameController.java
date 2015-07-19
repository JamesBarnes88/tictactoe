package com.castle.tictactoe.controller;

import java.awt.*;

import com.castle.tictactoe.model.Block;
import com.castle.tictactoe.model.GameBoard;
import com.castle.tictactoe.model.piece.OPiece;
import com.castle.tictactoe.model.piece.Piece;
import com.castle.tictactoe.model.piece.XPiece;
import com.castle.tictactoe.validation.ValidatorEngine;

public class GameController {

	private static GameController instance = null;
	private final ValidatorEngine validationEngine;

	private GameBoard gameBoard;

	boolean player1Turn = true;

	private GameController() {
		this.validationEngine = new ValidatorEngine(GameBoard.getInstance());
	}

	public void startGame(){
		gameBoard = GameBoard.getInstance();
		gameBoard.setXY(3,3);
		gameBoard.setup();
	}

	public void setPiece(Point pos){
		gameBoard.getBlock((int) pos.getX(), (int) pos.getY()).setPiece(new XPiece());
	}

	public GameBoard getGameBoard() {
		return gameBoard;
	}

	public boolean makeMove(Point dest) {
		Block block = gameBoard.getBlock((int) dest.getX(), (int) dest.getY());
		if (validationEngine.isValidMove(dest)) {
			block.setPiece(getPiece());

			// Do check for board conditions
			validationEngine.isGameValid();

			switchTurns();
			return true;
		} else {
			return false;
		}
	}

	public void switchTurns(){
		if(player1Turn){
			player1Turn = false;
		} else {
			player1Turn = true;
		}
	}

	private Piece getPiece(){
		if(player1Turn) {
			return new XPiece();
		} else {
			return new OPiece();
		}
	}

	public Piece getboardPiece(Point point) {
		return gameBoard.getBlock(point).getPiece();
	}

	public Piece getboardPiece(int x, int y) {
		return gameBoard.getBlock(x, y).getPiece();
	}

	public static GameController getInstance() {
		if (instance == null) {
			instance = new GameController();
		}
		return instance;
	}
}
