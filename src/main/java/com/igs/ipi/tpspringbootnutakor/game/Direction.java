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
	
	private int x;
	private int y;
	public int x() {return x;}
	public int y() {return y;}
	
	Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Direction inverse() {
		x *= -1;
		y *= -1;
		return this;
	}
}