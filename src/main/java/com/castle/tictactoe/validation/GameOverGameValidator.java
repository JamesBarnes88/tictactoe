package com.castle.tictactoe.validation;

import static com.castle.tictactoe.validation.ValidatorEngine.status.GAMEOVER;

import com.castle.tictactoe.model.GameBoard;
import com.castle.tictactoe.model.piece.Piece;

public class GameOverGameValidator implements GameValidator {

	private GameBoard board;

	public GameOverGameValidator(GameBoard board) {
		this.board = board;
	}

	@Override
	public boolean isGameValid() {
		boolean check = false;
		// check horizontals, vertical, and diagonal win condition
		check = checkVertical() || checkHorizontal();

		return check;
	}

	public boolean checkHorizontal(){
		boolean check = false;
		for (int y = 0; y < board.getY(); y++) {
			Piece lastPiece = board.getBlock(0, y).getPiece();

			// only loop if row would be filled
			if (lastPiece != null) {
				for (int x = 1; x < board.getX(); x++) {
					Piece piece = board.getBlock(x, y).getPiece();
					if (piece == null) {
						check = false;
						break;
					} else if (piece.getClass().getSimpleName()
							.equals(lastPiece.getClass().getSimpleName())) {
						lastPiece = piece;
						check = true;
						if (x== board.getX()-1){
							return true;
						}
					} else {
						check = false;
						break;
					}
				}
			}
		}
		return check;
	}

	public boolean checkVertical() {
		boolean check = false;
		for (int x = 0; x < board.getY(); x++) {
			Piece lastPiece = board.getBlock(x, 0).getPiece();

			// only loop if row would be filled
			if (lastPiece != null) {
				for (int y = 1; y < board.getX(); y++) {
					Piece piece = board.getBlock(x, y).getPiece();
					if (piece == null) {
						check = false;
						break;
					} else if (piece.getClass().getSimpleName()
							.equals(lastPiece.getClass().getSimpleName())) {
						lastPiece = piece;
						check = true;
						if (y == board.getY() - 1) {
							return true;
						}
					} else {
						check = false;
						break;
					}
				}
			}
		}

		return check;
	}

	@Override
	public ValidatorEngine.status getStatus() {
		return GAMEOVER;
	}
}
