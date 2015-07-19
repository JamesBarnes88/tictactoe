package com.castle.tictactoe.model.piece;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OPiece extends Piece {

	public OPiece() {
		try {
			this.image = ImageIO.read(this.getClass().getResourceAsStream("/O.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
