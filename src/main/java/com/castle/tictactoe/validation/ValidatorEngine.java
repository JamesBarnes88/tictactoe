package com.castle.tictactoe.validation;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import com.castle.tictactoe.model.GameBoard;

public class ValidatorEngine implements MoveValidator, GameValidator{

	public enum status {GAMEOVER, STALEMATE, WIN, LOSE}

	private List<GameValidator> gameValidators = new ArrayList<>();
	private List<MoveValidator> moveValidators = new ArrayList<>();


	public ValidatorEngine(GameBoard board) {
		this.moveValidators.add(new PieceMoveValidator(board));
		this.gameValidators.add(new GameOverGameValidator(board));
	}

	@Override
	public boolean isGameValid() {
		for (GameValidator validator : gameValidators) {
			// Check for failure
			if (validator.isGameValid()) {
				System.out.println(validator.getStatus().name());
				return false;
			}
		}
		// if all pass
		return true;
	}

	@Override
	public status getStatus() {
		return null;
	}

	@Override
	public boolean isValidMove(Point dest) {
		for (MoveValidator validator : moveValidators) {
			// Check for failure
			if (!validator.isValidMove(dest))
				return false;
		}
		// if all pass
		return true;
	}
}
