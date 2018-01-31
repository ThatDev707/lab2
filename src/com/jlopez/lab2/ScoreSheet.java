package com.jlopez.lab2;

public class ScoreSheet {

	private frame[] frames = new frame[10];
	private int currentFrame = 0;
	
	
	public void throwBall(ballThrow throwToSet) throws IllegalThrowException{
		
		if(currentFrame >= 10){
			throw new IllegalThrowException("There can only be 10 frames");
		}

		if(frames[currentFrame] != null && frames[currentFrame].isAwaitingThrow()){

			frames[currentFrame].throwBall(throwToSet);
		}
		else{
			frame f = new frame();
			f.throwBall(throwToSet);

			frames[currentFrame] = f;
		}

		if(!frames[currentFrame].isAwaitingThrow())
		{
			currentFrame++;
		}

	}

	
	public int getFrameScore(int frame) throws IllegalScoreException{
		if(frame>=10){
			throw new IllegalScoreException("This frame doesn't exist");
		}

		if(frames[frame] == null){
			return 0;
		}

		int score = frames[frame].pinsKnockedDown();
		
		if(frames[frame].isStrike()){

			if(frame +1 < 10 && frames[frame + 1] != null){
				score += frames[frame + 1].pinsKnockedDown();
			}

			if(frame +2 < 10 && frames[frame + 2] != null){
				score += frames[frame + 2].pinsKnockedDown();
			}

		}
		else if(frames[frame].isSpare()){
			if(frame +1 < 10 && frames[frame + 1] != null){
				score += frames[frame + 1].pinsKnockedDown();
			}
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
