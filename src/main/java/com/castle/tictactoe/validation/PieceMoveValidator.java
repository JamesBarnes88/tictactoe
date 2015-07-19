package com.castle.tictactoe.validation;

import java.awt.*;

import com.castle.tictactoe.model.GameBoard;

public class PieceMoveValidator implements MoveValidator{

	private GameBoard board;

	public PieceMoveValidator(GameBoard board) {
		this.board = board;
	}

	@Override
	public boolean isValidMove(Point dest) {
		return board.getBlock(dest).getPiece() == null;
	}
}
