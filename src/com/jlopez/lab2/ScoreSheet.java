package com.jlopez.lab2;

public class ScoreSheet {

	private frame[] frames = new frame[10];
	private int currentFrame = 0;
	
	
	public void throwBall(ballThrow throwToSet) throws IllegalThrowException{
		
		if(currentFrame >= 10){
			throw new IllegalThrowException("There can only be 10 frames");
		}
		
		frame f = new frame();
		f.throwBall(throwToSet);
		frames[currentFrame++] = f; 		
	}
	
	public int getFrameScore(int frame) throws IllegalScoreException{
		int score = frames[frame].pinsKnockedDown();
		
		if(frames[frame].isStrike()){
			if(frames[frame + 1] == null || frames[frame + 1].isAwaitingThrow()){
				throw new IllegalScoreException("No Data on the next frame");
			}
			
			score += getFrameScore(frame + 1);

			if(frames[frame + 2] == null || frames[frame + 2].isAwaitingThrow()){
				throw new IllegalScoreException("No Data on the next frame");
			}
			
			score += getFrameScore(frame + 2);
			
		}
		else if(frames[frame].isSpare()){

			if(frames[frame + 1] == null  || frames[frame + 1].isAwaitingThrow()){
				throw new IllegalScoreException("No Data on the next frame");
			}
			
			score += getFrameScore(frame + 1);
		}
		
		return score;
	}
	
	public int getTotalScore() throws IllegalScoreException{
		int total = 0;
		
		for( int i=0; i<10;i++){
			total += getFrameScore(i);			
		}
		
		return total;
	}
	
}
