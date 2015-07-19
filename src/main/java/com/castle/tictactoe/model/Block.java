package com.castle.tictactoe.model;

import com.castle.tictactoe.model.piece.Piece;

public class Block {

	private Piece piece;

	public Block() {
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
}
