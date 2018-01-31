package com.jlopez.lab2;

public enum ballThrow {
	
	ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), STRIKE(10), NOTHROW(0), AwaitingThrow(0);

	private int value;
	
	private ballThrow(int val){
		this.value = val;
	}
	
	public int getValue(){
		
		return value;
	}
	
}
