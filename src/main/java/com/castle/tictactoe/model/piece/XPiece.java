package com.castle.tictactoe.model.piece;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class XPiece extends Piece {

	public XPiece() {
		try {
			InputStream in = this.getClass().getResourceAsStream("/X.png");
			this.image = ImageIO.read(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
