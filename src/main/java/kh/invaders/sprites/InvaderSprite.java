package kh.invaders.sprites;

import kh.gameengine.ui.Sprite;

public class InvaderSprite extends Sprite {

	private static final int INVADER_Y_HIGHEST_POSITION = 8;
	private static final int INVADER_Y_LOWEST_POSITION = 0;

	private static final int ANIMATE_X_PIXELS = 6;
	public static final int INVADER_MAX_X_POSITION_RIGHT = 8;
	public static final int INVADER_MAX_X_POSITION__LEFT = -8;
	
	private int currentAnimationXPosition = 0;
	private int currentAnimationYPosition = INVADER_Y_HIGHEST_POSITION;
	
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
		this.currentAnimationXPosition--;
		//change alternative sprite
		this.toggleDisplayAlternativeImage();

	}

	@Override
	public void moveRight() {

		this.x = this.x + ANIMATE_X_PIXELS;
		this.currentAnimationXPosition++;
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

	public int getCurrentAnimationXPosition() {
		return this.currentAnimationXPosition;
	}

	public void setCurrentAnimationXPosition(int currentXPosition) {
		this.currentAnimationXPosition = currentXPosition;
	}

	public MovingDirection getMovingDirection() {
		return movingDirection;
	}

	public void setMovingDirection(MovingDirection movingDirection) {
		this.movingDirection = movingDirection;
	}

	public int getCurrentAnimationYPosition() {
		return currentAnimationYPosition;
	}

	public void setCurrentAnimationYPosition(int currentAnimationYPosition) {
		this.currentAnimationYPosition = currentAnimationYPosition;
	}

}
