package com.igs.ipi.tpspringbootnutakor.exceptions;

public class SpotOccupiedException extends MapException {

	public SpotOccupiedException(int x, int y) {
		super("The spot (" + x + ", " + y + ") is already occupied.");
	}

}