package com.jlopez.lab2;

public class frame {
	
	private ballThrow throw1 = ballThrow.AwaitingThrow;
	private ballThrow throw2 = ballThrow.AwaitingThrow;
	
	public int pinsKnockedDown(){
		return throw1.getValue() + throw2.getValue();
	}
	
	public boolean isStrike(){
		return throw1 == ballThrow.STRIKE;		
	}
	
	public boolean isSpare(){
		return !isStrike() && pinsKnockedDown() == 10;		
	}

	
	public boolean isAwaitingThrow(){
		return throw1 == ballThrow.AwaitingThrow || throw2 == ballThrow.AwaitingThrow;		
	}
	
	public void throwBall(ballThrow throwToSet) throws IllegalThrowException{
				if(throw1 == ballThrow.AwaitingThrow){
					throw1 = throwToSet;
					if(throwToSet == ballThrow.STRIKE){
						throw2 = ballThrow.NOTHROW;
					}
				}
				else if(throw2 == ballThrow.AwaitingThrow){
					if((throw1.getValue() + throwToSet.getValue()) > 10){
						throw new IllegalThrowException("You cannot knock down more than 10 pins");
					}
					
					throw2 = throwToSet;
				}
				
				throw new IllegalThrowException("You cannot throw again on this frame");
	}
	
	
	
}
