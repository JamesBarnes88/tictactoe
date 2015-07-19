package com.castle.tictactoe.validation;

public interface GameValidator {

	public boolean isGameValid();

	ValidatorEngine.status getStatus();
}
