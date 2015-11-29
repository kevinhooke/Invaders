package kh.invaders.sprites;

import kh.gameengine.ui.Sprite;

public class InvaderSprite extends Sprite {

	private static final int ANIMATE_X_PIXELS = 6;
	public static final int MAX_POS_RIGHT = 8;
	public static final int MAX_POS_LEFT = -8;
	
	private int currentPosition = 0;
	
	private MovingDirection movingDirection = MovingDirection.RIGHT;
	
	public enum MovingDirection{
		LEFT, RIGHT;
	}
	
	public InvaderSprite(String fileName, String fileName2) throws Exception {
		super(fileName, fileName2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveLeft() {

		this.x = this.x - ANIMATE_X_PIXELS;
		this.currentPosition--;
		//change alternative sprite
		this.toggleDisplayAlternativeImage();

	}

	@Override
	public void moveRight() {

		this.x = this.x + ANIMATE_X_PIXELS;
		this.currentPosition++;
		//change alternative sprite
		this.toggleDisplayAlternativeImage();
		
	}

	private void toggleDisplayAlternativeImage() {
		if(this.getDisplayAlternativeImage()){
			this.setDisplayAlternativeImage(false);
		}
		else{
			this.setDisplayAlternativeImage(true);
		}
	
	}

	public int getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}

	public MovingDirection getMovingDirection() {
		return movingDirection;
	}

	public void setMovingDirection(MovingDirection movingDirection) {
		this.movingDirection = movingDirection;
	}

}
