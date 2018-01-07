package com.igs.ipi.tpspringbootnutakor.game;

public enum Direction {
	NORTH(0, -1),
	NORTH_EAST(1, -1),
	EAST(1, 0),
	SOUTH_EAST(1, 1),
	SOUTH(0, 1),
	SOUTH_WEST(-1, 1),
	WEST(-1, 0),
	NORTH_WEST(-1, -1);
	
	public static Direction[] half() {
		return new Direction[]{
			NORTH,
			NORTH_EAST,
			EAST,
			SOUTH_EAST
		};
	}
	
	private int dx;
	private int dy;
	public int x() {return dx;}
	public int y() {return dy;}
	
	Direction(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public Direction inverse() {
		dx *= -1;
		dy *= -1;
		return this;
	}
}