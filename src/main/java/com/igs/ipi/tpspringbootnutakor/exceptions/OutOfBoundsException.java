package com.igs.ipi.tpspringbootnutakor.exceptions;

public class OutOfBoundsException extends MapException {

	public OutOfBoundsException(int x, int y) {
		super("The coordinates (" + x + ", " + y + ") are out of bounds.");
	}

}